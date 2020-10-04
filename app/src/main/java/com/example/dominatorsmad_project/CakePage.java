package com.example.dominatorsmad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class CakePage extends Fragment {
    private ImageView cakeImage;
    private TextView cakeName;
    private TextView cakePrice;
    private TextView cakeQuantity;
    private TextView cakeDescription;

    private Button addToCartButton;
    private Button buyNowButton;
    private Bundle bundle;
    private String Email;
    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference allItems = database.getReference().child("All_Cakes");
    private DatabaseReference cartReference = database.getReference().child("Cart");
   private DatabaseReference databaseReferenceAddress;
    private DatabaseReference databaseReference_Payment;
private String name,carNo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_page, container, false);
        bundle = this.getArguments();
        cakeImage = view.findViewById(R.id.display_image);
        cakeName = view.findViewById(R.id.display_name);
        cakePrice = view.findViewById(R.id.display_price);
        cakeQuantity = view.findViewById(R.id.display_quantity);
        cakeDescription = view.findViewById(R.id.display_Description);

        addToCartButton = view.findViewById(R.id.add_to_cart_button);
        buyNowButton = view.findViewById(R.id.buy_now_button);

        auth = FirebaseAuth.getInstance();
        cartReference = cartReference.child(auth.getCurrentUser().getUid());





        displayItemDetails();
        addToCart();



        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              try {
                  check_details();
              }catch (Exception e3){

                  Intent i = new Intent(getContext(), Address.class);
                  startActivity(i);
              }
}
});





















        return view;
    }

    private void addToCart() {
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = bundle.getString("cakeName");
                String itemPrice = bundle.getString("cakePrice");
                String itemImage = bundle.getString("cakeImage");
                String itemDescription = bundle.getString("Description");
                String itemId = cartReference.push().getKey();
                int itemQuantity = 1;
                int totalPrice = Integer.parseInt(itemPrice);

                Cart newCartItem = new Cart(itemId, itemName, itemPrice, itemImage,itemDescription, itemQuantity, totalPrice);
                cartReference.child(itemId).setValue(newCartItem);
                Toast.makeText(getContext(), "Item Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayItemDetails() {
        Picasso.get().load(bundle.getString("cakeImage")).into(cakeImage);
        cakeName.setText(bundle.getString("cakeName"));
        cakePrice.setText(bundle.getString("cakePrice"));
        cakeQuantity.setText(bundle.getString("cakeQuantity"));
        cakeDescription.setText(bundle.getString("cakeDescription"));


}

private  void check_details(){


    try {
        databaseReferenceAddress=database.getReference().child("Addresss").child(auth.getUid());
        databaseReferenceAddress.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    name = dataSnapshot.getValue().toString();
                }catch (Exception e2){
                    Intent i = new Intent(getContext(), Address.class);
                    startActivity(i);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                name="Empty";
            }
        });

        try {
            databaseReference_Payment=database.getReference().child("Payment").child(auth.getUid());
            databaseReference_Payment.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        carNo = dataSnapshot.getValue().toString();

                    }catch (Exception e){
                        Intent i = new Intent(getContext(), Address.class);
                        startActivity(i);
                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    carNo="Empty";
                }
            });
        }catch (Exception e7){
            carNo="Empty";
        }

    }catch (Exception e5){
        Intent i = new Intent(getContext(), Address.class);
        startActivity(i);
    }

    if (name.equals("Empty")){

        Toast.makeText(getContext(), "Address page", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getContext(), Address.class);
        startActivity(i);

    }
    else{
        if (carNo.equals("Empty")){
            Toast.makeText(getContext(), "Payment page", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getContext(), Payment.class);
            startActivity(i);
        }
        else{
            Toast.makeText(getContext(), "Confirm page", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getContext(), Summary.class);
            i.putExtra("CardNo",carNo);
            startActivity(i);

        }
    }

}


}
