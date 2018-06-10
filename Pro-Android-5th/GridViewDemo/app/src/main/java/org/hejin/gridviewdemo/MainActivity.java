package org.hejin.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridView1);
        String[] someColors = new String[] {
                "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Black", "White"
        };
        List<String > colorArrayList = new ArrayList<>();
        colorArrayList.addAll(Arrays.asList(someColors));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, colorArrayList);

        gridView.setAdapter(listAdapter);
        gridView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) gridView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
