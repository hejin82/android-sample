package org.hejin.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button secondActivity = (Button) findViewById(R.id.secondActivity);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", "Hello SecondActivity");
                // startActivity(intent);
                startActivityForResult(intent, 1);
                Toast.makeText(FirstActivity.this,
                                "you clicked secondActivity",
                                Toast.LENGTH_LONG)
                        .show();
            }
        });
        Button thirdActivity = (Button) findViewById(R.id.thirdActivity);
        thirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.hejin.activitytest.ACTION_START");
                intent.addCategory("org.hejin.activitytest.CATEGORY");
                startActivity(intent);
                Toast.makeText(FirstActivity.this,
                        "you clicked thirdActivity",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
        Button baiduActivity = (Button) findViewById(R.id.baiduActivity);
        baiduActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button dialActivity = (Button) findViewById(R.id.dialActivity);
        dialActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you clicked add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked remove", Toast.LENGTH_LONG).show();
                break;

                default:
        }
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
                default:
        }
    }
}
