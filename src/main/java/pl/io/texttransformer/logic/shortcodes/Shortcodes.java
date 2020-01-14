package pl.io.texttransformer.logic.shortcodes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shortcodes {

    public void readFile(String filename) {
         try {
             File file = new File(Shortcodes.class.getClassLoader().getResource(filename).getFile());
             Scanner sc = new Scanner(file);
             shortcodesList = new ArrayList<>();
             while (sc.hasNextLine()) {
                 String line = sc.nextLine();
                 String[] exps = line.split(",");
                 shortcodesList.add(exps);
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

     }

    public  ArrayList<String[]> getShortcodesList() {
        return shortcodesList;
    }

    private ArrayList<String[]> shortcodesList;
}
