package com.example.ahmed.navimanually;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ahmed on 1/16/2018.
 */

public class AdapterIcon extends RecyclerView.Adapter<AdapterIcon.ViewHolder> {
    ArrayList<IconModel> models = new ArrayList <>();
    private static final String TAG = "ADAPTER";
    int[] ic ;
    String[] tit ;
    IconModel model ;
    Context c;
    /*private parse parse;*/
    private LayoutInflater inflater ;

    public AdapterIcon(Context context){
        c=context;
        Log.d(TAG, "AdapterIcon: 1"+context);
        inflater = LayoutInflater.from(context);
        Log.d(TAG, "AdapterIcon: 2"+inflater);
        tit = context.getResources().getStringArray(R.array.title);
        Log.d(TAG, "AdapterIcon: 3"+tit[1]);
        getdata();

    }

    /*public void setParse(parse parse) {
        this.parse = parse;
    }*/

    private void getdata() {
        Log.d(TAG, "getdata: 1");
        ic= new int[]{R.mipmap.ic_arrow_forward_black_24dp,R.mipmap.ic_check_circle_black_24dp,R.mipmap.ic_dashboard_black_24dp,R.mipmap.ic_date_range_black_24dp,R.mipmap.ic_explore_black_24dp,R.mipmap.ic_fingerprint_black_24dp,R.mipmap.ic_info_black_24dp,R.mipmap.ic_list_black_24dp};
        Log.d(TAG, "getdata: 2"+ic[1]);
        Log.d(TAG, "getdata: 2"+R.mipmap.ic_arrow_forward_black_24dp);
        for (int i = 0; i < ic.length; i++) {
            Log.d(TAG, "getdata: 3"+i);
            model = new IconModel(ic[i],tit[i]);
            Log.d(TAG, "getdata: 3"+model.getIcon());
            models.add(model);
            Log.d(TAG, "getdata: 3"+models.get(i).getIcon());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: 1");
        View row = inflater.inflate(R.layout.rv_item_model,parent,false);
        Log.d(TAG, "onCreateViewHolder: 2"+row);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivIcon.setImageResource(Integer.parseInt(String.valueOf(models.get(position).getIcon())));
        holder.tvIcon.setText(models.get(position).getTitle());
        /*holder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, "Icon here", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+models.size());
        return models.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivIcon;
        TextView tvIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvIcon = itemView.findViewById(R.id.tv_icon);
            Log.d(TAG, "ViewHolder: 1"+ivIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*delete(getLayoutPosition());
            * Toast.makeText(c, "this item deleted ", Toast.LENGTH_SHORT).show();*/
            /*if (parse != null){
                parse.parsePosition(view,getLayoutPosition());
            }*/

        }
    }
    /*public interface parse{
       void parsePosition(View v ,int p);
    }*/

    private void delete(int layoutPosition) {
        this.models.remove(layoutPosition);
        notifyDataSetChanged();
    }
}
