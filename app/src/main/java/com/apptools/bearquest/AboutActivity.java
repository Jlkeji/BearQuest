package com.apptools.bearquest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView logoImage = findViewById(R.id.about_logo);
        logoImage.setImageResource(R.drawable.logo);

        TextView appNameView = findViewById(R.id.about_app_name);
        TextView versionView = findViewById(R.id.about_version);
        TextView descriptionView = findViewById(R.id.about_description);

        appNameView.setText(getString(R.string.app_name));
        versionView.setText(getString(R.string.app_version));
        descriptionView.setText(getString(R.string.about_description));
    }
}