package pl.io.texttransformer.logic.numbers;

import org.junit.Test;
import pl.io.texttransformer.logic.numbers.NumbersUtils;
import pl.io.texttransformer.logic.Transformation;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class NumbersToWordsTest {

    @Test
    public void transform() {

        NumbersUtils mock = mock(NumbersUtils.class);
        when(mock.singleNumberTransform("123")).thenReturn("sto dwadziescia trzy");
        when(mock.singleNumberTransform("10")).thenReturn("dziesiec");
        when(mock.singleNumberTransform("12.3553")).thenReturn("dwanascie i trzydziesci piec setnych");
        when(mock.singleNumberTransform("120")).thenReturn("sto dwadziescia");
        when(mock.singleNumberTransform("32.558")).thenReturn("trzydziesci dwa i piecdziesiat piec setnych");

        NumbersToWords t = new NumbersToWords(new Transformation(), mock);

        mock.singleNumberTransform("123");
        verify(mock).singleNumberTransform("123");

        mock.singleNumberTransform("10");
        verify(mock).singleNumberTransform("10");

        mock.singleNumberTransform("12.3553");
        verify(mock).singleNumberTransform("12.3553");

        mock.singleNumberTransform("120");
        verify(mock).singleNumberTransform("120");

        mock.singleNumberTransform("32.558");
        verify(mock).singleNumberTransform("32.558");

        assertEquals(t.transform("elo byku 123,./"), "elo byku sto dwadziescia trzy,./");
        assertEquals(t.transform(""), "");
        assertEquals(t.transform("WitaM PaNa 123, 10."), "WitaM PaNa sto dwadziescia trzy, dziesiec.");
        assertEquals(t.transform("Czesc 12,3553, 120"), "Czesc dwanascie i trzydziesci piec setnych, sto dwadziescia");
        assertEquals(t.transform("test,312, 32.558.."), "test,312, trzydziesci dwa i piecdziesiat piec setnych..");

    }
}