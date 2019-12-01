package pl.io.texttransformer.logic.shortcodes;
import pl.io.texttransformer.logic.Transformation;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpandText extends AbbrOperate{
    private Transformation transformation;

    public ExpandText(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text) {
        if(Abbrs == null){
            try {
                Abbrs = readAbbrs("skroty.csv");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> words = new ArrayList<>(Arrays.asList( text.split(" ")));
        for (int i = 3; i>0; i--){
            for (int j = 0; j<=words.size()-i; j++){
                for (String[] k : Abbrs){
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
        return String.join(" ", words);
    }
}
