package pl.io.texttransformer.logic.ciphers;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class VigenereTest {
    @Test
    public void transform() {
        Vigenere t = new Vigenere(new Transformation());

        assertEquals(t.transform("testing"), "omyxvrx");
        assertEquals(t.transform("TESTING"), "OMYXVRX");
        assertEquals(t.transform("testinG Testing tESting"), "omyxvrX Xzazmak kINbort");
    }
}
