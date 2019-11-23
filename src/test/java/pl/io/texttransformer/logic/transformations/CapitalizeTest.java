package pl.io.texttransformer.logic.transformations;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class CapitalizeTest {

    @Test
    public void transform() {
        Capitalize t = new Capitalize(new Transformation());

        assertEquals(t.transform("testing"), "Testing");
        assertEquals(t.transform("TESTING"), "TESTING");
        assertEquals(t.transform("testinG Testing tESting"), "TestinG Testing TESting");
    }
}