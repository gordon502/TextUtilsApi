package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

public class UpperCase extends Transformation {

    private Transformation transformation;

    public UpperCase(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        return transformation.transform(text.toUpperCase());
    }
}
