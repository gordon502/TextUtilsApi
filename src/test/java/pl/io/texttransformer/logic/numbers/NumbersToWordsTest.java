package pl.io.texttransformer.logic.numbers;

import org.junit.Test;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

public class NumbersToWordsTest {

    @Test
    public void transform() {
        NumbersToWords t = new NumbersToWords(new Transformation());

        assertEquals(t.transform("elo byku 123,./"), "elo byku sto dwadziescia trzy,./");
        assertEquals(t.transform(""), "");
        assertEquals(t.transform("WitaM PaNa 123, 10."), "WitaM PaNa sto dwadziescia trzy, dziesiec.");
        assertEquals(t.transform("Czesc 12,3553, 120"), "Czesc dwanascie i trzydziesci piec setnych, sto dwadziescia");
        assertEquals(t.transform("test,312, 32.558.."), "test,312, trzydziesci dwa i piecdziesiat piec setnych..");
    }
}