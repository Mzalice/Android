package com.example.administrator.gamehmg;

/**
 * 程序入口
 * 欢迎界面
 * @author MzAlice
 * @Time 2017.1.5
 */

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    //SharedPreferences存储
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    //数据库与表
    DatabaseHelper dbHelper;

    //背景音调整
    private SoundPool sp;
    private int sound1;

    String a,b,c,d,e,f,g,h,i,j,k,l,m;
    List<Integer> thNum = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        // 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下
        dbHelper = new DatabaseHelper(this, "hmgDatabase.db3", 1);

        // 获取只能被本应用程序读、写的SharedPreferences对象，文件名宝石，全篇试用这一个baoshi文件进行数据传递
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();

        //记录程序使用次数，第一次打开程序执行部分操作
        int countnumber = preferences.getInt("count", 0);

        if (countnumber == 0) {
            thNum.add(R.drawable.th01);
            thNum.add(R.drawable.th02);
            thNum.add(R.drawable.th03);
            thNum.add(R.drawable.th04);
            thNum.add(R.drawable.th05);

            //rwNum转换JSON
            JSONArray array = new JSONArray();
            for (int d : thNum) {
                array.put(d);
            }

            //存入本地
            editor.putString("thNum",array.toString());
            editor.commit();

            // 插入人物记录Remilia
            a = 1 + "";
            b = "Remilia";
            c = 150 + "";
            d = 100 + "";
            e = 200 + "";
            f = 80 + "";
            g = 200 + "";
            h = 100 + "";
            i = 25 + "";
            j = 50 + "";
            k = 25 + "";
            l = 10 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录Reimu
            a = 2 + "";
            b = "Reimu";
            c = 120 + "";
            d = 120 + "";
            e = 150 + "";
            f = 120 + "";
            g = 180 + "";
            h = 70 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录flandre
            a = 3 + "";
            b = "flandre";
            c = 200 + "";
            d = 100 + "";
            e = 250 + "";
            f = 50 + "";
            g = 250 + "";
            h = 50 + "";
            i = 30 + "";
            j = 50 + "";
            k = 10 + "";
            l = 5 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录sakuya
            a = 4 + "";
            b = "sakuya";
            c = 120 + "";
            d = 120 + "";
            e = 100 + "";
            f = 120 + "";
            g = 300 + "";
            h = 70 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录patchouli
            a = 5 + "";
            b = "patchouli";
            c = 120 + "";
            d = 120 + "";
            e = 30 + "";
            f = 120 + "";
            g = 320 + "";
            h = 70 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录devil
            a = 6 + "";
            b = "devil";
            c = 120 + "";
            d = 120 + "";
            e = 80 + "";
            f = 120 + "";
            g = 250 + "";
            h = 70 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录meirin
            a = 7 + "";
            b = "meirin";
            c = 120 + "";
            d = 120 + "";
            e = 250 + "";
            f = 150 + "";
            g = 50 + "";
            h = 50 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录marisa
            a = 8 + "";
            b = "marisa";
            c = 120 + "";
            d = 120 + "";
            e = 150 + "";
            f = 120 + "";
            g = 150 + "";
            h = 100 + "";
            i = 20 + "";
            j = 60 + "";
            k = 25 + "";
            l = 25 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录youmu
            a = 9 + "";
            b = "youmu";
            c = 120 + "";
            d = 120 + "";
            e = 180 + "";
            f = 80 + "";
            g = 180 + "";
            h = 80 + "";
            i = 20 + "";
            j = 50 + "";
            k = 25 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录yuyuko
            a = 10 + "";
            b = "yuyuko";
            c = 120 + "";
            d = 120 + "";
            e = 180 + "";
            f = 80 + "";
            g = 180 + "";
            h = 80 + "";
            i = 20 + "";
            j = 50 + "";
            k = 25 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录yukari
            a = 11 + "";
            b = "yukari";
            c = 100 + "";
            d = 100 + "";
            e = 100 + "";
            f = 80 + "";
            g = 300 + "";
            h = 80 + "";
            i = 20 + "";
            j = 50 + "";
            k = 25 + "";
            l = 25 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录yukari
            a = 12 + "";
            b = "yukari";
            c = 100 + "";
            d = 100 + "";
            e = 100 + "";
            f = 80 + "";
            g = 300 + "";
            h = 80 + "";
            i = 20 + "";
            j = 50 + "";
            k = 25 + "";
            l = 25 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录tenshi
            a = 13 + "";
            b = "tenshi";
            c = 100 + "";
            d = 100 + "";
            e = 300 + "";
            f = 80 + "";
            g = 100 + "";
            h = 80 + "";
            i = 20 + "";
            j = 40 + "";
            k = 10 + "";
            l = 10 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入人物记录alice
            a = 14 + "";
            b = "alice";
            c = 100 + "";
            d = 100 + "";
            e = 200 + "";
            f = 80 + "";
            g = 100 + "";
            h = 80 + "";
            i = 20 + "";
            j = 60 + "";
            k = 15 + "";
            l = 15 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入物品记录木刀
            a = R.drawable.th01 + "";
            b = "木刀";
            c = 0 + "";
            d = 0 + "";
            e = 100 + "";
            f = 0 + "";
            g = 0 + "";
            h = 0 + "";
            i = 10 + "";
            j = 0 + "";
            k = 0 + "";
            l = 0 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入物品记录长枪
            a = R.drawable.th02 + "";
            b = "长枪";
            c = 0 + "";
            d = 0 + "";
            e = 150 + "";
            f = 0 + "";
            g = 0 + "";
            h = 0 + "";
            i = 5 + "";
            j = 0 + "";
            k = 0 + "";
            l = 0 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入物品记录水晶
            a = R.drawable.th03 + "";
            b = "水晶";
            c = 0 + "";
            d = 0 + "";
            e = 0 + "";
            f = 0 + "";
            g = 120 + "";
            h = 0 + "";
            i = 10 + "";
            j = 0 + "";
            k = 0 + "";
            l = 0 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入物品记录符文
            a = R.drawable.th04 + "";
            b = "符文";
            c = 0 + "";
            d = 0 + "";
            e = 80 + "";
            f = 0 + "";
            g = 80 + "";
            h = 0 + "";
            i = 0 + "";
            j = 0 + "";
            k = 0 + "";
            l = 0 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

            // 插入物品记录人偶
            a = R.drawable.th05 + "";
            b = "人偶";
            c = 0 + "";
            d = 0 + "";
            e = 100 + "";
            f = 0 + "";
            g = 0 + "";
            h = 0 + "";
            i = 15 + "";
            j = 0 + "";
            k = 0 + "";
            l = 0 + "";
            insertData(dbHelper.getReadableDatabase(), a, b, c,
                    d, e, f, g, h, i, j, k, l);

        }
        //存入数据
        editor.putInt("count", ++countnumber);
        //提交修改
        editor.commit();

        final Button start = (Button) findViewById(R.id.start);
        //添加按键音效
        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        sound1 = sp.load(this, R.raw.sound1 ,1);

        //传递intent给Mymedia来开启线程service
        Intent intent = new Intent(MainActivity.this,Mymedia.class);
        intent.putExtra("ui0", true);
        startService(intent);


        // 加载第一份动画资源
        final Animation anim = AnimationUtils
                .loadAnimation(this, R.anim.anim);

        // 设置动画结束后保留结束状态
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                start.startAnimation(anim);
                sp.play(sound1,2,2,0,0,1);
                Timer timer=new Timer();
                TimerTask task=new TimerTask(){
                    public void run(){

                        ComponentName comp = new ComponentName(MainActivity.this,Mymedia.class);
                        Intent intent = new Intent();
                        intent.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                        stopService(intent);

                        ComponentName comp1 = new ComponentName(MainActivity.this,UI.class);
                        Intent intent1 = new Intent();
                        intent1.setComponent(comp1);
                        startActivity(intent1);

                        MainActivity.this.finish();
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
                timer.schedule(task, 3900);
            }
        });
    }

    //调用结束mymedia
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(MainActivity.this,Mymedia.class);
        stopService(intent);
        super.onStop();
    }

    //数据库表插入类
    private void insertData(SQLiteDatabase db, String number , String name
            , String hp , String mp , String atk , String def
            , String mat , String mdf , String cri , String spd , String luk , String flee)
    {
        // 执行插入语句
        db.execSQL("insert into dict values(null , ? , ? , ? , ? , ? , ? , ? , ? , ? " +
                        ", ? , ? , ? )"
                , new String[] { number, name, hp, mp, atk, def, mat, mdf, cri, spd, luk, flee});
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        if (dbHelper != null)
        {
            dbHelper.close();
        }
    }

}
