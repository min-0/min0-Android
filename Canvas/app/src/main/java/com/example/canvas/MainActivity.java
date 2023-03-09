package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Graphic gv = new Graphic(this);
        setContentView(gv);
    }
}
class Graphic extends View {
    public Graphic (Context context) {
        super(context);
    }
    protected void onDraw(Canvas cnvs) {
        Paint pnt = new Paint();

        pnt.setStyle(Paint.Style.STROKE);
        pnt.setStrokeWidth(5);

        cnvs.drawLine(100,200,300,500, pnt);
        cnvs.drawRect(300, 400, 600, 1000, pnt);
        cnvs.drawCircle(500, 500, 200, pnt);

        int x = 500, y = 500;
        String str = "(" + x + ", " + y + ")  위치의 텍스트 출력";

        pnt.setTextSize(40);
        cnvs.drawText(str, x, y, pnt);
    }
}