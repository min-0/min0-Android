package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    
    ImageView ivRt; //이미지뷰 변수 선언
    float startD = 0; //시작각도 변수 0으로 설정
    float endD = 0; //종료각도

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivRt = (ImageView)findViewById(R.id.roulet); //roulet 이미지뷰를 변수 ivRt에 할당
    }
    public void rotate(View view) {
        startD = endD;
        int minD = 3600; //최소 회전각도 즉, 3600도(10바퀴)
        Random rand = new Random();
        int raD = rand.nextInt(360); //추가 회전 각도 즉, 1~360도 사이
        endD = startD + minD + raD;

        ObjectAnimator obj = ObjectAnimator.ofFloat(ivRt, "rotation", startD, endD); //(animate 되는 객체, animate 성질(회전), animate 시작각도, animate 종료각도)
        obj.setInterpolator(new AccelerateDecelerateInterpolator()); //점점 가속하다가 다시 감속하도록 회전 설정
        obj.setDuration(5000); //5초동안 회전 유지(5000ms)
        obj.start();
    }
}