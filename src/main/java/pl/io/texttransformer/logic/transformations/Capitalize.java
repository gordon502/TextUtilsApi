package pl.io.texttransformer.logic.transformations;

import org.springframework.util.StringUtils;
import pl.io.texttransformer.logic.Transformation;

public class Capitalize extends Transformation {

    private Transformation transformation;

    public Capitalize(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        return StringUtils.capitalize(transformation.transform(text));
    }
}
