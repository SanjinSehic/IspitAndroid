package com.example.quiz;

public class Question {

    private String category;
    private String question;
    private boolean answer;

    public Question(String category, String question, boolean answer) {
        this.category = category;
        this.question = question;
        this.answer = answer;

    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
