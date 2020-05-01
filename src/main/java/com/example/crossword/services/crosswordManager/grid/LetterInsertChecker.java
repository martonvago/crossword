package com.example.crossword.services.crosswordManager.grid;

import com.example.crossword.exceptions.crosswordManagerExceptions.CoordinatesOutOfBoundsException;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.Grid;
import com.example.crossword.models.GridCoordinates;

public class LetterInsertChecker {
    private Grid grid;
    private GridTraversalHelper traversalHelper;

    public LetterInsertChecker(Grid grid, GridTraversalHelper traversalHelper) {
        this.grid = grid;
        this.traversalHelper = traversalHelper;
    }

    public boolean canInsertLetter(Character letter, GridCoordinates coords, ClueDirection dir) {
        try {
            return Character.isLetter(letter)
                    && traversalHelper.coordinatesAreInBounds(coords)
                    && letterCanFitInSquare(letter, coords, dir);
        }
        catch (CoordinatesOutOfBoundsException e) {
            return false;
        }
    }

    public boolean canBeginWordInSquare(GridCoordinates coords, ClueDirection dir) {
        return dir == ClueDirection.Across
                ? !traversalHelper.neighbouringSquareLeftIsOccupied(coords)
                : !traversalHelper.neighbouringSquareAboveIsOccupied(coords);
    }

    public boolean canEndWordInSquare(GridCoordinates coords, ClueDirection dir) {
        return dir == ClueDirection.Across
                ? !traversalHelper.neighbouringSquareRightIsOccupied(coords)
                : !traversalHelper.neighbouringSquareBelowIsOccupied(coords);
    }

    private boolean letterCanFitInSquare(Character letter, GridCoordinates coords, ClueDirection dir) throws CoordinatesOutOfBoundsException {
        return traversalHelper.squareIsOccupied(coords)
                ? letterMatchesSquare(letter, coords) && letterCanFitInOccupiedSquare(coords, dir)
                : letterCanFitInUnoccupiedSquare(coords, dir);
    }

    private boolean letterMatchesSquare(Character letter, GridCoordinates coords) throws CoordinatesOutOfBoundsException {
        return traversalHelper.getSquareAt(coords).getLetter() == letter;
    }

    private boolean letterCanFitInOccupiedSquare(GridCoordinates coords, ClueDirection dir) {
        return dir == ClueDirection.Across
                ? !traversalHelper.anyHorizontalNeighbouringSquaresAreOccupied(coords)
                : !traversalHelper.anyVerticalNeighbouringSquaresAreOccupied(coords);
    }

    private boolean letterCanFitInUnoccupiedSquare(GridCoordinates coords, ClueDirection dir) {
        return dir == ClueDirection.Across
                ? !traversalHelper.anyVerticalNeighbouringSquaresAreOccupied(coords)
                : !traversalHelper.anyHorizontalNeighbouringSquaresAreOccupied(coords);
    }
}
