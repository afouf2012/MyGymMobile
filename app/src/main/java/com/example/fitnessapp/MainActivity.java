package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapp.Calculator.Bmi;

public class MainActivity extends AppCompatActivity {
TextView titre;
Button MyExercices ;
Button female;
Button ButtonCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titre=findViewById(R.id.title);
        MyExercices=findViewById(R.id.MyExercices);
        female=findViewById(R.id.button);

        ButtonCalculator=findViewById(R.id.ButtonCalculator);

        MyExercices.setOnClickListener(view -> {


            Intent intent = new Intent(this, MyExercices.class);
            startActivity(intent);

        });
        female.setOnClickListener(view -> {


            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);

        });

        ButtonCalculator.setOnClickListener(view -> {


            Intent intent = new Intent(this, Bmi.class);
            startActivity(intent);

        });
    }
}