package pl.io.texttransformer.logic.shortcodes;
import pl.io.texttransformer.controllers.TextTransformController;
import pl.io.texttransformer.logic.Transformation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Shorten phrases to appropriate shortcuts.
 * Extending AbbrOperate which bring list of known shortcuts and corresponding statements.
 */
public class ShortenText extends Transformation{
    private Transformation transformation;
    private Shortcodes shortcodes;

    public ShortenText(Transformation transformation,Shortcodes shortcodes) {
        this.transformation = transformation;
        this.shortcodes = shortcodes;
    }

    public ShortenText(Transformation transformation) {
        this.transformation = transformation;
        this.shortcodes = TextTransformController.getShortcodes();
    }

    @Override
    public String transform(String text) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList( text.split(" ")));
        for (int i = 3; i>0; i--){
            for (int j = 0; j<=words.size()-i; j++){
                boolean finded = false;
                for (String[] k : shortcodes.getShortcodesList()){
                    if (Character.toUpperCase(k[0].charAt(0)) != Character.toUpperCase(words.get(j).charAt(0))){
                        continue;
                    }
                    for(int l = 1; l<k.length; l++){
                        if(k[l].equals(String.join(" ", words.subList(j, j + i)))){
                            for(int m = j; m<j+i; m++) {
                                words.remove(j);
                            }
                            words.add(j,k[0]);
                            j-=(i-1);
                            finded = true;
                            break;
                        }
                    }
                    if(finded) break;
                }
            }
        }
        return transformation.transform(String.join(" ", words));
    }
}
