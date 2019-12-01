package pl.io.texttransformer.logic.numbers;

import pl.io.texttransformer.logic.Transformation;

public class WordsToNumbers extends Transformation {

    private Transformation transformation;

    public WordsToNumbers(Transformation transformation) { this.transformation = transformation; }

    @Override
    public String transform(String text){
        return transformation.transform(text);
    }

}
