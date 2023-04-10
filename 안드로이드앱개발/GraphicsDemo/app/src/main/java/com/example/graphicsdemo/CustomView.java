package com.example.graphicsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawColor(Color.BLUE);
        canvas.drawRoundRect(30, 50, 330, 550, 15, 15, paint); //둥근꼭지점 사각형
        canvas.drawOval(450, 50, 750, 550, paint); //타원
        //직선 그리기
        float[] points = {30, 650, 300, 750, 300, 750, 60, 850, 60, 850, 360, 900};
        paint.setStrokeWidth(10); //펜(선) 그리기
        canvas.drawLines(points, paint); //선 그리기
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
