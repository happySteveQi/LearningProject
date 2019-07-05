package com.example.ui_learning.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.ui_learning.R;
import com.example.ui_learning.utils.Utils;

/**
 * Description:
 *
 * @author Steve_qi
 * @date: 2019/7/5
 */
public class RoundAvatarView extends View {
    private static final float WIDTH = Utils.dp2px(300);
    private static final float PADDING = Utils.dp2px(30);
    private static final float EDGE_WIDTH = Utils.dp2px(10);

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    //采用Xfermode
    Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    RectF mSavedArea;
    // 采用bitmapShader
//    BitmapShader mBitmapShader;

    {
        mSavedArea = new RectF();
        mPaint.setColor(Color.YELLOW);
        mBitmap = getAvatar((int) (WIDTH));//BitmapFactory.decodeResource(getResources(),R.drawable.test_avatar);
//        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public RoundAvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mSavedArea.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(PADDING , PADDING ,
                WIDTH + PADDING, WIDTH + PADDING, mPaint);
        int saved = canvas.saveLayer(mSavedArea, mPaint);
        canvas.drawOval(PADDING + EDGE_WIDTH, PADDING + EDGE_WIDTH,
                WIDTH + PADDING - EDGE_WIDTH, WIDTH + PADDING - EDGE_WIDTH, mPaint);
        mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(mBitmap,PADDING,PADDING,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saved);

/*  //采用BitmapShader 划圆形头像
      Matrix matrix = new Matrix();
        float scale = (float) getWidth()/mBitmap.getWidth();
        matrix.setScale(scale,scale);
        mBitmapShader.setLocalMatrix(matrix);
        canvas.setMatrix(matrix);
        mPaint.setShader(mBitmapShader);
        mPaint.setColor(Color.parseColor("#ffffff"));
        int half = getWidth()/2;

        canvas.drawCircle(half,half,half,mPaint);*/
    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.test_avatar,options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.test_avatar,options);
    }
}
