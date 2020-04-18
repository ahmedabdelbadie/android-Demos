package com.example.ahmed.testfragment.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ahmed.testfragment.CounterInterface;
import com.example.ahmed.testfragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CounterFragmentA extends Fragment  implements View.OnClickListener{
    private CounterInterface counterInterface ;
    private int counter1 = 0 , counter2 = 0 ;
    Button b1 , b2 ;


    public CounterFragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_counter_a, container, false);
        if (savedInstanceState != null){
            counter1 = savedInstanceState.getInt("c1");
            counter2 = savedInstanceState.getInt("c2");
        }
         b1 = v.findViewById(R.id.countera);
         b2= v.findViewById(R.id.counterb);
         b1.setOnClickListener(this);
         b2.setOnClickListener(this);

        counterInterface = (CounterInterface) getActivity();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        if (view==b1){
            counterInterface.Count("The Counter A is "+counter1++);

        }else if (view==b2){
            counterInterface.Count("The Counter B is "+counter2++);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("c1",counter1);
        outState.putInt("c2",counter2);
    }
}
