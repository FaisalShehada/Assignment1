package com.example.faisal.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText userNum;
    Button restart, check;
    int number ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNum = (EditText) findViewById(R.id.userNum);
        restart = (Button) findViewById(R.id.restart);
        check = (Button) findViewById(R.id.check);

          number = getRandom();

        check.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if (!userNum.getText().toString().equals("")) {
                            int userNummber = Integer.parseInt(userNum.getText().toString());

                            int value = Math.abs(number - userNummber);
                            if (number == userNummber) {
                                Toast.makeText(MainActivity.this, "Correct :D", Toast.LENGTH_SHORT).show();
                                check.setEnabled(false);

                            } else if (value <= 5) {
                                Toast.makeText(MainActivity.this, "Very Close", Toast.LENGTH_SHORT).show();

                            } else if (userNummber < number) {
                                Toast.makeText(MainActivity.this, "Greater", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity.this, "Smaller", Toast.LENGTH_SHORT).show();

                            }


                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter A number", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );
        restart.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    number = getRandom();
                        Toast.makeText(MainActivity.this, "Restarted",Toast.LENGTH_SHORT ).show();
                        userNum.setText("");
                        check.setEnabled(true);


                    }
                }
        );

    }

    public int getRandom() {
        Random random = new Random();
        int num = random.nextInt((1000 - 0) + 1) + 0;
        return num;
    }
}
