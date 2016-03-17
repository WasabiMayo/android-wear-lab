package com.example.wasabi.wearable;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wasabi on 3/17/2016.
 */
public class MyWearableAdapter extends WearableListView.Adapter {

    private ArrayList<String> mDataset;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public MyWearableAdapter(Context context, ArrayList<String> dataset) {
        mDataset = dataset;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public static class ItemViewHolder extends WearableListView.ViewHolder {

        private TextView textView;

        public ItemViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textbox);
        }
    }


    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(mInflater.inflate(R.layout.list_item,null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        TextView view = itemHolder.textView;
        view.setText(mDataset.get(position));
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
