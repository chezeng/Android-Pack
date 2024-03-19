package com.example.quizgame;

import java.util.ArrayList;

public class QuestionInfo {

    public String question;
    public String subject;
    public String category;
    public String[] answers;
    public ArrayList<String> choices = null;
    public int img = 0;

    public QuestionInfo(String question, String subject, String[] answers) {
        //this is the qna type
        this.question = question;
        this.subject = subject;
        this.answers = answers;
    }

    public QuestionInfo(String question, String subject, String[] answers,
                        String choice1, String choice2, String choice3,
                        String choice4) {
        //this is the multi choice type
        this.question = question;
        this.subject = subject;
        this.answers = answers;
        this.choices = new ArrayList<>();
        this.choices.add(choice1);
        this.choices.add(choice2);
        this.choices.add(choice3);
        this.choices.add(choice4);
    }

    public QuestionInfo(String question, String subject, String[] answers, int img) {
        //this is the img qna type
        this.question = question;
        this.subject = subject;
        this.answers = answers;
        this.img = img;
    }

}
