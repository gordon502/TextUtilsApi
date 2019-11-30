package pl.io.texttransformer.logic.shortcodes;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.Capitalize;

import static org.junit.Assert.assertEquals;

public class ShortenTextTest {

    @Test
    public void transform() {
        ShortenText t = new ShortenText(new Transformation());

        assertEquals(t.transform("między innymi to"), "m.in. to");
        assertEquals(t.transform("polej"), "polej");
        assertEquals(t.transform("profesor nadzwyczajny doktor habilitowany magister inżynier Łysy Klepacz Kodu"), "prof. nadzw. dr hab. mgr inż. Łysy Klepacz Kodu");
    }
}