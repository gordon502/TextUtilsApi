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
        String[] textsplit = text.split(" ");
        for(int i=0; i<textsplit.length; i++){
            textsplit[i]=StringUtils.capitalize(textsplit[i]);
        }

        return transformation.transform(String.join(" ", textsplit));
    }
}
