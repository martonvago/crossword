package com.example.crossword.models;

import com.example.crossword.entities.ClueEntity;
import com.example.crossword.entities.InsertedClueEntity;

public class InsertedClue {
    private ClueEntity clue;
    private GridCoordinates startCoordinates;
    private ClueDirection direction;

    public InsertedClue(ClueEntity clue, GridCoordinates startCoordinates, ClueDirection direction) {
        this.clue = clue;
        this.startCoordinates = startCoordinates;
        this.direction = direction;
    }

    public InsertedClue(InsertedClueEntity insertedClueEntity) {

    }

    public ClueEntity getClue() {
        return clue;
    }

    public void setClue(ClueEntity clue) {
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
