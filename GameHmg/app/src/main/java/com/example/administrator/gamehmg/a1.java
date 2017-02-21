package com.example.administrator.gamehmg;

/**
 * 物品一览页面
 * @author MzAlice 
 */


import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class a1 extends AppCompatActivity {

    GridView grid;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    List<Integer> thNum = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();

        Button a1b = (Button) findViewById(R.id.a1b);
        a1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName comp = new ComponentName(a1.this,a.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a1.this.finish();
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

        preferences.getString("thNum", "[]");

        //读取本地文件的rwNum字符串，转换成int后存入rwNum的数组
        try {
            JSONArray array1 = new JSONArray(preferences.getString("thNum", "[]"));
            for (int i = 0; i < array1.length(); i++) {
                thNum.add( array1.getInt(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        int[] imageIdsa1 = new int[100];

        for (int i = 0; i < thNum.size(); i++) {
           imageIdsa1[i] = thNum.get(i);
        }

        // 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();

        for (int i = 0; i < thNum.size(); i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIdsa1[i]);
            listItems.add(listItem);
        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems
                , R.layout.grs, new String[] { "image" },
                new int[] { R.id.image });

        grid = (GridView) findViewById(R.id.gridviewa1);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                ComponentName comp = new ComponentName(a1.this, a11.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                Bundle bundle = new Bundle();

                bundle.putInt("id", thNum.get(position));
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });

        // 为GridView设置Adapter
        grid.setAdapter(simpleAdapter);
    }

}