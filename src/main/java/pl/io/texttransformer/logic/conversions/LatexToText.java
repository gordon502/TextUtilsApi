package pl.io.texttransformer.logic.conversions;

import pl.io.texttransformer.logic.Transformation;

public class LatexToText extends Transformation{

    private Transformation transformation;

    public LatexToText(Transformation transformation) {this.transformation = transformation;}

    @Override
    public String transform(String text){
        text = text.replace("\\&", "&");
        text = text.replace("\\$", "$");

        return transformation.transform(text);
    }
}
