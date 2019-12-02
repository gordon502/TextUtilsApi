package pl.io.texttransformer.logic.transformations;

import pl.io.texttransformer.logic.Transformation;

/**
 * Changes all characters to lowercase.
 */
public class LowerCase extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation Previous transformation.
     */
    public LowerCase(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Changes all characters to lowercase using standard Java method String toLowerCase().
     * @param text Input text modified by previous transformations.
     * @return String Text modified by transformation.
     */
    @Override
    public String transform(String text) {
        return transformation.transform(text.toLowerCase());
    }
}
