package pl.io.texttransformer.logic.ciphers;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class VigenereTest {
    @Test
    public void transform() {
        Vigenere t = new Vigenere(new Transformation());

        assertEquals(t.transform("testing", "VIGENERE", "cipher"), "omyxvrx");
        assertEquals(t.transform("TESTING", "VIGENERE", "cipher"), "OMYXVRX");
        assertEquals(t.transform("testinG Testing tESting", "VIGENERE", "cipher"), "omyxvrX Xzazmak kINbort");
        assertEquals(t.transform("cchiex rxvsan b wnmxqk", "VIGENERE", "decipher"), "hubert atakuj o swicie");
    }
}
