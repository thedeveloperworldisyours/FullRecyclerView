package com.thedeveloperworldisyours.fullrecycleview.updateData;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.multiple.MultipleRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by javierg on 30/10/2017.
 */

public class UpdateDataAdapter extends RecyclerView
        .Adapter<UpdateDataAdapter
        .DataObjectHolder> {

    private ArrayList<UpdateData> mDataset;
    private static Context mContext;
    private static int mPosition;
    private static SparseBooleanArray selectedItems;
    private static UpdateDataClickListener sClickListener;
    private static final int MULTIPLE = 0;
    private static final int SINGLE = 1;
    private static int sModo = 0;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView mLabel;
        TextView mDateTime;
        LinearLayout mBackground;


        DataObjectHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(R.id.vertical_list_item_title);
            mDateTime = (TextView) itemView.findViewById(R.id.vertical_list_item_subtitle);
            mBackground = (LinearLayout) itemView.findViewById(R.id.vertical_list_item_background);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mLabel.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            if (selectedItems.get(getAdapterPosition(), false)) {
                selectedItems.delete(getAdapterPosition());
                mBackground.setSelected(false);
            } else {
                switch (sModo) {
                    case SINGLE:
                        selectedItems.put(mPosition, false);
                        break;
                    case MULTIPLE:
                    default:
                        break;
                }
                mLabel.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                selectedItems.put(getAdapterPosition(), true);
                mBackground.setSelected(true);
            }
            sClickListener.onItemClick(getAdapterPosition());
        }
    }

    void setOnItemClickListener(UpdateDataClickListener clickListener) {
        sClickListener = clickListener;
    }

    UpdateDataAdapter(ArrayList<UpdateData> myDataset, Context context, int modo) {
        mDataset = myDataset;
        mContext = context;
        selectedItems = new SparseBooleanArray();
        sModo = modo;
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
        holder.mBackground.setSelected(selectedItems.get(position, false));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void selected(int position) {
        switch (sModo) {
            case SINGLE:
                mPosition = position;
                notifyDataSetChanged();
                break;
            case MULTIPLE:
            default:
                break;
        }
    }

    public void changeMode(int modo) {
        sModo = modo;
        selectedItems.clear();
        notifyDataSetChanged();
    }

    interface UpdateDataClickListener {
        void onItemClick(int position);
    }

}
