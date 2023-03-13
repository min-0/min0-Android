package com.example.methodoverloading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    public Graphic (Context context) {
        super(context);
    }
    protected void onDraw(Canvas cnvs) {
        Paint pnt = new Paint();
        cnvs.drawColor(Color.LTGRAY);

        pnt.setColor(Color.GREEN);
        cnvs.drawRoundRect(new RectF(100, 100, 300, 400), 15, 15, pnt);

        cnvs.drawOval(new RectF(400, 100, 550, 400), pnt);

        pnt.setColor(Color.YELLOW);
        cnvs.drawArc(new RectF(700, 100, 900, 300),30, 300, true, pnt);

        float[] pnts = {300, 600, 700, 700, 700, 700, 450, 750, 450, 750, 600, 800};
        pnt.setColor(Color.BLACK);
        pnt.setStrokeWidth(10);
        cnvs.drawLines(pnts, pnt);
    }
}