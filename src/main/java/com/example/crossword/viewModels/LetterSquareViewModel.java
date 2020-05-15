package com.example.crossword.viewModels;

public class LetterSquareViewModel {

    private Integer id;

    private Integer clueNum;

    private Character letter;

    private int rowNum;

    private int colNum;

    public LetterSquareViewModel() { }


    public Character getLetter() {
        return letter;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClueNum() {
        return clueNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

}
