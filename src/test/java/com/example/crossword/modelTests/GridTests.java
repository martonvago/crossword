package com.example.crossword.modelTests;

import com.example.crossword.models.Grid;
import com.example.crossword.models.LetterSquare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GridTests {
    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new Grid(20, 40);
    }

    @Test
    public void constructorCreatesGridOfEmptySquares() {
        for (LetterSquare[] row : grid.getGrid()) {
            for (LetterSquare sq : row) {
                assertFalse(sq.hasLetter());
            }
        }
    }

    @Test
    public void constructorCreatesGridWithCorrectDimensions() {
        assertEquals(20, grid.getGrid().length);
        assertEquals(40, grid.getGrid()[0].length);
    }
}
