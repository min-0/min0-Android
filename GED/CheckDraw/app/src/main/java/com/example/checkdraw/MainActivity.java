package com.example.checkdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Boolean isLine = false, isRect = false, isCircle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView nv = new drawView(this);
        LinearLayout board = findViewById(R.id.canvas);
        board.addView(nv);
    }
    public void checkList (View view) {
        if(view.getId() == R.id.ckLine){
            if(isLine) isLine = false;
            else isLine = true;
        }
        if(view.getId() == R.id.ckReck){
            if(isRect) isRect = false;
            else isRect = true;
        }
        if(view.getId() == R.id.ckCircle) {
            if(isCircle) isCircle = false;
            else isCircle = true;
        }
    }
    class drawView extends View {
        private Paint paint = new Paint();
        int px1, py1, px2, py2;

        public drawView(Context context) {
            super(context);

            setBackgroundColor(Color.LTGRAY);
            paint.setStrokeWidth(10);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
        }

        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    px1 = (int) event.getX();
                    py1 = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    px2 = (int) event.getX();
                    py2 = (int) event.getY();
                    break;
            }
            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            paint.setColor(Color.BLUE);
            canvas.drawPoint(px1, py1, paint);
            canvas.drawPoint(px2, py2, paint);

            paint.setColor(Color.RED);
            if(isLine) canvas.drawLine(px1, py1, px2, py2, paint);
            if(isRect) canvas.drawRect(px1, py1, px2, py2, paint);
            if(isCircle) canvas.drawOval(px1, py1, px2, py2, paint);
        }
    }
}
