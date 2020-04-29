package com.example.crossword.models;

import com.example.crossword.exceptions.gridExceptions.InvalidLetterException;
import org.springframework.lang.NonNull;

public class LetterSquare {
    private Character letter = null;

    private LetterSquare() { }

    public static LetterSquare Empty() {
        return new LetterSquare();
    }

    public static LetterSquare Letter(@NonNull Character letter) throws InvalidLetterException {
        LetterSquare ls = new LetterSquare();
        ls.setLetter(letter);
        return ls;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(@NonNull Character letter) throws InvalidLetterException {
        if (!Character.isLetter(letter)) {
            throw new InvalidLetterException();
        }

        this.letter = letter;
    }

    public void clearLetter() {
        letter = null;
    }

    public boolean hasLetter() {
        return letter != null;
    }
}
