package com.example.dominatorsmad_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;



public class CartItem extends Fragment {

    private RecyclerView cartView;
    private TextView cartTotprice;
    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference().child("Cart");
    private FirebaseRecyclerAdapter<Cart> options;
    private FirebaseRecyclerAdapter<Cart, CartItemViewHolder> adapter;
    private int sum = 0;
    private CartItem cItem;
    private int dbItemQuantity;
    private int dbItemQuantityRemove;
    private int totSum;
    private int value;

    public CartItem() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        auth = FirebaseAuth.getInstance();
        cItem = new CartItem();
        cartTotprice = view.findViewById(R.id.cart_tot_price);
        cartView = view.findViewById(R.id.cart_recycle_view);
        cartView.setHasFixedSize(true);
        cartView.setLayoutManager(new LinearLayoutManager(getContext()));

        options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(reference.child(auth.getCurrentUser().getUid()), Cart.class).build();

        return view;
    }
}