package pl.io.texttransformer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.io.texttransformer.app.Response;
import pl.io.texttransformer.exceptions.UnknownTransformException;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.Capitalize;
import pl.io.texttransformer.logic.transformations.Inverse;
import pl.io.texttransformer.logic.transformations.LowerCase;
import pl.io.texttransformer.logic.transformations.UpperCase;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;

@RestController
public class TextTransformController {

    private Map<String, String> transformations;
    private Logger logger = LoggerFactory.getLogger(TextTransformController.class);

    public TextTransformController() {
        RegisterTransforms();
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

    private void RegisterTransforms() {
        logger.info("Registering text transformations");

        transformations = Map.of(
                "uppercase", UpperCase.class.getName(),
                "lowercase", LowerCase.class.getName(),
                "capitalize", Capitalize.class.getName(),
                "inverse", Inverse.class.getName()
        );
    }

    private boolean checkTransformations(String[] transformations) {
        for (String transformation : transformations)
            if (!this.transformations.containsKey(transformation))
                return false;
        return true;
    }
}
