package com.example.ui_learning.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.ui_learning.utils.Utils;

/**
 * Description:
 *
 * @author Steve_qi
 * @date: 2019/7/5
 */
public class DashView extends View {

    private final float START_ANGLE = 120f;
    private final float END_ANGLE = 240f;
    private final float RADIUS = Utils.dp2px(150);

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    {

    }
    public DashView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(getWidth()/2-RADIUS,0,getWidth()/2+RADIUS,getWidth(),START_ANGLE,360-END_ANGLE,false,mPaint);
    }
}
