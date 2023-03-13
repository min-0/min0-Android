package com.example.drawablegraphicani;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable rocketAni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView rocketImg = (ImageView) findViewById(R.id.rocket_image);
        rocketImg.setBackgroundResource(R.drawable.rocket_thrust);
        rocketAni = (AnimationDrawable) rocketImg.getBackground();

        rocketImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocketAni.start();
            }
        });
    }
}