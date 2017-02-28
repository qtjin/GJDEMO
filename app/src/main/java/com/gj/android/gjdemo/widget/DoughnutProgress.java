package com.gj.android.gjdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import com.gj.android.gjdemo.R;

/**
 * Created by guojing on 15/12/27.
 */
public class DoughnutProgress extends View {

    private static final int DEFAULT_MIN_WIDTH = 400; //View默认最小宽度
    private static int RED = 248, GREEN = 248, BLUE = 255; //基础颜色，这里是白色
    private static final int MIN_ALPHA = 0; //最小不透明度
    private static final int MIDDLE_ALPHA = 120; //最小不透明度
    private static final int MAX_ALPHA = 255; //最大不透明度
    private static final float doughnutRaduisPercent = 0.65f; //圆环外圆半径占View最大半径的百分比
    private static final float doughnutWidthPercent = 0.022f; //圆环宽度占View最大半径的百分比
    private static final float doughnutWidthPercent2 = 0.045f; //圆环宽度占View最大半径的百分比 粗圆弧用

    private static int[] doughnutColors; //圆点颜色

    private static int[] doughnutColors2; //圆环颜色

    private Paint paint = new Paint(); //画笔
    private float width; //自定义view的宽度
    private float height; //自定义view的高度
    private float raduis; //自定义view的最大半径

    private static int color;

    public DoughnutProgress(Context context) {
        super(context);
    }

    public DoughnutProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DoughnutProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DoughnutProgress);
        color = array.getColor(R.styleable.DoughnutProgress_doughnut_color,0XFFFFFFFF);

         RED = (color & 0xff0000) >> 16;
         GREEN = (color & 0x00ff00) >> 8;
         BLUE = (color & 0x0000ff);

        //圆点颜色
         doughnutColors = new int[]{
                Color.argb(MAX_ALPHA, RED, GREEN, BLUE),
                Color.argb(MIDDLE_ALPHA, RED, GREEN, BLUE),
                Color.argb(MIN_ALPHA, RED, GREEN, BLUE)};
        //圆环颜色
         doughnutColors2 = new int[]{
                Color.argb(MIN_ALPHA, RED, GREEN, BLUE),
                Color.argb(MIDDLE_ALPHA, RED, GREEN, BLUE),
                Color.argb(MAX_ALPHA, RED, GREEN, BLUE)};
    }

    private void resetParams() {
        width = getWidth();
        height = getHeight();
        raduis = Math.min(width, height)/2;
    }

    private void initPaint() {
        paint.reset();
        paint.setAntiAlias(true);  //设置画笔为无锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        resetParams();

        //将画布中心设为原点(0,0), 方便后面计算坐标
        canvas.translate(width / 2, height / 2);

        //画底部细点的圆环
        float doughnutWidth = raduis * doughnutWidthPercent;//圆环宽度
        //圆环外接矩形
        RectF rectF = new RectF(-raduis * doughnutRaduisPercent, -raduis * doughnutRaduisPercent, raduis * doughnutRaduisPercent, raduis * doughnutRaduisPercent);
        initPaint();
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);
        canvas.drawArc(rectF, 0, 360, false, paint);


        initPaint();

        //画渐变粗圆弧
        float doughnutWidth2 = raduis * doughnutWidthPercent2;//圆环宽度
        //圆环外接矩形
        paint.setStrokeWidth(doughnutWidth2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setShader(new SweepGradient(0, 0, doughnutColors2, null)); //设置渐变 梯度渲染
        canvas.drawArc(rectF, 210, 60, false, paint);


        initPaint();

        //画旋转头部圆
//        paint.setColor(color);
        //1.圆心X坐标2.Y坐标3.半径 4.颜色数组 5.相对位置数组，可为null 6.渲染器平铺模式
        // 环形渐变渲染
        Shader mRadialGradient  = new RadialGradient(0, - raduis * doughnutRaduisPercent, doughnutWidth / 2 + 30, doughnutColors , null,
                Shader.TileMode.MIRROR);
        // 绘制环形渐变
        paint.setShader(mRadialGradient);  //设置渐变 环形渲染
        // 第一个,第二个参数表示圆心坐标
        // 第三个参数表示半径
        canvas.drawCircle(0, - raduis * doughnutRaduisPercent, doughnutWidth / 2 + 30, paint);

    }

    /**
     * 当布局为wrap_content时设置默认长宽
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    private int measure(int origin) {
        int result = DEFAULT_MIN_WIDTH;
        int specMode = MeasureSpec.getMode(origin);
        int specSize = MeasureSpec.getSize(origin);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
