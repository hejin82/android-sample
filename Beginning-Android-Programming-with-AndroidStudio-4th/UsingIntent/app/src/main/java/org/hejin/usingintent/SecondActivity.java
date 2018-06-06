package org.hejin.usingintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view) {
        Intent data = new Intent();
        EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        data.setData(Uri.parse(txtUsername.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
    }
}
