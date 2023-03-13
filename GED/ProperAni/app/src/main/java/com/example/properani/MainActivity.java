package com.example.properani;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.BaseInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView rTxt = findViewById(R.id.textView);

        ObjectAnimator obj = ObjectAnimator.ofFloat(rTxt, "scaleY", 4); //"translationX", 200, "rotation", 0, 2520
        obj.setInterpolator(new BounceInterpolator());
        obj.setDuration(5000);
        obj.start();
    }
}