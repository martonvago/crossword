package com.example.crossword.services.grid;

import com.example.crossword.models.GridCoordinates;

public class GridCoordinatesHelper {
    private GridCoordinatesHelper() { }

    public static GridCoordinates aboveBy(GridCoordinates coords, int distance) {
        return new GridCoordinates(coords.getRow() - distance, coords.getColumn());
    }

    public static GridCoordinates rightBy(GridCoordinates coords, int distance) {
        return new GridCoordinates(coords.getRow(), coords.getColumn() + distance);
    }

    public static GridCoordinates belowBy(GridCoordinates coords, int distance) {
        return new GridCoordinates(coords.getRow() + distance, coords.getColumn());
    }

    public static GridCoordinates leftBy(GridCoordinates coords, int distance) {
        return new GridCoordinates(coords.getRow(), coords.getColumn() - distance);
    }
}
