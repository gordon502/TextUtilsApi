package pl.io.texttransformer.logic.hash;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.*;

public class HashSHA256Test {

    @Test
    public void transform() {
        HashSHA256 t = new HashSHA256(new Transformation());

        assertEquals(t.transform("testing"), "cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90");
        assertEquals(t.transform("TESTING"), "5de71b2143c86cd2e0c801830ed729e7ef2f8f478b454d7d3e9dd5a86a92b255");
        assertEquals(t.transform("testinG Testing tESting"), "998b3b8d55072d74eccc9bcf1ae52c766ed5aec23d3146b28be475ab5decd15b");
    }
}