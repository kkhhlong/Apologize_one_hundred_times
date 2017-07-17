package com.example.nhl71.apologize;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    ImageView heardLoad;
    ClipDrawable clipDrawable;
    Timer timer;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heardLoad = (ImageView) findViewById(R.id.heartLoad);
        clipDrawable = (ClipDrawable) heardLoad.getDrawable();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0){
                    if(clipDrawable.getLevel()==10000){
                        Intent i = new Intent(MainActivity.this,InforActivity.class);
                        startActivity(i);
                        finish();
                    }
                    clipDrawable.setLevel(clipDrawable.getLevel()+5);
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },0,1);
    }
}
