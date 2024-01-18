package edu.cuhk.csci3310;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private int mGuessNumber = 1;
    private TextView mShowNumber;

    private int actualNumber;
    private int guessCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowNumber = findViewById(R.id.show_number);
        Random random = new Random();
        actualNumber = random.nextInt(10);
    }

    public void showToast(View view) {
        String toast_message;
        guessCount++;
        if(mGuessNumber == actualNumber)
            toast_message = "Bingo! You made it in "+guessCount+" guess!";
        else if(actualNumber - mGuessNumber >= 3)
            toast_message = "Too small";
        else
            toast_message = "";
        Toast toast = Toast.makeText(this, toast_message, Toast.LENGTH_SHORT);
        toast.show();
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