package com.example.buttonif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.txt1);
    }

    public void textPrint(View view) {
        if(view.getId() == R.id.button1){
            tv.setText("button1을 클릭했습니다");
        }
        else if(view.getId() == R.id.button2){
            tv.setText("button2를 클릭했습니다");
        }
    }
}