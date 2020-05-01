package com.example.crossword.services.crosswordMaker.grid;

import com.example.crossword.exceptions.gridExceptions.*;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.models.LetterSquare;

public class WordInsertHelper {
    private Grid grid;
    private GridTraversalHelper traversalHelper;

    public WordInsertHelper(Grid grid, GridTraversalHelper traversalHelper) {
        this.grid = grid;
        this.traversalHelper = traversalHelper;
    }

    public void insertWord(String word, GridCoordinates startCoords, ClueDirection direction) throws WordInsertException {
        try {
            for (int i = 0; i < word.length(); i++) {
                LetterSquare sq = traversalHelper.getRelativeSquareByClueDirection(startCoords, direction, i);
                sq.setLetter(word.charAt(i));
            }
        }
        catch(Exception e) {
            throw new WordInsertException();
        }
    }
}
