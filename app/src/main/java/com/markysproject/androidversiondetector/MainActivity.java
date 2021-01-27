package com.markysproject.androidversiondetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView Tvdetectdroid;
    private Button btndetectdroid;
    private int buildInt = Build.VERSION.SDK_INT;
    private String buildString = Build.VERSION.RELEASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SETIT();
    }

    public void detectdroid(View view) {
        detected(buildInt,buildString);
    }

    private void SETIT() {
        Tvdetectdroid = (TextView) findViewById(R.id.Tvdetectdroid);
        btndetectdroid = (Button) findViewById(R.id.btndetectdroid);
    }

    private void detected(int buildvrr,String buildvr) {
        Tvdetectdroid.setText("API: " + buildvrr +"\nAndroid version: "+buildvr);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
        }else{
            v.vibrate(200);
        }
    }

}