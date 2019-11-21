package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton tommy_hilfiger, reitmans, root, hudson_bay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tommy_hilfiger = findViewById(R.id.tommy_hilfiger);
        reitmans = findViewById(R.id.reitmans);
        root = findViewById(R.id.roots);
        hudson_bay = findViewById(R.id.hudson_bay);

        tommy_hilfiger.setContentDescription(getResources().getString(R.string.hilfiger));
        reitmans.setContentDescription(getResources().getString(R.string.reitmans));
        root.setContentDescription(getResources().getString(R.string.root));
        hudson_bay.setContentDescription(getResources().getString(R.string.hudson));

        tommy_hilfiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, LocationSelector.class);
                intentLoadNewActivity.putExtra("Place","Tommy Hilfiger");
                startActivity(intentLoadNewActivity);
            }
        });
        reitmans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, LocationSelector.class);
                intentLoadNewActivity.putExtra("Place","Reitmans");
                startActivity(intentLoadNewActivity);
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, LocationSelector.class);
                intentLoadNewActivity.putExtra("Place","Root");
                startActivity(intentLoadNewActivity);
            }
        });
        hudson_bay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, LocationSelector.class);
                intentLoadNewActivity.putExtra("Place","Hudson Bay");
                startActivity(intentLoadNewActivity);
            }
        });

    }
}
