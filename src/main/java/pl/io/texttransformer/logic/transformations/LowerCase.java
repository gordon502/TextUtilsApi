package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

public class LowerCase extends Transformation {

    private Transformation transformation;

    public LowerCase(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        return transformation.transform(text).toLowerCase();
    }
}
