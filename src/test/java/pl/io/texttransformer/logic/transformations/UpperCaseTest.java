package pl.io.texttransformer.logic.transformations;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpperCaseTest {

    @Test
    public void transform() {
        UpperCase t = new UpperCase();

        assertEquals(t.transform("testing"), "TESTING");
        assertEquals(t.transform("TESTING"), "TESTING");
    }
}