package com.example.dominatorsmad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class View extends AppCompatActivity {

    TextView name,feedback;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

//        feedback=findViewById(R.id.textViewfeedback);
//        name=findViewById(R.id.textViewname);
//
//
//        databaseReference= FirebaseDatabase.getInstance().getReference().child("FeedBack").child("User1");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String feedbacks=dataSnapshot.child("feedback").getValue().toString();
//                String names=dataSnapshot.child("name").getValue().toString();
//                feedback.setText(feedbacks);
//                name.setText(names);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }
}