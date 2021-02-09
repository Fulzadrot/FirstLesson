package com.geekbrains.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {

    private CalcLogic calcLogic;
    private TextView operationField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearcalc);
        int[] numbersId = new int[]{
                R.id.button0,
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9,
                R.id.buttonDot,
        };
        int[] actionID = new int[]{
                R.id.buttonClear,
                R.id.buttonDivision,
                R.id.buttonPlus,
                R.id.buttonPercent,
                R.id.buttonMultiplication,
                R.id.buttonNegative,
                R.id.buttonSubtraction,
                R.id.buttonEqually,

        };
        calcLogic = new CalcLogic();
        operationField = findViewById(R.id.OperationField);

        View.OnClickListener numberClickListener = v -> {
            calcLogic.onNumberClick(v.getId());
            operationField.setText(calcLogic.getText());
        };
        View.OnClickListener actionClickListener = v -> {
            calcLogic.onActionClick(v.getId());
            operationField.setText(calcLogic.getText());
        };

        for (int i = 0; i < numbersId.length; i++) {
            findViewById(numbersId[i]).setOnClickListener(numberClickListener);
        }

        for (int i = 0; i <actionID.length ; i++) {
            findViewById(actionID[i]).setOnClickListener(actionClickListener);
        }
    }
}