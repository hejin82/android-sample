package org.hejin.helloworld;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;

public class TrackService extends Service {

    private LocationManager mgr;
    private String preferredProvider;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        //initGPS();
        if (preferredProvider != null) {
            //mgr.requestLocationUpdates(preferredProvider, MIN_SECONDS * 1000, MIN_METRES,this);
            return START_STICKY;
        }
        return START_NOT_STICKY;
    }

    public boolean onUnbind(Intent intent) {
        //mgr.removeUpdates(this);
        return super.onUnbind(intent);
    }
}
