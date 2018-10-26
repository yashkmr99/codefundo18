package com.example.dell.projectkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class emergencyactivity extends AppCompatActivity {



    TextView earthquake;
    String str = "\n" +
            "Disasters supplies\n" +
            "1. Flashlight & extra batteries\n" +
            "2. First aid kit & manual\n" +
            "3. Emergency food & water\n" +
            "4. non-electric can opener\n" +
            "5. Essential medicines\n" +
            "6. Dust mask\n" +
            "7. Sturdy shoes\n" +
            "8. Bedding.\n" +
            "9. Critical documents.";

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
