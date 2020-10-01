package com.example.dominatorsmad_project;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class payment_confirm extends AppCompatActivity {

    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    TextView CustomerName,CustomerAddress1,CustomerAddress2,CustomerPhone,cardNo;
    ImageButton editaddress;
    String Cardno;
Button PlaceOrder;
ImageButton deletecardDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirm);


        CustomerName=(TextView) findViewById(R.id.txtuserName);
        CustomerAddress1=(TextView) findViewById(R.id.txtuserAddress);
        CustomerAddress2=(TextView) findViewById(R.id.txtuserAddress2);
        CustomerPhone=(TextView) findViewById(R.id.txtuserPhone);

        editaddress=(ImageButton) findViewById(R.id.txtimageeditaddress);
        PlaceOrder=(Button) findViewById(R.id.btnPlaceorder);
        cardNo=(TextView) findViewById(R.id.txtcardno);




        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Payment").child("User1");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    Cardno = dataSnapshot.child("cardNo").getValue().toString();
                    cardNo.setText(Cardno);
                }
                catch (Exception e){
                    Cardno=null;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Cardno=null;
            }
        });

        deletecardDetails=(ImageButton) findViewById(R.id.btndeletepayment);


        final Loading loading=new Loading(payment_confirm.this);


        deletecardDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment Dialog= new DialogFragment();
                Dialog.show(getSupportFragmentManager(),"DialogFragment");
            }
        });





        databaseReference = FirebaseDatabase.getInstance().getReference().child("Address").child("User2");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String City= dataSnapshot.child("cities").getValue().toString();
                String Name= dataSnapshot.child("names").getValue().toString();
                String Phn= dataSnapshot.child("phoneNumber").getValue().toString();
                String Address1= dataSnapshot.child("street1").getValue().toString();
                String Address2= dataSnapshot.child("street3").getValue().toString();

                CustomerName.setText(Name);
                CustomerAddress1.setText(Address1);
                CustomerAddress2.setText(City);
                CustomerPhone.setText(Phn);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        editaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), editAddress.class);
                startActivity(i);
            }
        });


        PlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.PaymentLoadingAnimation();
                Handler handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismissDialog();
                        Intent i = new Intent(getApplicationContext(), purchaseSuccess.class);
                        startActivity(i);
                    }
                },5000);

            }
        });


    }
}

//
