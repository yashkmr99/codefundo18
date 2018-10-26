package com.example.dell.projectkeeper;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MarkLocationStranded extends AppCompatActivity {

    Button sendButton;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_location_stranded);

        sendButton = (Button) findViewById(R.id.sendDetailButton);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("People");


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                String clipbrd = item.getText().toString();
                String location = clipbrd.substring(47);

                mDatabase.push().setValue(location);

            }
        });


    }
}
