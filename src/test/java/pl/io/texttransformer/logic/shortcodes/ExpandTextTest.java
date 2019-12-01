package pl.io.texttransformer.logic.shortcodes;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.Capitalize;

import static org.junit.Assert.assertEquals;

public class ExpandTextTest {

    @Test
    public void transform() {
        ExpandText t = new ExpandText(new Transformation());

        assertEquals(t.transform("m.in. to"), "między innymi to");
        assertEquals(t.transform("polej"), "polej");
        assertEquals(t.transform("prof. nadzw. dr hab. mgr inż. Łysy Klepacz Kodu"), "profesor nadzwyczajny doktor habilitowany magister inżynier Łysy Klepacz Kodu");
    }
}