package com.example.dominatorsmad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
=======
>>>>>>> origin/master

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
=======
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
>>>>>>> origin/master
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
<<<<<<< HEAD
import com.squareup.picasso.Picasso;












=======
>>>>>>> origin/master


public class Summary extends AppCompatActivity {


<<<<<<< HEAD
    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private FirebaseRecyclerOptions<Products> options;
    private FirebaseRecyclerAdapter<Products, myproducts> adapter;
    private DatabaseReference reference = database.getReference().child("Cart");
    RecyclerView recyclerView;

    TextView CustomerName, CustomerAddress1, CustomerAddress2, CustomerPhone, cardNo;
    ImageButton editaddress;
    String Cardno;
    Button PlaceOrder;
    Button deletecardDetails;

    TextView product;
    private DatabaseReference databaseReference_Payment;
    private DatabaseReference databaseReference_Address;

    ImageView display_cart_cake_image;
    TextView display_cart_item_name;
    TextView display_cart_item_price;
=======
    TextView CustomerName,CustomerAddress1,CustomerAddress2,CustomerPhone,cardNo;
    ImageButton editaddress;
    String Cardno;
    Button PlaceOrder;
    ImageButton deletecardDetails;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Address");

    private DatabaseReference databaseReferencecard = FirebaseDatabase.getInstance().getReference().child("Payment");


>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


<<<<<<< HEAD
        CustomerName = (TextView) findViewById(R.id.txtuserName);
        CustomerAddress1 = (TextView) findViewById(R.id.txtuserAddress);
        CustomerAddress2 = (TextView) findViewById(R.id.txtuserAddress2);
        CustomerPhone = (TextView) findViewById(R.id.txtuserPhone);

        editaddress = (ImageButton) findViewById(R.id.txtimageeditaddress);
        PlaceOrder = (Button) findViewById(R.id.btnPlaceorder);
        cardNo = (TextView) findViewById(R.id.txtcardno);


        auth = FirebaseAuth.getInstance();
        databaseReference_Payment = database.getReference().child("Payment").child(auth.getUid());

        display_cart_cake_image=findViewById(R.id.display_cart_cake_image);
        display_cart_item_name=findViewById(R.id.display_cart_item_name);
        display_cart_item_price=findViewById(R.id.display_cart_item_price);




//        options=new FirebaseRecyclerOptions.Builder<Products>().setQuery(reference,Products.class).build();
//        adapter=new FirebaseRecyclerAdapter<Products, myproducts>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull myproducts myproducts, int i, @NonNull Products products) {
//
//                myproducts.name.setText(products.getName());
//                myproducts.price.setText(products.getPrice());
//                myproducts.qty.setText(products.getQTY());
//
//                Picasso.get().load(products.getImage()).into(myproducts.imageview);
//            }
//
//            @NonNull
//            @Override
//            public myproducts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//                View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_summary,parent,false);
//
//
//                return new myproducts(v);
//            }
//        };
//        adapter.startListening();
//        recyclerView.setAdapter(adapter);












        databaseReference_Payment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    Cardno = dataSnapshot.child("cardNo").getValue().toString();
                    cardNo.setText(Cardno);
                } catch (Exception e) {
                    Cardno = null;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Cardno = null;
            }
        });

        deletecardDetails = findViewById(R.id.cart_item_delete_butto);


        final Loading loading = new Loading(Summary.this);
=======
        CustomerName=(TextView) findViewById(R.id.txtuserName);
        CustomerAddress1=(TextView) findViewById(R.id.txtuserAddress);
        CustomerAddress2=(TextView) findViewById(R.id.txtuserAddress2);
        CustomerPhone=(TextView) findViewById(R.id.txtuserPhone);

        editaddress=(ImageButton) findViewById(R.id.txtimageeditaddress);
        PlaceOrder=(Button) findViewById(R.id.btnPlaceorder);
        cardNo=(TextView) findViewById(R.id.txtcardno);

        databaseReference = databaseReference.child(auth.getCurrentUser().getUid());
        databaseReferencecard = databaseReferencecard.child(auth.getCurrentUser().getUid());


        databaseReferencecard.addValueEventListener(new ValueEventListener() {
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


        final Loading loading=new Loading(Summary.this);
>>>>>>> origin/master


        deletecardDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                DialogFragment Dialog = new DialogFragment();
                Dialog.show(getSupportFragmentManager(), "DialogFragment");
=======
                DialogFragment Dialog= new DialogFragment();
                Dialog.show(getSupportFragmentManager(),"DialogFragment");
>>>>>>> origin/master
            }
        });


<<<<<<< HEAD
        auth = FirebaseAuth.getInstance();
        databaseReference_Address = database.getReference().child("Addresss").child(auth.getUid());


        databaseReference_Address.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String City = dataSnapshot.child("cities").getValue().toString();
                String Name = dataSnapshot.child("names").getValue().toString();
                String Phn = dataSnapshot.child("phoneNumber").getValue().toString();
                String Address1 = dataSnapshot.child("street1").getValue().toString();
                String Address2 = dataSnapshot.child("street3").getValue().toString();
=======




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String City= dataSnapshot.child("cities").getValue().toString();
                String Name= dataSnapshot.child("names").getValue().toString();
                String Phn= dataSnapshot.child("phoneNumber").getValue().toString();
                String Address1= dataSnapshot.child("street1").getValue().toString();
                String Address2= dataSnapshot.child("street3").getValue().toString();
>>>>>>> origin/master

                CustomerName.setText(Name);
                CustomerAddress1.setText(Address1);
                CustomerAddress2.setText(City);
                CustomerPhone.setText(Phn);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


<<<<<<< HEAD
=======

>>>>>>> origin/master
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
<<<<<<< HEAD
                Handler handler = new Handler();
=======
                Handler handler =new Handler();
>>>>>>> origin/master
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismissDialog();
                        Intent i = new Intent(getApplicationContext(), purchaseSuccess.class);
                        startActivity(i);
                    }
<<<<<<< HEAD
                }, 5000);
=======
                },5000);
>>>>>>> origin/master

            }
        });


    }
}