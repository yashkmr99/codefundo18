package com.example.dell.projectkeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class optionsactivity extends AppCompatActivity {

    private ImageButton mapShelterbutton;
    private ImageButton callHelpbutton;
    private ImageButton doDontbutton;
    private ImageButton markStranded;
    private ImageButton showStranded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionsactivity);

        mapShelterbutton = (ImageButton) findViewById(R.id.mapShelterButton);
        callHelpbutton = (ImageButton) findViewById(R.id.callHelpAmbulanceButton);
        doDontbutton = (ImageButton) findViewById(R.id.doDontButton);
        markStranded = (ImageButton) findViewById(R.id.MarkStranded);
        showStranded = (ImageButton) findViewById(R.id.showStranded);

        callHelpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(optionsactivity.this, GetLocation.class);
                startActivity(int1);
            }
        });

        mapShelterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(optionsactivity.this, MapsActivity.class);
                startActivity(int1);
            }
        });


        doDontbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(optionsactivity.this, dosdonts.class);
                startActivity(int1);
            }
        });

        markStranded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(optionsactivity.this, MarkLocationStranded.class);
                startActivity(int1);
            }
        });

        showStranded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(optionsactivity.this, ShowStrandedActivity.class);
                startActivity(in1);
            }
        });

    }
}
