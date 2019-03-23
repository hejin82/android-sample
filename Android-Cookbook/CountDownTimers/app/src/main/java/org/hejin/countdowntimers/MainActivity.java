package org.hejin.countdowntimers;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MalibuCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;

    private final long startTime = 50 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startB = (Button) findViewById(R.id.button);
        startB.setOnClickListener(this);

        text = (TextView) findViewById(R.id.timer);
        timeElapsedView = (TextView) findViewById(R.id.timeElapsed);

        countDownTimer = new MalibuCountDownTimer(startTime, interval);

        text.setText(text.getText() + String.valueOf(startTime));

    }

    @Override
    public void onClick(View v) {
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("RESET");
        }
    }

    public class MalibuCountDownTimer extends CountDownTimer {

        public MalibuCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain:" + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }
    }
}
