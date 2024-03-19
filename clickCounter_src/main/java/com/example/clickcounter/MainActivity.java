package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView clickCounterText = findViewById(R.id.click_counter_text);
        clickCounterText.setText(String.valueOf(numClicks));
        Button clickButton = findViewById(R.id.click_button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClicks += 1;
                clickCounterText.setText(String.valueOf(numClicks));
            }
        });

        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClicks = 0;
                clickCounterText.setText(String.valueOf(numClicks));
            }
        });
    }
}