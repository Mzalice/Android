package com.example.administrator.gamehmg;

/**
 * 音乐管理
 * @author MzAlice
 * @Time 2017.1.7
 */

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Mymedia extends Service {

    private MediaPlayer mp;
    private MediaPlayer mp1;
    private MediaPlayer mp2;
    private MediaPlayer mp3;

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        boolean playing0 = intent.getBooleanExtra("ui0", false);
        boolean playing1 = intent.getBooleanExtra("ui1", false);
        boolean playing2 = intent.getBooleanExtra("ui2", false);
        boolean playing3 = intent.getBooleanExtra("ui3", false);

        // 开始播放音乐
        if(playing0) {
            mp.start();
            // 音乐播放完毕的事件处理
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    // 循环播放
                    try {
                        mp.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            // 播放音乐时发生错误的事件处理
            mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // TODO Auto-generated method stub
                    // 释放资源
                    try {
                        mp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                }
            });
        }

        else if(playing1){
            mp1.start();
            // 音乐播放完毕的事件处理
            mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    // 循环播放
                    try {
                        mp.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            // 播放音乐时发生错误的事件处理
            mp1.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // TODO Auto-generated method stub
                    // 释放资源
                    try {
                        mp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                }
            });
        }

        else if(playing2){
            mp2.start();
            // 音乐播放完毕的事件处理
            mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    // 循环播放
                    try {
                        mp.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            // 播放音乐时发生错误的事件处理
            mp2.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // TODO Auto-generated method stub
                    // 释放资源
                    try {
                        mp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                }
            });
        }

        else if(playing3){
            mp3.start();
            // 音乐播放完毕的事件处理
            mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    // 循环播放
                    try {
                        mp.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            // 播放音乐时发生错误的事件处理
            mp3.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // TODO Auto-generated method stub
                    // 释放资源
                    try {
                        mp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                }
            });
        }
        super.onStart(intent, startId);
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        // 初始化音乐资源
        try {
            // 创建MediaPlayer对象
            mp = new MediaPlayer();
            mp1 = new MediaPlayer();
            mp2 = new MediaPlayer();
            mp3 = new MediaPlayer();
            // 将音乐保存在res/raw,R.java中自动生成
            mp = MediaPlayer.create(Mymedia.this, R.raw.gm0);
            mp1 = MediaPlayer.create(Mymedia.this, R.raw.gm1);
            mp2 = MediaPlayer.create(Mymedia.this, R.raw.gm2);
            mp3 = MediaPlayer.create(Mymedia.this, R.raw.gm3);

            // 在MediaPlayer取得播放资源与stop()之后要准备PlayBack的状态前一定要使用MediaPlayer.prepeare()
            mp.prepare();
            mp1.prepare();
            mp2.prepare();
            mp3.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        // 服务停止时停止播放音乐并释放资源
        mp.stop();
        mp1.stop();
        mp2.stop();
        mp3.stop();
        mp.release();
        mp1.release();
        mp2.release();
        mp3.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}