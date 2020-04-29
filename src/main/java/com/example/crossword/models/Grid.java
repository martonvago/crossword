package com.example.crossword.models;

import java.util.stream.Stream;

public class Grid {
    private int numRows;
    private int numCols;
    private LetterSquare[][] grid;

    public Grid(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        grid = generateEmptyGrid();
    }

    public LetterSquare[][] getGrid() {
        return grid;
    }

    private LetterSquare[][] generateEmptyGrid() {
        return Stream
                .generate(this::generateEmptyRow)
                .limit(numRows)
                .toArray(LetterSquare[][]::new);
    }

    private LetterSquare[] generateEmptyRow() {
        return Stream
                .generate(LetterSquare::Empty)
                .limit(numCols)
                .toArray(LetterSquare[]::new);
    }
}
