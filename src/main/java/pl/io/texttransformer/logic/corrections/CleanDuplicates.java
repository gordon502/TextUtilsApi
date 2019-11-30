package pl.io.texttransformer.logic.corrections;

import pl.io.texttransformer.logic.Transformation;

import java.util.ArrayList;
import java.util.Arrays;

public class CleanDuplicates extends Transformation {
    private Transformation transformation;

    public CleanDuplicates(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList( text.split(" ")));
        for (int i = 1; i<words.size(); i++){
            if(words.get(i-1).toUpperCase().equals(words.get(i).toUpperCase())){
                words.remove(i);
                i--;
            }
        }

        return String.join(" ", words);
    }
}
