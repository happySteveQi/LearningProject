package com.example.ui_learning.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Description:
 *
 * @author Steve_qi
 * @date: 2019/7/5
 */
public class FlipPageView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {

    }

    public FlipPageView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
