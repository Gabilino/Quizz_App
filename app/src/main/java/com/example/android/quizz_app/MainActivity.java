package com.example.android.quizz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * pressing the button will reset all answers to defaults
     */
    public void resetButton(View view) {

        //first question reset

        RadioGroup q1group = (RadioGroup) findViewById(R.id.answer_1);
        q1group.clearCheck();

        //second question reset

        CheckBox q2a = (CheckBox) findViewById(R.id.answer_2_a);
        q2a.setChecked(false);
        CheckBox q2b = (CheckBox) findViewById(R.id.answer_2_b);
        q2b.setChecked(false);
        CheckBox q2c = (CheckBox) findViewById(R.id.answer_2_c);
        q2c.setChecked(false);
        CheckBox q2d = (CheckBox) findViewById(R.id.answer_2_d);
        q2d.setChecked(false);

        //third question reset

        EditText q3Text = (EditText) findViewById(R.id.answer_3);
        q3Text.getText().clear();

        //fourth question reset

        RadioGroup q4group = (RadioGroup) findViewById(R.id.answer_4);
        q4group.clearCheck();

        //fifth question reset

        RadioGroup q5group = (RadioGroup) findViewById(R.id.answer_5);
        q5group.clearCheck();

        //sixth question reset

        EditText q6Text = (EditText) findViewById(R.id.answer_6);
        q6Text.getText().clear();

        //seven question reset

        RadioGroup q7group = (RadioGroup) findViewById(R.id.answer_7);
        q7group.clearCheck();

    }

    /**
     * pressing the button calculate and display the overall score in a toast message
     */
    public void submitButton(View view) {
        String resultText = getResources().getString(R.string.your_score) + " " + calculateScore() + " " + getString(R.string.out_of);
        Toast.makeText(this, resultText, Toast.LENGTH_LONG).show();

        /**
         * Evaluate the user based on the number of his/her correct answers
         */

        if (calculateScore()<4){
            String improvementText = getResources().getString(R.string.room_for_improvement);
            Toast.makeText (this, improvementText, Toast.LENGTH_LONG).show();
        }
        else if (calculateScore()<7){
            String notBadText = getResources().getString(R.string.not_bad);
            Toast.makeText (this, notBadText, Toast.LENGTH_LONG).show();
        }
        else {
            String WellDoneText = getResources().getString(R.string.excellent_result);
            Toast.makeText (this, WellDoneText, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * evaluate answers and
     *
     * @return overall score
     */
    private int calculateScore () {

        int total = 0;

        //check first question

        RadioButton q1RadioButton = (RadioButton) findViewById(R.id.answer_1_a);
        if (q1RadioButton.isChecked()) {
            total += 1;
        }
        //check second question

        CheckBox q2a = (CheckBox) findViewById(R.id.answer_2_a);
        CheckBox q2b = (CheckBox) findViewById(R.id.answer_2_b);
        CheckBox q2c = (CheckBox) findViewById(R.id.answer_2_c);
        CheckBox q2d = (CheckBox) findViewById(R.id.answer_2_d);
        if (q2a.isChecked() && q2b.isChecked()) {
            total += 1;
        }

        //check third question

        EditText q3Text = (EditText) findViewById(R.id.answer_3);
        String answer3 = q3Text.getText().toString().toLowerCase().trim();
        if (answer3.equals("ben nevis")) {
            total += 1;
        }
        //check fourth question

        RadioButton q4RButton = (RadioButton) findViewById(R.id.answer_4_b);
        if (q4RButton.isChecked()) {
            total += 1;
        }
        //check fifth question

        RadioButton q5RButton = (RadioButton) findViewById(R.id.answer_5_b);
        if (q5RButton .isChecked()) {
            total += 1;
        }
        //check sixth question

        EditText q6Text = (EditText) findViewById(R.id.answer_6);
        String answer6 = q6Text.getText().toString().toLowerCase().trim();
        if (answer6.equals("john barbour")) {
            total += 1;
        }
        //check seventh question

        RadioButton q7RButton = (RadioButton) findViewById(R.id.answer_7_c);
        if (q7RButton.isChecked()) {
            total += 1;
        }

        return total;
    }

}
