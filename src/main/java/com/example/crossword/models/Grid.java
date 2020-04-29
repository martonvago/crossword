package com.example.crossword.models;

import java.util.stream.Stream;

public class Grid {
    private int numRows;
    private int numCols;
    private LetterSquare[][] letterSquares;

    public Grid(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        letterSquares = generateEmptyGrid();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public LetterSquare[][] getLetterSquares() {
        return letterSquares;
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
