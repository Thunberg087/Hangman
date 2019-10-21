package com.example.hangman;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    EditText letterInput;
    TextView guessWordTextView;
    ArrayList<String> words = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        letterInput = findViewById(R.id.letterInput);

        guessWordTextView = findViewById(R.id.guessWordTextView);

        words.add("telefon");
        words.add("gris");
        words.add("flygplan");
        words.add("ITHS");
        words.add("android");
        words.add("varmkorv");
        words.add("kiosk");
        words.add("bokstav");



        Random rand = new Random();

        String guessWord = words.get(rand.nextInt(words.size()));


        for (int i = 0;i < guessWord.length(); i++){

        }


        guessWordTextView.setText(guessWord);




        ArrayList<Character> guessWordArray = new ArrayList<>();

        for (int i = 0;i < guessWord.length(); i++){
            guessWordArray.add(guessWord.charAt(i));
        }

        System.out.println(Arrays.toString(guessWordArray.toArray()));
    }


    public void guessLetter(View view) {

        Toast toast;

        if (letterInput.getText().toString().length() == 0) {
            toast = Toast.makeText(getApplicationContext(), "Välj en bokstav först", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 150);
            toast.show();
        }


    }
}
