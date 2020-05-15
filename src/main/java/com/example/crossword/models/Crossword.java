package com.example.crossword.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "crossword")
public class Crossword {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer numRows;

    private Integer numColumns;

    @OneToMany(cascade= CascadeType.ALL)
    private List<InsertedClue> insertedClues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumRows() {
        return numRows;
    }

    public void setNumRows(Integer numRows) {
        this.numRows = numRows;
    }

    public Integer getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(Integer numColumns) {
        this.numColumns = numColumns;
    }

    public List<InsertedClue> getInsertedClues() {
        return insertedClues;
    }

    public void setInsertedClues(List<InsertedClue> insertedClues) {
        this.insertedClues = insertedClues;
    }
}