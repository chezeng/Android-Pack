package com.example.quizgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageQNAFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_q_n_a, container, false);
        linkViews(view);
        return view;
    }

    /* Defines how UI components are shown and what happens when player interacts with them. */
    private void linkViews(View view) {
        QuestionInfo currentQuestion = CurrentGame.getCurrentQuestion();
        String currentQuestionString = currentQuestion.question;
        int currentQuestionImg = currentQuestion.img;

        TextView imageQNAQuestion = view.findViewById(R.id.image_qna_question);
        ImageView questionImage = view.findViewById(R.id.question_image);
        imageQNAQuestion.setText(currentQuestionString);
        questionImage.setImageDrawable(ContextCompat.getDrawable(getActivity(), currentQuestionImg));

        /* Part 3: Capture the answer that the player entered.
         *          Assign to currentGame.currentAnswer to let the game know
         *          this is the player's current answer to the given question. */
        CurrentGame currentGame = CurrentGame.get();
        EditText imageAnswer = view.findViewById(R.id.image_qna_answer);
        imageAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentGame.currentAnswer = imageAnswer.getText().toString();

            }
        });

    }

}