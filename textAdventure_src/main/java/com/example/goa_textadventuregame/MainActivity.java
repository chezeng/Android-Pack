package com.example.goa_textadventuregame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String position = "entrance";

    // Items
    Boolean backyardKey = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //region IGNORE THIS CODE
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input = findViewById(R.id.input);
        TextView textbox = findViewById(R.id.textbox);
        textbox.setMovementMethod(new ScrollingMovementMethod());
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        //endregion


        // The starting text of the game
        textbox.setText("You suddenly wake up finding yourself in an unfamiliar room. You don't know where you are, but you know you need to get out." +
                "You see two doors. One of the left and one on the right. Which one do you take?" +
                "\nEnter 'left' or 'right'.");

        // Code here will run when the user presses the "Submit" button
        buttonSubmit.setOnClickListener(v -> {


            // This is the String variable that holds the text inside of the text input
            // TODO: Apply the "trim" string function to "inputText" to remove leading and trailing spaces
            // TODO: Apply the "toLowerCase" string method to "inputText" to turn it into all lowercase

            String inputText = input.getText().toString().trim();
            inputText = inputText.toLowerCase();
            String text = "";

            // TODO: Here is a list of possible inputs the user can give to make the player turn left and right
            //       Create 2 more String variables for possible variations to go "back" and "forward"
            String leftVariations = "left l gauche lft ";
            String rightVariations = "right r droit droite rgt";
            String backVariations = "back b bck";
            String forwardVariations = "forward f forth, for";

            // TODO: Once you have your variation variables ready, use the "contains" string method anywhere
            //       in the code that we check the inputText so that we can handle multiple variations of answers.
            //       Refer to the example in the "entrance" room if needed.

            // This line of code will update the text box with the text generated in the previous line of code
            textbox.setText(text);

            // This will clear the text input
            input.getText().clear();

            if (position.equals("entrance")) {
                if (leftVariations.contains(inputText)) {
                    position = "dining room";
                    text = "From the entrance, you walk forward into a new room. Nothing much to see here, just a dining table with chairs that seat up to 8 people." +
                            "There is now a door in front of you and one behind you. Which do you take?" +
                            "\nEnter 'forward' or 'back'.";
                } else if (rightVariations.contains(inputText)) {
                    position = "living room";
                    text = "You walk into a living room. Looking around, it looks like every other living room. You see a couch, a coffee table and a TV that inexplicably doesn't work." +
                            "There are now 3 doors to choose from. One in front of you, one to the right and one behind you." +
                            "\nEnter 'forward', 'right' or 'back'.";
                } else {
                    text = "Invalid answer. You are in a room with 2 doors in front of you. One on the left and one on the right. Which do you take?" +
                            "\nEnter 'left' or 'right'";
                }
            }

            else if (position.equals("dining room")) {
                if (forwardVariations.contains(inputText)) {
                    position = "kitchen";
                    text = "You walk through the door and enter a kitchen. There are now 3 doors. One in front of you, one to the left and one behind you." +
                            "\nEnter 'forward', 'right' or 'back'.";
                } else if (backVariations.contains(inputText)) {
                    position = "entrance";
                    text = "You are now back at the entrance. You see two doors. One on the left and one on the right. Which one do you take?" +
                            "\nEnter 'left' or 'right'.";

                }// TODO: Add an else clause to this if statement to handle invalid answers
                else {
                    text = "Invalid answer. You are in a room with 2 doors in front of you. One on the front and one on the back. Which do you take?" +
                            "\nEnter 'forward' or 'back'";}
            }

            else if (position.equals("kitchen")) {
                if (forwardVariations.contains(inputText) && backyardKey) {
                    position = "backyard";
                    text = "You walk out the door ahead of you and find yourself outside! Congratulations, you escaped the house!";
                } else if (forwardVariations.contains(inputText) && !backyardKey) {
                    position = "kitchen";
                    text = "You try to open the door ahead of you, but it's locked. Maybe there's a key somewhere?" +
                            " There are 3 doors. One in front of you, one to the left and one behind you." +
                            "\nEnter 'forward', 'right' or 'back'.";
                } else if (rightVariations.contains(inputText)) {
                    position = "office";
                    text = "You go to the right. You find yourself in a room that resembles a home office. It's a pretty small space but its complete with a shelf full of books, a desk, and a desktop computer." +
                            "From this room you have a door on your left and behind you. Which do you take?" +
                            "\nEnter 'left' or 'back'.";
                } else if (backVariations.contains(inputText)) {
                    position = "dining room";
                    text = "You walk through the door behind you. Nothing much to see here, just a dining table with chairs that seat up to 8 people." +
                            "There is now a door in front of you and one behind you. Which do you take?" +
                            "\nEnter 'forward' or 'back'.";
                } // TODO: Add an else clause to this if statement to handle invalid answers
                else {
                    text = "Invalid answer. You are in a room with 3 doors in front of you. One on the front and one on the back and one on the right. Which do you take?" +
                            "\nEnter 'forward' or 'back' or 'right'";
                }
            }

            else if (position.equals("living room")) {
                if (forwardVariations.contains(inputText)) {
                    position = "office";
                    text = "You... rush into the office. \n Enter 'left' or 'back'";
                }
                else if (rightVariations.contains(inputText)) {
                    position = "bedroom";
                    text = "You... rush into the bedroom. \n Enter 'left' or 'forward'";
                }
                else if (backVariations.contains(inputText)) {
                    position = "entrance";
                    text = "You... rush back to the entrance. \n Enter 'left' or 'right'";
                }
                else {
                    text = "Invalid answer. You are in a room with 3 doors in front of you. One on the front and one on the back and one on the right. Which do you take?" +
                            "\nEnter 'forward' or 'back' or 'right'";
                }
                // TODO: Write some if/else-if statements for each direction the player can move in from the "living room"
                //       1. Forward should bring the player to the office
                //       2. Right should bring the player to the bedroom
                //       3. Back should bring the player to the entrance

            }

            // TODO: Wrap the following if/else-if block with a check to see if the player is in the "office"
            else if (position.equals("office")) {
                if (leftVariations.contains(inputText)) {
                    position = "kitchen";
                    text = "You walk through the door and enter a kitchen. There are now 3 doors. One in front of you, one to the right and one behind you." +
                            "\nEnter 'forward', 'right' or 'back'.";
                } else if (backVariations.contains(inputText)) {
                    position = "living room";
                    text = "You walk into a living room. Looking around, it looks like every other living room. You see a couch, a coffee table and a TV that inexplicably doesn't work." +
                            "There are now 3 doors to choose from. One in front of you, one to the right and one behind you." +
                            "\nEnter 'forward', 'right' or 'back'.";
                }
                else{
                    text = "Invalid answer. You are in a room with 2 doors in front of you. One on the back and one on the left. Which do you take?" +
                            "\nEnter 'back' or 'left'";
                    }

                } // TODO: Add an else clause to this if statement to handle invalid answers


            // TODO: Write your own nested if statement for the bedroom. Follow the example of the previous rooms as a guideline
            //       1. Left will take you to the living room
            //       2. Forward will take you to the bathroom. The backyardKey will be in the bathroom.
            //          Write 2 else-if blocks that will give the player a different message depending on if they already have the key or not

            else if (position.equals("bedroom")) {
                if (leftVariations.contains(inputText)) {
                    position = "living room";
                    text = "You... rush into the living room. \n Enter 'forward', 'back' or 'right'";
                }

                else if (forwardVariations.contains(inputText) && !backyardKey) {
                    position = "bathroom";
                    backyardKey = true;
                    text = "Wow! You find a key to the backyard! \n Enter 'back' right now";
                }

                else if (forwardVariations.contains(inputText) && backyardKey) {
                    position = "bathroom";
                    text = "Why are you still here instead of going out? You got the key! \n Enter 'back' right now";
                }

                else{
                    text = "Invalid answer. You are in a room with 2 doors in front of you. One on the forward and one on the left. Which do you take?" +
                        "\nEnter 'forward' or 'left'";
                }
            }

            else if (position.equals("bathroom")) {
                if (backVariations.contains(inputText)) {
                    position = "bedroom";
                    text = "You rush back to the bedroom \n Enter 'left' or 'forward'";
                }
                else{
                    text = "Invalid answer. You are in a room with 1 door in front of you. One on the back. Which do you take?" +
                            "\nEnter 'back'";
                }
            }
            // TODO: Write your own nested if statement for the bathroom. Follow the example of the previous rooms as a guideline
            //       1. Back will take you to the bedroom

            textbox.setText(text);
        });
    }
}