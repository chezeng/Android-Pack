package com.example.quizgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MultiChoiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multi_choice, container, false);
        linkViews(view);
        return view;
    }

    /* Defines how UI components are shown and what happens when player interacts with them. */
    private void linkViews(View view) {
        QuestionInfo currentQuestion = CurrentGame.getCurrentQuestion();
        String currentQuestionString = currentQuestion.question;
        String choice1 = currentQuestion.choices.get(0);
        String choice2 = currentQuestion.choices.get(1);
        String choice3 = currentQuestion.choices.get(2);
        String choice4 = currentQuestion.choices.get(3);

        TextView multiChoiceQuestion = view.findViewById(R.id.multi_choice_question);
        Button choice1Button = view.findViewById(R.id.choice_1_button);
        Button choice2Button = view.findViewById(R.id.choice_2_button);
        Button choice3Button = view.findViewById(R.id.choice_3_button);
        Button choice4Button = view.findViewById(R.id.choice_4_button);
        multiChoiceQuestion.setText(currentQuestionString);
        choice1Button.setText(choice1);
        choice2Button.setText(choice2);
        choice3Button.setText(choice3);
        choice4Button.setText(choice4);

        /* Part 3: Capture the answer that the player selected.
         *         Assign to currentGame.currentAnswer to let the game know
         *         this is the player's current answer to the given question.
         *
         *         Indicate to the player the choice they have most recently selected. */
        CurrentGame currentGame = CurrentGame.get();
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentGame.currentAnswer = choice1Button.getText().toString();
                choice1Button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                choice2Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice3Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice4Button.setBackgroundColor(getResources().getColor(R.color.purple_700));

            }
        });

        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentGame.currentAnswer = choice2Button.getText().toString();
                choice2Button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                choice1Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice3Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice4Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
            }
        });

        choice3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentGame.currentAnswer = choice3Button.getText().toString();
                choice3Button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                choice2Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice1Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice4Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
            }
        });

        choice4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentGame.currentAnswer = choice4Button.getText().toString();
                choice4Button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                choice2Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice3Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                choice1Button.setBackgroundColor(getResources().getColor(R.color.purple_700));
            }
        });



    }

}