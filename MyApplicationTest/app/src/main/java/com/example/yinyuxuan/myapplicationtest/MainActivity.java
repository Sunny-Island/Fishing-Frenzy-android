package com.example.yinyuxuan.myapplicationtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;





import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

//Callback接口用于SurfaceHolder 对SurfaceView 的状态进行监听
public class MainActivity extends SurfaceView implements Callback,Runnable{
    private int[] fish1 = {R.drawable.fish1_1,R.drawable.fish1_2,R.drawable.fish1_3,
            R.drawable.fish1_4,R.drawable.fish1_5,R.drawable.fish1_6,R.drawable.fish1_7,
            R.drawable.fish1_8,R.drawable.fish1_9,R.drawable.fish1_10,R.drawable.fish1_11,
            R.drawable.fish1_12,R.drawable.fish1_13,R.drawable.fish1_14,R.drawable.fish1_15,
            R.drawable.fish1_16,R.drawable.fish1_17,R.drawable.fish1_18,R.drawable.fish1_19,
            R.drawable.fish1_20,R.drawable.fish1_21,R.drawable.fish1_22,R.drawable.fish1_23,
            R.drawable.fish1_24,R.drawable.fish1_25};
    private int[] fish2 = {R.drawable.fish2_1,R.drawable.fish2_2,R.drawable.fish2_3,
            R.drawable.fish2_4,R.drawable.fish2_5,R.drawable.fish2_6,R.drawable.fish2_7,
            R.drawable.fish2_8,R.drawable.fish2_9,R.drawable.fish2_10,R.drawable.fish2_11,
            R.drawable.fish2_12,R.drawable.fish2_13,R.drawable.fish2_14,R.drawable.fish2_15,
            R.drawable.fish2_16,R.drawable.fish2_17,R.drawable.fish2_18};
    private int[] fish3 = {R.drawable.fish3_1,R.drawable.fish3_2,R.drawable.fish3_3,
            R.drawable.fish3_4,R.drawable.fish3_5,R.drawable.fish3_6,R.drawable.fish3_7,
            R.drawable.fish3_8,R.drawable.fish3_9,R.drawable.fish3_10,R.drawable.fish3_11,
            R.drawable.fish3_12,R.drawable.fish3_13,R.drawable.fish3_14,R.drawable.fish3_15,
            R.drawable.fish3_16,R.drawable.fish3_17,R.drawable.fish3_18,R.drawable.fish3_19,
            R.drawable.fish3_20,R.drawable.fish3_21};
    private int[] fish4 = {R.drawable.fish4_1,R.drawable.fish4_2,R.drawable.fish4_3,
            R.drawable.fish4_4,R.drawable.fish4_5,R.drawable.fish4_6,R.drawable.fish4_7,
            R.drawable.fish4_8,R.drawable.fish4_9,R.drawable.fish4_10,R.drawable.fish4_11,
            R.drawable.fish4_12,R.drawable.fish4_13,R.drawable.fish4_14,R.drawable.fish4_15,
            R.drawable.fish4_16,R.drawable.fish4_17,R.drawable.fish4_18,R.drawable.fish4_19,
            R.drawable.fish4_20,R.drawable.fish4_21,R.drawable.fish4_22};
    private int[] fish5 = {R.drawable.fish5_1,R.drawable.fish5_2,R.drawable.fish5_3,
            R.drawable.fish5_4,R.drawable.fish5_5,R.drawable.fish5_6,R.drawable.fish5_7,
            R.drawable.fish5_8,R.drawable.fish5_9,R.drawable.fish5_10,R.drawable.fish5_11,
            R.drawable.fish5_12,R.drawable.fish5_13,R.drawable.fish5_14,R.drawable.fish5_15,
            R.drawable.fish5_16,R.drawable.fish5_17,R.drawable.fish5_18,R.drawable.fish5_19,
            R.drawable.fish5_20,R.drawable.fish5_21,R.drawable.fish5_22,R.drawable.fish5_23,
            R.drawable.fish5_24,R.drawable.fish5_25,R.drawable.fish5_26};
    private int[] fish6 = {R.drawable.fish6_1,R.drawable.fish6_2,R.drawable.fish6_3,
            R.drawable.fish6_4,R.drawable.fish6_5,R.drawable.fish6_6,R.drawable.fish6_7,
            R.drawable.fish6_8,R.drawable.fish6_9,R.drawable.fish6_10,R.drawable.fish6_11,
            R.drawable.fish6_12,R.drawable.fish6_13,R.drawable.fish6_14,R.drawable.fish6_15,
            R.drawable.fish6_16,R.drawable.fish6_17,R.drawable.fish6_18,R.drawable.fish6_19,
            R.drawable.fish6_20,R.drawable.fish6_21,R.drawable.fish6_22,R.drawable.fish6_23,
            R.drawable.fish6_24,R.drawable.fish6_25};
    private int[] fish7 = {R.drawable.fish7_1,R.drawable.fish7_2,R.drawable.fish7_3,
            R.drawable.fish7_4,R.drawable.fish7_5,R.drawable.fish7_6,R.drawable.fish7_7,
            R.drawable.fish7_8,R.drawable.fish7_9,R.drawable.fish7_10,R.drawable.fish7_11,
            R.drawable.fish7_12,R.drawable.fish7_13,R.drawable.fish7_14,R.drawable.fish7_15,
            R.drawable.fish7_16,R.drawable.fish7_17,R.drawable.fish7_18,R.drawable.fish7_19,
            R.drawable.fish7_20,R.drawable.fish7_21,R.drawable.fish7_22,R.drawable.fish7_23,
            R.drawable.fish7_24,R.drawable.fish7_25};
    private int[] fish8 = {R.drawable.fish8_1,R.drawable.fish8_2,R.drawable.fish8_3,
            R.drawable.fish8_4,R.drawable.fish8_5,R.drawable.fish8_6,R.drawable.fish8_7,
            R.drawable.fish8_8,R.drawable.fish8_9,R.drawable.fish8_10,R.drawable.fish8_11,
            R.drawable.fish8_12,R.drawable.fish8_13,R.drawable.fish8_14,R.drawable.fish8_15,
            R.drawable.fish8_16,R.drawable.fish8_17,R.drawable.fish8_18,R.drawable.fish8_19,
            R.drawable.fish8_20,R.drawable.fish8_21,R.drawable.fish8_22,R.drawable.fish8_23,
            R.drawable.fish8_24,R.drawable.fish8_25,R.drawable.fish8_26,R.drawable.fish8_27};
    private int[] fish9 = {R.drawable.fish9_1,R.drawable.fish9_2,R.drawable.fish9_3,
            R.drawable.fish9_4,R.drawable.fish9_5};
    private int[] fish10 = {R.drawable.fish10_1,R.drawable.fish10_2,R.drawable.fish10_3,
            R.drawable.fish10_4,R.drawable.fish10_5,R.drawable.fish10_6,R.drawable.fish10_7,
            R.drawable.fish10_8,R.drawable.fish10_9,R.drawable.fish10_10,R.drawable.fish10_11,
            R.drawable.fish10_12,R.drawable.fish10_13,R.drawable.fish10_14,R.drawable.fish10_15,
            R.drawable.fish10_16,R.drawable.fish10_17,R.drawable.fish10_18,R.drawable.fish10_19,
            R.drawable.fish10_20};
    private int[] fish11 = {R.drawable.fish11_1,R.drawable.fish11_2,R.drawable.fish11_3,
            R.drawable.fish11_4,R.drawable.fish11_5,R.drawable.fish11_6,R.drawable.fish11_7,
            R.drawable.fish11_8,R.drawable.fish11_9,R.drawable.fish11_10,R.drawable.fish11_11,
            R.drawable.fish11_12,R.drawable.fish11_13,R.drawable.fish11_14,R.drawable.fish11_15};
    private int[][] fish={fish1,fish2,fish3,fish4,fish5,fish6,fish7,fish8,fish9,fish10,fish11};
    private Bitmap[][]bmp=new  Bitmap[11][];

