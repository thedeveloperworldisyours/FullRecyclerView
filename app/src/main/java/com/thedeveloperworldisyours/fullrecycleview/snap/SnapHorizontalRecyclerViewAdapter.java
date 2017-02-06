package com.thedeveloperworldisyours.fullrecycleview.snap;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

/**
 * Created by javierg on 06/02/2017.
 */

public class SnapHorizontalRecyclerViewAdapter extends RecyclerView.Adapter<SnapHorizontalRecyclerViewAdapter.DataObjectHolder> {

    private Context mContext;
    private ArrayList<SnapData> mDataSet;

    public SnapHorizontalRecyclerViewAdapter(ArrayList<SnapData> dataset, Context context) {
        this.mDataSet = dataset;
        this.mContext = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.snap_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.mTextView.setText(mDataSet.get(position).getText());
        holder.mImage.setImageDrawable(ContextCompat.getDrawable(mContext, mDataSet.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImage;
        TextView mTextView;

        public DataObjectHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.snap_list_item_image_view);
            mTextView = (TextView) itemView.findViewById(R.id.snap_list_item_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
