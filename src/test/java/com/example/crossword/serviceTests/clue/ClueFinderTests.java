package com.example.crossword.serviceTests.clue;

import com.example.crossword.entities.ClueEntity;
import com.example.crossword.exceptions.crosswordManagerExceptions.WordInsertException;
import com.example.crossword.models.*;
import com.example.crossword.repositories.ClueRepository;
import com.example.crossword.services.crosswordManager.clue.ClueFinder;
import com.example.crossword.services.crosswordManager.grid.GridManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClueFinderTests {
    private ClueFinder clueFinder;
    private GridManager gridManager;

    private ClueEntity alpha;
    private ClueEntity bravo;
    private ClueEntity charlie;
    private ClueEntity delta;
    private ClueEntity echo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Grid grid = new Grid(10, 10);
        ClueRepository clueRepository = mock(ClueRepository.class);

        gridManager = new GridManager(grid);
        clueFinder = new ClueFinder(clueRepository, gridManager);

        alpha = dummyClue("ALPHA");
        bravo = dummyClue("BRAVO");
        charlie = dummyClue("CHARLIE");
        delta = dummyClue("DELTA");
        echo = dummyClue("ECHO");

        when(clueRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(
            alpha, bravo, charlie, delta, echo
        )));
    }

    @Test
    public void canFindAllClues() {
        GridCoordinates coords = new GridCoordinates(0, 0);
        ClueDirection dir = ClueDirection.Across;

        List<ClueEntity> expected = new ArrayList<>(Arrays.asList(alpha, bravo, charlie, delta, echo));
        List<ClueEntity> actual = clueFinder.findCluesThatCanBeInserted(coords, dir);

        assertEquals(expected, actual);
    }

    @Test
    public void filtersCluesByMatchingIntersectingLetters() throws WordInsertException {
        GridCoordinates coords1 = new GridCoordinates(5, 0);
        ClueDirection dir1 = ClueDirection.Across;

        gridManager.insertWord(alpha.getAnswer(), coords1, dir1);

        GridCoordinates coords2 = new GridCoordinates(3, 0);
        ClueDirection dir2 = ClueDirection.Down;

        List<ClueEntity> expected = new ArrayList<>(Arrays.asList(bravo, charlie));
        List<ClueEntity> actual = clueFinder.findCluesThatCanBeInserted(coords2, dir2);

        assertEquals(expected, actual);
    }

    @Test
    public void filtersCluesThatAreTooLongToFitInGrid() {
        GridCoordinates coords = new GridCoordinates(0, 6);
        ClueDirection dir = ClueDirection.Across;

        List<ClueEntity> expected = new ArrayList<>(Arrays.asList(echo));
        List<ClueEntity> actual = clueFinder.findCluesThatCanBeInserted(coords, dir);

        assertEquals(expected, actual);
    }

    private ClueEntity dummyClue(String answer) {
        ClueEntity clue = new ClueEntity();
        clue.setAnswer(answer);
        return clue;
    }
}
