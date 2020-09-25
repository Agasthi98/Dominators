package com.example.dominatorsmad_project;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView cartItemImage;
    public TextView cartItemName;
    public TextView cartItemPrice;
    public Button cDeleteButton;
    public Button cAddButton;
    public Button removeButton;
    public TextView cQuantity;

    public CartItemViewHolder(@NonNull View itemView) {
        super(itemView);
        cartItemImage = itemView.findViewById(R.id.display_cake_image);
        cartItemName = itemView.findViewById(R.id.display_cart_item_name);
        cartItemPrice = itemView.findViewById(R.id.display_cake_price);
        cDeleteButton = itemView.findViewById(R.id.cart_item_delete_button);
        cAddButton = itemView.findViewById(R.id.cart_item_add_button);
        removeButton = itemView.findViewById(R.id.cart_item_remove_button);
        cQuantity = itemView.findViewById(R.id.cart_item_quantity);
    }

}
