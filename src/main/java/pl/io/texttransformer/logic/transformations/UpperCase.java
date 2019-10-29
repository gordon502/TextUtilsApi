package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

public class UpperCase extends Transformation {

    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}
