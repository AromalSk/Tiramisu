package com.example.tiramisu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   Handler obj = new Handler();
        obj.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);
            }
        },5000);*/

        Thread obj = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        };
        obj.start();
    }
}