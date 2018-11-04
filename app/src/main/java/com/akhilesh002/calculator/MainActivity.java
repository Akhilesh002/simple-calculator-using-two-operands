package com.akhilesh002.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstNumber;
    private EditText secondNumber;
    private EditText result;
    private Button addition;
    private Button subtraction;
    private Button multiplication;
    private Button division;
    private Button modulus;
    int firstNum;
    int secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        modulus = findViewById(R.id.modulus);

        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        modulus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String res;

        try{
            firstNum = Integer.parseInt(firstNumber.getText().toString().trim());
            secondNum = Integer.parseInt(secondNumber.getText().toString().trim());
        }catch (NumberFormatException NFE){

        }

        if (TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString())){
            Toast.makeText(this, "You have to fill all the input field first", Toast.LENGTH_SHORT).show();
        }
        else{
            if (v == addition){
                res = String.valueOf(firstNum + secondNum);
                result.setText(res);
            }
            if (v == subtraction){
                res = String.valueOf(firstNum - secondNum);
                result.setText(res);
            }
            if (v == multiplication){
                res = String.valueOf(firstNum * secondNum);
                result.setText(res);
            }
            if (v == division){
                if (secondNum == 0){
                    Toast.makeText(this, "Denominator can't be zero", Toast.LENGTH_SHORT).show();
                }
                else {
                    res = String.valueOf(firstNum / secondNum);
                    result.setText(res);
                }
            }
            if (v == modulus){
                if (secondNum == 0){
                    Toast.makeText(this, "Denominator can't be zero", Toast.LENGTH_SHORT).show();
                }
                else {
                    res = String.valueOf(firstNum % secondNum);
                    result.setText(res);
                }
            }

        }

    }
}
