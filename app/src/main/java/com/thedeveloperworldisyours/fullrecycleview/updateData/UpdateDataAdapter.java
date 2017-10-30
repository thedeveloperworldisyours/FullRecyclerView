package com.thedeveloperworldisyours.fullrecycleview.updateData;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

/**
 * Created by javierg on 30/10/2017.
 */

public class UpdateDataAdapter extends RecyclerView
        .Adapter<UpdateDataAdapter
        .DataObjectHolder> {

    private ArrayList<UpdateData> mDataset;
    private static UpdateDataAdapter.MyClickListener sClickListener;
    int mPosition = -1;
    private Context mContext;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView mLabel;
        TextView mDateTime;

        DataObjectHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(R.id.vertical_list_item_title);
            mDateTime = (TextView) itemView.findViewById(R.id.vertical_list_item_subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    void setOnItemClickListener(UpdateDataAdapter.MyClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    UpdateDataAdapter(ArrayList<UpdateData> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public UpdateDataAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);

        UpdateDataAdapter.DataObjectHolder dataObjectHolder = new UpdateDataAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(UpdateDataAdapter.DataObjectHolder holder, int position) {
        holder.mLabel.setText(mDataset.get(position).getmTitle());
        holder.mLabel.setTextColor(ContextCompat.getColor(mContext, android.R.color.black));
        holder.mDateTime.setText(mDataset.get(position).getmSubTitle());
        if ((mPosition != -1) && (mPosition == position)) {
            Log.d("onBindViewHolder", position+"");
            holder.mLabel.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            mPosition = -1;
        }
    }

    public void selected(int position) {
        mPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    interface MyClickListener {
        void onItemClick(int position, View v);
    }

}
