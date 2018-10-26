package com.example.dell.projectkeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class dosdonts extends AppCompatActivity {

    ImageButton earthquake;
    ImageButton floods;
    ImageButton tsunami;
    ImageButton landslides;
    ImageButton hurricane;
    ImageButton emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosdonts);

        earthquake = findViewById(R.id.earthquake);
        floods = findViewById(R.id.flood);
        tsunami = findViewById(R.id.tsunami);
        landslides= findViewById(R.id.landslides);
        emergency = findViewById(R.id.emergency);

        floods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(dosdonts.this, floodsactivity.class);
                startActivity(int1);
            }
        });
        earthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dosdonts.this, EarthquakeActivity.class);
                startActivity(intent);
            }
        });



        tsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dosdonts.this, tsunamiactivity.class);
                startActivity(intent);
            }
        });


        landslides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dosdonts.this, landslidesactivity.class);
                startActivity(intent);
            }
        });


        hurricane = findViewById(R.id.hurricane);
        hurricane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dosdonts.this, hurricaneactivity.class);
                startActivity(intent);
            }
        });


        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dosdonts.this, emergencyactivity.class);
                startActivity(intent);
            }

        });

    }
}
