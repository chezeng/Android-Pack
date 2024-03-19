package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private static String[] storyPhrases  = {
            "Walking on broken glass has a history in ",
            " as a test of an individual's concentration and endurance. The secret is to walk very ",
            " and ",
            ", so the glass doesn't cut your ",
            ". Don't run; running will only ",
            " you more. If you look down at your feet, you may get ",
            " and panic, so look straight ahead at all times. If it helps, focus on a/an ",
            " in front of you. Don't try this stunt without a professional glass-walker to ",
            " you out if you get ",
            "! The safest way to glass-walk is with a jetpack strapped to your ",
            ". That way, you can ",
            " inches above the glass and never touch it!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        ArrayList<String> storyWords = intent.getStringArrayListExtra("storyWords");
        TextView story = findViewById(R.id.story);
        SpannableStringBuilder storyBuilder = generateStory(storyWords);
        story.setText(storyBuilder, TextView.BufferType.SPANNABLE);

        Button againButton = findViewById(R.id.again_button);
        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private SpannableStringBuilder generateStory(ArrayList<String> storyWords) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        for (int i=0; i<storyWords.size(); i++) {
            SpannableString phrase = new SpannableString(storyPhrases[i]);
            SpannableString word = new SpannableString(storyWords.get(i));
            word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), 0);
            builder.append(phrase);
            builder.append(word);
        }
        builder.append(storyPhrases[storyPhrases.length-1]);
        return builder;
    }

    private void resetGame() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }
}