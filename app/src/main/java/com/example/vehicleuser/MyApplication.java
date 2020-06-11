package com.example.vehicleuser;

import android.app.Application;

import com.google.android.libraries.places.api.Places;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Places.initialize(this, "AIzaSyAXKToVMhTqOygP3edfncEN3zUqiG2EQ9Y");
        //UserDetailsIntentService


    }
}
