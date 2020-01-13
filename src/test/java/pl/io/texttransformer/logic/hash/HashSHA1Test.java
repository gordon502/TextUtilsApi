package pl.io.texttransformer.logic.hash;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class HashSHA1Test {
    @Test
    public void transform() {
        HashSHA1 t = new HashSHA1(new Transformation());

        assertEquals(t.transform("testing"), "dc724af18fbdd4e59189f5fe768a5f8311527050");
        assertEquals(t.transform("TESTING"), "cb73eb0155af5a3da3bb4a63646b40201ab650c4");
        assertEquals(t.transform("testinG Testing tESting"), "86b5f02326a25922e0a7df9a2d3d6689415f864e");
    }
}