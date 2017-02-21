package com.example.administrator.gamehmg;

/**
当前活动面板

此页面此次内容部分未涉及网络部分就暂时不再更新
 */
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);

        final ImageView imageViewb1 = (ImageView) findViewById(R.id.b1);
        final ImageView imageViewb2 = (ImageView) findViewById(R.id.b2);
        Button b3n = (Button) findViewById(R.id.b3);
        Button b4n = (Button) findViewById(R.id.b4);
        Button b5n = (Button) findViewById(R.id.b5);

        b3n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(b.this,b3.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                b.this.finish();
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

        b4n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(b.this,b4.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                b.this.finish();
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

        b5n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(b.this,UI.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                b.this.finish();
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