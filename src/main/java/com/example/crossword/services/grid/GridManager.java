package com.example.crossword.services.grid;

import com.example.crossword.exceptions.gridExceptions.*;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;

public class GridManager {
    private Grid grid;
    private GridTraversalHelper traversalHelper;
    private GridWordFitCheker fitChecker;
    private GridSquareSetter squareSetter;

    public GridManager(Grid grid) {
        this.grid = grid;
        traversalHelper = new GridTraversalHelper(grid);
        fitChecker = new GridWordFitCheker(grid, traversalHelper);
        squareSetter = new GridSquareSetter(grid, traversalHelper);
    }

    public boolean wordFits(String word, GridCoordinates startCoords, ClueDirection direction) {
        return fitChecker.wordFits(word, startCoords, direction);
    }

    public void insertWord(String word, GridCoordinates startCoords, ClueDirection direction) throws WordInsertException {
        fitChecker.assertWordFits(word, startCoords, direction);
        squareSetter.insertWord(word, startCoords, direction);
    }
}
