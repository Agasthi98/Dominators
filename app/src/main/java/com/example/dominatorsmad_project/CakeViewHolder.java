package com.example.dominatorsmad_project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CakeViewHolder extends RecyclerView.ViewHolder {

    public ImageView cakeImage;
    public TextView cakeName;
    public TextView cakePrice;
    public TextView cakeQuantity;

    public CakeViewHolder(@NonNull View itemView) {
        super(itemView);
        cakeImage = itemView.findViewById(R.id.display_cake_image);
        cakeName = itemView.findViewById(R.id.display_cake_name);
        cakeQuantity = itemView.findViewById(R.id.display_cake_quantity);
        cakePrice = itemView.findViewById(R.id.display_cake_price);

    }
}
