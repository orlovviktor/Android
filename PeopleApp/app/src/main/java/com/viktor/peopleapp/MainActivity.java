package com.viktor.peopleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // A list of objects of the type King is created, which is the program's data source.
    private List<King> kings = (new Kings()).getKings();
    // creating another list for strings that is used as data source for the topListView
    private List<String> lines = new ArrayList<>();
    // declaring variables for ListViews
    private ListView listView, multiListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ListView components are initialized in onCreate
        listView = findViewById(R.id.lstKings1);
        multiListView = findViewById(R.id.lstKings2);

/* listview component is initialized with an adapter. The type is ArrayAdapter which is an adapter used for a data source that is an array or a list and thus a data source where the individual objects are identified by an index.
In addition, a parameter (for the generic type) tells that the adapter represents King objects. The constructor has three parameters, where the first is the object (here the current object) to which the container has to initialize is a member, while the last parameter is te data resource.
Middle parameters tells how the objects should be presented by the container, here it is a constant it tells that an object should be presented as a string and thus that is the value of the object's toString() method to be displayed. */
        multiListView.setAdapter(new ArrayAdapter<King>(this,android.R.layout.simple_list_item_multiple_choice, kings));

/* An event handler is attached to the ListView component, it happens with the method setOnItemClickListener(), where the parameter is an OnItemClickListener, which is an interface that defines the event handler.
It has four parameters, where the most important is position, which indicates the index of the object that is clicked. It performs the method update() here, which converts the current King object into a string and if this string is already in data source lines it is deleted and otherwise added.
Adapter is the nused to update the top listview */
        multiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                update(kings.get(position));
            }
        });
    }
    public void update(King king){
        String line = toString(king);
        if (!lines.remove(line)) lines.add(line);
        listView.setAdapter(new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_list_item_1,lines));
    }
    // formating how the data will be presented: %s output - String, applies to any type. %d output -“true” if non-null, “false” if null, applies to integer (incl. byte, short, int, long)
    private String toString(King king){
        if (king.getFrom() != 0 && king.getTo() != 9999)
            return String.format("%s: %d - %d", king.getName(), king.getFrom(), king.getTo());
        if (king.getFrom() != 0)
            return String.format("%s: %d -", king.getName(), king.getFrom());
        if (king.getTo() != 9999)
            return String.format("%s: - %d", king.getName(), king.getTo());
        return king.getName();
    }

    public void next(View view) {
        Intent nextPage = new Intent(MainActivity.this,SpinnerKings.class);
        startActivity(nextPage);
    }
}