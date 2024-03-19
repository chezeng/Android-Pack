package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        int nextQuestionInd = CurrentGame.get().currentQuestionInd;
        showNextQuestion(nextQuestionInd);

        linkViews();
    }

    private void linkViews() {
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentGame currentGame = CurrentGame.get();
                if (currentGame.currentState != GameState.IN_PROGRESS) {
                    handleCheating();
                    return;
                }

                String currentAnswer = currentGame.currentAnswer;
                if (currentAnswer.isEmpty()) {
                    handleBlankAnswer();
                    return;
                }

                String[] expectedAnswers = CurrentGame.getCurrentQuestion().answers;
                Boolean isCorrect = checkAnswer(expectedAnswers, currentAnswer);
                handleResult(isCorrect);
            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void handleCheating() {
        CurrentGame.get().currentState = GameState.CHEAT;
        endQuiz();
    }

    private void handleBlankAnswer() {
        /* Part 3: Warn the player when no answer is given. */
    }

    private boolean checkAnswer(String[] acceptedAnswers, String currentAnswer) {
        /* Part 3: Check if the answer given by the player is one of the accepted answers to the question. */
        return true;
    }

    private void handleResult(Boolean isCorrect) {
        CurrentGame currentGame = CurrentGame.get();
        if (isCorrect) {
            currentGame.currentQuestionInd += 1;
            if (currentGame.currentQuestionInd == currentGame.currentQuestions.size()) {
                currentGame.currentState = GameState.WIN;
                endQuiz();
            } else {
                currentGame.currentAnswer = "";
                showNextQuestion(currentGame.currentQuestionInd);
            }
        } else {
            currentGame.currentState = GameState.LOSE;
            endQuiz();
        }
    }

    private void showNextQuestion(int nextQuestionInd) {
        QuestionInfo nextQuestion = CurrentGame.get().currentQuestions.get(nextQuestionInd);
        TextView questionTitle = findViewById(R.id.question_title);
        if (nextQuestion.category != null) {
            questionTitle.setText(String.format("Question %d: %s", nextQuestionInd+1, nextQuestion.category));
        } else if (nextQuestionInd == CurrentGame.get().currentQuestions.size() - 1) {
            questionTitle.setText(String.format("Million Dollar Question: Grade 5 %s", nextQuestion.subject));
        } else {
            questionTitle.setText(
                    String.format("Question %d: Grade %d %s",
                                  nextQuestionInd+1,
                                  nextQuestionInd / 2 + 1,
                                  nextQuestion.subject));
        }

        if (nextQuestion.choices != null) {
            showFragment(new MultiChoiceFragment());
        } else if (nextQuestion.img != 0) {
            showFragment(new ImageQNAFragment());
        } else {
            showFragment(new QNAFragment());
        }
    }

    private void endQuiz()  {
        // Create intent to transition to ResultActivity screen
        Intent resultActivityIntent = new Intent(this, ResultActivity.class);
        startActivity(resultActivityIntent);
    }
}