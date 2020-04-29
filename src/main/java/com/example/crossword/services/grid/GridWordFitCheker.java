package com.example.crossword.services.grid;

import com.example.crossword.exceptions.gridExceptions.DanglingWordsCreatedException;
import com.example.crossword.exceptions.gridExceptions.IntersectingLettersDoNotMatchException;
import com.example.crossword.exceptions.gridExceptions.WordExceedsGridBoundariesException;
import com.example.crossword.exceptions.gridExceptions.WordInsertException;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;

public class GridWordFitCheker {
    private Grid grid;
    private GridTraversalHelper traversalHelper;

    public GridWordFitCheker(Grid grid, GridTraversalHelper traversalHelper) {
        this.grid = grid;
        this.traversalHelper = traversalHelper;
    }
    
    public boolean wordFits(String word, GridCoordinates startCoords, ClueDirection direction) {
        return wordFitsInGridBoundaries(word, startCoords, direction)
                && lettersMatchExistingLettersAtAllIntersectionPoints(word, startCoords, direction)
                && noDanglingWordsCreated(word, startCoords, direction);
    }
    
    public void assertWordFits(String word, GridCoordinates startCoords, ClueDirection direction) throws WordInsertException {
        if (!wordFitsInGridBoundaries(word, startCoords, direction)) {
            throw new WordExceedsGridBoundariesException();
        }

        if (!lettersMatchExistingLettersAtAllIntersectionPoints(word, startCoords, direction)) {
            throw new IntersectingLettersDoNotMatchException();
        }

        if (!noDanglingWordsCreated(word, startCoords, direction)) {
            throw new DanglingWordsCreatedException();
        }
    }

    private boolean wordFitsInGridBoundaries(String word, GridCoordinates startCoords, ClueDirection direction) {
        return true;
    }
    
    private boolean lettersMatchExistingLettersAtAllIntersectionPoints(String word, GridCoordinates startCoords, ClueDirection direction) {
        return true;
    }
    
    private boolean noDanglingWordsCreated(String word, GridCoordinates startCoords, ClueDirection direction) {
        return true;
    }
}
