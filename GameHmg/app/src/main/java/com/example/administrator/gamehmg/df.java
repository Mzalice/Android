package com.example.administrator.gamehmg;

/**
 抽卡跳出界面十连
 */
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class df extends AppCompatActivity {

    GridView grid;
    int[] imageIds = new int[10];
    int[] number = new int[]{0,1,2,3,4,5,6,7,8,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.df);


        int[] images = new int[10];
        int length = images.length;
       //  Intent intent = getIntent();
       // String data = intent.getStringExtra("extra_data");
        Bundle bundle=this.getIntent().getExtras();
        images = bundle.getIntArray("image");

        Button dfb = (Button) findViewById(R.id.dfb);
        dfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName comp = new ComponentName(df.this,d.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                df.this.finish();
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

        for (int i = 0; i < length; i++) {
            int  a  =  images[i];
            int  b  =   number[i];

            if ( a >= 0 && a < 50 )
            {
                imageIds[b] = R.drawable.remilia;
            }
            if ( a >= 50 && a < 100)
            {
                imageIds[b] = R.drawable.reimu;
            }
            else if ( a >= 100 && a < 150 )
            {
                imageIds[b] = R.drawable.flandre;
            }
            else if ( a >= 150 && a < 200 )
            {
                imageIds[b] = R.drawable.sakuya;
            }
            else if ( a >= 200 && a < 250 )
            {
                imageIds[b] = R.drawable.patchouli;
            }
            else if ( a >= 250 && a < 300 )
            {
                imageIds[b] = R.drawable.devil;
            }
            else if ( a >= 300 && a < 350 )
            {
                imageIds[b] = R.drawable.meirin;
            }
            else if ( a >= 350 && a < 400 )
            {
                imageIds[b] = R.drawable.marisa;
            }
            else if ( a >= 400 && a < 450 )
            {
                imageIds[b] = R.drawable.youmu;
            }
            else if ( a >= 450 && a < 500 )
            {
                imageIds[b] = R.drawable.yuyuko;
            }
            else if ( a >= 500 && a < 600 )
            {
                imageIds[b] = R.drawable.yukari;
            }
            else if ( a >= 600 && a < 700 )
            {
                imageIds[b] = R.drawable.tenshi;
            }
            else if ( a >= 700 && a < 1000 )
            {
                imageIds[b] = R.drawable.alice;
            }
        }

// 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();

        for (int i = 0; i < imageIds.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems
                , R.layout.grs, new String[] { "image" },
                new int[] { R.id.image });

        grid = (GridView) findViewById(R.id.gridview);
        // 为GridView设置Adapter
        grid.setAdapter(simpleAdapter);

    }

}