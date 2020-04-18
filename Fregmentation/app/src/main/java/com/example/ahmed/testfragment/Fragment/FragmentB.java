package com.example.ahmed.testfragment.Fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.testfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private TextView textView ;
    private String desc ;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        textView = v.findViewById(R.id.desc);
        if (savedInstanceState != null) {
            desc = savedInstanceState.getString("desc");
            textView.setText(desc);
        }
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.desc);
    }
    public void showdesc(int id){

        Resources res = getResources();
        String[] desc = res.getStringArray(R.array.desc);
        this.desc = desc[id] ;
        textView.setText(desc[id]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("desc",desc);
    }

}
