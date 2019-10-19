package com.anish.bmicalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etHeight, etWeight;
    private TextView tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnCalculate.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate) {
            if(isValid())
                showResult();
            else
                showError();
        }
    }


    public void initView() {
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
    }

    public void showResult() {
        double result = Integer.parseInt(etWeight.getText().toString()) / (Double.parseDouble(etHeight.getText().toString()) * Double.parseDouble(etHeight.getText().toString()));

        DecimalFormat output = new DecimalFormat("#.00");

        if(result < 18.5) tvResult.setText("BMI = " + output.format(result) + "\n Underweight");
        else if(result >= 18.5 && result < 25) tvResult.setText("BMI = " + output.format(result) + "\n Normal Weight");
        else tvResult.setText("BMI = " + output.format(result) + "\n Overweight");
    }

    public void showError(){
        Toast.makeText(this, "Enter correct Weight and Height \n and Try Again", Toast.LENGTH_LONG).show();
    }

    public boolean isValid(){
        if(etHeight.getText().toString().length() == 0 || etWeight.getText().toString().length() == 0 || Double.parseDouble(etHeight.getText().toString()) == 0 || Integer.parseInt(etWeight.getText().toString()) == 0)
            return false;
        else
            return true;
    }
}
