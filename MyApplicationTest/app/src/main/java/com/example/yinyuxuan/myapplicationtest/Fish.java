package com.example.yinyuxuan.myapplicationtest;

import android.graphics.Bitmap;

import java.util.Random;

public class Fish {
    static int Width ,Height;
    int fish_x,fish_y,v_x,v_y,fish_type,fish_level,fish_currentFrame;
    int fish_left;
    int bitmap_Width,bitmap_Height;
    static Random r = new Random();
public static final boolean isCollision(Fish f1,Fish f2,int d){
    return Math.sqrt(Math.pow(f1.fish_x-f2.fish_y,2)+ Math.pow(f1.fish_y-f2.fish_y,2))<d;
}
public Fish(int fish_type,int fish_level, Bitmap bitmap){
    restart();
    fish_currentFrame = 0;
    this.fish_type=fish_type;
    this.fish_level=fish_level;
    bitmap_Height=bitmap.getHeight();
    bitmap_Width=bitmap.getWidth();
    v_x = 1;
    v_y = 1;
}
public Fish(Fish fish){
    fish_x=fish.fish_x;
    fish_y=fish.fish_y;
    v_x=fish.v_x;
    v_y=fish.v_y;
    fish_type=fish.fish_type;
    fish_level=fish.fish_level;
    fish_currentFrame=fish.fish_currentFrame;
}
public Fish(){}
public  void restart(){
    fish_left=(r.nextDouble()>0.5)?-1:1;
    fish_x=(fish_left==1)?Width-1:-bitmap_Width+1;//会不会导致直接出边界（好像不会
    fish_y=((r.nextDouble()>0.5)?1:0)*Height;//想改
    fish_y+=(fish_y==0)?-bitmap_Height+1:-1;
    fish_currentFrame=0;
}
}