package com.example.vehicleuser.services;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FirebaseNotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.d("MyNS", "onMessageReceived: "+remoteMessage.getData());
        Map json=remoteMessage.getData();
        Intent intent = new Intent("location.intent");
        intent.putExtra("latitude", (String) json.get("latitude"));
        intent.putExtra("longitude", (String) json.get("longitude"));
        getApplication().sendBroadcast(intent);
    }
    @Override
    public void onNewToken(String token) {
        Log.d("MyNS", "Refreshed token: " + token);

    }


}
