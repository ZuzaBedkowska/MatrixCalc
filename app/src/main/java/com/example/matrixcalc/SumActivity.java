package com.example.matrixcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Math.Matrix;

public class SumActivity extends AppCompatActivity {
    TextView result;
    ArrayList<TextView> amatrixComp;
    ArrayList<Integer> amatrixCompIDs;
    Matrix amatrix = new Matrix(3,3);
    ArrayList<TextView> bmatrixComp;
    ArrayList<Integer> bmatrixCompIDs;
    Matrix bmatrix = new Matrix(3,3);
    ArrayList<TextView> rmatrixComp;
    Matrix rmatrix = new Matrix(3,3);
    TextView chosenTextView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_view);
        amatrixComp = new ArrayList<TextView>(9);
        amatrixCompIDs = new ArrayList<>(9);
        result = findViewById(R.id.result);
        amatrixComp = new ArrayList<TextView>(9);
        bmatrixComp = new ArrayList<TextView>(9);
        rmatrixComp = new ArrayList<TextView>(9);
        amatrixCompIDs = new ArrayList<>(9);
        bmatrixCompIDs = new ArrayList<>(9);
        amatrixComp.add(findViewById(R.id.amatrix11));
        amatrixCompIDs.add(R.id.amatrix11);
        amatrixComp.add(findViewById(R.id.amatrix12));
        amatrixCompIDs.add(R.id.amatrix12);
        amatrixComp.add(findViewById(R.id.amatrix13));
        amatrixCompIDs.add(R.id.amatrix13);
        amatrixComp.add(findViewById(R.id.amatrix21));
        amatrixCompIDs.add(R.id.amatrix21);
        amatrixComp.add(findViewById(R.id.amatrix22));
        amatrixCompIDs.add(R.id.amatrix22);
        amatrixComp.add(findViewById(R.id.amatrix23));
        amatrixCompIDs.add(R.id.amatrix23);
        amatrixComp.add(findViewById(R.id.amatrix31));
        amatrixCompIDs.add(R.id.amatrix31);
        amatrixComp.add(findViewById(R.id.amatrix32));
        amatrixCompIDs.add(R.id.amatrix32);
        amatrixComp.add(findViewById(R.id.amatrix33));
        amatrixCompIDs.add(R.id.amatrix33);
        for (int i = 0; i < amatrixComp.size(); ++i) {
            assignIDTextField(amatrixComp.get(i), amatrixCompIDs.get(i));
        }
        bmatrixComp.add(findViewById(R.id.bmatrix11));
        bmatrixCompIDs.add(R.id.bmatrix11);
        bmatrixComp.add(findViewById(R.id.bmatrix12));
        bmatrixCompIDs.add(R.id.bmatrix12);
        bmatrixComp.add(findViewById(R.id.bmatrix13));
        bmatrixCompIDs.add(R.id.bmatrix13);
        bmatrixComp.add(findViewById(R.id.bmatrix21));
        bmatrixCompIDs.add(R.id.bmatrix21);
        bmatrixComp.add(findViewById(R.id.bmatrix22));
        bmatrixCompIDs.add(R.id.bmatrix22);
        bmatrixComp.add(findViewById(R.id.bmatrix23));
        bmatrixCompIDs.add(R.id.bmatrix23);
        bmatrixComp.add(findViewById(R.id.bmatrix31));
        bmatrixCompIDs.add(R.id.bmatrix31);
        bmatrixComp.add(findViewById(R.id.bmatrix32));
        bmatrixCompIDs.add(R.id.bmatrix32);
        bmatrixComp.add(findViewById(R.id.bmatrix33));
        bmatrixCompIDs.add(R.id.bmatrix33);
        for (int i = 0; i < bmatrixComp.size(); ++i) {
            assignIDTextField(bmatrixComp.get(i), bmatrixCompIDs.get(i));
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
                        getFromMatrix(amatrixComp, amatrix);
                        getFromMatrix(bmatrixComp, bmatrix);
                        rmatrix.sum(amatrix, bmatrix);
                        setInMatrix(rmatrixComp, rmatrix);
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
                String message = dc.format(m.elements[i][j]);
                if (message.endsWith(".0")) {
                    message = message.replace(".0", "");
                }
                if (m.elements[i][j]==0){
                    message = message.replace("-", "");
                }
                comps.get(i*3+j).setText(message);
            }
        }
    }
}
