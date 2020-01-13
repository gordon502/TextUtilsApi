package pl.io.texttransformer.logic.ciphers;

import org.springframework.util.StringUtils;
import pl.io.texttransformer.logic.Transformation;


/**
 * Ciphers and deciphers input text using Vigenere cipher.
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
        String res = "";
        int pos = 0;
        key = key.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                res += key.charAt(pos % key.length());
                pos++;
            } else res += " ";
        }
        return res;
    }

    /**
     * Ciphers input text using Vigenere cipher with key parameter as key.
     * @param text
     * @param key
     * @return Ciphered input text.
     */
    public String cipher(String text, String key) {
        String cipher_text = "";
        String textUpper = text.toUpperCase();
        String cipherKey = generateKey(textUpper, key);

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(textUpper.charAt(i))) {
                int x = (textUpper.charAt(i) + cipherKey.charAt(i)) % 26;
                x += 'A';

                cipher_text += Character.isUpperCase(text.charAt(i)) ? (char) (x) : Character.toLowerCase((char) (x));
            } else cipher_text += textUpper.charAt(i);
        }

        return cipher_text;
    }

    /**
     * Deciphers input text using Vigenere cipher with key parameter as key.
     * @param text
     * @param key
     * @return Deciphered input text.
     */
    public String decipher(String text, String key) {
        String cipher_text = "";
        String textUpper = text.toUpperCase();
        String cipherKey = generateKey(textUpper, key);

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(textUpper.charAt(i))) {
                int x = (textUpper.charAt(i) - cipherKey.charAt(i) + 26) % 26;
                x += 'A';

                cipher_text += Character.isUpperCase(text.charAt(i)) ? (char) (x) : Character.toLowerCase((char) (x));
            } else cipher_text += textUpper.charAt(i);
        }

        return cipher_text;
    }

    /**
     * Based on option ("cipher" or "decipher") either ciphers or deciphers text by using Vigenere cipher with String key as a key.
     * @param text Input text modified by previous transformations.
     * @param key Key passed for Vigenere cipher.
     * @param option Decides if transform should cipher or decipher input text.
     * @return
     */
    public String transform(String text, String key, String option) {
        if (option.equals("cipher")) {
            return transformation.transform(cipher(text, key));
        } else if (option.equals("decipher")) {
            return transformation.transform(decipher(text, key));
        }
        return transformation.transform(cipher(text, key));
    }
}
