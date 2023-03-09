package com.example.touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newView nv = new newView(this);
        setContentView(nv);
    }
    class newView extends View {
        int x, y;

        public newView (Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX();
            y = (int) event.getY();
            invalidate();
            return super.onTouchEvent(event);
        }

        @Override
        protected void onDraw(Canvas cnvs) {
            Paint paint = new Paint();
            paint.setTextSize(40);
            cnvs.drawText("(" + x + ", " + y + ")에서 터치 이벤트 발생", x, y, paint);
        }
    }
}