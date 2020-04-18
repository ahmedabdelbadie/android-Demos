package com.example.ahmed.testfragment.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.ahmed.testfragment.ItemId;
import com.example.ahmed.testfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ItemId itemId;


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView=getActivity().findViewById(R.id.movie);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.items,android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        itemId= (ItemId) getActivity();
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        itemId.respond(i);
    }
}
