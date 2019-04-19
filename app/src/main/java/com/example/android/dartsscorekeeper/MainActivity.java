package com.example.android.dartsscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int selectedScoreLeft;
    private int totalScoreLeft;
    private int selectedScoreRight;
    private int totalScoreRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedScoreLeft = 0;
        totalScoreLeft = 0;
        selectedScoreRight = 0;
        totalScoreRight = 0;

        displayScore(R.id.text_view_total_left, totalScoreLeft);
        displayScore(R.id.text_view_total_right, totalScoreRight);

        setupSpinner(R.id.spinner_score_left);
        setupSpinner(R.id.spinner_score_right);
    }

    private void displayScore(int totalScoreViewId, int score) {
        TextView totalScoreView = findViewById(totalScoreViewId);
        totalScoreView.setText("Total: " + score);
    }

    private void setupSpinner(int spinnerViewId) {
        Spinner spinner = findViewById(spinnerViewId);

        spinner.setOnItemSelectedListener(this);

        List<Integer> scores = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++) {
            scores.add(i);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, scores);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(0);

        spinner.setAdapter(arrayAdapter);
    }

    public void resetScores(View view) {
        selectedScoreLeft = 0;
        totalScoreLeft = 0;
        selectedScoreRight = 0;
        totalScoreRight = 0;

        displayScore(R.id.text_view_total_left, totalScoreLeft);
        displayScore(R.id.text_view_total_right, totalScoreRight);

        Spinner leftSpinner = findViewById(R.id.spinner_score_left);
        leftSpinner.setSelection(0);

        Spinner rightSpinner = findViewById(R.id.spinner_score_right);
        rightSpinner.setSelection(0);
    }

    public void multiplyBy2(View view) {
        if (view.getId() == R.id.button_multiply_by_2_left) {
            multiplyLeft(2);
        } else {
            multiplyRight(2);
        }
    }

    public void multiplyBy1(View view) {

        if (view.getId() == R.id.button_multiply_by_1_left) {
            multiplyLeft(1);
        } else {
            multiplyRight(1);
        }
    }

    public void multiplyBy3(View view) {

        if (view.getId() == R.id.button_multiply_by_3_left) {
            multiplyLeft(3);
        } else {
            multiplyRight(3);
        }
    }

    public void add25(View view) {

        if (view.getId() == R.id.button_outer_bullseye_left) {
            addLeft(25);
        } else {
            addRight(25);
        }
    }

    public void add50(View view) {

        if (view.getId() == R.id.button_inner_bullseye_left) {
            addLeft(50);
        } else {
            addRight(50);
        }
    }

    private void addLeft(int amount) {
        totalScoreLeft += amount;

        displayScore(R.id.text_view_total_left, totalScoreLeft);
    }

    private void addRight(int amount) {
        totalScoreRight += amount;

        displayScore(R.id.text_view_total_right, totalScoreRight);
    }

    private void multiplyLeft(int multiplier) {
        totalScoreLeft += selectedScoreLeft * multiplier;

        displayScore(R.id.text_view_total_left, totalScoreLeft);
    }

    private void multiplyRight(int multiplier) {
        totalScoreRight += selectedScoreRight * multiplier;

        displayScore(R.id.text_view_total_right, totalScoreRight);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_score_left) {
            selectedScoreLeft = position + 1;
        } else {
            selectedScoreRight = position + 1;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
