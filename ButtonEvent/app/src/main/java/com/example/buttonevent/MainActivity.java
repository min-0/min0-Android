package com.example.buttonevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printMessage (View view) {
        Toast.makeText(getApplicationContext(), "버튼이 클릭됨",Toast.LENGTH_SHORT).show();

    }
}