package pl.io.texttransformer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.io.texttransformer.app.Response;
import pl.io.texttransformer.exceptions.UnknownTransformException;
import pl.io.texttransformer.exceptions.WrongKeyException;
import pl.io.texttransformer.exceptions.WrongOptionException;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.ciphers.ROT13;
import pl.io.texttransformer.logic.ciphers.Vigenere;
import pl.io.texttransformer.logic.conversions.LatexToText;
import pl.io.texttransformer.logic.conversions.TextToLatex;
import pl.io.texttransformer.logic.corrections.CleanDuplicates;
import pl.io.texttransformer.logic.hash.HashMD5;
import pl.io.texttransformer.logic.hash.HashSHA1;
import pl.io.texttransformer.logic.hash.HashSHA256;
import pl.io.texttransformer.logic.numbers.NumbersToWords;
import pl.io.texttransformer.logic.numbers.WordsToNumbers;
import pl.io.texttransformer.logic.shortcodes.Shortcodes;
import pl.io.texttransformer.logic.shortcodes.ExpandText;
import pl.io.texttransformer.logic.shortcodes.ShortenText;
import pl.io.texttransformer.logic.transformations.Capitalize;
import pl.io.texttransformer.logic.transformations.Inverse;
import pl.io.texttransformer.logic.transformations.LowerCase;
import pl.io.texttransformer.logic.transformations.UpperCase;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

@RestController
public class TextTransformController {

    private Map<String, String> transformations;
    private Logger logger = LoggerFactory.getLogger(TextTransformController.class);
    private static Shortcodes shortcodes;

    public static Shortcodes getShortcodes() {
        return shortcodes;
    }

    public TextTransformController() {
        RegisterTransforms();
        shortcodes = new Shortcodes();
        shortcodes.readFile("skroty.csv");
    }

    @RequestMapping("/transform")
    public Response transform(@RequestParam("text") String text, @RequestParam("transformations") String[] transformations) throws Exception {
        if (!checkTransformations(transformations))
            throw new UnknownTransformException();

        Transformation transformation = new Transformation();

        for (String t : transformations) {

            Class<?> c = Class.forName(this.transformations.get(t));
            Constructor<?> constructor = c.getConstructor(Transformation.class);
            transformation = (Transformation) constructor.newInstance(transformation);
        }

        return new Response(transformation.transform(text));
    }

    @GetMapping("/transformations")
    public Set<String> transformations() {

        return transformations.keySet();
    }

    @RequestMapping("/cipher")
    public Response cipher(@RequestParam("text") String text, @RequestParam("key") String key, @RequestParam("option") String option) throws Exception {
        if (!option.equals("decipher") && !option.equals("cipher")){
            throw new WrongOptionException();
        }

        if(!key.matches("[a-zA-Z]+")){
            throw new WrongKeyException();
        }

        Transformation transformation = new Transformation();
        Vigenere vigenere = new Vigenere(transformation);
        return new Response(vigenere.transform(text, key, option));
    }

    private void RegisterTransforms() {
        logger.info("Registering text transformations");

        transformations = Map.ofEntries(
                entry("uppercase", UpperCase.class.getName()),
                entry("lowercase", LowerCase.class.getName()),
                entry("capitalize", Capitalize.class.getName()),
                entry("inverse", Inverse.class.getName()),
                entry("texttolatex", TextToLatex.class.getName()),
                entry("latextotext", LatexToText.class.getName()),
                entry("numberstowords", NumbersToWords.class.getName()),
                entry("wordstonumbers", WordsToNumbers.class.getName()),
                entry("shortentext", ShortenText.class.getName()),
                entry("expandtext", ExpandText.class.getName()),
                entry("cleanduplicates", CleanDuplicates.class.getName()),
                entry("md5", HashMD5.class.getName()),
                entry("sha256", HashSHA256.class.getName()),
                entry("sha1", HashSHA1.class.getName()),
                entry("rot13", ROT13.class.getName())
        );
    }

    private boolean checkTransformations(String[] transformations) {
        for (String transformation : transformations)
            if (!this.transformations.containsKey(transformation))
                return false;
        return true;
    }
}
