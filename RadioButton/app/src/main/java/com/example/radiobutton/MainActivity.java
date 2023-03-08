package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RadioList(View view) {
        boolean isCheck = ((RadioButton) view).isChecked();
        EditText res = (EditText)findViewById(R.id.res);

        switch (view.getId()) {
            case R.id.rbP:
                if(isCheck) res.setText("Python 언어가 선택됨.");
                break;
            case R.id.rbJ:
                if(isCheck) res.setText("Java 언어가 선택됨.");
                break;
            case R.id.rbC:
                if(isCheck) res.setText("C++ 언어가 선택됨.");
                break;
        }
    }
}