package com.example.crossword.services.crosswordManager.grid;

import com.example.crossword.exceptions.crosswordManagerExceptions.WordInsertException;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;

public class GridManager {
    private Grid grid;
    private GridTraversalHelper traversalHelper;
    private WordInsertChecker wordInsertChecker;
    private WordInsertHelper wordInsertHelper;

    public GridManager(Grid grid) {
        this.grid = grid;
        traversalHelper = new GridTraversalHelper(grid);
        wordInsertChecker = new WordInsertChecker(grid, new LetterInsertChecker(grid, traversalHelper));
        wordInsertHelper = new WordInsertHelper(grid, traversalHelper);
    }

    public boolean canInsertWord(String word, GridCoordinates startCoords, ClueDirection direction) {
        return wordInsertChecker.canInsertWord(word, startCoords, direction);
    }

    public void insertWord(String word, GridCoordinates startCoords, ClueDirection direction) throws WordInsertException {
        if (!canInsertWord(word, startCoords, direction)) {
            throw new WordInsertException();
        }
        wordInsertHelper.insertWord(word, startCoords, direction);
    }
}
