package com.example.yahtzee321j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;


public class MainActivity extends AppCompatActivity {

    //Declaring xml attributes globally
    private RadioButton r1, r2, r3, r4, r5;
    private Button roleDye;
    private TextView dice1, dice2, dice3, dice4, dice5, scoreA;
    int rolls = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning java variables xml attributes
        roleDye = (Button) findViewById(R.id.roll);
        dice1 = (TextView) findViewById(R.id.diceOne);
        dice2 = (TextView) findViewById(R.id.diceTwo);
        dice3 = (TextView) findViewById(R.id.diceThree);
        dice4 = (TextView) findViewById(R.id.diceFour);
        dice5 = (TextView) findViewById(R.id.diceFive);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r5 = (RadioButton) findViewById(R.id.r5);
        scoreA = (TextView) findViewById(R.id.aceScore);

        //on click listener
        roleDye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checks if radioButton is clicked before rolling dice
                //generates a random dice roll and updates it to the interface
                int d1=0,d2=0,d3=0,d4=0,d5 = 0;
                if(!r1.isChecked()){
                    d1 = rand();
                    String s1 = String.valueOf(d1);
                    dice1.setText(s1);
                }
                if(!r2.isChecked()){
                    d2 = rand();
                    String s2 = String.valueOf(d2);
                    dice2.setText(s2);
                }
                if(!r3.isChecked()){
                    d3 = rand();
                    String s3 = String.valueOf(d3);
                    dice3.setText(s3);
                }
                if(!r4.isChecked()){
                    d4 = rand();
                    String s4 = String.valueOf(d4);
                    dice4.setText(s4);
                }
                if(!r5.isChecked()){
                    d5 = rand();
                    String s5 = String.valueOf(d5);
                    dice5.setText(s5);
                }

                //disables roll button after three rolls
                if (rolls == 2) {
                    view.setEnabled(false);
                    int[] stats = checkValue(d1,d2,d3,d4,d5);
                    scoreA.setText(Arrays.toString(stats));
                }
                rolls = rolls + 1;
            }
        });
    }


    //returns random number from 1-6
    public int rand() {
        int min = 1;
        int max = 5;
        Random random = new Random();
        int result = random.nextInt(max + min) + min;
        return result;
    }

    public int[] checkValue(int one, int two, int three, int four, int five) {
        int[] result = new int[6];
        int[] check = new int[5];
        check[0] = one;
        check[1] = two;
        check[2] = three;
        check[3] = four;
        check[4] = five;
        for(int i =0;i<5;i++){
            if(check[i]==1){
                result[0]++;
            }else if(check[i]==2){
                result[1]++;
            }else if(check[i]==3){
                result[2]++;
            }else if(check[i]==4){
                result[3]++;
            }else if(check[i]==5){
                result[4]++;
            }else{
                result[5]++;
            }
        }
        return result;
    }
}