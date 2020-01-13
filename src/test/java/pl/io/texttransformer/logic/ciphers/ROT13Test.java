package pl.io.texttransformer.logic.ciphers;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class ROT13Test {
    @Test
    public void transform() {
        ROT13 t = new ROT13(new Transformation());

        assertEquals(t.transform("testing"), "grfgvat");
        assertEquals(t.transform("TESTING"), "GRFGVAT");
        assertEquals(t.transform("testinG Testing tESting"), "grfgvaT Grfgvat gRFgvat");
    }
}
