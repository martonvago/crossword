package com.example.crossword.services.grid;

import com.example.crossword.exceptions.gridExceptions.CoordinatesOutOfBoundsException;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.models.LetterSquare;

public class GridTraversalHelper {
    private Grid grid;

    public GridTraversalHelper(Grid grid) {
        this.grid = grid;
    }

    public boolean coordinatesAreInBounds(GridCoordinates coords) {
        return coords.getRow() >= 0
                && coords.getRow() < grid.getNumRows()
                && coords.getColumn() >= 0
                && coords.getColumn() < grid.getNumCols();
    }

    public LetterSquare getSquareAt(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        if (!coordinatesAreInBounds(coords)) {
            throw new CoordinatesOutOfBoundsException();
        }
        return grid.getLetterSquares()[coords.getRow()][coords.getColumn()];
    }

    public LetterSquare getRelativeSquareByClueDirection(GridCoordinates coords, ClueDirection direction, int distance) throws CoordinatesOutOfBoundsException {
        LetterSquare sq = null;

        switch (direction) {
            case Across:
                sq = getSquareRightBy(coords, distance);
                break;
            case Down:
                sq = getSquareBelowBy(coords, distance);
                break;
        }

        return sq;
    }

    public LetterSquare getSquareAboveBy(GridCoordinates coords, int distance) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.aboveBy(coords, distance));
    }

    public LetterSquare getSquareRightBy(GridCoordinates coords, int distance) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.rightBy(coords, distance));
    }

    public LetterSquare getSquareBelowBy(GridCoordinates coords, int distance) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.belowBy(coords, distance));
    }

    public LetterSquare getSquareLeftBy(GridCoordinates coords, int distance) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.leftBy(coords, distance));
    }

    public boolean gridHasSquareAbove(GridCoordinates coords) {
        return coordinatesAreInBounds(GridCoordinatesHelper.aboveBy(coords, 1));
    }

    public boolean gridHasSquareRight(GridCoordinates coords) {
        return coordinatesAreInBounds(GridCoordinatesHelper.rightBy(coords, 1));
    }

    public boolean gridHasSquareBelow(GridCoordinates coords) {
        return coordinatesAreInBounds(GridCoordinatesHelper.belowBy(coords, 1));
    }

    public boolean gridHasSquareLeft(GridCoordinates coords) {
        return coordinatesAreInBounds(GridCoordinatesHelper.leftBy(coords, 1));
    }
}
