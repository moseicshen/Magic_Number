package edu.cuhk.csci3310;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mGuessNumber = 1;
    private TextView mShowNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowNumber = findViewById(R.id.show_number);
    }

    public void showToast(View view) {
    }

    @SuppressLint("SetTextI18n")
    public void countUp(View view) {
        mGuessNumber++;
        if(mShowNumber != null)
            mShowNumber.setText(Integer.toString(mGuessNumber));
    }

    @SuppressLint("SetTextI18n")
    public void countDown(View view) {
        mGuessNumber--;
        if(mShowNumber != null)
            mShowNumber.setText(Integer.toString(mGuessNumber));
    }
}