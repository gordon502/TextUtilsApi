package pl.io.texttransformer.logic.corrections;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.Capitalize;

import static org.junit.Assert.assertEquals;

public class CleanDuplicatesTest {

    @Test
    public void transform() {
        CleanDuplicates t = new CleanDuplicates(new Transformation());

        assertEquals(t.transform("po po do po do"), "po do po do");
        assertEquals(t.transform("TESTING"), "TESTING");
        assertEquals(t.transform("testinG Testing tESting"), "testinG");
    }
}