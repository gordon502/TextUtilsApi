package pl.io.texttransformer.logic.ciphers;

import org.springframework.util.StringUtils;
import pl.io.texttransformer.logic.Transformation;


/**
 * Encodes input text using Vigenere cipher with key "VIGENERE".
 */
public class Vigenere extends Transformation {
    private Transformation transformation;

    /**
     * Class constructor.
     *
     * @param transformation Previous transformation.
     */
    public Vigenere(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Generates key by repeating key parameter in cycling manner until it has length of input text.
     *
     * @param str Input text.
     * @param key Key to be repeated.
     * @return Key repeated until it has length of input text.
     */
    static String generateKey(String str, String key) {
        String res="";
        int pos=0;

        for(int i=0; i<str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                res+=key.charAt(pos%key.length());
                pos++;
            }
            else res+=" ";
        }
        return res;
    }

    /**
     * Takes each letter and based on the key replaces it with character from given substitution alphabet.
     *
     * @param text Input text modified by previous transformations.
     * @return Text input encoded using Vigenere.
     */
    public String transform(String text) {
        String cipher_text = "";
        String textUpper = text.toUpperCase();
        String key = generateKey(textUpper, "VIGENERE");

        for (int i = 0; i < text.length(); i++) {
            if(Character.isLetter(textUpper.charAt(i))){
                int x = (textUpper.charAt(i) + key.charAt(i)) % 26;
                x += 'A';

                cipher_text += Character.isUpperCase(text.charAt(i)) ? (char) (x) : Character.toLowerCase((char) (x));
            } else cipher_text+=textUpper.charAt(i);
        }

        return transformation.transform(cipher_text);
    }
}
