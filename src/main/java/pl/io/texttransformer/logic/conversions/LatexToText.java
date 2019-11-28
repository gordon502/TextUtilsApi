package pl.io.texttransformer.logic.conversions;

import pl.io.texttransformer.logic.Transformation;

public class LatexToText extends Transformation{

    private Transformation transformation;

    public LatexToText(Transformation transformation) {this.transformation = transformation;}

    @Override
    public String transform(String text){

        String word = text;
        word = word.replace("\\&", "&");
        word = word.replace("\\$", "$");

        return transformation.transform(word);
    }
}
