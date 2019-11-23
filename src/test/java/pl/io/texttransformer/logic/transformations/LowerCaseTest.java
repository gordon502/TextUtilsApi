package pl.io.texttransformer.logic.transformations;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class LowerCaseTest {

    @Test
    public void transform() {
        LowerCase t = new LowerCase(new Transformation());

        assertEquals(t.transform("testing"), "testing");
        assertEquals(t.transform("TESTING"), "testing");
    }
}