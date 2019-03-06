package com.example.yinyuxuan.myapplicationtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class Myview extends View {

    private int textX=20,textY=20;
    /**
     * 重写父类构造函数
     * @param context
     */
    public Myview(Context context) {
        super(context);
        //设置焦点
        setFocusable(true);
    }

    /***
     * 重写按键按下事件
     * @param  keyCode 当前用户点击的按键
     * @param  event 按键的动作事件队列，此类还定义了很多静态常量键值
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判定用户按下的键值是否方向键的"上下左右"键
        if(keyCode==KeyEvent.KEYCODE_DPAD_UP)
        {
            //"上"按键被点击，应该让文本的Y坐标变小

            textY-=2;
        }else if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN)
        {
            //"下"按键被点击，应该让文本的Y坐标变大
            textY+=2;
        }else if(keyCode==KeyEvent.KEYCODE_DPAD_LEFT)
        {
            //"左"按键被点击，应该让文本的X坐标变小
            textX-=2;
        }else if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT)
        {
            //"右"按键被点击，应该让文本的X坐标变大
            textX+=2;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 重写按键抬起事件
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //invalidate();不能在当前子线程中循环调用执行
        //postInvalidate(); 可以在子线程中循环调用执行
        invalidate();//重新绘制画布
        return super.onKeyUp(keyCode, event);
    }

    /**
     * 重写触屏事件函数
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取用户手指触屏的X坐标赋值与文本的X坐标
        int x = (int)event.getX();
        //获取用户手指触屏的Y坐标赋值与文本的Y坐标
        int y = (int)event.getY();
        textX=x;
        textY=y;
        //重绘画布
        invalidate();
        return true;
    }

    /**
     * 重写父类绘图函数
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //创建一个画笔实例
        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(Color.WHITE);
        //设置画笔文本大小
        paint.setTextSize(18);
        //绘制文本
        canvas.drawText("Hi，你好！", textX, textY, paint);
        super.onDraw(canvas);
    }

}