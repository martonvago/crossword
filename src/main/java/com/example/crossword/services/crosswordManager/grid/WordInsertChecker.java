package com.example.crossword.services.crosswordManager.grid;

import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;

public class WordInsertChecker {
    private Grid grid;
    private LetterInsertChecker letterInsertChecker;

    public WordInsertChecker(Grid grid, LetterInsertChecker letterInsertChecker) {
        this.grid = grid;
        this.letterInsertChecker = letterInsertChecker;
    }

    public boolean canInsertWord(String word, GridCoordinates startCoords, ClueDirection dir) {
        int length = word.length();

        if (length < 2) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            GridCoordinates coords = GridCoordinatesHelper.getRelativeCoordinatesByClueDirection(startCoords, dir, i);

            if (!letterInsertChecker.canInsertLetter(word.charAt(i), coords, dir)) {
                return false;
            }

            if (i == 0 && !letterInsertChecker.canBeginWordInSquare(coords, dir)) {
                return false;
            }

            if (i == length - 1 && !letterInsertChecker.canEndWordInSquare(coords, dir)) {
                return false;
            }
        }

        return true;
    }
}
