package com.example.arenky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {
    private final int DURACION_SPLASH = 700;
    ProgressBar progressBar;
    Handler handler = new Handler();
    private int progressStatus = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definimos la orientación y parametros para que sea tipo fullSccreen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

//        progressBar = findViewById(R.id.progressBar);

        //Creamos  el lanzador que contendra un intento explicito que nos mandará a la ActivityMain
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);//Aqui le asignamos el tiempo que  va a durar
//        while(progressStatus<100){
//            progressStatus+=1;
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    progressBar.setProgress(progressStatus);
//                }
//            });
//        }
    }
}