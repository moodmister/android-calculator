package com.example.calculatorapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3,
    btn4, btn5, btn6,
    btn7, btn8, btn9,
    btn0, btnAdd, btnSub,
    btnMul, btnDiv, btnEq;

    Button btnDrawCircle;
    TextView textView;
    Integer firstNumber, secondNumber;
    String operator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEq = (Button) findViewById(R.id.btnEq);
        btnDrawCircle = (Button) findViewById(R.id.btnDrawCircle);
        textView = (TextView) findViewById(R.id.textView1);
        Button[] btns = {
                btn1, btn2, btn3,
                btn4, btn5, btn6,
                btn7, btn8, btn9,
                btn0, btnAdd, btnSub,
                btnMul, btnDiv, btnEq
        };

        for (Button btn :
                btns) {
            btn.setOnClickListener(v -> {
                Button pressedBtn = (Button) v;
                if ("1234567890".contains(pressedBtn.getText())) {
                    if (firstNumber == null) {
                        firstNumber = parseInt((String) pressedBtn.getText());
                        textView.setText("");
                    }
                    secondNumber = parseInt((String) pressedBtn.getText());
                }
                if ("+-*/".contains(pressedBtn.getText())) {
                    if (firstNumber == null) return;
                    operator = (String) pressedBtn.getText();
                }
                textView.setText(textView.getText().toString() + pressedBtn.getText().toString());
                if ("=".contentEquals(pressedBtn.getText())) {
                    Integer result = 0;
                    if ("+".equals(operator)) {
                        result = firstNumber + secondNumber;
                    }
                    if ("-".equals(operator)) {
                        result = firstNumber - secondNumber;
                    }
                    if ("*".equals(operator)) {
                        result = firstNumber * secondNumber;
                    }
                    if ("/".equals(operator)) {
                        result = firstNumber / secondNumber;
                    }
                    textView.setText(result.toString());
                    operator = null;
                    secondNumber = null;
                }
            });
        }
        btnDrawCircle.setOnClickListener(v -> {
            if (firstNumber == null) {
                textView.setText("You have to calculate two single digit numbers first");
                return;
            }

            textView.setText("");
            operator = null;
            secondNumber = null;
            firstNumber = null;

            Intent canvasActivity = new Intent(this, CanvasActivity.class);
            canvasActivity.putExtra("diameter", firstNumber);
            startActivity(canvasActivity);
        });
    }

}