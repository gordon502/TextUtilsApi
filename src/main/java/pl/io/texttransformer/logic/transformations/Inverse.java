package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

public class Inverse extends Transformation {

    private Transformation transformation;

    public Inverse(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        byte [] strAsByteArray = text.getBytes();
        byte [] result = new byte [strAsByteArray.length];

        for (int i = 0; i<strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length-i-1];
        return transformation.transform(new String(result));
    }
}
