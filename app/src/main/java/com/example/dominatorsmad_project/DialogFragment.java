package com.example.dominatorsmad_project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

<<<<<<< HEAD
import com.google.firebase.auth.FirebaseAuth;
=======
>>>>>>> origin/master
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    DatabaseReference databaseReference;
<<<<<<< HEAD
    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference_Payment;

=======
>>>>>>> origin/master
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Notice")
                .setMessage("succesfully deleted card details")
                .setMessage("Please Enter new card details")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

<<<<<<< HEAD
                        auth = FirebaseAuth.getInstance();
                        databaseReference_Payment=database.getReference().child("Payment").child(auth.getUid());
                        databaseReference_Payment.removeValue();
=======
                        databaseReference = FirebaseDatabase.getInstance().getReference().child("Payment");
                        databaseReference.child("User1").removeValue();
>>>>>>> origin/master

                        Intent a = new Intent(getContext(), Payment.class);
                        startActivity(a);

<<<<<<< HEAD
=======

>>>>>>> origin/master
                    }
                });
        return builder.create();
    }
}
