package org.hejin.listviewexample;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends ListActivity {

    private TextView mySelection;
    private static final String[] myListItems = {"To", "be", "or", "not", "to", "be", "that", "is", "the", "question"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.simple_list_item_1,
                myListItems));
        mySelection = (TextView) findViewById(R.id.mySelection);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        mySelection.setText(myListItems[position]);
    }
}
