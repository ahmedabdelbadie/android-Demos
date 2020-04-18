package com.example.ahmed.testfragment.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.testfragment.R;


public class FragmentLB extends Fragment {

    private TextView textView ;
    private String desc ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lb, container, false);
        textView = v.findViewById(R.id.descl);
        if (savedInstanceState != null) {
            desc = savedInstanceState.getString("desc");
            textView.setText(desc);
        }
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.descl);
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
