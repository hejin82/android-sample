package org.hejin.passingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("str1", "this is a string");
        intent.putExtra("age1", 25);
        Bundle bundle = new Bundle();
        bundle.putString("str2", "this is another string");
        bundle.putInt("age2", 35);
        intent.putExtras(bundle);

        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
