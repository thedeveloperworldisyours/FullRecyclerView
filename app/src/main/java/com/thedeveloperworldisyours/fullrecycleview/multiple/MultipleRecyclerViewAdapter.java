package com.thedeveloperworldisyours.fullrecycleview.multiple;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.List;

/**
 * Created by javierg on 01/02/2017.
 */

public class MultipleRecyclerViewAdapter extends RecyclerView
        .Adapter<MultipleRecyclerViewAdapter
        .DataObjectHolder> {

    List<MultipleData> mList;
    private static MultipleClickListener sClickListener;

    public MultipleRecyclerViewAdapter(List<MultipleData> mList) {
        this.mList = mList;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView mTextView;
        RadioButton mRadioButton;

        public DataObjectHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.multiple_list_item_text);
            mRadioButton = (RadioButton) itemView.findViewById(R.id.multiple_list_item_check_button);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void changedData(int position) {
            if (mList.get(position).isBoolean()) {
                mList.get(position).setBoolean(false);
            } else {
                mList.get(position).setBoolean(true);
            }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(MultipleClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.multiple_list_item, parent, false);

        MultipleRecyclerViewAdapter.DataObjectHolder dataObjectHolder = new MultipleRecyclerViewAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getTitle());
        holder.mRadioButton.setChecked(mList.get(position).isBoolean());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface MultipleClickListener {
        void onItemClick(int position, View v);
    }


}
