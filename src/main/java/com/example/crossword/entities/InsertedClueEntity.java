package com.example.crossword.entities;

import javax.persistence.*;

@Entity
@Table(name= "insertedClue")
public class InsertedClueEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "clue_id")
    private ClueEntity clue;

    @ManyToOne
    @JoinColumn(name= "crossword_id")
    private CrosswordEntity crossword;

    private Integer row;

    private Integer col;

    private Integer direction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClueEntity getClue() {
        return clue;
    }

    public void setClue(ClueEntity clue) {
        this.clue = clue;
    }

    public CrosswordEntity getCrossword() {
        return crossword;
    }

    public void setCrossword(CrosswordEntity crossword) {
        this.crossword = crossword;
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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}
