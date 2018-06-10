package org.hejin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number1EditText;
    private EditText number2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gatherControls();
        setupButtons();
    }

    private void gatherControls() {
        number1EditText = (EditText)findViewById(R.id.editText1);
        number2EditText = (EditText)findViewById(R.id.editText2);
        number2EditText.requestFocus();
    }

    private void setupButtons() {
        Button button = (Button)findViewById(R.id.plusButton);
        button.setOnClickListener(this);

        button = (Button)findViewById(R.id.minusButton);
        button.setOnClickListener(this);

        button = (Button)findViewById(R.id.multiplyButton);
        button.setOnClickListener(this);

        button = (Button)findViewById(R.id.divideButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String sNum1 = number1EditText.getText().toString();
        String sNum2 = number2EditText.getText().toString();
        double num1 = getDouble(sNum1);
        double num2 = getDouble(sNum2);
        Button button = (Button)view;

        double value = 0;
        if (button.getId() == R.id.plusButton) {
            value = plus(num1, num2);
        } else if (button.getId() == R.id.minusButton) {
            value = minus(num1, num2);
        } else if (button.getId() == R.id.multiplyButton) {
            value = multiply(num1, num2);
        } else if (button.getId() == R.id.divideButton) {
            value = divide(num1, num2);
        }

        number1EditText.setText(Double.toString(value));
    }

    private double plus(double n1, double n2) {
        return n1 + n2;
    }
    private double minus(double n1, double n2) {
        return  n1 - n2;
    }
    private double multiply(double n1, double n2) {
        return n1 * n2;
    }
    private double divide(double n1, double n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }
    private double getDouble(String s) {
        if (validString(s)) {
            return Double.parseDouble(s);
        }
        return 0;
    }
    private boolean invalidString(String s) {
        return !validString(s);
    }
    private boolean validString(String s) {
        if (s == null) {
            return false;
        }
        if (s.trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
}
