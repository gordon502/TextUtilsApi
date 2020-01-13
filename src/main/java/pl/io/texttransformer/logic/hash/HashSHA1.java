package pl.io.texttransformer.logic.hash;

import pl.io.texttransformer.logic.Transformation;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Creates SHA-1 hash for input text.
 */
public class HashSHA1 extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     *
     * @param transformation Previous transformation.
     */
    public HashSHA1(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Creates SHA-1 hash by using standard Java classes and methods.
     *
     * @param text Input text modified by previous transformations.
     * @return String SHA-1 hash of text.
     */
    @Override
    public String transform(String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(text.getBytes());
        byte[] digest = md.digest();
        String output = String.format("%032X", new BigInteger(1, digest)).toLowerCase();

        return transformation.transform(output);
    }
}
