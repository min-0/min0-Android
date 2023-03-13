package com.example.curvmotion;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView rTxt = findViewById(R.id.txt);

        Path path = new Path();
        path.arcTo(0f,0f,1000f,1000f,270f,-180f,true);

        ObjectAnimator ani = ObjectAnimator.ofFloat(rTxt, View.X, View.Y, path);
        ani.setDuration(5000);
        ani.start();
    }
}