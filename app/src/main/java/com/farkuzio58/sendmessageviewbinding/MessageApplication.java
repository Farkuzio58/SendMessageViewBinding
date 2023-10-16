package com.farkuzio58.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

/**
 * @author farku
 * @version 1.0
 * Clase para acceder a la clase Application
 */
public class MessageApplication extends Application {
    private static final String TAG = "MessageApplication";
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "MessageApplication -> onCreate()");
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
        Log.d(TAG, "MessageApplication -> onTerminate()");
    }
}
