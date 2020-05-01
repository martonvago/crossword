package com.example.crossword.serviceTests.grid;

import com.example.crossword.exceptions.crosswordManagerExceptions.WordInsertException;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.services.crosswordManager.grid.GridManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridManagerTests {

    private GridManager gridManager;

    @BeforeEach
    public void setUp() {
        Grid grid = new Grid(10, 10);
        gridManager = new GridManager(grid);
    }

    @Test
    public void canAddWord() {
        String word = "TEST";
        GridCoordinates startCoords = new GridCoordinates(0, 0);
        ClueDirection dir = ClueDirection.Across;

        assertCanInsertWord(word, startCoords, dir);
    }

    @Test
    public void cannotAddWordIfStartCoordsOutOfBounds() {
        String word = "TEST";
        GridCoordinates startCoords = new GridCoordinates(-1, 0);
        ClueDirection dir = ClueDirection.Across;

        assertCannotInsertWord(word, startCoords, dir);
    }

    @Test
    public void cannotAddWordIfTooLongToFitInGrid() {
        String word = "TEST";
        GridCoordinates startCoords = new GridCoordinates(7, 0);
        ClueDirection dir = ClueDirection.Down;

        assertCannotInsertWord(word, startCoords, dir);
    }

    @Test
    public void canAddWordIfIntersectingLettersMatch() throws WordInsertException {
        String word1 = "ONE";
        GridCoordinates startCoords1 = new GridCoordinates(5, 9);
        ClueDirection dir1 = ClueDirection.Down;

        gridManager.insertWord(word1, startCoords1, dir1);

        String word2 = "TWO";
        GridCoordinates startCoords2 = new GridCoordinates(5, 7);
        ClueDirection dir2 = ClueDirection.Across;

        assertCanInsertWord(word2, startCoords2, dir2);
    }

    @Test
    public void cannotAddWordIfIntersectingLettersDoNotMatch() throws WordInsertException {
        String word1 = "ONE";
        GridCoordinates startCoords1 = new GridCoordinates(0, 2);
        ClueDirection dir1 = ClueDirection.Down;

        gridManager.insertWord(word1, startCoords1, dir1);

        String word2 = "TWO";
        GridCoordinates startCoords2 = new GridCoordinates(1, 1);
        ClueDirection dir2 = ClueDirection.Across;

        assertCannotInsertWord(word2, startCoords2, dir2);
    }

    @Test
    public void cannotAddWordIfWouldCreateExtraWord() throws WordInsertException {
        String word1 = "ONE";
        GridCoordinates startCoords1 = new GridCoordinates(0, 5);
        ClueDirection dir1 = ClueDirection.Across;

        gridManager.insertWord(word1, startCoords1, dir1);

        String word2 = "TWO";
        GridCoordinates startCoords2 = new GridCoordinates(1, 6);
        ClueDirection dir2 = ClueDirection.Across;

        assertCannotInsertWord(word2, startCoords2, dir2);
    }

    private void assertCanInsertWord(String word, GridCoordinates startCoords, ClueDirection direction) {
        assertTrue(gridManager.canInsertWord(word, startCoords, direction));
        assertDoesNotThrow(() -> { gridManager.insertWord(word, startCoords, direction); });
    }

    private void assertCannotInsertWord(String word, GridCoordinates startCoords, ClueDirection direction) {
        assertFalse(gridManager.canInsertWord(word, startCoords, direction));
        assertThrows(WordInsertException.class, () -> { gridManager.insertWord(word, startCoords, direction); });
    }
}
