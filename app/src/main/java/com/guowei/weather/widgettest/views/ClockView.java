package com.guowei.weather.widgettest.views;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RemoteViews;

import com.guowei.weather.widgettest.MyApplication;
import com.guowei.weather.widgettest.MyWidgetProvider;
import com.guowei.weather.widgettest.R;
import com.guowei.weather.widgettest.utils.DensityUtil;


public class ClockView extends View{
    private int strokeWidth=3;
    public int weight=30;
    public int weightPx=DensityUtil.dip2px(weight);
    public int mWidth=weight*9;
    public int mHeight=weight*6;
    private Paint paint;
    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        }else {
            mWidth =weightPx*9 +3*strokeWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        }else {
            mHeight = weightPx*6+2*strokeWidth;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        //画大圆
//        canvas.drawColor(Color.GRAY);
        RectF bigRectF=new RectF(mWidth-6*weightPx-2*strokeWidth,
                strokeWidth,
                mWidth-strokeWidth,
                mHeight-strokeWidth);
        canvas.drawArc(bigRectF,120,300,false,paint);
        //画小圆
        RectF smalRectF=new RectF(strokeWidth,
                2*weightPx,
                4*weightPx+strokeWidth,
                mHeight-strokeWidth);
        canvas.drawArc(smalRectF,120,180,false,paint);
        canvas.save();
//        canvas.translate(6*weightPx+2*strokeWidth,3*weightPx+strokeWidth);
        canvas.rotate(30,6*weightPx+2*strokeWidth,3*weightPx+strokeWidth);
        Paint pointPaint = new Paint();
        pointPaint.setColor(Color.GRAY);
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth(2);
        canvas.drawCircle(6*weightPx+2*strokeWidth,strokeWidth+DensityUtil.dip2px(10),5,pointPaint);
        canvas.restore();
    }
    public void init(){
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);

    }
}
