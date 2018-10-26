package com.example.dell.projectkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class hurricaneactivity extends AppCompatActivity {

    TextView earthquake;
    String str = "HURRICANES- \n" +
            "DO's\n" +
            "1. Bring in anything outside that can be picked up by wind.\n" +
            "2. Close and reinforce windows, & doors\n" +
            "3. Turn refrigerators & freezers to coldest setting, so food last longer.\n" +
            "4. Turn off propane tanks & unplug small appliances.\n" +
            "5. Fill your cars with gas. \n" +
            "Top 5 \n" +
            "DON'TS\n" +
            "1. Play outside.\n" +
            "2. Use your phone to talk to friends. (Available phone lines are dedicated to 1st responders)\n" +
            "3. Stock up on supplies the day of the hurricane.\n" +
            "4. Stay on a boat.\n" +
            "5. Drive. (There may be too many hazards on the road.) ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floodsactivity);


        earthquake = (TextView) findViewById(R.id.earthquake);

        loadText();
    }

    private void loadText() {

        earthquake.setMovementMethod(new ScrollingMovementMethod());
        earthquake.setText(str);

    }
}
