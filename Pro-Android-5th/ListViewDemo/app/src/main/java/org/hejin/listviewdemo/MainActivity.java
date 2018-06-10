package org.hejin.listviewdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);
        String[] someColors = new String[] {
                "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Black", "White"
        };
        List<String > colorArrayList = new ArrayList<>();
        colorArrayList.addAll(Arrays.asList(someColors));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, colorArrayList);

        listView.setAdapter(listAdapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void doClick(View view) {
        int count = listView.getCount();
        SparseBooleanArray viewItems = listView.getCheckedItemPositions();
        for (int i = 0; i < count; i++) {
            if (viewItems.get(i)) {
                String selectedColor = (String) listView.getItemAtPosition(i);
                Log.v("ListViewDemo", selectedColor + " is checked at position " + i);
            }
        }
    }
}
