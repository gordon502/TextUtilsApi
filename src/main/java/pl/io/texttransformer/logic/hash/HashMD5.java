package pl.io.texttransformer.logic.hash;

import pl.io.texttransformer.logic.Transformation;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Creates MD5 hash for input text.
 */
public class HashMD5 extends Transformation {

    private Transformation transformation;

    /**
     * Class constructor.
     *
     * @param transformation Previous transformation.
     */
    public HashMD5(Transformation transformation) {
        this.transformation = transformation;
    }

    /**
     * Creates MD5 hash by using standard Java classes and methods.
     *
     * @param text Input text modified by previous transformations.
     * @return String MD5 hash of text.
     */
    @Override
    public String transform(String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(text.getBytes());
        byte[] digest = md.digest();
        String output = String.format("%032X", new BigInteger(1, digest)).toLowerCase();

        return transformation.transform(output);
    }
}
