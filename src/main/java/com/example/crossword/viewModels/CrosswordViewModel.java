package com.example.crossword.viewModels;

import java.util.List;

public class CrosswordViewModel {
    private Integer id;

    private int numRows;

    private int numCols;

    private List<LetterSquareViewModel> letterSquares;

    private List<ClueViewModel> cluesAcross;

    private List<ClueViewModel> cluesDown;

    public CrosswordViewModel() { }

    public Integer getId() {
        return id;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public List<LetterSquareViewModel> getLetterSquares() {
        return letterSquares;
    }

    public List<ClueViewModel> getCluesAcross() {
        return cluesAcross;
    }

    public List<ClueViewModel> getCluesDown() {
        return cluesDown;
    }
}
