package com.example.hangman;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    EditText letterInput;
    TextView guessWordTextView;
    ArrayList<String> words = new ArrayList();
    String guessWord;
    StringBuilder tempWord = new StringBuilder("");
    ArrayList<Character> triedCharacters = new ArrayList<>();
    int guessesLeft = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        letterInput = findViewById(R.id.letterInput);

        guessWordTextView = findViewById(R.id.guessWordTextView);

        words.add("telefon");
        words.add("gris");
        words.add("flygplan");
        words.add("iths");
        words.add("android");
        words.add("varmkorv");
        words.add("kiosk");
        words.add("bokstav");



        Random rand = new Random();

        guessWord = words.get(rand.nextInt(words.size()));



        for (int i = 0;i < guessWord.length(); i++){
            tempWord.append("_");
        }


        guessWordTextView.setText(tempWord);

        Log.d("awd", guessWord);
    }


    public void guessLetter(View view) {

        Toast toast;

        String letter = letterInput.getText().toString();

        if (letter.length() == 0) {
            toast = Toast.makeText(getApplicationContext(), "Välj en bokstav", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 150);
            toast.show();
            return;
        }

        for (int i = 0;i < triedCharacters.size(); i++){
            if (letter.charAt(0) == triedCharacters.get(i)) {
                toast = Toast.makeText(getApplicationContext(), "Du har redan provat den bokstaven", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 150);
                toast.show();
                return;
            }
        }

        boolean anyCorrect = false;

        for (int i = 0;i < guessWord.length(); i++){
            if (letter.charAt(0) == guessWord.charAt(i)) {
                tempWord.setCharAt(i, letter.charAt(0));
                anyCorrect = true;
            }
        }

        triedCharacters.add(letter.charAt(0));

        if (!anyCorrect) {

        }



        guessWordTextView.setText(tempWord.toString());


    }
}
