package com.example.licenta.model;

public class Result {
    String chapter;
    float score;

    public Result(String chapter, float score) {
        this.chapter = chapter;
        this.score = score;
    }

    public String getChapter() {
        return chapter;
    }

    public float getScore() {
        return score;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setScore(float score) {
        this.score = score;
}
}