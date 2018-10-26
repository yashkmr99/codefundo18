package com.example.dell.projectkeeper;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class GetLocation extends AppCompatActivity {

    private FusedLocationProviderClient client;
    private String loca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(this);

        Button button = findViewById(R.id.getLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ActivityCompat.checkSelfPermission(GetLocation.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {

                    return;
                }
                client.getLastLocation().addOnSuccessListener(GetLocation.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if(location!= null){

                            String loc = location.toString();
                            int i1=0,i2=0;
                            for(int i =0; i<loc.length(); i++)
                            {
                                if(loc.charAt(i)==' ')
                                    i1=i+1;
                                if(loc.charAt(i)==','){
                                    i2=i+1;
                                    break;
                                }
                            }
                            loca = loc.substring(i1, i1+9) + ',' + loc.substring(i2,i2+9);
                            TextView textView = findViewById(R.id.textViewlocation);
                            textView.setText(loca);
                        }

                    }
                });

            }
        });

        Button SendActivitybutton = (Button) findViewById(R.id.SendActivityButton);
        SendActivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GetLocation.this, SendToContacts.class);
                intent.putExtra("LOCATION", loca);
                startActivity(intent);

            }
        });
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
}