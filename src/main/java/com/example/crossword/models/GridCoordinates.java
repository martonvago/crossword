package com.example.crossword.models;

public class GridCoordinates {
    private int row;
    private int column;

    public GridCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
