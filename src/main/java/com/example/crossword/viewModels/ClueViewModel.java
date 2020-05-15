package com.example.crossword.viewModels;

public class ClueViewModel {
    private Integer id;

    private String hint;

    private String answer;

    private Integer clueNum;

    public ClueViewModel() { }

    public Integer getId() {
        return id;
    }

    public String getHint() {
        return hint;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getClueNum() {
        return clueNum;
    }
}
