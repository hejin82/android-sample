package org.hejin.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 200;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if (!paused) {
                            ms = ms + 100;
                            sleep(100);
                        }
                    }
                } catch (Exception e) {

                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();
    }
}
