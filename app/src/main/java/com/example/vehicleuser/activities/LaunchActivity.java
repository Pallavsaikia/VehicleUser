package com.example.vehicleuser.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.vehicleuser.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launch);
        try {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.hide();
        } catch (Exception e) {

        }
        new Handler().postDelayed(() -> {
        Intent i = new Intent(LaunchActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        },1500);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
