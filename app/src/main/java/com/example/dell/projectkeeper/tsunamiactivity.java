package com.example.dell.projectkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class tsunamiactivity extends AppCompatActivity {
    TextView earthquake;
    String str = "Tsunami – Top 5 DO’s\n" +
            "1. Remain calm\n" +
            "2. If there is an earthquake too, protect yourself from falling debris first.\n" +
            "3. Immediately head inland & to higher ground.\n" +
            "4. Know whether you are in a tsunami hazard zone or not.\n" +
            "5. Know where the nearest tsunami escape route is. \n" +
            "Top 5 DON’TS\n" +
            "1. Rush to the beach to see the Big wave.\n" +
            "2. Rush to the beach after the first wave to see what has washed up on shore.\n" +
            "3. Wait for a bus or car to take you to higher ground- (get out of the zone as quickly as possible, ideally by foot)\n" +
            "4. Stop to pack your valuables (you may not have time).\n" +
            "5. Wait for an official warning if you feel an earthquake that lasts a minute or more. (By the time the warning is issued, it may be too late) ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsunamiactivity);


        earthquake =(TextView) findViewById(R.id.earthquake);

        loadText();
    }

    private void loadText(){

        earthquake.setMovementMethod(new ScrollingMovementMethod());
        earthquake.setText(str);

    }

}
