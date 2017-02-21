package com.example.administrator.gamehmg;

/**
佣兵界面
 */
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class a2 extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    List<String> rwNum1 = new ArrayList<String>();
    ListView mainLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        Button a2b = (Button) findViewById(R.id.a2b);
        a2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName comp = new ComponentName(a2.this,a.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                a2.this.finish();
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

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("baoshi", MODE_PRIVATE);
        editor = preferences.edit();
        mainLView = (ListView) findViewById(R.id.lv_listview);

        preferences.getString("rwNum1", "[]");

        try {
            JSONArray string1 = new JSONArray(preferences.getString("rwNum1", "[]"));
            for (int i = 0; i < string1.length(); i++) {
                rwNum1.add( string1.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(rwNum1.toString()).getAsJsonArray();

        ArrayList<Jhshuju> shujuList = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement user : jsonArray) {
            //使用GSON，直接转成Bean对象
            Jhshuju shujuBean = gson.fromJson(user, Jhshuju.class);
            shujuList.add(shujuBean);
        }

        mainLView.setAdapter(new UserAdapter(this, shujuList));
    }


}