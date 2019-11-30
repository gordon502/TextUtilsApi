package pl.io.texttransformer.logic.shortcodes;
import pl.io.texttransformer.logic.Transformation;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class ShortenText extends AbbrOperate{
    private Transformation transformation;

    public ShortenText(Transformation transformation) {
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
                boolean finded = false;
                for (String[] k : Abbrs){
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
        return String.join(" ", words);
    }
}
