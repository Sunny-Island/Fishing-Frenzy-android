package com.example.yinyuxuan.myapplicationtest;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

//Callback接口用于SurfaceHolder 对SurfaceView 的状态进行监听
public class MySurfaceView extends SurfaceView implements Callback, Runnable {
    // 用于控制SurfaceView 的大小、格式等，并且主要用于监听SurfaceView 的状态
    private SurfaceHolder sfh;
    // 声明一个画笔
    private Paint paint;
    // 文本坐标
    private int textX = 30, textY = 30;
    // 声明一个线程
    private Thread th;
    // 线程消亡的标识符
    private boolean flag;
    // 声明一个画布
    private Canvas canvas;
    // 声明屏幕的宽高
    private int screenW, screenH;

    /**
     * SurfaceView 初始化函数
     *
     * @param context
     */
    public MySurfaceView(Context context) {
        super(context);
        // 实例SurfaceView
        sfh = this.getHolder();
        // 为SurfaceView添加状态监听
        sfh.addCallback(this);
        // 实例一个画笔
        paint = new Paint();
        // 设置字体大小
        paint.setTextSize(20);
        // 设置画笔的颜色
        paint.setColor(Color.WHITE);
        // 设置焦点
        setFocusable(true);
    }

    /**
     * SurfaceView 视图创建，响应此函数
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        screenW = this.getWidth();
        screenH = this.getHeight();
        flag = true;
        // 实例线程
        th = new Thread(this);
        // 启动线程
        th.start();
    }

    /**
     * SurfaceView 视图状态发生改变时，响应此函数
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    /**
     * SurfaceView 视图消亡时，响应此函数
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

    /**
     * 游戏绘图
     */
    public void myDraw() {
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                // ————利用绘制矩形的方式刷屏
                // canvas.drawRect(0, 0, this.getWidth(), this.getHeight(),
                // paint);
                // ————利用填充画布，刷屏
                // canvas.drawColor(Color.BLACK);
                // ————利用填充画布指定的颜色分量，刷屏
                canvas.drawRGB(0, 0, 0);
                canvas.drawText("啦啦啦，德玛西亚！", textX, textY, paint);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }

    /**
     * 触屏事件监听
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textX = (int) event.getX();
        textY = (int) event.getY();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 游戏逻辑
     */
    private void logic() {
    }

    @Override
    public void run() {
        while (flag) {
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 50) {
                    Thread.sleep(50 - (end - start));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}