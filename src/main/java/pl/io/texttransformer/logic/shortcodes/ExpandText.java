package pl.io.texttransformer.logic.shortcodes;
import pl.io.texttransformer.controllers.TextTransformController;
import pl.io.texttransformer.logic.Transformation;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Expands shortcuts.
 * Extending AbbrOperate which bring list of known shortcuts and corresponding states.
 */
public class ExpandText extends Transformation{
    private Transformation transformation;
    private Shortcodes shortcodes;

    public ExpandText(Transformation transformation) {
        this.transformation = transformation;
        this.shortcodes = TextTransformController.getShortcodes();
    }

    public ExpandText(Transformation transformation, Shortcodes shortcodes) {
        this.transformation = transformation;
        this.shortcodes = shortcodes;
    }

    @Override
    public String transform(String text) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList( text.split(" ")));
        for (int i = 3; i>0; i--){
            for (int j = 0; j<=words.size()-i; j++){
                for (String[] k : shortcodes.getShortcodesList()){
                    if(k[0].equals(String.join(" ", words.subList(j, j + i)))){
                        for(int m = j; m<j+i; m++) {
                            words.remove(j);
                        }
                        words.add(j,k[1]);
                        j-=(i-1);
                        break;
                    }
                }
            }
        }
        return transformation.transform(String.join(" ", words));
    }
}
