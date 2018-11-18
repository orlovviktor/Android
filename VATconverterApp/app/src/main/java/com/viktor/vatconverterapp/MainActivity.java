package com.viktor.vatconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final double factor = 0.25;

    private EditText txt_input;
    private RadioButton netto, brutto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_input = findViewById(R.id.txt_number);
        netto = findViewById(R.id.toNetto);
        brutto = findViewById(R.id.toBrutto);
    }

    public static double toBrutto(double salary) {

        return salary - (salary * factor);
    }

    public static double toNetto(double salary) {
        return salary + (salary * factor);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.clr) {
            txt_input.setText("");
        }
        else if (view.getId() == R.id.conv) {
            if (txt_input.getText().length() == 0) {
                Toast.makeText(this, "@string/info", Toast.LENGTH_SHORT).show();
                return;
            }

            double value = Double.parseDouble(txt_input.getText().toString());

            if (netto.isChecked()) txt_input.setText(String.valueOf(toBrutto(value)));
            else txt_input.setText(String.valueOf(toNetto(value)));
        }
    }
}
