package com.example.custumviewgraphic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustumView extends View {
    private ShapeDrawable m_Drawable;

    //초기 위치의 좌표, 좌측 상단이 원점(0, 0)
    int x = 50;
    int y = 50;
    //볼의 크기
    int height = 100;
    int width = 100;
    //화면에서 볼의 중심이 있는 좌표
    int cx, cy;
    //x, y가 증가하면 1, 감소하면 -1
    int xdir = 1;
    int ydir = 1;
    //x, y방향으로 이동하는 크기
    int dx = 5; int dy = 15;

    //화면의 크기
    int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CustumView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_Drawable = new ShapeDrawable(new OvalShape());
        m_Drawable.getPaint().setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cx = x + width / 2; //화면에서 볼의 중심 좌표 계산
        cy = y + height /2;

        //x방향 이동 시 방향
        if(cx <= width / 2) xdir = 1;
        else if (cx >= screen_width - width / 2) xdir = -1;

        //y방향 이동 시 방향
        if (cy <= height / 2) ydir = 1;
        else if(cy >= screen_height - height / 2) ydir = -1;

        x = x + xdir * dx; //결정된 방향에 따라 새로운 위치 계산
        y = y + ydir * dy;
        m_Drawable.setBounds(x, y, x + width, y + height);
        m_Drawable.draw(canvas); //그래픽 출력
        invalidate(); //현재의 그래픽 출력을 지우고 다시 onDraw() 메서드 호출, 즉 새로 그림
    }
}
