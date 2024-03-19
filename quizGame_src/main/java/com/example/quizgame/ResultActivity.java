package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        linkViews();
    }

    /* Defines how UI components are shown on the screen and what happens when player
       interacts with them. */
    private void linkViews() {
        Button playAgainButton = findViewById(R.id.play_again_button);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });

        /* Part 3: The result screen should tell the player that they won, lost, cheated, or their status is unknown. */
        CurrentGame currentGame = CurrentGame.get();
        TextView resultText = findViewById(R.id.result_text);
        switch (currentGame.currentState) {
            case WIN: // if (currentState == WIN)
                /* What message should be displayed when the player wins the game? */


                break;
            case LOSE: // else if (currentState == LOSE)
                /* What message should be displayed when the player loses the game? */
                String actualAnswer = CurrentGame.getCurrentQuestion().answers[0];


                break;
            case CHEAT: // else if (currentState == CHEAT)
                /* What message should be displayed when the player cheats in the game? */


                break;
            default: // else
                /* What message should be displayed when the player's status is none of the above? */


                break;
        }
    }

    /* Restarts game! */
    private void restartGame()  {
        CurrentGame currentGame = CurrentGame.get();
        currentGame.currentState = null;
        currentGame.currentQuestionInd = -1;
        currentGame.currentQuestions = new ArrayList<>();
        currentGame.currentAnswer = "";
        // Create intent to transition to Title screen
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }
}