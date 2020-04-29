package com.example.crossword.services.grid;

import com.example.crossword.exceptions.gridExceptions.*;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.models.LetterSquare;

public class GridSquareSetter {
    private Grid grid;
    private GridTraversalHelper traversalHelper;

    public GridSquareSetter(Grid grid, GridTraversalHelper traversalHelper) {
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
        catch(CoordinatesOutOfBoundsException e) {
            throw new WordExceedsGridBoundariesException();
        }
        catch(InvalidLetterException e) {
            throw new InvalidWordException();
        }
    }
}
