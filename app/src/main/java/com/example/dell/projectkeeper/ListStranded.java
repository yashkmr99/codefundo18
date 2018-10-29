package com.example.dell.projectkeeper;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class ListStranded extends AppCompatActivity {

    Button addeventbutton, gotoMap;
    Intent intent;

    private DatabaseReference mdatabase;
    private ListView mEventList;

    private Button buttonviewmap;

    private int i =1;

    private String myDate, selectedEventDate, coordinates="";

    private ArrayList<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stranded);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("People");

        mEventList = (ListView) findViewById(R.id.meventlist);

        buttonviewmap = (Button) findViewById(R.id.buttonviewmap);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListStranded.this, android.R.layout.simple_list_item_1, mList);
        mEventList.setAdapter(arrayAdapter);

        mdatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value = dataSnapshot.getValue(String.class);
                mList.add(value);

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonviewmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListStranded.this, ShowStrandedActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",mList);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);

            }
        });

    }
}

