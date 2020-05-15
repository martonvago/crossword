package com.example.crossword.models;

import javax.persistence.*;

@Entity
@Table(name= "insertedClue")
public class InsertedClue {
    public InsertedClue() {
    }

    public InsertedClue(Clue clue, Crossword crossword, GridCoordinates startCoords, ClueDirection direction) {
        this.clue = clue;
        this.crossword = crossword;
        this.row = startCoords.getRow();
        this.col = startCoords.getColumn();
        this.direction = direction;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "clue_id")
    private Clue clue;

    @ManyToOne
    @JoinColumn(name= "crossword_id")
    private Crossword crossword;

    private Integer row;

    private Integer col;

    @Enumerated(EnumType.ORDINAL)
    private ClueDirection direction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clue getClue() {
        return clue;
    }

    public void setClue(Clue clue) {
        this.clue = clue;
    }

    public Crossword getCrossword() {
        return crossword;
    }

    public void setCrossword(Crossword crossword) {
        this.crossword = crossword;
    }

    public GridCoordinates getStartCoordinates() {
        return new GridCoordinates(row, col);
    }

    public void setStartCoordinates(GridCoordinates startCoordinates) {
        this.row = startCoordinates.getRow();
        this.col = startCoordinates.getColumn();
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public ClueDirection getDirection() {
        return direction;
    }

    public void setDirection(ClueDirection direction) {
        this.direction = direction;
    }
}
