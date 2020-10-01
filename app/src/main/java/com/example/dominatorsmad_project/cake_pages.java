package com.example.dominatorsmad_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.dominatorsmad_project.R.*;

public class cake_pages extends AppCompatActivity {

    private Button Next;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    public String Name,CardNo;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_cake_pages);


        Next = findViewById(R.id.add_to_cart_button);


//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Address").child("User2");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                try{
//
//                    Name = dataSnapshot.child("names").getValue().toString();
//                }
//                catch (Exception e1){
//
//                    Name="Empty";
//                }
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                CardNo="Empty";
//            }
//        });
//
//        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("Payment").child("User1");
//        databaseReference1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                try {
//                    CardNo = dataSnapshot.child("cardNo").getValue().toString();
//                }
//                catch (Exception e ){
//                    CardNo="Empty";
//                }
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                CardNo="Empty";
//            }
//        });


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (Name.equals("Empty")){

                    Toast.makeText(getApplicationContext(), "Address page", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Address.class);
                    startActivity(i);
//
//                }
//                else{
//                    if (CardNo.equals("Empty")){
//                        Toast.makeText(getApplicationContext(), "Payment page", Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(getApplicationContext(), Payment.class);
//                        startActivity(i);
//                    }
//                    else{
//                        Toast.makeText(getApplicationContext(), "Confirm page", Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(getApplicationContext(), payment_confirm.class);
//                        i.putExtra("CardNo",CardNo);
//                        startActivity(i);
//
//                    }
//                }
//
//
//
            }


        });


    }

}