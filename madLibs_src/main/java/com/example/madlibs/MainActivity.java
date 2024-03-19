package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> blanks = new ArrayList<>();
    private ArrayList<Integer> errmsgs = new ArrayList<>();
    private ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupForm();

        Button doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean noBlankWords = checkBlanks();
                if (noBlankWords) {
                    showStory();
                }
            }
        });
    }

    private void setupForm() {
        blanks.add(R.id.foreign_country_edittext);
        blanks.add(R.id.adverb_1_edittext);
        blanks.add(R.id.adverb_2_edittext);
        blanks.add(R.id.body_part_1_edittext);
        blanks.add(R.id.verb_1_edittext);
        blanks.add(R.id.adjective_1_edittext);
        blanks.add(R.id.noun_edittext);
        blanks.add(R.id.verb_2_edittext);
        blanks.add(R.id.adjective_2_edittext);
        blanks.add(R.id.body_part_2_edittext);
        blanks.add(R.id.verb_3_edittext);

        errmsgs.add(R.id.foreign_country_errmsg);
        errmsgs.add(R.id.adverb_1_errmsg);
        errmsgs.add(R.id.adverb_2_errmsg);
        errmsgs.add(R.id.body_part_1_errmsg);
        errmsgs.add(R.id.verb_1_errmsg);
        errmsgs.add(R.id.adjective_1_errmsg);
        errmsgs.add(R.id.noun_errmsg);
        errmsgs.add(R.id.verb_2_errmsg);
        errmsgs.add(R.id.adjective_2_errmsg);
        errmsgs.add(R.id.body_part_2_errmsg);
        errmsgs.add(R.id.verb_3_errmsg);
    }

    private boolean checkBlanks() {
        words = new ArrayList<>();
        for (int ind = 0; ind < blanks.size(); ind++) {
            Integer blank_id = blanks.get(ind);
            Integer errmsg_id = errmsgs.get(ind);
            EditText blankEditText = findViewById(blank_id);
            TextView errmsg = findViewById(errmsg_id);
            /* NOTE: This takes care of displaying an error message only when the associated blank
                     is found to not have been filled. */
            String blankAnswer = blankEditText.getText().toString().trim();
            if (blankAnswer.equals("")) {
                errmsg.setVisibility(View.VISIBLE);
            } else {
                words.add(blankAnswer);
                errmsg.setVisibility(View.INVISIBLE);
            }
        }
        return words.size() == blanks.size();
    }

    private void showStory() {
        Intent resultActivityIntent = new Intent(this, ResultActivity.class);
        resultActivityIntent.putStringArrayListExtra("storyWords", words);
        startActivity(resultActivityIntent);
    }
}