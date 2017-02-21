package com.example.administrator.gamehmg;

/**
 * 物品属性显示页面
 * @author MzAlice 
 */

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class a11 extends AppCompatActivity {

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a11);

        Button a11b = (Button) findViewById(R.id.a11b);
        a11b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName comp = new ComponentName(a11.this,a1.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a11.this.finish();
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

        // 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下
        dbHelper = new DatabaseHelper(this, "hmgDatabase.db3", 1);

        Bundle bundle=this.getIntent().getExtras();
        int a = bundle.getInt("id");

        String key = a + "";
        // 执行查询

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                "select * from dict where number like ?",
                new String[] {key});


        ListView listView = (ListView) findViewById(R.id.showa11);
        ArrayList<Map<String, String>>  chuandione = converCursorToList(cursor);
        SimpleAdapter adapter = new SimpleAdapter(a11.this
                , chuandione,
                R.layout.simple, new String[] {"number", "name", "hp", "mp" ,"atk" ,"def" ,
                "mat", "mdf", "cri", "spd", "luk", "flee"}
                , new int[] { R.id.sim1,R.id.name, R.id.hp, R.id.mp ,R.id.atk ,R.id.def ,
                R.id.mat ,R.id.mdf ,R.id.cri , R.id.spd, R.id.luk, R.id.flee});
        // 填充ListView
        listView.setAdapter(adapter);
        cursor.close();

    }

    protected ArrayList<Map<String, String>>
    converCursorToList(Cursor cursor)
    {
        ArrayList<Map<String, String>> result =
                new ArrayList<Map<String, String>>();
        // 遍历Cursor结果集
        while (cursor.moveToNext())
        {
            // 将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            map.put("number", cursor.getString(1));
            map.put("name", cursor.getString(2));
            map.put("hp", cursor.getString(3));
            map.put("mp", cursor.getString(4));
            map.put("atk", cursor.getString(5));
            map.put("def", cursor.getString(6));
            map.put("mat", cursor.getString(7));
            map.put("mdf", cursor.getString(8));
            map.put("cri", cursor.getString(9));
            map.put("spd", cursor.getString(10));
            map.put("luk", cursor.getString(11));
            map.put("flee", cursor.getString(12));
            result.add(map);
        }
        return result;
    }
}
