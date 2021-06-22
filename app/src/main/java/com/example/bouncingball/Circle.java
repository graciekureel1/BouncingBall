package com.example.bouncingball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Circle {
    private int leftTopX;
    private int leftTopY;
    private int radius;
    private Paint paint;
    private RectF bounds;
    private int speedX;
    private int speedY;
    private int maxX;
    private int maxY;

    public Circle(int color) {
        paint = new Paint();
        paint.setColor(color);
        bounds = new RectF();
    }
    public void setCoords(int x, int y, int radius) {
        leftTopX = x;
        leftTopY = y;
        this.radius = radius;
        bounds.set(leftTopX, leftTopY,
                leftTopX + this.radius * 2, leftTopY + this.radius * 2);
    }
    public void setSpeed(int speedX, int speedY){
        this.speedX = speedX;
        this.speedY = speedY;
    }
    public void setMax(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void draw(Canvas canvas){
        canvas.drawOval(bounds, paint);
        update();

    }

    private void update() {

        if (leftTopX + radius * 2 > maxX){
          speedX = speedX*-1;
        } else if (leftTopX<0){
            speedX = speedX*-1;
        }
        if (leftTopY + radius * 2 > maxY){
            speedY = speedY*-1;
        } else if (leftTopY<0){
            speedY = speedY*-1;
        }
        leftTopX = leftTopX + speedX;
        leftTopY = leftTopY + speedY;
        bounds.set(leftTopX, leftTopY,
                leftTopX + this.radius * 2, leftTopY + this.radius * 2);
    }
}
