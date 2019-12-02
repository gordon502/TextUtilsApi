package pl.io.texttransformer.logic.transformations;

import org.springframework.util.StringUtils;
import pl.io.texttransformer.logic.Transformation;

/**
 * Capitalizes each word in input text.
 */
public class Capitalize extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     * @param transformation Previous transformation.
     */
    public Capitalize(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Splits string into separate words, capitalizes them and returns them joined into one string.
     * @param text Input text modified by previous transformations.
     * @return String Text modified by transformation.
     */
    @Override
    public String transform(String text) {
        String[] textsplit = text.split(" ");
        for(int i=0; i<textsplit.length; i++){
            textsplit[i]=StringUtils.capitalize(textsplit[i]);
        }

        return transformation.transform(String.join(" ", textsplit));
    }
}
