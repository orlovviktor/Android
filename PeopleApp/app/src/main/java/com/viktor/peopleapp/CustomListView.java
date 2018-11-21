package com.viktor.peopleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.List;

public class CustomListView extends AppCompatActivity {

    /* for the sake of simplicity created new arrays with values here instead of adding to the Kings classes also this way you'll have a better overview how to create and use ArrayMap.
    Added a short PDF file called ArrayMap to the project, it has detailed info about what an ArrayMap is.
    */

    String [] listviewTitle = new String[]{
            "Albert Einstein", "Steve Jobs", "Marilyn Monroe"
    };

    int[] listviewImage = new int[]{
            R.drawable.einstein, R.drawable.jobs, R.drawable. monroe
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        List<ArrayMap<String, String>> list = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put("listview_title", listviewTitle[i]);
            arrayMap.put("listview_image", Integer.toString(listviewImage[i]));
            list.add(arrayMap);
        }

        String[] from = {"listview_image", "listview_title","listview_year"};
        int[] to = {R.id.listview_image, R.id.listview_item_title};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), list, R.layout.listview_activity,from,to);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(simpleAdapter);
    }
}