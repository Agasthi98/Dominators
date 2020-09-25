package com.example.dominatorsmad_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HomePage extends Fragment {

    private RecyclerView homePageRecyclerView;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference().child("All_Cakes");

    private FirebaseRecyclerOptions<Cake> options;
    private FirebaseRecyclerAdapter<Cake, CakeViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        homePageRecyclerView = view.findViewById(R.id.home_page_recycler_view);
        homePageRecyclerView.setHasFixedSize(true);
        homePageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        options = new FirebaseRecyclerOptions.Builder<Cake>().setQuery(reference, Cake.class).build();
        adapter = new FirebaseRecyclerAdapter<Cake, CakeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CakeViewHolder holder, int position, @NonNull Cake model) {
                holder.cakeName.setText(model.getName());
                holder.cakePrice.setText(model.getCakePrice());
                holder.cakeQuantity.setText(model.getCakeQuantity());
                Picasso.get().load(model.getImgUri()).into(holder.cakeImage);
            }

            @NonNull
            @Override
            public CakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cake_item, parent, false);
                return new CakeViewHolder(v);
            }
        };
        adapter.startListening();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        homePageRecyclerView.setLayoutManager(gridLayoutManager);
        homePageRecyclerView.setAdapter(adapter);
        return view;
    }
}