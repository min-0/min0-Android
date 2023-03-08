package com.example.rectanglearea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText x1, y1, x2, y2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        res = (TextView)findViewById(R.id.res);
        x1 = (EditText)findViewById(R.id.x1);
        y1 = (EditText)findViewById(R.id.y1);
        x2 = (EditText)findViewById(R.id.x2);
        y2 = (EditText)findViewById(R.id.y2);
    }
    public void Cal(View view) {
        int height, width;

        height = Integer.parseInt(y2.getText().toString()) - Integer.parseInt(y1.getText().toString());
        width = Integer.parseInt(x2.getText().toString()) - Integer.parseInt(x1.getText().toString());

        res.setText("넓이는 " + String.valueOf(height*width) + ", 둘레는 " + String.valueOf(height*2 + width *2));
    }
}