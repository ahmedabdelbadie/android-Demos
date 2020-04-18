package com.example.ahmed.dialogfrag;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


public class SimpleItemAlert extends DialogFragment {
    Boolean[] arr ;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Do you love Android ");


        //Handle Item in Message
        builder.setItems(R.array.days, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Selected From item "+i,Toast.LENGTH_SHORT).show();

            }
        });

        /*arr = new Boolean[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=null;
        }
        builder.setMultiChoiceItems(R.array.days, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                arr[i]=b;
                Toast.makeText(getActivity(),"Item position "+i+" Checked "+b,Toast.LENGTH_SHORT).show();
            }
        });*/
        builder.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getActivity(),"Selected No",Toast.LENGTH_SHORT).show();

//                startActivity(new Intent(getActivity(),Main2Activity.class));



            }
        });

        builder.setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for (int j=0;j<arr.length;j++){
                    Toast.makeText(getActivity(),"Item position "+j+" Checked "+arr[j],Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getActivity(),"Selected Yes",Toast.LENGTH_SHORT).show();
            }
        });


        builder.setNeutralButton(" Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Selected Cancel",Toast.LENGTH_SHORT).show();
            }
        });





        Dialog dialog = builder.create();

        return dialog;
    }
}
