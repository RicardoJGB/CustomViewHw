package com.mobileapps.customviewhw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    private Paint mPaintThing = new Paint();
    private Path mPath = new Path();

    public CustomView(Context context) {
        super(context);
        init(null,0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init (attrs,0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init (attrs,defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init (AttributeSet attrs, int defStyleAttr){
        mPaintThing.setColor(Color.RED);
        mPaintThing.setAntiAlias(true);
        mPaintThing.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath,mPaintThing);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        super.onTouchEvent(motionEvent);
        return true;
    }
}
