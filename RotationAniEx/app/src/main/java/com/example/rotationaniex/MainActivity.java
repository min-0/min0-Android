package com.example.rotationaniex;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView rTxt = findViewById(R.id.txt);

        ObjectAnimator obj = ObjectAnimator.ofFloat(rTxt, "rotation",0, 2520); //각도 0도부터 360*7바퀴
        obj.setInterpolator(new BounceInterpolator());
        obj.setDuration(5000);
        obj.start();
    }
}