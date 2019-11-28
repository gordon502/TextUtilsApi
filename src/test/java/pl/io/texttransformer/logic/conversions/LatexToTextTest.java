package pl.io.texttransformer.logic.conversions;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class LatexToTextTest {

    @Test
    public void transform(){
        LatexToText t = new LatexToText(new Transformation());

        assertEquals(t.transform("Witam \\$pana"), "Witam $pana");
        assertEquals(t.transform(""), "");
        assertEquals(t.transform("test \\& 1"), "test & 1");
    }
}
