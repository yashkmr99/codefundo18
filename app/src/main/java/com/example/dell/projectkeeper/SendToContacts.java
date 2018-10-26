package com.example.dell.projectkeeper;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.Manifest.permission.SEND_SMS;

public class SendToContacts extends AppCompatActivity {

    Button Sendbut;
    private EditText phonenmbr;
    private static final int REQUEST_SMS = 0;

    final int send_sms_permission = 1;

    private String loca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_contacts);

        Sendbut = (Button) findViewById(R.id.SendButton);
        phonenmbr = (EditText) findViewById(R.id.editTextphone);

        loca = getIntent().getStringExtra("LOCATION");

        Sendbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int hasSMSpermission = checkSelfPermission(SEND_SMS);
                if (hasSMSpermission != PackageManager.PERMISSION_GRANTED){

                    if(!shouldShowRequestPermissionRationale(SEND_SMS)) {

                        showMessageOKCancel("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions(new String[] {SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions(new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }
                sendMySMS();


            }
        });

    }

    public void sendMySMS() {

        String smsNumber = "+91"+phonenmbr.getText().toString();
        phonenmbr.setText(smsNumber);

        String smsloca = "I am stranded here -" + '\n' + "http://maps.google.com/?q="+loca;

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(smsNumber, null, smsloca, null, null);

    }

    private boolean checkPermission() {
        return ( ContextCompat.checkSelfPermission(getApplicationContext(), SEND_SMS ) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{SEND_SMS}, REQUEST_SMS);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_SMS:
                if (grantResults.length > 0 &&  grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access sms", Toast.LENGTH_SHORT).show();
                    sendMySMS();

                }else {
                    Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and sms", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(SEND_SMS)) {
                            showMessageOKCancel("You need to allow access to both the permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{SEND_SMS},
                                                        REQUEST_SMS);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(SendToContacts.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
}
