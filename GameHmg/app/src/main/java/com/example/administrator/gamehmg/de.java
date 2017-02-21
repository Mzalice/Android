package com.example.administrator.gamehmg;

/**
 抽卡跳出界面单抽
 */

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class de extends AppCompatActivity {

    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de);
        this.choose();

        Bundle bundle=this.getIntent().getExtras();
        int a = bundle.getInt("image1");

        Button dea = (Button) findViewById(R.id.dea);
        dea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName comp = new ComponentName(de.this,d.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                de.this.finish();
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

    public void choose() {

        Bundle bundle=this.getIntent().getExtras();
        int a = bundle.getInt("image1");

        final ImageView deimage = (ImageView) findViewById(R.id.deimage);
        if ( a >= 0 && a < 50 )
        {
            deimage.setImageResource( R.drawable.remilia);
        }
        if ( a >= 50 && a < 100)
        {
            deimage.setImageResource( R.drawable.reimu);
        }
        else if ( a >= 100 && a < 150 )
        {
            deimage.setImageResource( R.drawable.flandre);
        }
        else if ( a >= 150 && a < 200 )
        {
            deimage.setImageResource( R.drawable.sakuya);
        }
        else if ( a >= 200 && a < 250 )
        {
            deimage.setImageResource( R.drawable.patchouli);
        }
        else if ( a >= 250 && a < 300 )
        {
            deimage.setImageResource( R.drawable.devil);
        }
        else if ( a >= 300 && a < 350 )
        {
            deimage.setImageResource( R.drawable.meirin);
        }
        else if ( a >= 350 && a < 400 )
        {
            deimage.setImageResource(  R.drawable.marisa);
        }
        else if ( a >= 400 && a < 450 )
        {
            deimage.setImageResource(  R.drawable.youmu);
        }
        else if ( a >= 450 && a < 500 )
        {
            deimage.setImageResource( R.drawable.yuyuko);
        }
        else if ( a >= 500 && a < 600 )
        {
            deimage.setImageResource( R.drawable.yukari);
        }
        else if ( a >= 600 && a < 700 )
        {
            deimage.setImageResource( R.drawable.tenshi);
        }
        else if ( a >= 700 && a < 1000 )
        {
            deimage.setImageResource( R.drawable.alice);
        }
    }
}