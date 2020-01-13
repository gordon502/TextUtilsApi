package pl.io.texttransformer.logic.ciphers;

import pl.io.texttransformer.logic.Transformation;

/**
 * Encodes input string using ROT13 cipher.
 */
public class ROT13 extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     *
     * @param transformation Previous transformation.
     */
    public ROT13(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Replaces each character in input string with a character shifted by 13 places in the alphabet.
     *
     * @param text Input text modified by previous transformations.
     * @return Text input encoded using ROT13.
     */
    @Override
    public String transform(String text) {
        char[] str = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(str[i])) {
                int asc = str[i];
                int start = (Character.isUpperCase(asc) ? 'A' : 'a');
                str[i] = (char) (start + (asc - start + 13) % 26);
            }
        }
        return transformation.transform(new String(str));
    }
}
