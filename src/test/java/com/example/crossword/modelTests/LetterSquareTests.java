package com.example.crossword.modelTests;

import com.example.crossword.exceptions.InvalidLetterException;
import com.example.crossword.models.LetterSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LetterSquareTests {

    @Test
    public void canCreateEmptySquare() {
        LetterSquare sq = LetterSquare.Empty();
        assertSquareIsEmpty(sq);
    }

    @Test
    public void canCreateSquareWithLetter() throws InvalidLetterException {
        LetterSquare sq = LetterSquare.Letter('A');
        assertSquareContainsLetter('A', sq);
    }

    @Test
    public void canClearLetter() throws InvalidLetterException {
        LetterSquare sq = LetterSquare.Letter('A');
        sq.clearLetter();
        assertSquareIsEmpty(sq);
    }

    @Test
    public void canSetLetter() throws InvalidLetterException {
        LetterSquare sq = LetterSquare.Empty();
        sq.setLetter('A');
        assertSquareContainsLetter('A', sq);
    }

    @Test
    public void canChangeLetter() throws InvalidLetterException {
        LetterSquare sq = LetterSquare.Letter('A');
        sq.setLetter('B');
        assertSquareContainsLetter('B', sq);
    }

    @Test
    public void cannotSetLetterToNonLetterCharacter() {
        assertThrows(InvalidLetterException.class, () -> { LetterSquare.Letter('9'); });
        assertThrows(InvalidLetterException.class, () -> { LetterSquare.Empty().setLetter('@'); });
    }

    @Test
    public void cannotSetLetterToNullExplicitly() {
        assertThrows(NullPointerException.class, () -> { LetterSquare.Letter(null); });
        assertThrows(NullPointerException.class, () -> { LetterSquare.Empty().setLetter(null); });
    }

    private void assertSquareIsEmpty(LetterSquare sq) {
        assertFalse(sq.hasLetter());
        assertNull(sq.getLetter());
    }

    private void assertSquareContainsLetter(Character letter, LetterSquare sq) {
        assertTrue(sq.hasLetter());
        assertEquals(letter, sq.getLetter());
    }
}
