package com.example.animalradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RadioList(View view) {
        boolean isCheck = ((RadioButton)view).isChecked();
        ImageView iv = (ImageView) findViewById(R.id.image);
        EditText res = (EditText)findViewById(R.id.res);

        switch (view.getId()) {
            case R.id.Dog:
                if(isCheck) res.setText("개가 선택됨.");
                iv.setImageResource(R.drawable.dog);
                break;
            case R.id.Cat:
                if(isCheck) res.setText("고양이가 선택됨.");
                iv.setImageResource(R.drawable.cat);
                break;
            case R.id.Bird:
                if(isCheck) res.setText("새가 선택됨.");
                iv.setImageResource(R.drawable.bird);
                break;
            case R.id.Rabbit:
                if(isCheck) res.setText("토끼가 선택됨.");
                iv.setImageResource(R.drawable.rabbit);
                break;
        }
    }
}