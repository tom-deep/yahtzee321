package com.example.yahtzee321j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.*;


public class MainActivity extends AppCompatActivity {

    //Declaring xml attributes globally
    private RadioButton r1, r2, r3, r4, r5, rAce, rTwo, rThree, rFour, rFive, rSix, rTok, rFok, rFh, rSmS, rLgS, rY;
    private Button roleDye,nextB;
    private TextView dice1, dice2, dice3, dice4, dice5, ace, two, three, four, five, six, tUp, uBonus, ttUpper, tok, fok, fh, smStraight, lgStraight, yahtzee, chance, yBonus, ttLower, fTotal;
    int rolls = 0;
    int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning java variables xml attributes
        nextB = (Button) findViewById(R.id.next);
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
        ace = (TextView) findViewById(R.id.aceScore);
        two = (TextView) findViewById(R.id.twoScore);
        three = (TextView) findViewById(R.id.threeScore);
        four = (TextView) findViewById(R.id.fourScore);
        five = (TextView) findViewById(R.id.fivesScore);
        six = (TextView) findViewById(R.id.sixScore);
        tUp = (TextView) findViewById(R.id.firstUpperScore);
        uBonus = (TextView) findViewById(R.id.bonusScore);
        ttUpper = (TextView) findViewById(R.id.upperScore);
        tok = (TextView) findViewById(R.id.tokScore);
        fok = (TextView) findViewById(R.id.fokScore);
        fh = (TextView) findViewById(R.id.fhScore);
        smStraight = (TextView) findViewById(R.id.smScore);
        lgStraight = (TextView) findViewById(R.id.lgScore);
        yahtzee = (TextView) findViewById(R.id.yScore);
        chance = (TextView) findViewById(R.id.chanceScore);
        yBonus = (TextView) findViewById(R.id.ybScore);
        ttLower = (TextView) findViewById(R.id.lowerScore);
        fTotal = (TextView) findViewById(R.id.totalScore);
        rAce = (RadioButton) findViewById(R.id.race);
        rTwo = (RadioButton) findViewById(R.id.rtwo);
        rThree = (RadioButton) findViewById(R.id.rthree);
        rFour = (RadioButton) findViewById(R.id.rFour);
        rFive = (RadioButton) findViewById(R.id.rFive);
        rSix = (RadioButton) findViewById(R.id.rSix);
        rTok = (RadioButton) findViewById(R.id.rtok);
        rFok = (RadioButton) findViewById(R.id.rfok);
        rFh = (RadioButton) findViewById(R.id.rfh);
        rSmS = (RadioButton) findViewById(R.id.smStraight);
        rLgS = (RadioButton) findViewById(R.id.rlgStraight);
        rY = (RadioButton) findViewById(R.id.rY);

        nextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextB.setEnabled(false);
                if(rTok.isChecked()){
                    tok.setText(String.valueOf(d1+d2+d3+d4+d5));
                    rTok.setEnabled(false);
                }
                if (rFok.isChecked()){
                    fok.setText(String.valueOf(d1+d2+d3+d4+d5));
                }

                if (rFh.isChecked()){
                    fh.setText("25");
                }

                if (rSmS.isChecked()){
                    smStraight.setText("30");
                }

                if(rLgS.isChecked()){
                    lgStraight.setText("40");
                }