    //act=[turnStartPic,swallowStartPic] ,for SwimStartPic=0
    public int[][] act={{15,19},{-1,14},{13,18},{-1,16},{16,20},{14,19},{13,19},{15,20,23}};
    boolean[] turnFlag={true,false,true,false,true,true,true,false};
    int touch_x,touch_y,center_x,center_y,d,fish_x=400,fish_y=400;//d未初始化
    ArrayList<Fish>fishArray;
    int[]type_list;
    int fish_type;
    int fish_level;
    // 用于控制SurfaceView 的大小、格式等，并且主要用于监听SurfaceView 的状态
    private SurfaceHolder sfh;
    // 声明一个画布
    private Canvas canvas;
    // 声明一个线程
    private Thread th;
    // 线程消亡的标识符
    private boolean flag;
    private Paint paint;
    public MyFish myFish;
    Random r;

    public MainActivity(Context context) {
        super(context);
        // 实例SurfaceView
        for (int i = 0; i < 11; i++) {
            int length=fish[i].length;
            bmp[i]=new Bitmap[length];
            for (int j = 0; j < length; j++) {
                bmp[i][j]=BitmapFactory.decodeResource(this.getResources(),fish[i][j]);
            }
        }
        sfh = this.getHolder();
        // 为SurfaceView添加状态监听
        sfh.addCallback(this);
        paint = new Paint();
        // 画笔无锯齿
        paint.setAntiAlias(true);
        myFish=new MyFish();
        fishArray=new ArrayList<>();
        fishArray.add(myFish);
        for (int i = 0; i < 10; i++) {
            fishArray.add(new Fish(getWidth(),getHeight(),bmp[1][0]));

        }
        for (int i = 0; i < 10; i++) {
            fishArray.add(new Fish(getWidth(),getHeight(),bmp[1][0]));
        }
        r=new Random();
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        flag = true;
        // 实例线程
        th = new Thread(this);
        // 启动线程
        th.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    public void logic(){
        Fish f,f1;
        Bitmap bitmap;
        //animation first, collision next
        for(Fish f2 : fishArray){
            if(f2.fish_type<act.length-1){
                if(f2.fish_currentFrame==act[f2.fish_type][0] - 1
                        || f2.fish_currentFrame==act[f2.fish_type][1] - 1
                        || f2.fish_currentFrame==fish[f2.fish_type].length - 1)
                    f2.fish_currentFrame = 0;
                else f2.fish_currentFrame+=1;
            }

        }

        //逻辑待修改！！！！！！！
        //转向！！！！
        //已经实现碰撞检测
        //calculate next location for myfish
        if(Math.sqrt(Math.pow(touch_x-center_x,2)+Math.pow(touch_y-center_y,2))<=d){
            int nextx =  myFish.fish_x + myFish.v_x*(touch_x-center_x);
            int nexty =  myFish.fish_y + myFish.v_y*(touch_y-center_y);

            if(nextx > 0+myFish.bitmap_Width/2  && nextx < getWidth()-myFish.bitmap_Width/2)
                myFish.fish_x = nextx;
            if(nexty > 0+myFish.bitmap_Height/2  && nexty < getHeight()-myFish.bitmap_Height/2)
                myFish.fish_y+=myFish.v_y*(touch_y-center_y);
            //touch_x=center_x;touch_y=center_y;
        }

        //calculate next location for other fish
        for (int i = 1; i < fishArray.size(); i++) {
            f=fishArray.get(i);
            f.fish_x+=-f.fish_left*f.v_x;
            f.fish_y+=f.v_y*(r.nextInt(5)-2);
        }

        //judge whether collsion
        for (int i = 1; i < fishArray.size(); i++) {
            f= fishArray.get(i);
            for (int j = 0; j < fishArray.size(); j++) {
                f1= fishArray.get(j);
                if(Fish.isCollision(f,f1,d)&&f.fish_level!=f1.fish_level){
                    if(f1.fish_level>f.fish_level){
                        f.restart();
                        f1.fish_currentFrame=act[f1.fish_type][1];
                    }
                    else {
                        f1.restart();
                        f.fish_currentFrame=act[f.fish_type][1];
                    }
                }
            }
        }
        //judge whether collision
        for(int i = 1;i<fishArray.size();i++)
        {
            f = fishArray.get(i);
            if(Fish.isCollision(f,myFish,d) &&  myFish.fish_level> f.fish_level)//myfish eats other fish
            {
                //播放吃的动画
                f.restart();
                myFish.score += 10;
                //upgrade();
            }

        }
        //judge whether  other fish arrive edge
        for (int i = 1; i < fishArray.size(); i++) {
            Boolean flag1;
            f=fishArray.get(i);
            bitmap = bmp[f.fish_type][f.fish_currentFrame];
            f= fishArray.get(i);
            if(f.fish_y+bitmap.getHeight()<0 || f.fish_y>getHeight() ||
                    f.fish_x+bitmap.getWidth()<0 || f.fish_x>getWidth()) f.restart();
        }


        //限制自己不能游出边界(已实现）
    }

    private void myDraw() {
        Matrix ma=new Matrix();
        Bitmap bitmap;
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                // 刷屏，画布白色
                canvas.drawColor(Color.WHITE);
                // 绘制鱼
                for(Fish f : fishArray){
                    canvas.save();
                    ma.postTranslate(f.fish_x,f.fish_y);
                    bitmap=bmp[f.fish_type][f.fish_currentFrame];
                    ma.postScale(-1,1,f.fish_x+bitmap.getWidth()/2,f.fish_y+bitmap.getHeight()/2);
                    canvas.drawBitmap(bitmap,ma,paint);
                    canvas.restore();
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
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