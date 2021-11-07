package com.example.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddExercices extends AppCompatActivity {

    EditText title_input, categoriy_input, duration_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercices);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title_input = findViewById(R.id.title_input);
        categoriy_input = findViewById(R.id.categoriy_input);
        duration_input = findViewById(R.id.duration_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyExercicesDB myDB = new MyExercicesDB(AddExercices.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        categoriy_input.getText().toString().trim(),
                        Integer.valueOf(duration_input.getText().toString().trim()));
            }
        });
    }
}