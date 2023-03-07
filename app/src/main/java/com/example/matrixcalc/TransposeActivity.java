package com.example.matrixcalc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;
import java.util.ArrayList;

import Math.Matrix;

public class TransposeActivity extends AppCompatActivity{
    ArrayList<TextView> matrixComp;
    ArrayList<TextView> rmatrixComp;
    ArrayList<Integer> matrixCompIDs;
    TextView result;
    Matrix matrix = new Matrix(3,3);
    TextView chosenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transpose_viev);
        result = findViewById(R.id.detResult);
        matrixComp = new ArrayList<TextView>(9);
        rmatrixComp = new ArrayList<TextView>(9);
        matrixCompIDs = new ArrayList<>(9);
        matrixComp.add(findViewById(R.id.matrix11));
        matrixCompIDs.add(R.id.matrix11);
        matrixComp.add(findViewById(R.id.matrix12));
        matrixCompIDs.add(R.id.matrix12);
        matrixComp.add(findViewById(R.id.matrix13));
        matrixCompIDs.add(R.id.matrix13);
        matrixComp.add(findViewById(R.id.matrix21));
        matrixCompIDs.add(R.id.matrix21);
        matrixComp.add(findViewById(R.id.matrix22));
        matrixCompIDs.add(R.id.matrix22);
        matrixComp.add(findViewById(R.id.matrix23));
        matrixCompIDs.add(R.id.matrix23);
        matrixComp.add(findViewById(R.id.matrix31));
        matrixCompIDs.add(R.id.matrix31);
        matrixComp.add(findViewById(R.id.matrix32));
        matrixCompIDs.add(R.id.matrix32);
        matrixComp.add(findViewById(R.id.matrix33));
        matrixCompIDs.add(R.id.matrix33);
        for (int i = 0; i < matrixComp.size(); ++i) {
            assignIDTextField(matrixComp.get(i), matrixCompIDs.get(i));
        }
        rmatrixComp.add(findViewById(R.id.rmatrix11));
        rmatrixComp.add(findViewById(R.id.rmatrix12));
        rmatrixComp.add(findViewById(R.id.rmatrix13));
        rmatrixComp.add(findViewById(R.id.rmatrix21));
        rmatrixComp.add(findViewById(R.id.rmatrix22));
        rmatrixComp.add(findViewById(R.id.rmatrix23));
        rmatrixComp.add(findViewById(R.id.rmatrix31));
        rmatrixComp.add(findViewById(R.id.rmatrix32));
        rmatrixComp.add(findViewById(R.id.rmatrix33));
        assignID(R.id.button_9);
        assignID(R.id.button_8);
        assignID(R.id.button_7);
        assignID(R.id.button_6);
        assignID(R.id.button_5);
        assignID(R.id.button_4);
        assignID(R.id.button_3);
        assignID(R.id.button_2);
        assignID(R.id.button_1);
        assignID(R.id.button_0);
        assignIDSpecial(R.id.button_cancel);
        assignIDSpecial(R.id.button_equals);
        assignID(R.id.button_minus);
        assignID(R.id.button_dot);
    }

    void assignID(int id) {
        Button button = findViewById(id);
        Button finalButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = (String)chosenTextView.getText() + (String)finalButton.getText();
                chosenTextView.setText(number);
            }
        });
    }
    void assignIDSpecial(int id) {
        Button button = findViewById(id);
        Button finalButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalButton.getText().equals("C")) {
                    String number = (String)chosenTextView.getText();
                    number = number.substring(0, number.length() - 1);
                    if (number.length() == 0) {
                        number = "0";
                    }
                    chosenTextView.setText(number);
                } else if(finalButton.getText().equals("=")) {
                    try {
                        getFromMatrix(matrixComp, matrix);
                        matrix.transpose();
                        setInMatrix(rmatrixComp, matrix);
                    } catch (Exception e) {
                        System.out.println("blad! " + e.getMessage());
                    }
                }
            }
        });
    }
    void assignIDTextField(TextView text, int id) {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                chosenTextView = text;
            }
        });
    }
    void getFromMatrix(ArrayList<TextView> comps, Matrix m) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (comps.get(i*3+j).getText().equals("")) {
                    comps.get(i*3+j).setText("0");
                }
                m.setElement(i, j, Double.parseDouble((String) comps.get(i*3+j).getText()));
            }
        }
    }

    void setInMatrix(ArrayList<TextView> comps, Matrix m) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                DecimalFormat dc = new DecimalFormat("###.#");
                String message = dc.format(m.transposed[i][j]);
                if (message.endsWith(".0")) {
                    message = message.replace(".0", "");
                }
                comps.get(i*3+j).setText(message);
            }
        }
    }
}
