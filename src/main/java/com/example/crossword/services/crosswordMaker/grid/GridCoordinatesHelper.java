package com.example.crossword.services.crosswordMaker.grid;

import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.GridCoordinates;

public class GridCoordinatesHelper {
    private GridCoordinatesHelper() { }

    public static GridCoordinates above(GridCoordinates coords) {
        return new GridCoordinates(coords.getRow() - 1, coords.getColumn());
    }

    public static GridCoordinates right(GridCoordinates coords) {
        return new GridCoordinates(coords.getRow(), coords.getColumn() + 1);
    }

    public static GridCoordinates below(GridCoordinates coords) {
        return new GridCoordinates(coords.getRow() + 1, coords.getColumn());
    }

    public static GridCoordinates left(GridCoordinates coords) {
        return new GridCoordinates(coords.getRow(), coords.getColumn() - 1);
    }

    public static GridCoordinates getRelativeCoordinatesByClueDirection(GridCoordinates coords, ClueDirection dir, int distance) {
        return dir == ClueDirection.Across
                ? new GridCoordinates(coords.getRow(), coords.getColumn() + distance)
                : new GridCoordinates(coords.getRow() + distance, coords.getColumn());
    }
}
