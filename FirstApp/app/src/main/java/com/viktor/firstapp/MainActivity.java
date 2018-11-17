package com.viktor.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_zoo = "http://tallinnzoo.ee/";
                Intent zoo = new Intent(Intent.ACTION_VIEW);
                zoo.setData(Uri.parse(url_zoo));
                startActivity(zoo);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_vst = "https://www.visittallinn.ee/eng";
                Intent vst = new Intent(Intent.ACTION_VIEW);
                vst.setData(Uri.parse(url_vst));
                startActivity(vst);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_rmk = "https://rmk.ee/";
                Intent rmk = new Intent(Intent.ACTION_VIEW);
                rmk.setData(Uri.parse(url_rmk));
                startActivity(rmk);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_air = "https://www.tallinn-airport.ee/";
                Intent air = new Intent(Intent.ACTION_VIEW);
                air.setData(Uri.parse(url_air));
                startActivity(air);
            }
        });

    }

    public void shwPic(View view) {
        Intent picture = new Intent(MainActivity.this, PicturesActivity.class);
        startActivity(picture);
    }
}
