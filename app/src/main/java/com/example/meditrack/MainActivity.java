package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 7000;

    VideoView video2;


    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        video2 = (VideoView) findViewById(R.id.video2);
        String path = "android.resource://com.example.meditrack/"+R.raw.ic_intro;
        Uri u = Uri.parse(path);
        video2.setVideoURI(u);
        video2.start();

        video2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
            }
        });
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_SCREEN);
    }
    @Override
    protected void onResume() {
        video2.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        video2.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        video2.stopPlayback();
        super.onDestroy();
    }

}