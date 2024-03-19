package com.example.quizgame;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

public class CurrentGame {

    private static final int MAX_NUM_QUESTIONS = 11;
    private static final int MAX_NUM_GRADE_LEVELS = 5;

    ArrayList<QuestionInfo> currentQuestions = new ArrayList<>();
    int currentQuestionInd = -1;
    String currentAnswer = "";
    GameState currentState = null;

    private static CurrentGame instance = null;
    public static CurrentGame get() {
        if (instance == null) {
            instance = new CurrentGame();
        }
        return instance;
    }

    public static QuestionInfo getCurrentQuestion() {
        if (instance != null) {
            return instance.currentQuestions.get(instance.currentQuestionInd);
        }
        return null;
    }

    /* Load a set of 3 hard-coded questions for the demo game,
    *  used during implementation and debugging of the game's features. */
    public static void loadDemoGameQuestions() {
        if (instance == null) {
            return;
        }
        instance.currentQuestions = new ArrayList<>();
        QuestionInfo question1 = new QuestionInfo("1 + 1 = ?",
                "",
                new String[]{"2", "two"});
        question1.category = "Grade 1 Math";
        QuestionInfo question2 = new QuestionInfo("What is the capital of Canada?",
                "",
                new String[] {"Ottawa"},
                "Toronto",
                "Ottawa",
                "Yukon",
                "Vancouver");
        question2.category = "Grade 3 Geography";
        QuestionInfo question3 = new QuestionInfo("Which is the fastest bird on foot?",
                "",
                new String[] {"ostrich"},
                R.drawable.birds);
        question3.category = "Grade 5 Science";
        instance.currentQuestions.add(question1);
        instance.currentQuestions.add(question2);
        instance.currentQuestions.add(question3);
    }

    /* Randomly generate a set of questions for the full game,
    *  making sure that the subject of each question is unique. */
    public static void generateFullGameQuestions() {
        if (instance == null) {
            return;
        }
        instance.currentQuestions = new ArrayList<>();
        SecureRandom rand = new SecureRandom();
        HashSet<String> coveredSubjects = new HashSet<>();
        int gradeLevelInd;
        QuestionInfo[] gradeLevelQuestions;
        int questionInd;
        QuestionInfo questionToAdd = null;
        for (int i = 0; i < MAX_NUM_QUESTIONS; i++) {
            gradeLevelInd = i / 2;
            while (gradeLevelInd > MAX_NUM_GRADE_LEVELS - 1) {
                gradeLevelInd--;
            }
            gradeLevelQuestions = QuestionBank.questions[gradeLevelInd];
            while (questionToAdd == null || coveredSubjects.contains(questionToAdd.subject)) {
                questionInd = rand.nextInt(gradeLevelQuestions.length);
                questionToAdd = gradeLevelQuestions[questionInd];
            }
            //found a suitable question!
            instance.currentQuestions.add(questionToAdd);
            coveredSubjects.add(questionToAdd.subject);
        }
    }
}
