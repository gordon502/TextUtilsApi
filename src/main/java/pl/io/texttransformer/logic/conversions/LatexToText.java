package pl.io.texttransformer.logic.conversions;

import pl.io.texttransformer.logic.Transformation;

/**
 * Converts latex like characters in sentence to standard format.
 * Supports conversions for "\$" and "\&"
 */
public class LatexToText extends Transformation{

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation
     */
    public LatexToText(Transformation transformation) {this.transformation = transformation;}

    /**
     * Main method providing conversion
     * @param text to convert
     * @return converted text without latex like characters
     */
    @Override
    public String transform(String text){

        String word = text;
        word = word.replace("\\&", "&");
        word = word.replace("\\$", "$");

        return transformation.transform(word);
    }
}
