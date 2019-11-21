package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startActivity(new Intent(SplashScreen.this,MainActivity.class));
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close splash activity
        finish();
    }
}
