package com.example.administrator.gamehmg;

/**
 * 武器氪金页面
 */
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class d extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    int[] images = new int[]{
            R.drawable.remilia,
            R.drawable.reimu,
            R.drawable.flandre,
            R.drawable.sakuya,
            R.drawable.patchouli,
            R.drawable.devil,
            R.drawable.meirin,
            R.drawable.marisa,
            R.drawable.youmu,
            R.drawable.yuyuko,
            R.drawable.yukari,
            R.drawable.tenshi,
            R.drawable.alice
    };


    int currentImg = 0;
    Random random = new Random();
    List<Integer> rwNum = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d);

        Intent intent = new Intent(d.this,Mymedia.class);
        intent.putExtra("ui2", true);
        startService(intent);

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();

        Button da = (Button) findViewById(R.id.da);
        Button dc = (Button) findViewById(R.id.dc);
        Button de = (Button) findViewById(R.id.de);
        Button df = (Button) findViewById(R.id.df);


        try {
            JSONArray array1 = new JSONArray(preferences.getString("rwNum", "[]"));
            for (int i = 0; i < array1.length(); i++) {
                rwNum.add( array1.getInt(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    View root = this.getLayoutInflater().inflate(R.layout.dc, null);
    final PopupWindow popup = new PopupWindow(root, 400, 400);


     View root1 = this.getLayoutInflater().inflate(R.layout.dg, null);
     final PopupWindow popup1 = new PopupWindow(root1, 400, 400);

        dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.showAtLocation(findViewById(R.id.dc),
                        Gravity.CENTER, 400,400);
            }
        });

        // 获取PopupWindow中的“关闭”按钮
        root.findViewById(R.id.close).setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        // 关闭PopupWindow
                        popup.dismiss(); // ①
                    }
                });
        // 获取PopupWindow中的“关闭”按钮
        root1.findViewById(R.id.close1).setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        // 关闭PopupWindow
                        popup1.dismiss(); // ①
                    }
                });

        //返回城镇
        da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(d.this,Mymedia.class);
                Intent intent = new Intent();
                intent.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                stopService(intent);

                ComponentName comp1 = new ComponentName(d.this,UI.class);
                Intent intent1 = new Intent();
                intent1.setComponent(comp1);
                startActivity(intent1);
                d.this.finish();
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

//单抽界面按钮
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a = preferences.getInt("abc", 0);
                int c = random.nextInt(999);
                if (a >= 100) {
                    int b = a - 100;
                    editor.putInt("abc", b);
                    editor.commit();

                    rwNum.add(c);

                    //rwNum转换JSON
                    JSONArray array = new JSONArray();

                    for (int d : rwNum) {
                        array.put(d);
                    }

                    //存入本地
                    editor.putString("rwNum",array.toString());
                    editor.commit();

                    ComponentName comp = new ComponentName(d.this, de.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);

                    Bundle bundle = new Bundle();

                    bundle.putInt("image1", c);
                    intent.putExtras(bundle);


                    startActivity(intent);
                    d.this.finish();
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
                else if (a < 100)
                {
                    popup1.showAtLocation(findViewById(R.id.df),
                            Gravity.CENTER, 400,400);
                }
            }
        });

//十连抽界面按钮
        df.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int a = preferences.getInt("abc", 0);
                if (a >= 1000) {
                    int b = a - 1000;
                    editor.putInt("abc", b);
                    editor.commit();

                    final int[] images = new int[10];
                    int length = images.length;

                    //写入10个随机数进入ruNum
                    for (int i = 0; i < length; i++) {
                        images[i] = random.nextInt(999);
                        rwNum.add(images[i]);
                    }

                    //rwNum转换JSON
                    JSONArray array = new JSONArray();

                    for (int c : rwNum) {
                        array.put(c);
                    }

                    //存入本地
                    editor.putString("rwNum",array.toString());
                    editor.commit();


                    ComponentName comp = new ComponentName(d.this, com.example.administrator.gamehmg.df.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);

                    Bundle bundle = new Bundle();

                    bundle.putIntArray("image", images);
                    intent.putExtras(bundle);

                    startActivity(intent);

                    d.this.finish();
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
                else if (a < 1000)
                {
                    popup1.showAtLocation(findViewById(R.id.df),
                            Gravity.CENTER, 400,400);
                }
            }
        });



        final ImageView dd = (ImageView) findViewById(R.id.dd);
        final Handler myHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                // 如果该消息是本程序所发送的
                if (msg.what == 0x1233)
                {
                    // 动态地修改所显示的图片
                    dd.setImageResource(images[currentImg++
                            % images.length]);
                }
            }
        };
        // 定义一个计时器，让该计时器周期性地执行指定任务
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                // 发送空消息
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 5000);

        dd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dd.setImageResource(
                        images[++currentImg % images.length]);
            }
        });

    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(d.this,Mymedia.class);
        stopService(intent);
        super.onStop();
    }

}