package com.example.yinyuxuan.myapplicationtest;

public class MyFish extends Fish {
    public int[] ExpBound;
    public int currentExp;
    public int score;
    public int ability;
    //重写自己的restart函数！！！！

    public void upgrade()
    {
        //体型增大
        fish_level++;//等级提升

    }
@Override
    public  void restart()
{

}
}
