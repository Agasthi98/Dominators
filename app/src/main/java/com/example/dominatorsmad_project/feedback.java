package com.example.dominatorsmad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    EditText txtname,txtfeedbakc;
    Button submit,buttontnreview;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtname=findViewById(R.id.txtname);
        txtfeedbakc=findViewById(R.id.txtfeedback);
        submit=findViewById(R.id.btnsubmit);
        buttontnreview=findViewById(R.id.buttontnreview);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference= FirebaseDatabase.getInstance().getReference().child("FeedBack");
                String name= txtname.getText().toString();
                String yourReview= txtfeedbakc.getText().toString();
                feedbackClass FBC=new feedbackClass(name,yourReview);
                databaseReference.child("User1").setValue(FBC);



            }
        });

        buttontnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),feedback_update.class);
                startActivity(intent);
            }
        });


    }
}