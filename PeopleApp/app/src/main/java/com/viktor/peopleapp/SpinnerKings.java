package com.viktor.peopleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class SpinnerKings extends AppCompatActivity {

    // A list of objects of the type King is created, which is the program's data source.
    private List<King> kings = (new Kings()).getKings();
    // declaring variables for Editext and Spinner
    private Spinner view;
    private EditText from, to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_kings);

// ListView and EditText components are initialized in onCreate
        view = findViewById(R.id.lstKings);
        from = findViewById(R.id.txtFrom);
        to = findViewById(R.id.txtTo);

// using disable method on both EditTexts
        disable(from);
        disable(to);

// listview component is initialized with an adapter
        view.setAdapter(new ArrayAdapter<King>(this, android.R.layout.simple_spinner_item, kings));
// event handler attached to listview, this time has another listener, which is an interface that defines two methods
        view.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                from.setText("");
                to.setText("");
            }
        });
    }
    // disable method that'll disable both of the input fields so user can't enter text
    private void disable(EditText view){
        view.setKeyListener(null);
        view.setEnabled(false);
    }

    public void update(int position){
        int a = kings.get(position).getFrom();
        int b = kings.get(position).getTo();
        from.setText(a == 0 ? "" : "" + a);
        to.setText(b == 9999 ? "" : "" + b);
    }

    public void next(View view) {
        Intent nextPage = new Intent(SpinnerKings.this,CustomListView.class);
        startActivity(nextPage);
    }
}
