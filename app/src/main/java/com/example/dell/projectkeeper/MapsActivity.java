package com.example.dell.projectkeeper;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_PERMISSIONS_ACCESS_FINE_LOCATION = 1;
    private static final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 2;
    private static final int READ_SMS_PERMISSIONS_REQUEST = 3;

    private GoogleMap mMap;

    ArrayList<String> smsMessagesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            getPermissionToReadSMS();
        } else {
            refreshSmsInbox();
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void refreshSmsInbox() {
        ContentResolver contentResolver = getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;
        smsMessagesList.clear();
        do {
            if (smsInboxCursor.getString(indexAddress).equals("+919741285067")) {
                String str = smsInboxCursor.getString(indexBody);
                String result[] = str.split("\\s+");
                smsMessagesList.add(result[0]);
                smsMessagesList.add(result[1]);
                smsMessagesList.add(result[2]);
            }
        } while (smsInboxCursor.moveToNext());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        requestLPermission();
        mMap = googleMap;
        Float lat = null;
        Float lon = null;
        String title;

        for (int i = 0; i < smsMessagesList.size(); i++) {
            if (i % 3 == 0) {
                lat = Float.valueOf(smsMessagesList.get(i));
            } else if (i % 3 == 1) {
                lon = Float.valueOf(smsMessagesList.get(i));
            }else{
                title = smsMessagesList.get(i);
                LatLng shelter = new LatLng(lat, lon);
                mMap.addMarker(new MarkerOptions().position(shelter).title(title.toUpperCase()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(shelter));
            }
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            return;
        }

        mMap.setMyLocationEnabled(true);

    }

    ////  PERMSSION TO GET LOCATION
    private void requestLPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);

        requestPermissions(new String[]{Manifest.permission.READ_SMS},
                READ_SMS_PERMISSIONS_REQUEST);
    }

    ////  PERMSSION TO READ SMS
    public void getPermissionToReadSMS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_SMS)) {
                Toast.makeText(this, "Please allow permission!", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{Manifest.permission.READ_SMS},
                    READ_SMS_PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == READ_SMS_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read SMS permission granted", Toast.LENGTH_SHORT).show();
                refreshSmsInbox();

            } else {
                Toast.makeText(this, "Read SMS permission denied", Toast.LENGTH_SHORT).show();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}