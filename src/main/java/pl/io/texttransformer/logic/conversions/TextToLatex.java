package pl.io.texttransformer.logic.conversions;

import pl.io.texttransformer.logic.Transformation;

public class TextToLatex extends Transformation{

    private Transformation transformation;

    public TextToLatex(Transformation transformation) {this.transformation = transformation;}

    @Override
    public String transform(String text){

        String word = text;
        word.replace("$", "\\$");
        word.replace("&", "\\&");

        return transformation.transform(word);
    }
}