package com.example.crossword.services.crosswordManager;

import com.example.crossword.models.Clue;
import com.example.crossword.exceptions.crosswordManagerExceptions.CannotLoadCrosswordException;
import com.example.crossword.exceptions.crosswordManagerExceptions.WordInsertException;
import com.example.crossword.models.*;
import com.example.crossword.repositories.CrosswordRepository;
import com.example.crossword.services.crosswordManager.clue.ClueFinder;
import com.example.crossword.services.crosswordManager.grid.GridManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CrosswordInsertManager {
    @Autowired
    private CrosswordRepository crosswordRepository;

    private Crossword crossword;
    private Grid grid;
    private GridManager gridManager;
    private ClueFinder clueFinder;

    private CrosswordInsertManager(Crossword crossword, Grid grid, GridManager gridManager, ClueFinder clueFinder) {
        this.crossword = crossword;
        this.grid = grid;
        this.gridManager = gridManager;
        this.clueFinder = clueFinder;
    }

    public static CrosswordInsertManager NewCrossword(int gridRows, int gridColumns) {
        Crossword crossword = new Crossword();
        crossword.setInsertedClues(new ArrayList<>());
        crossword.setNumRows(gridRows);
        crossword.setNumColumns(gridColumns);

        Grid grid = new Grid(gridRows, gridColumns);
        GridManager gridManager = new GridManager(grid);
        ClueFinder clueFinder = new ClueFinder(gridManager);

        return new CrosswordInsertManager(crossword, grid, gridManager, clueFinder);
    }

    public static CrosswordInsertManager LoadCrossword(Crossword crossword) throws CannotLoadCrosswordException {
        Grid grid = new Grid(crossword.getNumRows(), crossword.getNumColumns());
        GridManager gridManager = new GridManager(grid);
        ClueFinder clueFinder = new ClueFinder(gridManager);

        try {
            populateGrid(gridManager, crossword.getInsertedClues());
            return new CrosswordInsertManager(crossword, grid, gridManager, clueFinder);
        }
        catch(WordInsertException e) {
            throw new CannotLoadCrosswordException();
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void insertClue(Clue clue, GridCoordinates startCoords, ClueDirection dir) throws WordInsertException {
        gridManager.insertWord(clue.getAnswer(), startCoords, dir);
        crossword.getInsertedClues().add(new InsertedClue(clue, this.crossword, startCoords, dir));
    }

    public List<Clue> findCluesThatCanBeInserted(GridCoordinates startCoords, ClueDirection dir) {
        return clueFinder.findCluesThatCanBeInserted(startCoords, dir);
    }

    private static void populateGrid(GridManager gridManager, List<InsertedClue> insertedClues) throws WordInsertException {
        for (InsertedClue insertedClue : insertedClues) {
            gridManager.insertWord(insertedClue.getClue().getAnswer(), insertedClue.getStartCoordinates(), insertedClue.getDirection());
        }
    }
}
