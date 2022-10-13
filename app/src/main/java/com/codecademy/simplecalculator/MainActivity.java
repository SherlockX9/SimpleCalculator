package com.codecademy.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText firstNumber = findViewById(R.id.number1);
        EditText secondNumber = findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.operators);
        RadioGroup operators2 = findViewById(R.id.operators2);
        RadioButton add = findViewById(R.id.add);
        RadioButton subtract = findViewById(R.id.subtract);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
                secondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter appropriate values in both fields ", Toast.LENGTH_SHORT).show();
                    result.setText("");
                    return;
                } else if (firstNumber.getText().toString().equals(".") || secondNumber.getText().toString().equals(".")) {
                    Toast.makeText(MainActivity.this, "Enter appropriate values in both fields ", Toast.LENGTH_SHORT).show();
                    result.setText("");
                    return;
                } else {
                    float firstNumberValue = Float.parseFloat(firstNumber.getText().toString());
                    float secondNumberValue = Float.parseFloat(secondNumber.getText().toString());
                    int operatorButtonId = operators.getCheckedRadioButtonId();
                    int operators2ButtonId = operators2.getCheckedRadioButtonId();
                    float answer = 0;

                    if (operatorButtonId == add.getId()) {
                        answer = firstNumberValue + secondNumberValue;
                    } else if (operatorButtonId == subtract.getId()) {
                        answer = firstNumberValue - secondNumberValue;
                    } else if (operators2ButtonId == multiply.getId()) {
                        answer = firstNumberValue * secondNumberValue;
                    } else {
                        answer = firstNumberValue / secondNumberValue;
                    }
                    String formattedString = String.format("%.02f", answer);
                    result.setText(formattedString);

                }
            }
        });
    }



    public void handleCombinedClick(View view) {
        RadioGroup operators = findViewById(R.id.operators);
        RadioGroup operators2 = findViewById(R.id.operators2);
        RadioButton add = findViewById(R.id.add);
        RadioButton subtract = findViewById(R.id.subtract);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);
        operators.clearCheck();
        operators2.clearCheck();
        ((RadioButton) view).setChecked(true);


    }
}