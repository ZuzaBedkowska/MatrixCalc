package com.example.matrixcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OneMatrixActivity extends AppCompatActivity {
    Button detButton, rankButton, transposeButton, inverseButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_matrix_operations);
        detButton = findViewById(R.id.wyznacznikOperation);
        //rankButton = findViewById(R.id.rzadOperation);
        transposeButton = findViewById(R.id.transpozycjaOperation);
        inverseButton = findViewById(R.id.odwrotnaOperation);
        backButton = findViewById(R.id.backButton);
        detButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(OneMatrixActivity.this, DetActivity.class);
                startActivity(obj);
            }
        });
        transposeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(OneMatrixActivity.this, TransposeActivity.class);
                startActivity(obj);
            }
        });
        inverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(OneMatrixActivity.this, InverseActivity.class);
                startActivity(obj);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(OneMatrixActivity.this, MainActivity.class);
                startActivity(obj);
            }
        });
    }
}
