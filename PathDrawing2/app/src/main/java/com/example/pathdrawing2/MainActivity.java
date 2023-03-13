package com.example.pathdrawing2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText input;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.txt);
        drawView dv = new drawView(this);
        LinearLayout board = findViewById(R.id.canvas);
        board.addView(dv);
    }
    class drawView extends View {
        Path path = new Path();
        Paint pnt = new Paint();
        public drawView (Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.reset();
                    path.moveTo(x, y);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    break;

            }
            invalidate();
            return true;
        }
        protected void onDraw(Canvas cnvs) {
            str = input.getText().toString();
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.STROKE);

            pnt.setStyle(Paint.Style.FILL);
            pnt.setTextSize(150);
            cnvs.drawTextOnPath(str, path, 0, 0, pnt);
        }
    }
}
