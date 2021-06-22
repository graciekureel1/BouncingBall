package com.example.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

public class BouncingBallView extends View{
    int maxX;
    int maxY;
    private Circle ball;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        maxX = w;
        maxY = h;
        ball.setMax(maxX,maxY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ball.draw(canvas);
        invalidate();
    }

    public BouncingBallView(Context context) {
        super(context);
        ball = new Circle(Color.BLUE);
        ball.setCoords(0,0,80);
        ball.setSpeed(5,5);

    }
}
