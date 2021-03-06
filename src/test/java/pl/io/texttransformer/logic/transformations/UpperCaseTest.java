package pl.io.texttransformer.logic.transformations;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.*;

public class UpperCaseTest {

    @Test
    public void transform() {
        UpperCase t = new UpperCase(new Transformation());

        assertEquals(t.transform("testing"), "TESTING");
        assertEquals(t.transform("TESTING"), "TESTING");
    }
}