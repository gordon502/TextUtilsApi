package pl.io.texttransformer.logic.hash;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class HashMD5Test {
    @Test
    public void transform() {
        HashMD5 t = new HashMD5(new Transformation());

        assertEquals(t.transform("testing"), "ae2b1fca515949e5d54fb22b8ed95575");
        assertEquals(t.transform("TESTING"), "907953dcbd01ad68db1f19be286936f4");
        assertEquals(t.transform("testinG Testing tESting"), "5abf35cbababaec015babfd1d388c7aa");
    }
}