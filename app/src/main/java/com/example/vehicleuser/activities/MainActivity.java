package com.example.vehicleuser.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.vehicleuser.R;


public class MainActivity extends AppCompatActivity {


    ImageView settings;
    AppCompatButton mapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        try {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.hide();
        } catch (Exception e) {

        }

        settings = findViewById(R.id.settingsBtn);
        mapBtn = findViewById(R.id.mapBtn);

        settings.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        });

        mapBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(i);
        });
    }
}
