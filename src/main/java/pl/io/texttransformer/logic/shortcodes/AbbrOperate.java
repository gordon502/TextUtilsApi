package pl.io.texttransformer.logic.shortcodes;
import pl.io.texttransformer.logic.Transformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class AbbrOperate extends Transformation{
    private Transformation transformation;

    protected ArrayList<String[]> readAbbrs(String filename) throws FileNotFoundException {
        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        Scanner sc = new Scanner(file);
        ArrayList<String[]> Abbrs = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] exps = line.split(",");
            Abbrs.add(exps);
        }
        return Abbrs;
    }

    static protected ArrayList<String[]> Abbrs;
}
