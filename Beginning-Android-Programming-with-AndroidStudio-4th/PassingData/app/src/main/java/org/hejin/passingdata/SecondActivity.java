package org.hejin.passingdata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,getIntent().getIntExtra("age1",0),Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        Toast.makeText(this, bundle.getString("str2"), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,bundle.getInt("age2",0),Toast.LENGTH_SHORT).show();

    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("age3", 45);
        intent.setData(Uri.parse("something passed back to main activity"));
        // set the result with ok and the Intent object
        setResult(RESULT_OK, intent);
        // destroy the current activity
        finish();
    }
}
