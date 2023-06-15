package com.ashikurrahman.chinesetraditionaldress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LandingPageActivity extends AppCompatActivity {

    private static final int DELAY_MILLIS = 2000; // 2 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Delay for 2 seconds and then navigate to the ListPageActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LandingPageActivity.this, ListPageActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);
    }
}
