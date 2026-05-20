package com.apptools.bearquest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bannerImage = findViewById(R.id.main_banner);
        bannerImage.setImageResource(R.drawable.logo_banner);

        Button startGameBtn = findViewById(R.id.btn_start_game);
        Button aboutBtn = findViewById(R.id.btn_about);
        Button privacyBtn = findViewById(R.id.btn_privacy);

        startGameBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });

        aboutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        privacyBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PrivacyActivity.class);
            startActivity(intent);
        });
    }
}