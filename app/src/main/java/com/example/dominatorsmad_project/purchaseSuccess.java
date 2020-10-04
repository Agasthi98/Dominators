package com.example.dominatorsmad_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class purchaseSuccess extends AppCompatActivity {

    private Button purchaseSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_success);

        purchaseSuccess=findViewById(R.id.btncomplete);

        purchaseSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), user_profile.class);
               startActivity(i);
            }
        });

    }
}