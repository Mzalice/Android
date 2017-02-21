package com.example.administrator.gamehmg;

/**
 * UI跳转抽卡界面特效界面
 * @author MzAlice 
 * @Time 2017.1.7
 */
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class Ld extends AppCompatActivity {

    private AnimationDrawable mAnimation = null;
    private ImageView mImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingd);

        mImageView = (ImageView) findViewById(R.id.loadingtv);
        mImageView.setBackgroundResource(R.drawable.gointo);
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        mAnimation.start();

        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){

                ComponentName comp1 = new ComponentName(Ld.this,d.class);
                Intent intent = new Intent();
                intent.setComponent(comp1);
                startActivity(intent);

                Ld.this.finish();
                android.os.Process
                        .killProcess(android.os.Process
                                .myPid());
                android.os.Process
                        .killProcess(android.os.Process
                                .myTid());
                android.os.Process
                        .killProcess(android.os.Process
                                .myUid());
            }
        };
        timer.schedule(task, 2000);
    }

}