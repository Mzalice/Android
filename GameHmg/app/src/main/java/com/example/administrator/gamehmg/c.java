package com.example.administrator.gamehmg;

/**
酒馆/交流/信息获得等面板

此页面暂时不再进行更新
 */
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c);

        Button c1n = (Button) findViewById(R.id.c1);
        Button c2n = (Button) findViewById(R.id.c2);
        Button c3n = (Button) findViewById(R.id.c3);
        Button c4n = (Button) findViewById(R.id.c4);
        Button c5n = (Button) findViewById(R.id.c5);

        c1n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(c.this,UI.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                c.this.finish();
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