package com.example.crossword.modelTests;

import com.example.crossword.models.Grid;
import com.example.crossword.models.LetterSquare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GridTests {
    private static final int numRows = 20;
    private static final int numCols = 20;

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new Grid(numRows, numCols);
    }

    @Test
    public void constructorCreatesGridOfEmptySquares() {
        for (LetterSquare[] row : grid.getLetterSquares()) {
            for (LetterSquare sq : row) {
                assertFalse(sq.hasLetter());
            }
        }
    }

    @Test
    public void constructorCreatesGridWithSpecifiedDimensions() {
        assertEquals(numRows, grid.getLetterSquares().length);
        assertEquals(numRows, grid.getNumRows());

        assertEquals(numCols, grid.getLetterSquares()[0].length);
        assertEquals(numCols, grid.getNumCols());
    }
}
