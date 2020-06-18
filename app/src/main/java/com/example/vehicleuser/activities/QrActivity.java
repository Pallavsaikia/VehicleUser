package com.example.vehicleuser.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.vehicleuser.R;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import utils.GlobalPref;

public class QrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_qr);
        try {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.hide();
        } catch (Exception e) {

        }

        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(new GlobalPref(getApplicationContext()).getToken(), BarcodeFormat.QR_CODE, 400, 400);
            ImageView imageViewQrCode = (ImageView) findViewById(R.id.qrCode);
            imageViewQrCode.setImageBitmap(bitmap);
        } catch(Exception e) {

        }
    }
}
