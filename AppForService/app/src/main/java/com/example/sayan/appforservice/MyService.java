package com.example.sayan.appforservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends IntentService {

    public static final String MESSAGE = "message";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this){
            try {
                wait(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(MESSAGE);
        showText(text);

    }
    private void showText(final String text){
        Log.v("My Service", text);
    }
}
