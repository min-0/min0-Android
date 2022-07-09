package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    TextView result;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        txt = (TextView) findViewById(R.id.txt);
    }

    public void calcBMI (View view) {
        float h, w, BMI;

        h = Float.parseFloat(height.getText().toString());
        w = Float.parseFloat(weight.getText().toString());
        BMI = w/(h*h);

        result.setText(String.valueOf(BMI));

        if(BMI < 18.5) {
            txt.setText("당신은 [저체중] 입니다.");
        }
        else if(BMI >= 18.5 && BMI < 25) {
            txt.setText("당신은 [정상] 입니다.");
        }
        else if(BMI >= 25 && BMI < 30) {
            txt.setText("당신은 [과체중] 입니다.");
        }
        else if(BMI >= 30) {
            txt.setText("당신은 [비만] 입니다.");
        }
    }
    public void clearSCR (View view) {
        height.setText("");
        weight.setText("");
        result.setText("");
        txt.setText("당신의 BMI를 계산해보세요");
    }
}