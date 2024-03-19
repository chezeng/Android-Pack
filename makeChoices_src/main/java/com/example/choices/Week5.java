package com.example.choices;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Week5 extends AppCompatActivity {

    TextView levelView;
    TextView questionView;
    TextView scoreView;

    Button optionButton1;
    Button optionButton2;
    Button optionButton3;
    Button optionButton4;
    Button startStopButton;

    int score = 0;
    int level = 0;
    boolean gameIsRunning = false;

    // TODO: Define and create a member variable ArrayList<Boolean> named results

    ArrayList<Boolean> results = new ArrayList<>();


    // onCreate is called by the Android system when this Activity (the screen)
    // is first created (and displayed) on screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionView = findViewById(R.id.question);
        scoreView = findViewById(R.id.score);
        levelView = findViewById(R.id.level);
        optionButton1 = findViewById(R.id.button1);
        optionButton2 = findViewById(R.id.button2);
        optionButton3 = findViewById(R.id.button3);
        optionButton4 = findViewById(R.id.button4);
        startStopButton = findViewById(R.id.buttonStartStop);

        // This sets up a "handler", which is the function called onClick()
        // below that is called whenever the user taps on the startStopButton
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameIsRunning) {
                    stopGame();
                }
                else {
                    startGame();
                }
            }
        });

        stopGame();
    }

    private void stopGame() {
        level = 0;
        setupForLevel(level);
        gameIsRunning = false;
        startStopButton.setText("Start");
    }

    private void startGame() {
        gameIsRunning = true;
        startStopButton.setText("Stop");

        // TODO: Remove all the elements in the results array (use .clear())
        results.clear();

        score = 0;
        level = 1;

        scoreView.setText("" + score);
        setupForLevel(level);
    }

    // Set up the screen to display the specified level (passed as a parameter)
    private void setupForLevel(int level) {
        // Show the current level on screen
        levelView.setText("" + level);

        // Initialize the question, answer and options to blank strings
        String question = "";
        String answer = "wrong answer";
        String option1 = "";
        String option2 = "";
        String option3 = "";
        String option4 = "";

        // Depending on what level we're on, set the appropriate text to be
        // displayed for the question, answer and options
        if (level == 0) {
            // We haven't started yet (level is 0), so set the text for the
            // initial instruction
            question = "Press any options to START";
        } else if (level == 1) {
            question = "1 + 1 = ";
            answer = "2";
            option1 = "0";
            option2 = "1";
            option3 = answer;
            option4 = "3";
        } else if (level == 2) {
            question = "2 + 3 * 4 = ";
            answer = "14";
            option1 = "10";
            option2 = answer;
            option3 = "12";
            option4 = "20";
        } else if (level == 3) {
            question = "What is the water content of a watermelon?";
            answer = "96%";
            option1 = "77%";
            option2 = "81%";
            option3 = answer;
            option4 = "99%";
        }
        else {
            // TODO: We've finished all the levels, time to stop the game
            //     call stopGame()
            stopGame();
        }

        // Set up the screen to display the question and options
        setupQuestion(question, option1, option2, option3, option4, answer);

        // TODO: Check if game has stopped (i.e. !gameIsRunning), then call
        //     showResults()
        if (!gameIsRunning) {
            showResults();
        }
    }

    private void moveToNextLevel() {
        level++;
        setupForLevel(level);
    }

    private void setupQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
        questionView.setText(question);
        setupOptionButton(optionButton1, option1, answer);
        setupOptionButton(optionButton2, option2, answer);
        setupOptionButton(optionButton3, option3, answer);
        setupOptionButton(optionButton4, option4, answer);
    }

    private void setupOptionButton(Button button, String option, String answer) {
        button.setText(option);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If game is not running, don't do any more work
                if (!gameIsRunning) {
                    return;
                }

                // If option and answer match, the user has selected the
                //     correct answer
                if (option.equals(answer)) {
                    correctAnswer();
                } else {
                    wrongAnswer();
                }
            }
        });
    }

    private void correctAnswer() {
        score++;
        scoreView.setText("" + score);

        // TODO: Append the value true to the results array to indicate
        //     that the user got the answer to this question correct
        results.add(true);
        moveToNextLevel();
    }

    private void wrongAnswer() {
        // TODO: Append the value false to the results array to indicate
        //     that the user got the answer to this question wrong

        results.add(false);
        moveToNextLevel();
    }

    private void showResults() {
        StringBuilder paragraph = new StringBuilder("Result: \n");
        /**
         * TODO: Use a for-each loop to go through the results and tell the user
         *     which questions were right or wrong
         *
         * Example:
         *   Result:
         *   Question 1: Correct
         *   Question 2: Incorrect :(
         *   Question 3: Correct
         *   Question 4: Correct
         *
         *   Use string concatenation to put your text into the paragraph
         *   variable, which will be displayed below.
         */
        for(int x = 0; x < results.size(); x += 1) {
            String temp = "Question " + x + 1 + ": ";
            if (results.get(x)) {
                temp += "Correct\n";
            }
            else {
                temp += "Incorrect :(\n";
            }

            paragraph.append(temp);
        }



        // Display the contents of the paragraph string on screen
        questionView.setText(paragraph.toString());
    }

    // TODO (Extra): You might have realized that when the game ends, the level shown is one higher than
    //     the last level. Why is this? Can you fix it?
}