package com.example.crossword.models;

public class InsertedClue {
    private Clue clue;
    private GridCoordinates startCoordinates;
    private ClueDirection direction;

    public InsertedClue(Clue clue, GridCoordinates startCoordinates, ClueDirection direction) {
        this.clue = clue;
        this.startCoordinates = startCoordinates;
        this.direction = direction;
    }

    public Clue getClue() {
        return clue;
    }

    public void setClue(Clue clue) {
        this.clue = clue;
    }

    public GridCoordinates getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(GridCoordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public ClueDirection getDirection() {
        return direction;
    }

    public void setDirection(ClueDirection direction) {
        this.direction = direction;
    }
}
