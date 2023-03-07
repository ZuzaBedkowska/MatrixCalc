package com.example.matrixcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Math.Matrix;

public class MainActivity extends AppCompatActivity {
    Button oneButton;
    Button twoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            oneButton = findViewById(R.id.oneMatrixOperations);
            twoButton = findViewById(R.id.manyMatrixOperations);
            oneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent obj = new Intent(MainActivity.this, OneMatrixActivity.class);
                    startActivity(obj);
                }
            });
            twoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent obj = new Intent(MainActivity.this, ManyMatrixActivity.class);
                    startActivity(obj);
                }
            });
        }catch (Exception e) {
            System.out.println("blad! " + e.getMessage());
        }
    }
}



