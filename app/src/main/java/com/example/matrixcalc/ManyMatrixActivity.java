package com.example.matrixcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManyMatrixActivity extends AppCompatActivity {
    Button sumButton, subButton, mulButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.many_matrix_operations);
        sumButton = findViewById(R.id.sumaOperation);
        subButton = findViewById(R.id.roznicaOperation);
        mulButton = findViewById(R.id.mnozenieOperation);
        backButton = findViewById(R.id.backButton);
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(com.example.matrixcalc.ManyMatrixActivity.this, SumActivity.class);
                startActivity(obj);
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(com.example.matrixcalc.ManyMatrixActivity.this, SubActivity.class);
                startActivity(obj);
            }
        });
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(com.example.matrixcalc.ManyMatrixActivity.this, MulActivity.class);
                startActivity(obj);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(ManyMatrixActivity.this, MainActivity.class);
                startActivity(obj);
            }
        });
    }
}
