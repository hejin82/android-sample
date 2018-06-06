package org.hejin.appsingleton;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AndroidApplication extends Application {

    private static AndroidApplication sInstance;
    private SessionHandler sessionHandler;

    public static AndroidApplication getsInstance() {
        return sInstance;
    }

    public SessionHandler getSessionHandler() {
        return sessionHandler;
    }

    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    protected void initializeInstance() {
        sessionHandler = new SessionHandler(this.getSharedPreferences("PREFS_PRIVATE", Context.MODE_PRIVATE));
    }

    private class SessionHandler {
        SharedPreferences sp;
        SessionHandler(SharedPreferences sp) {
            this.sp = sp;
        }
    }
}
