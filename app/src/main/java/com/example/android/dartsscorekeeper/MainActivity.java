package com.example.android.dartsscorekeeper;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int playerOneSelectedScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneSelectedScore = 0;

        Spinner playerOneScoreSpinner = findViewById(R.id.spinner_player_one_score);

        playerOneScoreSpinner.setOnItemSelectedListener(this);

        List<Integer> scores = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++)
        {
            scores.add(i);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, scores);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerOneScoreSpinner.setSelection(0);

        playerOneScoreSpinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        playerOneSelectedScore = position + 1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
