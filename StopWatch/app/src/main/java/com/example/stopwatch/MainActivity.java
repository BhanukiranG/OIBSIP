package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Chronometer chronometer;
    public long offSet;
    public boolean run;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer=findViewById(R.id.time);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-chronometer.getBase())>=3599000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(MainActivity.this, "Restarting...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void start(View view){
        if(!run){
            chronometer.setBase(SystemClock.elapsedRealtime()-offSet);
            chronometer.start();
            run=true;
        }
    }
    public void stop(View view){
        if(run){
            chronometer.stop();
            offSet=SystemClock.elapsedRealtime()-chronometer.getBase();
            run=false;
        }
    }
    public void hold(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        offSet=0;
    }
}