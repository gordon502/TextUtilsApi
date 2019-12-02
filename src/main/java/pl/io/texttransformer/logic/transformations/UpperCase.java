package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

/**
 * Changes all letters to uppercase.
 */
public class UpperCase extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation Previous transformation.
     */
    public UpperCase(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Changes all letters to uppercase using standard Java method String toUpperCase().
     * @param text Input text modified by previous transformations.
     * @return String Text modified by transformation.
     */
    @Override
    public String transform(String text) {
        return transformation.transform(text.toUpperCase());
    }
}
