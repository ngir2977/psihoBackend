package com.example.licenta.model;

public class ResultTest {
    private String email;
    private String chapter;

    public ResultTest(String email, String chapter) {
        this.email = email;
        this.chapter = chapter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
