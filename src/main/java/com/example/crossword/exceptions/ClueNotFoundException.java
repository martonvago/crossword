package com.example.crossword.exceptions;

public class ClueNotFoundException extends Exception {
    public ClueNotFoundException(Integer clueId) {
        super("Couldn't find clue with id " + clueId.toString());
    }
}
