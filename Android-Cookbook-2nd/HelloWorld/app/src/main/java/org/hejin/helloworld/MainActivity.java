package org.hejin.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view = new TextView(this);
        view.setText("Hello World");

        // put this newly created view into the Activity
        // sort of like JFrame.getContentPane().add(view)
        setContentView(view);
    }
}
