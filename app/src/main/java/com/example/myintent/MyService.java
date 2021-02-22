package com.example.myintent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "service";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Test");
        if (intent == null){
            return Service.START_STICKY;
        }  else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        String name = intent.getStringExtra("name");
        Log.d(TAG,name);

        try {
            Thread.sleep(5000);
        } catch (Exception e){

        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}