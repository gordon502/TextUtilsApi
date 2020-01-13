package pl.io.texttransformer.logic.ciphers;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class DeVigenereTest {
    @Test
    public void transform() {
        DeVigenere t = new DeVigenere(new Transformation());

        assertEquals(t.transform("cchiex rxvsan b wnmxqk"), "hubert atakuj o swicie");
    }
}