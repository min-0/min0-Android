package com.example.colorbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setColor(View view) {
        TextView tv = (TextView)findViewById(R.id.txt1);
        switch (view.getId()) {
            case R.id.R:
                tv.setText("RED");
                tv.setBackgroundColor(Color.rgb(255,0,0));
                break;
            case R.id.G:
                tv.setText("GREEN");
                tv.setBackgroundColor(Color.parseColor("#00FF00"));
                break;
            case R.id.B:
                tv.setText("BLUE");
                tv.setBackgroundColor(Color.rgb(0,0,255));
                break;
        }
    }
}