package org.hejin.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    public static final String EXTRA_STRING_NAME = "extraStringName";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button = (Button) findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_STRING_NAME, "returnValueAsString");
                setResult(Activity.RESULT_OK, intent);
                // returns to the parent
                finish();
            }
        });
    }
}