                if(rY.isChecked()){
                    yahtzee.setText("50");
                }
                roleDye.setEnabled(true);
                r1.setChecked(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
                r5.setChecked(false);
                rolls = 0;
                dice1.setText("0");
                dice2.setText("0");
                dice3.setText("0");
                dice4.setText("0");
                dice5.setText("0");
            }
        });

        //on click listener
        roleDye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checks if radioButton is clicked before rolling dice
                //generates a random dice roll and updates it to the interface
                //int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5=0;
                String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
                if (!r1.isChecked()) {
                    d1 = rand();
                    s1 = String.valueOf(d1);
                    dice1.setText(s1);
                }
                if (!r2.isChecked()) {
                    d2 = rand();
                    s2 = String.valueOf(d2);
                    dice2.setText(s2);
                }
                if (!r3.isChecked()) {
                    d3 = rand();
                    s3 = String.valueOf(d3);
                    dice3.setText(s3);
                }
                if (!r4.isChecked()) {
                    d4 = rand();
                    s4 = String.valueOf(d4);
                    dice4.setText(s4);
                }
                if (!r5.isChecked()) {
                    d5 = rand();
                    s5 = String.valueOf(d5);
                    dice5.setText(s5);
                }

                //disables roll button after three rolls
                if (rolls == 2) {
                    view.setEnabled(false);
                    Log.d("Var", s1);
                    Log.d("Var", s2);
                    Log.d("Var", s3);
                    Log.d("Var", s4);
                    Log.d("Var", s5);

                    int[] stats = checkValue(d1, d2, d3, d4, d5);
                    if (threeOfKind(stats)){
                        rTok.setVisibility(view.VISIBLE);
                    }
                    if(fourOfKind(stats)){
                        rFok.setVisibility(view.VISIBLE);
                    }
                    if(checkHouse(stats)){
                        rFh.setVisibility(view.VISIBLE);
                    }
                    if(smStraight(stats)){
                        rSmS.setVisibility(view.VISIBLE);
                    }
                    if(lgStraight(stats)){
                        rLgS.setVisibility(view.VISIBLE);
                    }
                    if(yaht(stats)){
                        rY.setVisibility(view.VISIBLE);
                    }
                    String aScore = String.valueOf(stats[0]);
                    String twScore = String.valueOf(stats[1]*2);
                    String thScore = String.valueOf(stats[2]*3);
                    String fScore = String.valueOf(stats[3]*4);
                    String fiScore = String.valueOf(stats[4]*5);
                    String sScore = String.valueOf(stats[5]*6);
                    ace.setText(aScore);
                    two.setText(twScore);
                    three.setText(thScore);
                    four.setText(fScore);
                    five.setText(fiScore);
                    six.setText(sScore);
                    nextB.setEnabled(true);
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
        for (int i = 0; i < 5; i++) {
            if (check[i] == 1) {
                result[0]++;
            } else if (check[i] == 2) {
                result[1]++;
            } else if (check[i] == 3) {
                result[2]++;
            } else if (check[i] == 4) {
                result[3]++;
            } else if (check[i] == 5) {
                result[4]++;
            } else {
                result[5]++;
            }
        }
        return result;
    }

    //returns sum of top scores barring the total upper scorer and the bonus
    public int sumOfTop(int[] scores) {
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += scores[i];
        }
        return sum;
    }

    public boolean checkBonus(int i){
        if(i>63){
            return true;
        }
        return false;
    }

    //returns the sum of sumOfTop return as well as the bonus
    public int totalUpper(int[] scores) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += scores[i];
        }
        return sum;
    }

    //returns the total lower score
    public int totalLower(int[] scores) {
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += scores[i];
        }
        return sum;
    }

    //returns true if small straight is achieved
    public boolean smStraight(int[] values) {
        if (values[0] >= 1 && values[1] >= 1 && values[2] >= 1 && values[3] >= 1) {
            return true;
        } else if (values[1] >= 1 && values[2] >= 1 && values[3] >= 1 && values[4] >= 1) {
            return true;
        } else if (values[2] >= 1 && values[3] >= 1 && values[4] >= 1 && values[5] >= 1) {
            return true;
        }else{
            return false;
        }

    }

    //returns true if large straight is achieved
    public boolean lgStraight(int[] values){
        if(values[0]>=1 && values[1]>=1 && values[2]>=1 && values[3]>=1 && values[4]>=1){
            return true;
        } else if(values[1]>=1 && values[2]>=1 && values[3]>=1 && values[4]>=1 && values[5]>=1) {
            return true;
        }else{
            return false;
        }
    }

    public boolean checkHouse(int[] values){
        boolean three = false;
        boolean two = false;
        for(int i=0; i<6;i++){
            if(values[i] == 3){
                three = true;
            }
            if(values[i] == 2){
                two = true;
            }
        }
        if(three && two){
            return true;
        }
        return false;
    }

    public boolean threeOfKind(int[] values) {
        for(int i=0; i<6; i++){
            if(values[i] == 3){
                return true;
            }
        }
        return false;
    }

    public boolean fourOfKind(int[] values) {
        for(int i=0; i<6; i++){
            if(values[i] == 4){
                return true;
            }
        }
        return false;
    }

    public boolean yaht(int[] values) {
        for(int i=0; i<6; i++){
            if(values[i] == 5){
                return true;
            }
        }
        return false;
    }








}