package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
    }

    private void linkViews() {
        Button startGameButton = findViewById(R.id.start_game_button);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private void startQuiz()  {
        setupGame();
        // Create intent to transition to QuizActivity screen
        Intent quizActivityIntent = new Intent(this, QuizActivity.class);
        startActivity(quizActivityIntent);
    }

    private void setupGame() {
        CurrentGame currentGame = CurrentGame.get();

        /* Part 3: Load the full game and try to prove you're smarter than a 5th grader! */
        CurrentGame.loadDemoGameQuestions();
//        CurrentGame.generateFullGameQuestions();

        currentGame.currentState = GameState.IN_PROGRESS;
        currentGame.currentQuestionInd += 1;
    }

}