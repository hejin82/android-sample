package org.hejin.helloworld;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "HelloWorld";
    public static final int MY_REQUEST_CODE = 123;
    AlertDialog alertDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeButtonReceive homeButtonReceive = new HomeButtonReceive();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        this.registerReceiver(homeButtonReceive, intentFilter);


        textView =  (TextView) findViewById(R.id.textview);

        Button button = (Button)findViewById(R.id.btnAlert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog = new AlertDialog.Builder(v.getContext())
                        .setTitle("title")
                        .setMessage("message")
                        .setPositiveButton("Save", new AlertDialog.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNeutralButton("cancel", new AlertDialog.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        Button sendMail = (Button) findViewById(R.id.sendMail);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_TITLE, "My Title");
                intent.putExtra(Intent.EXTRA_SUBJECT, "My Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Text");
                startActivity(intent);
            }
        });

        Button callSub = (Button) findViewById(R.id.btnSub);
        callSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, MY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }




    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed()");
        super.onBackPressed();
    }

    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume()");
        super.onPostResume();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onPostCreate()");
        super.onPostCreate(savedInstanceState);
    }


    public class HomeButtonReceive extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(), "Good bye", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onUserLeaveHint() {
        if (alertDialog != null) {
            alertDialog.cancel();
        }
        Toast.makeText(getApplicationContext(), "Good bye", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                final String data = intent.getExtras().getString(SubActivity.EXTRA_STRING_NAME);
                textView.setText("SubActivity return: " + data);
            }
        }
    }
}
