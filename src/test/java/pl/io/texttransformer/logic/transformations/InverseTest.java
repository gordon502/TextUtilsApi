package pl.io.texttransformer.logic.transformations;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class InverseTest {

    @Test
    public void transform() {
        Inverse t = new Inverse(new Transformation());

        assertEquals(t.transform("testing"), "gnitset");
        assertEquals(t.transform("TESTING"), "GNITSET");
        assertEquals(t.transform("testinG Testing tESting"), "gnitSEt gnitseT Gnitset");
    }
}