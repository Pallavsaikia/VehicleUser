package com.example.vehicleuser.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vehicleuser.R;
import com.google.zxing.qrcode.encoder.QRCode;

import utils.GlobalPref;

public class SettingsActivity extends AppCompatActivity {

    ImageView copyBtn;
    ImageView shareBtn;
    EditText serverKeyEditTxt;
    String token;
    AppCompatButton showQrBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        try {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.hide();
        } catch (Exception e) {

        }

        token = new GlobalPref(getApplicationContext()).getToken();

        copyBtn=findViewById(R.id.copyBtn);
        shareBtn=findViewById(R.id.shareBtn);
        showQrBtn=findViewById(R.id.showQrBtn);

        serverKeyEditTxt=findViewById(R.id.serverKeyEditTxt);
        serverKeyEditTxt.setText(token);

        copyBtn.setOnClickListener(v->{
            try {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", token);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),"copied",Toast.LENGTH_SHORT).show();
            }catch (Exception e){

            }
        });

        showQrBtn.setOnClickListener(v->{
            Intent i = new Intent(SettingsActivity.this, QrActivity.class);
            startActivity(i);
        });

        shareBtn.setOnClickListener(v->{
            /*Create an ACTION_SEND Intent*/
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);

            /*The type of the content is text, obviously.*/
            intent.setType("text/plain");
            /*Applying information Subject and Body.*/
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "any");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, token);
            /*Fire!*/
            startActivity(Intent.createChooser(intent, "any"));
        });
    }
}
