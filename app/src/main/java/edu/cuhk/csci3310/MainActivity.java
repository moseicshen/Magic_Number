package edu.cuhk.csci3310;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private int mGuessNumber = 1;
    private TextView mShowNumber;
    private int actualNumber;
    private int guessCount = 0;
    private Button button_guess;
    private Button button_minus;
    private Button button_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowNumber = findViewById(R.id.show_number);
        Random random = new Random();
        actualNumber = random.nextInt(10);
        button_guess = findViewById(R.id.button_guess);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);
    }

    public void showToast(View view) {
        String toast_message;
        guessCount++;
        if(mGuessNumber == actualNumber){
            toast_message = "Bingo! You made it in "+guessCount+" guess!";
            endGame();
        }
        else if(guessCount < 3){
            if(actualNumber - mGuessNumber >= 3)
                toast_message = "Too small!";
            else if(mGuessNumber - actualNumber >= 3)
                toast_message = "Too large!";
            else
                toast_message = "Close!";
        }
        else {
            toast_message = "Game Over! The Magic Number is " + actualNumber;
            endGame();
        }
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

    private void endGame(){
        button_guess.setEnabled(false);
        button_minus.setEnabled(false);
        button_plus.setEnabled(false);
    }
}