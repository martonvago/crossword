package com.example.crossword.services;

import com.example.crossword.exceptions.gridExceptions.WordInsertException;
import com.example.crossword.models.*;
import com.example.crossword.services.grid.GridManager;

import java.util.ArrayList;
import java.util.List;

public class CrosswordMaker {
    private GridManager gridManager;
    private List<InsertedClue> clueList;

    public CrosswordMaker(int gridRows, int gridColumns) {
        gridManager = new GridManager(new Grid(gridRows, gridColumns));
        clueList = new ArrayList<>();
    }

    public void insertClue(Clue clue, GridCoordinates startCoords, ClueDirection dir) throws WordInsertException {
        gridManager.insertWord(clue.getAnswer(), startCoords, dir);
        clueList.add(new InsertedClue(clue, startCoords, dir));
    }
}
