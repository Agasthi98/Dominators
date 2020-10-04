package com.example.dominatorsmad_project;

<<<<<<< HEAD
import androidx.annotation.NonNull;
=======
>>>>>>> origin/master
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Address extends AppCompatActivity {

    private EditText Name, phn, phn2, Street, Street2, City;
    private Button Save;
    private String phoneNumbers;
    private String carNo, name;

    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReferenceAddress;
    private DatabaseReference databaseReference_Payment;
=======
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Address extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText Name,phn,phn2,Street,Street2,City;
    private Button Save;
    private String phoneNumbers;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Address");
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        Name = findViewById(R.id.txtEditname);
        phn = findViewById(R.id.txtEditCont);
        phn2 = findViewById(R.id.txtcont2);
        Street = findViewById(R.id.txteditStreet);
        Street2 = findViewById(R.id.txteditStreet2);
        City = findViewById(R.id.txtEditCity);
        Save = findViewById(R.id.btnupdateAddress);

<<<<<<< HEAD
=======
        databaseReference = databaseReference.child(auth.getCurrentUser().getUid());

>>>>>>> origin/master

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String BuyerName = Name.getText().toString();
                String PhoneNumber = phn.getText().toString();
                String Street_one = Street.getText().toString();
                String Street_two = Street2.getText().toString();
                String Cit = City.getText().toString();

                if (!BuyerName.isEmpty()) {
                    if (!PhoneNumber.isEmpty()) {
                        if (!Street_one.isEmpty()) {
                            if (!Cit.isEmpty()) {
                                insertAddress();
                            } else {
                                Toast.makeText(Address.this, "required City", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Address.this, "required Street", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Address.this, "required Phone number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Address.this, "required Name", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

<<<<<<< HEAD
    private void insertAddress() {
        auth = FirebaseAuth.getInstance();
        databaseReferenceAddress = database.getReference().child("Addresss").child(auth.getUid());

        String BuyerName = Name.getText().toString();
        String PhoneNumber = phn.getText().toString();
        String Street_one = Street.getText().toString();
        String Street_two = Street2.getText().toString();
        String Cit = City.getText().toString();

        AddressHandle AddressHD = new AddressHandle(BuyerName, PhoneNumber, Street_one, Street_two, Cit);
        databaseReferenceAddress.setValue(AddressHD);

        Intent i = new Intent(getApplicationContext(), Payment.class);
        startActivity(i);

    }


=======
    private void insertAddress(){

        String BuyerName=Name.getText().toString();
        String PhoneNumber=phn.getText().toString();
        String Street_one=Street.getText().toString();
        String Street_two=Street2.getText().toString();
        String Cit=City.getText().toString();


        AddressHandle AddressHD = new AddressHandle(BuyerName, PhoneNumber, Street_one, Street_two,Cit);
        databaseReference.setValue(AddressHD);

        Intent intent=new Intent(getApplicationContext(),Payment.class);
        startActivity(intent);

        Toast.makeText(Address.this, "Datainserted", Toast.LENGTH_SHORT).show();
>>>>>>> origin/master

    }


<<<<<<< HEAD




=======
}
>>>>>>> origin/master
