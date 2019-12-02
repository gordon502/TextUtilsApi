package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

/**
 * Inverts input text.
 */
public class Inverse extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation Previous transformation.
     */
    public Inverse(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Converts String into array of bytes and inverts the order of characters.
     * @param text Input text modified by previous transformations.
     * @return String Text modified by transformation.
     */
    @Override
    public String transform(String text) {
        byte [] strAsByteArray = text.getBytes();
        byte [] result = new byte [strAsByteArray.length];

        for (int i = 0; i<strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length-i-1];
        return transformation.transform(new String(result));
    }
}
