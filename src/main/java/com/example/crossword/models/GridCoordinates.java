package com.example.crossword.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof GridCoordinates)) {
            return false;
        }

        return coordinatesAreIdentical(this, (GridCoordinates)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    private static boolean coordinatesAreIdentical(GridCoordinates coords1, GridCoordinates coords2) {
        return coords1.getRow() == coords2.getRow()
                && coords1.getColumn() == coords2.getColumn();
    }
}
