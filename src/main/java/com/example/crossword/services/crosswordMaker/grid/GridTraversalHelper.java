package com.example.crossword.services.crosswordMaker.grid;

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

    public LetterSquare getRelativeSquareByClueDirection(GridCoordinates coords, ClueDirection dir, int distance) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.getRelativeCoordinatesByClueDirection(coords, dir, distance));
    }

    public boolean squareIsOccupied(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return getSquareAt(coords).hasLetter();
    }

    public LetterSquare getNeighbouringSquareAbove(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.above(coords));
    }

    public LetterSquare getNeighbouringSquareRight(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.right(coords));
    }

    public LetterSquare getNeighbouringSquareBelow(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.below(coords));
    }

    public LetterSquare getNeighbouringSquareLeft(GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return getSquareAt(GridCoordinatesHelper.left(coords));
    }

    public boolean neighbouringSquareAboveIsOccupied(GridCoordinates coords) {
        try {
            return getNeighbouringSquareAbove(coords).hasLetter();
        }
        catch (CoordinatesOutOfBoundsException e) {
            return false;
        }
    }

    public boolean neighbouringSquareRightIsOccupied(GridCoordinates coords) {
        try {
            return getNeighbouringSquareRight(coords).hasLetter();
        }
        catch (CoordinatesOutOfBoundsException e) {
            return false;
        }
    }

    public boolean neighbouringSquareBelowIsOccupied(GridCoordinates coords) {
        try {
            return getNeighbouringSquareBelow(coords).hasLetter();
        }
        catch (CoordinatesOutOfBoundsException e) {
            return false;
        }
    }

    public boolean neighbouringSquareLeftIsOccupied(GridCoordinates coords) {
        try {
            return getNeighbouringSquareLeft(coords).hasLetter();
        }
        catch (CoordinatesOutOfBoundsException e) {
            return false;
        }
    }

    public boolean anyHorizontalNeighbouringSquaresAreOccupied(GridCoordinates coords) {
        return neighbouringSquareLeftIsOccupied(coords) || neighbouringSquareRightIsOccupied(coords);
    }

    public boolean anyVerticalNeighbouringSquaresAreOccupied(GridCoordinates coords) {
        return neighbouringSquareAboveIsOccupied(coords) || neighbouringSquareBelowIsOccupied(coords);
    }
}
