package com.example.crossword.models;

import javax.persistence.*;

@Entity
@Table(name= "clue")
public class Clue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String hint;

    private String answer;

    private String topic;

    private String style;

    private String author;

    private String difficulty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String clue) {
        this.hint = clue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
