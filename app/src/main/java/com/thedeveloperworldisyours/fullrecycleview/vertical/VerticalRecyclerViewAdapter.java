package com.thedeveloperworldisyours.fullrecycleview.vertical;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

/**
 * Created by javierg on 25/01/2017.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView
        .Adapter<VerticalRecyclerViewAdapter
        .DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<com.thedeveloperworldisyours.fullrecycleview.vertical.Data> mDataset;
    private static VerticalRecyclerViewAdapter.MyClickListener mClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView mLabel;
        TextView mDateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(R.id.vertical_list_item_title);
            mDateTime = (TextView) itemView.findViewById(R.id.vertical_list_item_subtitle);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(VerticalRecyclerViewAdapter.MyClickListener myClickListener) {
        this.mClickListener = myClickListener;
    }

    public VerticalRecyclerViewAdapter(ArrayList<com.thedeveloperworldisyours.fullrecycleview.vertical.Data> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public VerticalRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);

        VerticalRecyclerViewAdapter.DataObjectHolder dataObjectHolder = new VerticalRecyclerViewAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewAdapter.DataObjectHolder holder, int position) {
        holder.mLabel.setText(mDataset.get(position).getmTitle());
        holder.mDateTime.setText(mDataset.get(position).getmSubTitle());
    }

    public void addItem(com.thedeveloperworldisyours.fullrecycleview.vertical.Data dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
