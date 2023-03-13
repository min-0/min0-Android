package com.example.pathdrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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
    Path path = new Path();
    Paint pnt = new Paint();
    public Graphic (Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }
    protected void onDraw(Canvas cnvs) {
        pnt.setColor(Color.BLUE);
        pnt.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 600);
        path.lineTo(300, 500);
        path.cubicTo(450, 120, 600, 1200, 900, 800);
        cnvs.drawPath(path, pnt);

        pnt.setStyle(Paint.Style.FILL);
        pnt.setTextSize(150);
        cnvs.drawTextOnPath("Path에 Text 출력 !!!", path, 0, 0, pnt);
    }
}