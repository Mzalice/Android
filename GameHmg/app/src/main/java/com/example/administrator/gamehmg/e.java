package com.example.administrator.gamehmg;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
出征.主线.活动面板
 */

public class e extends AppCompatActivity {

    private View view1, view2, view3;
    private ViewPager viewPager;  //对应的viewPager
    private List<View> viewList;//view数组

    // 窗体的ListVIew控件
    private ListView list,list1,list2,list3;
    private int[] imageIds = new int[]
            { R.drawable.btr1 , R.drawable.btr1
                    , R.drawable.btr1 , R.drawable.btr1};
    private int[] tag = new int[]
            {0,1,2,3};
    private int[] imageIds1 = new int[]
            { R.drawable.btr1 , R.drawable.btr1
                    , R.drawable.btr1 , R.drawable.btr1};
    private int[] imageIds2 = new int[]
            { R.drawable.btr1 , R.drawable.btr1
                    , R.drawable.btr1 , R.drawable.btr1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e);

        Intent intent = new Intent(e.this,Mymedia.class);
        intent.putExtra("ui3", true);
        startService(intent);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        View view1 = inflater.inflate(R.layout.v1, null);
        View view2 = inflater.inflate(R.layout.v2,null);
        View view3 = inflater.inflate(R.layout.v3, null);

        ListView list1 = (ListView) view1.findViewById(R.id.vibt1);
        ListView list2 = (ListView) view2.findViewById(R.id.vibt2);
        ListView list3 = (ListView) view3.findViewById(R.id.vibt3);

        final ImageView vi1 = (ImageView) view1.findViewById(R.id.vi1);
        final ImageView vi2 = (ImageView) view2.findViewById(R.id.vi2);
        final ImageView vi3 = (ImageView) view3.findViewById(R.id.vi3);

        final Button vb1 = (Button) view1.findViewById(R.id.v1b);

        //返回城镇
        vb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(e.this,Mymedia.class);
                Intent intent = new Intent();
                intent.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                stopService(intent);

                ComponentName comp1 = new ComponentName(e.this,UI.class);
                Intent intent1 = new Intent();
                intent1.setComponent(comp1);
                startActivity(intent1);
                e.this.finish();
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


        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItems.add(listItem);
        }

        List<Map<String, Object>> listItems1 =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds1.length; i++)
        {
            Map<String, Object> listItem1 = new HashMap<String, Object>();
            listItem1.put("header", imageIds1[i]);
            listItems1.add(listItem1);
        }

        List<Map<String, Object>> listItems2 =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds2.length; i++)
        {
            Map<String, Object> listItem2 = new HashMap<String, Object>();
            listItem2.put("header", imageIds2[i]);
            listItems2.add(listItem2);
        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simple_item,
                new String[] { "header"},
                new int[] { R.id.header});

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this, listItems1,
                R.layout.simple_item,
                new String[] { "header"},
                new int[] { R.id.header});

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter2 = new SimpleAdapter(this, listItems2,
                R.layout.simple_item,
                new String[] { "header"},
                new int[] { R.id.header});

        // 为ListView设置Adapter
        list1.setAdapter(simpleAdapter);
        list2.setAdapter(simpleAdapter1);
        list3.setAdapter(simpleAdapter2);

        // 为ListView的列表项的单击事件绑定事件监听器
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                int a = tag[position];
                if( a == 0 )
                {
                    vi1.setImageResource(R.drawable.tiaozhuan2);
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,a.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( a == 1 )
                {
                    vi1.setImageResource(R.drawable.tiaozhuan2);
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,b.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( a == 2 )
                {
                    vi1.setImageResource(R.drawable.tiaozhuan3);
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,c.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( a == 3 )
                {
                    vi1.setImageResource(R.drawable.tiaozhuan1);
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,d.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
            }
        });

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                int b = tag[position];
                if( b == 0 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,a.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( b == 1 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,b.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( b == 2 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,c.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( b == 3 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,d.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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



            }
        });

        list3.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                int c = tag[position];
                if( c == 0 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,a.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( c == 1 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,b.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( c == 2 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,c.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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
                else if( c == 3 )
                {
                    ComponentName comp1 = new ComponentName(e.this,Mymedia.class);
                    Intent intent1 = new Intent();
                    intent1.setAction("ITOP.MOBILE.SIMPLE.SERVICE.SENSORSERVICE");
                    stopService(intent1);

                    ComponentName comp = new ComponentName(e.this,d.class);
                    Intent intent = new Intent();
                    intent.setComponent(comp);
                    startActivity(intent);

                    e.this.finish();
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


            }
        });


        // 为ListView的列表项的选中事件绑定事件监听器
        list1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            // 第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };


        viewPager.setAdapter(pagerAdapter);

    }

}