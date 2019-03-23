package org.hejin.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BackgroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_service);

        final Intent intent = new Intent(this, TrackService.class);
        Button startButton = (Button) findViewById(R.id.btnStartBackgroundService);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
                Toast.makeText(BackgroundServiceActivity.this, "Starting", Toast.LENGTH_LONG).show();
            }
        });
        Button stopButton = (Button) findViewById(R.id.btnStopBackgroundService);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                Toast.makeText(BackgroundServiceActivity.this, "Stopped", Toast.LENGTH_LONG).show();
            }
        });
    }
}
