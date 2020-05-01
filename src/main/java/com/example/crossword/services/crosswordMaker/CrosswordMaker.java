package com.example.crossword.services.crosswordMaker;

import com.example.crossword.exceptions.gridExceptions.WordInsertException;
import com.example.crossword.models.*;
import com.example.crossword.services.crosswordMaker.clue.ClueFinder;
import com.example.crossword.services.crosswordMaker.grid.GridManager;

import java.util.ArrayList;
import java.util.List;

public class CrosswordMaker {
    private Grid grid;
    private GridManager gridManager;
    private List<InsertedClue> clueList;
    private ClueFinder clueFinder;

    public CrosswordMaker(int gridRows, int gridColumns) {
        grid = new Grid(gridRows, gridColumns);
        gridManager = new GridManager(grid);
        clueList = new ArrayList<>();
        clueFinder = new ClueFinder(gridManager);
    }

    public Grid getGrid() {
        return grid;
    }

    public void insertClue(Clue clue, GridCoordinates startCoords, ClueDirection dir) throws WordInsertException {
        gridManager.insertWord(clue.getAnswer(), startCoords, dir);
        clueList.add(new InsertedClue(clue, startCoords, dir));
    }

    public List<Clue> findCluesThatCanBeInserted(GridCoordinates startCoords, ClueDirection dir) {
        return clueFinder.findCluesThatCanBeInserted(startCoords, dir);
    }
}
