package com.example.ahmed.testfragment.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.testfragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CounterFragmentB extends Fragment {
    private TextView textView ;
    private String cs ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_counter_b, container, false);
        textView =v.findViewById(R.id.text_counter);
        if (savedInstanceState != null){
            cs = savedInstanceState.getString("data");
            textView.setText(cs);
        }
        textView =v.findViewById(R.id.text_counter);
        return  v ;
    }
    public void respond(String c){
        this.cs = c ;
        textView.setText(c);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",cs);
    }
}
