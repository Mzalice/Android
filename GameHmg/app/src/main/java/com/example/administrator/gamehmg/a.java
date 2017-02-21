package com.example.administrator.gamehmg;

/**
佣兵公会面板

 完成物品栏目页面
 初始宝石量→1000

 */

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class a extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    List<Integer> rwNum = new ArrayList<Integer>();
    List<String> rwNum1 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();

        //读取本地文件的rwNum字符串，转换成int后存入rwNum的数组
        try {
            JSONArray array1 = new JSONArray(preferences.getString("rwNum", "[]"));
            for (int i = 0; i < array1.length(); i++) {
                rwNum.add( array1.getInt(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Jhshuju a1 = new Jhshuju();
        a1.image = R.drawable.remilia;
        a1.hp = 1000+"";
        a1.mp = 100+"";
        a1.name = "Remilia";
        a1.atk = 10+"";
        a1.def = 10+"";
        a1.mat = 10+"";
        a1.mdf = 10+"";
        a1.cri = 10+"";
        a1.spd = 10+"";
        a1.luk = 20+"";
        a1.flee = 10+"";

        Jhshuju a2 = new Jhshuju();
        a2.image = R.drawable.reimu;
        a2.hp = 1000+"";
        a2.mp = 100+"";
        a2.name = "Reimu";
        a2.atk = 10+"";
        a2.def = 10+"";
        a2.mat = 10+"";
        a2.mdf = 10+"";
        a2.cri = 10+"";
        a2.spd = 10+"";
        a2.luk = 20+"";
        a2.flee = 10+"";

        Jhshuju a3 = new Jhshuju();
        a3.image = R.drawable.flandre;
        a3.hp = 1000+"";
        a3.mp = 100+"";
        a3.name = "Flandre";
        a3.atk = 10+"";
        a3.def = 10+"";
        a3.mat = 10+"";
        a3.mdf = 10+"";
        a3.cri = 10+"";
        a3.spd = 10+"";
        a3.luk = 20+"";
        a3.flee = 10+"";

        Jhshuju a4 = new Jhshuju();
        a4.image = R.drawable.sakuya;
        a4.hp = 1000+"";
        a4.mp = 100+"";
        a4.name = "Sakuya";
        a4.atk = 10+"";
        a4.def = 10+"";
        a4.mat = 10+"";
        a4.mdf = 10+"";
        a4.cri = 10+"";
        a4.spd = 10+"";
        a4.luk = 20+"";
        a4.flee = 10+"";

        Jhshuju a5 = new Jhshuju();
        a5.image = R.drawable.patchouli;
        a5.hp = 1000+"";
        a5.mp = 100+"";
        a5.name = "Patchouli";
        a5.atk = 10+"";
        a5.def = 10+"";
        a5.mat = 10+"";
        a5.mdf = 10+"";
        a5.cri = 10+"";
        a5.spd = 10+"";
        a5.luk = 20+"";
        a5.flee = 10+"";

        Jhshuju a6 = new Jhshuju();
        a6.image = R.drawable.devil;
        a6.hp = 1000+"";
        a6.mp = 100+"";
        a6.name = "Devil";
        a6.atk = 10+"";
        a6.def = 10+"";
        a6.mat = 10+"";
        a6.mdf = 10+"";
        a6.cri = 10+"";
        a6.spd = 10+"";
        a6.luk = 20+"";
        a6.flee = 10+"";

        Jhshuju a7 = new Jhshuju();
        a7.image = R.drawable.meirin;
        a7.hp = 1000+"";
        a7.mp = 100+"";
        a7.name = "Meirin";
        a7.atk = 10+"";
        a7.def = 10+"";
        a7.mat = 10+"";
        a7.mdf = 10+"";
        a7.cri = 10+"";
        a7.spd = 10+"";
        a7.luk = 20+"";
        a7.flee = 10+"";

        Jhshuju a8 = new Jhshuju();
        a8.image = R.drawable.marisa;
        a8.hp = 1000+"";
        a8.mp = 100+"";
        a8.name = "Marisa";
        a8.atk = 10+"";
        a8.def = 10+"";
        a8.mat = 10+"";
        a8.mdf = 10+"";
        a8.cri = 10+"";
        a8.spd = 10+"";
        a8.luk = 20+"";
        a8.flee = 10+"";

        Jhshuju a9 = new Jhshuju();
        a9.image = R.drawable.youmu;
        a9.hp = 1000+"";
        a9.mp = 100+"";
        a9.name = "Youmu";
        a9.atk = 10+"";
        a9.def = 10+"";
        a9.mat = 10+"";
        a9.mdf = 10+"";
        a9.cri = 10+"";
        a9.spd = 10+"";
        a9.luk = 20+"";
        a9.flee = 10+"";

        Jhshuju a10 = new Jhshuju();
        a10.image = R.drawable.yuyuko;
        a10.hp = 1000+"";
        a10.mp = 100+"";
        a10.name = "Yuyuko";
        a10.atk = 10+"";
        a10.def = 10+"";
        a10.mat = 10+"";
        a10.mdf = 10+"";
        a10.cri = 10+"";
        a10.spd = 10+"";
        a10.luk = 20+"";
        a10.flee = 10+"";

        Jhshuju a11 = new Jhshuju();
        a11.image = R.drawable.yukari;
        a11.hp = 1000+"";
        a11.mp = 100+"";
        a11.name = "Yukari";
        a11.atk = 10+"";
        a11.def = 10+"";
        a11.mat = 10+"";
        a11.mdf = 10+"";
        a11.cri = 10+"";
        a11.spd = 10+"";
        a11.luk = 20+"";
        a11.flee = 10+"";

        Jhshuju a12 = new Jhshuju();
        a12.image = R.drawable.tenshi;
        a12.hp = 1000+"";
        a12.mp = 100+"";
        a12.name = "Tenshi";
        a12.atk = 10+"";
        a12.def = 10+"";
        a12.mat = 10+"";
        a12.mdf = 10+"";
        a12.cri = 10+"";
        a12.spd = 10+"";
        a12.luk = 20+"";
        a12.flee = 10+"";

        Jhshuju a13 = new Jhshuju();
        a13.image = R.drawable.alice;
        a13.hp = 1000+"";
        a13.mp = 100+"";
        a13.name = "Alice";
        a13.atk = 10+"";
        a13.def = 10+"";
        a13.mat = 10+"";
        a13.mdf = 10+"";
        a13.cri = 10+"";
        a13.spd = 10+"";
        a13.luk = 20+"";
        a13.flee = 10+"";

        String b1 = gson.toJson(a1);
        String b2 = gson.toJson(a2);
        String b3 = gson.toJson(a3);
        String b4 = gson.toJson(a4);
        String b5 = gson.toJson(a5);
        String b6 = gson.toJson(a6);
        String b7 = gson.toJson(a7);
        String b8 = gson.toJson(a8);
        String b9 = gson.toJson(a9);
        String b10 = gson.toJson(a10);
        String b11 = gson.toJson(a11);
        String b12 = gson.toJson(a12);
        String b13 = gson.toJson(a13);

        int length = rwNum.size();

        for (int i = 0; i < rwNum.size(); i++) {

            int  a  =  rwNum.get(i);

            if ( a >= 0 && a < 50 )
            {
                rwNum1.add(b1);
            }
            if ( a >= 50 && a < 100)
            {
                rwNum1.add(b2);
            }
            else if ( a >= 100 && a < 150 )
            {
                rwNum1.add(b3);
            }
            else if ( a >= 150 && a < 200 )
            {
                rwNum1.add(b4);
            }
            else if ( a >= 200 && a < 250 )
            {
                rwNum1.add(b5);
            }
            else if ( a >= 250 && a < 300 )
            {
                rwNum1.add(b6);
            }
            else if ( a >= 300 && a < 350 )
            {
                rwNum1.add(b7);
            }
            else if ( a >= 350 && a < 400 )
            {
                rwNum1.add(b8);
            }
            else if ( a >= 400 && a < 450 )
            {
                rwNum1.add(b9);
            }
            else if ( a >= 450 && a < 500 )
            {
                rwNum1.add(b10);
            }
            else if ( a >= 500 && a < 600 )
            {
                rwNum1.add(b11);
            }
            else if ( a >= 600 && a < 700 )
            {
                rwNum1.add(b12);
            }
            else if ( a >= 700 && a < 1000 )
            {
                rwNum1.add(b13);
            }
        }

        //存入本地
        editor.putString("rwNum1",rwNum1.toString());
        editor.commit();

        Button a1n = (Button) findViewById(R.id.a1);
        Button a2n = (Button) findViewById(R.id.a2);
        Button a3n = (Button) findViewById(R.id.a3);
        Button a4n = (Button) findViewById(R.id.a4);
        Button a6n = (Button) findViewById(R.id.a6);
        Button a8n = (Button) findViewById(R.id.a8);
        Button a9n = (Button) findViewById(R.id.a9);

        a1n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(a.this, a1.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a.this.finish();
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

        a2n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(a.this, a2.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a.this.finish();
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

        a9n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(a.this, UI.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a.this.finish();
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

    }

}
