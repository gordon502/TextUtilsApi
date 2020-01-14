package pl.io.texttransformer.logic.shortcodes;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;
import pl.io.texttransformer.logic.transformations.Capitalize;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExpandTextTest {

    @Test
    public void transform() {
        Shortcodes mock = mock(Shortcodes.class);
        ArrayList<String[]> returnedList = new ArrayList<>();
        returnedList.add(new String[]{"m.in.","miedzy innymi"});
        returnedList.add(new String[]{"prof.","profesor"});
        returnedList.add(new String[]{"nadzw.","nadzwyczajny"});
        returnedList.add(new String[]{"dr","doktor"});
        returnedList.add(new String[]{"hab.","habilitowany"});
        returnedList.add(new String[]{"mgr","magister"});
        returnedList.add(new String[]{"inz.","inzynier"});

        when(mock.getShortcodesList()).thenReturn(returnedList);

        ExpandText t = new ExpandText(new Transformation(),mock);

        assertEquals(t.transform("m.in. to"), "miedzy innymi to");
        assertEquals(t.transform("polej"), "polej");
        assertEquals(t.transform("prof. nadzw. dr hab. mgr inz. Lysy Klepacz Kodu"), "profesor nadzwyczajny doktor habilitowany magister inzynier Lysy Klepacz Kodu");
    }
}