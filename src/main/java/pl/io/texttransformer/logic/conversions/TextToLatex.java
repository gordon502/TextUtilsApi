package pl.io.texttransformer.logic.conversions;

import pl.io.texttransformer.logic.Transformation;

/**
 * Converts standard format characters to latex like format.
 * Supports conversion for "$" and "&"
 */
public class TextToLatex extends Transformation{

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation
     */
    public TextToLatex(Transformation transformation) {this.transformation = transformation;}

    /**
     * Main method providing conversion.
     * @param text to convert
     * @return converted text with latex like characters
     */
    @Override
    public String transform(String text){

        String word = text;
        word = word.replace("$", "\\$");
        word = word.replace("&", "\\&");

        return transformation.transform(word);
    }
}