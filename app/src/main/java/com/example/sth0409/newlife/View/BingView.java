package com.example.sth0409.newlife.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by STH0409 on 2016/10/9.
 */

public class BingView extends View{
    RectF oval;
    Paint paint;
    int i=290;
    int i1=45;
    int t=0;
    private int t1=0;
    int c=0;
    private int j=0;

    public BingView(Context context) {
        super(context);
    }

    public BingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint=new Paint();
        paint.setColor(0xffF1BC68);
        final Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                t+=2;
                t1-=2;
                i=290+t;
                i1=45+t1;
                postInvalidate();
                if (t>=26){
                    t1=t=0;
                    c+=1;

                }
                if (c>=6){
                    timer.cancel();
                }
            }
        };
        timer.schedule(task,30,80);
    }

    public BingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawArc(oval,i1,i,true,paint);
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int hight=MeasureSpec.getSize(heightMeasureSpec);
        oval=new RectF(0,0,width,hight);
        setMeasuredDimension(width,hight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
