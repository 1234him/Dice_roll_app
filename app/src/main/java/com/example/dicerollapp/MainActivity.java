package com.example.dicerollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resetBtn = findViewById(R.id.resetButton);
        Button rollDice = findViewById(R.id.throwDice);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView img = findViewById(R.id.img1);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView playerOneScoreTxt = findViewById(R.id.playerOneScore);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView playerTwoScoreTxt = findViewById(R.id.playerTwoScore);

        TextView currentPlayerOneScoreTxt = findViewById(R.id.currentPlayerOneScore);
        TextView currentPlayerTwoScoreTxt  =findViewById(R.id.currentPlayerTwoScore);

        TextView playerOneHeadTxt = findViewById(R.id.playerOneHead);
        TextView playerTwoHeadTxt = findViewById(R.id.playerTwoHead);

        final boolean[] playerOneChance = {true};
        final boolean[] playerTwoChance = {false};
        final int[] playerOneScore = {0};
        final int[] playerTwoScore = {0};


        rollDice.setOnClickListener(view -> {
            int randomDiceNumber = (int)Math.floor(Math.random()*6+1);
            switch (randomDiceNumber){
                case 1:
                    img.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    img.setImageResource(R.drawable.dice2);
                    break;
                case 3:
                    img.setImageResource(R.drawable.dice3);
                    break;
                case 4:
                    img.setImageResource(R.drawable.dice4);
                    break;
                case 5:
                    img.setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    img.setImageResource(R.drawable.dice6);
                    break;
            }
            if(playerOneChance[0]){
                playerOneChance[0] = false;
                playerTwoChance[0] = true;
                playerOneScore[0] += randomDiceNumber;
                currentPlayerOneScoreTxt.setText(String.valueOf(randomDiceNumber));
                playerOneScoreTxt.setText(String.valueOf(playerOneScore[0]));
                if(playerOneScore[0]>100){
                    Toast.makeText(getApplicationContext(), "Player 1 won!", Toast.LENGTH_LONG).show();
                    rollDice.setEnabled(false);
                }
            }else{
                playerOneChance[0] = true;
                playerTwoChance[0] = false;
                playerTwoScore[0] += randomDiceNumber;
                currentPlayerTwoScoreTxt.setText(String.valueOf(randomDiceNumber));
                playerTwoScoreTxt.setText(String.valueOf(playerTwoScore[0]));
                if(playerTwoScore[0]>100){
                    Toast.makeText(getApplicationContext(), "Player 2 won!", Toast.LENGTH_LONG).show();
                    rollDice.setEnabled(false);
                }
            }
        });

        resetBtn.setOnClickListener(view -> {
            playerOneChance[0] = true;
            playerTwoChance[0] = false;

            currentPlayerOneScoreTxt.setText("0");
            currentPlayerTwoScoreTxt.setText("0");

            playerOneScoreTxt.setText("0");
            playerTwoScoreTxt.setText("0");

            playerOneScore[0] = 0;
            playerTwoScore[0] = 0;
        });
    }
}