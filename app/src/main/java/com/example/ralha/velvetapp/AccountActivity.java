package com.example.ralha.velvetapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference dbName, dbCCN, dbCCV, dbEndDate, dbAddress, dbNameOnCard, dbPhoneNo;
    private TextView Name, Address, CCN, CCV, PhoneNumber, NameOnCard, EndDate;
   // private ImageView edit = R.id.edit;
    // private ImageView back = R.id.back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        firebaseAuth = FirebaseAuth.getInstance();
        dbName = FirebaseDatabase.getInstance().getReference().child("name");
        dbName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                Name.setText("Name: " + name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}




   /* @Override
    public void onClick(View v) {
        if(v == edit)
        { startActivity(new Intent(this, ProfileActivity.class));}
        if (v == back)
        {finish();
            startActivity(new Intent(this, HomeP.class));}

    }*/
