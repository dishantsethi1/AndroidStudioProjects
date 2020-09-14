package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addThree(View v){
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }
    public void addTwo(View v){
        scoreTeamA=scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }
    public void addOne(View v){
        scoreTeamA=scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }


    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeb(View v){
        scoreTeamB=scoreTeamB+3;
        displayForTeamB(scoreTeamB);
    }
    public void addTwob(View v){
        scoreTeamB=scoreTeamB+2;
        displayForTeamB(scoreTeamB);
    }
    public void addOneb(View v){
        scoreTeamB=scoreTeamB+1;
        displayForTeamB(scoreTeamB);
    }


    public void resetScore(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(0);
        displayForTeamB(0);
    }
}