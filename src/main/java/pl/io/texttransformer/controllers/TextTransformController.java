package pl.io.texttransformer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.io.texttransformer.app.Response;
import pl.io.texttransformer.exceptions.UnknownTransformException;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.UpperCase;

import java.util.Map;
import java.util.Set;

@RestController
public class TextTransformController {

    private Map<String, Transformation> transformations;

    public TextTransformController() {
        RegisterTransforms();
    }

    @RequestMapping("/transform")
    public Response transform(@RequestParam("text") String text, @RequestParam("transformations") String[] transformations) {
        if (!checkTransformations(transformations))
            throw new UnknownTransformException();

        String result = text;
        for (String transformation : transformations)
            result = this.transformations.get(transformation).transform(result);

        return new Response(result);
    }

    @GetMapping("/transformations")
    public Set<String> transformations() {

        return transformations.keySet();
    }

    private void RegisterTransforms() {
        transformations = Map.of(
                "uppercase", new UpperCase()
        );
    }

    private boolean checkTransformations(String[] transformations) {
        for (String transformation : transformations)
            if (!this.transformations.containsKey(transformation))
                return false;
        return true;
    }
}
