package com.example.drawingboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    drawLine nv;
    ImageButton curBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nv = (drawLine) new drawLine(this);
        LinearLayout board = findViewById(R.id.canvus);
        board.addView(nv);
    }

    public void selectColor(View view) {
        if(view != curBtn) {
            String color = view.getTag().toString();
            nv.colorSet(color);
            curBtn = (ImageButton) view;

        }
    }
}
class drawLine extends View {
    Paint paint = new Paint();
    Path path = new Path();
    Paint cnvPnt;
    Canvas gCnvs;
    Bitmap bCnvs;
    int pColor;

    public drawLine (Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);

        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                gCnvs.drawPath(path, paint);
                path.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bCnvs = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        gCnvs = new Canvas(bCnvs);
        cnvPnt = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bCnvs, 0, 0, cnvPnt);
        canvas.drawPath(path, paint);
    }

    public void colorSet (String newColor) {
        invalidate();
        pColor = Color.parseColor(newColor);
        paint.setColor(pColor);
    }

}