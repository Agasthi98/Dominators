package com.example.dominatorsmad_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {
private Activity activity;
private AlertDialog dialog;


    Loading(Activity myactivity){
        activity=myactivity;
    }
    void PaymentLoadingAnimation(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater intflater = activity.getLayoutInflater();
        builder.setView(intflater.inflate(R.layout.loading,null));
        builder.setCancelable(false);

        dialog=builder.create();
        dialog.show();

    }
    void dismissDialog(){
        dialog.dismiss();

    }


}
