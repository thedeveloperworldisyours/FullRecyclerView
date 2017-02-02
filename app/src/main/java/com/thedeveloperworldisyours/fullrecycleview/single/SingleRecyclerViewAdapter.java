package com.thedeveloperworldisyours.fullrecycleview.single;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

/**
 * Created by javierg on 02/02/2017.
 */

public class SingleRecyclerViewAdapter extends RecyclerView.Adapter<SingleRecyclerViewAdapter.DataObjectHolder> {

    private String[] mData;
    private static SingleClickListener sClickListener;
    private static int sSelected = -1;

    public SingleRecyclerViewAdapter(String[] mData) {
        this.mData = mData;
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextView;
        RadioButton mRadioButton;

        public DataObjectHolder(View itemView) {
            super(itemView);
            this.mTextView = (TextView) itemView.findViewById(R.id.single_list_item_text);
            this.mRadioButton = (RadioButton) itemView.findViewById(R.id.single_list_item_check_button);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            sSelected = getAdapterPosition();
            sClickListener.onItemClickListener(getAdapterPosition(), view);
        }
    }

    public void selectedItem() {
        notifyDataSetChanged();
    }

    void setOnItemClickListener(SingleClickListener clickListener) {
        sClickListener = clickListener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.mTextView.setText(mData[position]);

        if (sSelected == position) {
            holder.mRadioButton.setChecked(true);
        } else {
            holder.mRadioButton.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    interface SingleClickListener {
        void onItemClickListener(int position, View view);
    }

}
