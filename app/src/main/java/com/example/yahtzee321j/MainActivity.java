package com.example.yahtzee321j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    private Button roleDye;
    private TextView dice1,dice2,dice3,dice4,dice5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roleDye = (Button) findViewById(R.id.roll);
        dice1 = (TextView) findViewById(R.id.diceOne);
        dice2 = (TextView) findViewById(R.id.diceTwo);
        dice3 = (TextView) findViewById(R.id.diceThree);
        dice4 = (TextView) findViewById(R.id.diceFour);
        dice5 = (TextView) findViewById(R.id.diceFive);

        roleDye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d1 = rand();
                int d2 = rand();
                int d3 = rand();
                int d4 = rand();
                int d5 = rand();

                String s1 = String.valueOf(d1);
                String s2 = String.valueOf(d2);
                String s3 = String.valueOf(d3);
                String s4 = String.valueOf(d4);
                String s5 = String.valueOf(d5);

                dice1.setText(s1);
                dice2.setText(s2);
                dice3.setText(s3);
                dice4.setText(s4);
                dice5.setText(s5);
            }
        });
    }


    //returns random number from 1-6
    public int rand(){
        int min = 1;
        int max = 5;
        Random random = new Random();
        int result = random.nextInt(max + min) + min;
        return result;
    }
}