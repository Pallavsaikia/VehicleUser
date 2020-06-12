package com.example.vehicleuser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import utils.GlobalPref;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Places.initialize(this, "AIzaSyAXKToVMhTqOygP3edfncEN3zUqiG2EQ9Y");
        //UserDetailsIntentService


        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(task.isSuccessful()){
                            Log.d("My", "onComplete: "+task.getResult().getToken());
                            new GlobalPref(getApplicationContext()).setToken(task.getResult().getToken());
                        }else{
                            Log.d("My", "onComplete: "+task.getException().getMessage());
                        }
                    }
                });
    }
}
