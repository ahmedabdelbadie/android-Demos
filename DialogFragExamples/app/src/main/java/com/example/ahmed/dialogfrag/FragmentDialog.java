package com.example.ahmed.dialogfrag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentDialog extends DialogFragment implements View.OnClickListener {
    Button y , n , c ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setCancelable(false);
        View v =inflater.inflate(R.layout.fragment_fragment_dialog,null);
        y=v.findViewById(R.id.btn_yes);
        n=v.findViewById(R.id.btn_no);
        c=v.findViewById(R.id.btn_cancel);
        y.setOnClickListener(this);
        n.setOnClickListener(this);
        c.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view==y){
            dismiss();
            Toast.makeText(getActivity(),"clicked Yes",Toast.LENGTH_SHORT).show();
        }else if (view==n){
            dismiss();
            Toast.makeText(getActivity(),"clicked No",Toast.LENGTH_SHORT).show();
        }else {
            dismiss();
            Toast.makeText(getActivity(),"clicked Cancel",Toast.LENGTH_SHORT).show();
        }

    }
}
