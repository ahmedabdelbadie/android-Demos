package com.example.a.testrecyclercardviewwithhighlighttext;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import eu.fiskur.chipcloud.ChipCloud;
import eu.fiskur.chipcloud.ChipListener;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ListView mListView;
    ArrayList<String> data;
    ArrayList<ListTag> listTags;
    private static final String TAG = "MAINACTIVITY";
    String[] strings = new String[]{" Health ", " Education ", " Development " , " HealthDevelopment "/*," Health ", " Education ", " Development " , " Health "*/};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        listTags = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            data.addAll(Arrays.asList(strings));
            data.add("...");
            listTags.add(new ListTag(data));
            data.clear();
        }
        mRecyclerView = findViewById(R.id.rv_cards);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AdapterCards());

    }


    private class AdapterCards extends RecyclerView.Adapter<AdapterCards.MyHolderView> {
        @Override
        public MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new MyHolderView(layoutView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolderView holder, int position) {
            Picasso.get().load(R.drawable.capture4).fit().into(holder.imageView);
            holder.tag_layout.removeAllViews();
            holder.tag_layout.datas.clear();
            holder.tag_layout.addALL(listTags.get(position).tagObjects);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return listTags.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        public class MyHolderView extends RecyclerView.ViewHolder {
            ImageView imageView;
            ChipCloud tag_layout;

            MyHolderView(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.img_icon);
                tag_layout = itemView.findViewById(R.id.tag);
                tag_layout.setSelectedColor(Color.parseColor("#FF4081"));
                tag_layout.setSelectedFontColor(Color.WHITE);
                tag_layout.setUnselectedColor(Color.parseColor("#BDBDBD"));
                tag_layout.setUnselectedFontColor(Color.parseColor("#D500F9"));
            }
        }
    }

}
