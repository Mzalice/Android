package com.example.administrator.gamehmg;

/**
 * 游戏主界面，各种参数
 * @author MzAlice 
 * @Time 2017.1.5
 */

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UI extends AppCompatActivity {

    private SoundPool sp;

    //按钮提示音
    private int sound1;
    private int sound2;
    private int sound3;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        //添加按键音效
        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        sound1 = sp.load(this, R.raw.sound ,1);
        sound2 = sp.load(this, R.raw.sound2 ,1);
        sound3 = sp.load(this, R.raw.sound3 ,1);

        Button cn = (Button) findViewById(R.id.c);
        Button dn = (Button) findViewById(R.id.d);
        Button en = (Button) findViewById(R.id.e);
        Button fn = (Button) findViewById(R.id.f);
        Button gn = (Button) findViewById(R.id.g);
        Button hn = (Button) findViewById(R.id.h);

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();

        //定义初始宝石数量
        int a =  preferences.getInt("abc",10000);

        editor.putInt("abc",a);
        editor.commit();

        //显示宝石数量
        int nbc = preferences.getInt("abc",0);
        cn.setTextSize(30);
        cn.setTextColor(Color.parseColor("#EE2C2C"));
        cn.setText(nbc + "");


        //传递intent给Mymedia来开启线程service
        Intent intent = new Intent(UI.this,Mymedia.class);
        intent.putExtra("ui1", true);
        startService(intent);

        //人物，物品相关界面
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sound1,2,2,0,0,1);

                Timer timer=new Timer();
                TimerTask task=new TimerTask(){
                    public void run(){

                        ComponentName comp = new ComponentName(UI.this,a.class);
                        Intent intent = new Intent();
                        intent.setComponent(comp);
                        startActivity(intent);

                        UI.this.finish();
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
                timer.schedule(task, 500);
            }
        });

        //活动设计界面
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(UI.this,b.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                UI.this.finish();
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
        });

        //酒馆/交流/信息获得等面板
        fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(UI.this,c.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                UI.this.finish();
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
        });

        //通往抽卡界面的中间过渡特效界面
        gn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.play(sound2,2,2,0,0,1);

                Timer timer=new Timer();
                TimerTask task=new TimerTask(){
                    public void run(){

                        ComponentName comp = new ComponentName(UI.this,Mymedia.class);
                        Intent intent = new Intent();
                        intent.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                        stopService(intent);

                        ComponentName comp1 = new ComponentName(UI.this,Ld.class);
                        Intent intent1 = new Intent();
                        intent1.setComponent(comp1);
                        startActivity(intent1);

                        UI.this.finish();
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
                timer.schedule(task, 3500);
            }
        });

        //关卡界面
        hn.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View view) {

            sp.play(sound3,2,2,0,0,1);

            Timer timer=new Timer();
            TimerTask task=new TimerTask(){
                public void run(){
                    ComponentName comp = new ComponentName(UI.this,Mymedia.class);
                    Intent intent = new Intent();
                    intent.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent);

                    ComponentName comp1 = new ComponentName(UI.this,e.class);
                    Intent intent1 = new Intent();
                    intent1.setComponent(comp1);
                    startActivity(intent1);

                    UI.this.finish();
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
            timer.schedule(task, 2500);
        }
    });
}
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(UI.this,Mymedia.class);
        stopService(intent);
        super.onStop();
    }

}
