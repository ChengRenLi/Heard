package com.example.custom.heard.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 用三阶层曲线画 ❤️
 * 1.首先用三阶曲线画一个圆
 * 2.然后调整控制点
 * 3.具体的大小自己调整到满意
 */

public class HeardView extends View {
    private Paint mpaint;
    //view的宽高
    private int width;
    private int height;
    private float radius;
    //贝赛尔三阶曲线画圆的固定值
    private static final float NORMAL = 0.551915024494f;
    private float normal_radius;


    //初始化画笔
    private void initPaint() {
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setStrokeWidth(3);
        mpaint.setStyle(Paint.Style.FILL);
        mpaint.setDither(true);
        mpaint.setFilterBitmap(true);
        mpaint.setAntiAlias(true);

    }

    public HeardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //构建view的时候就初始化
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
        radius = width > height ? height / 2 : width / 2;
        normal_radius = radius * NORMAL;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        Path path = new Path();
        path.moveTo(0, radius);
        path.cubicTo(normal_radius / 1.5f, radius / 1.5f, radius, normal_radius / 1.3f, radius, 0);
        path.cubicTo(radius, -normal_radius, normal_radius, -radius, 0, -radius / 3f);
        path.cubicTo(-normal_radius, -radius, -radius, -normal_radius, -radius, 0);
        path.cubicTo(-radius, normal_radius / 1.3f, -normal_radius / 1.5f, radius / 1.5f, 0, radius);
        canvas.drawPath(path, mpaint);

    }
}
