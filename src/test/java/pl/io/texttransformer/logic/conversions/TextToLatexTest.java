package pl.io.texttransformer.logic.conversions;

import org.junit.Test;

import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class TextToLatexTest {

    @Test
    public void transform() {

        TextToLatex t = new TextToLatex(new Transformation());

        assertEquals(t.transform("Witam $"), "Witam \\$");
        assertEquals(t.transform(""), "");
        assertEquals(t.transform("12&eww2"), "12\\&eww2");
    }
}
