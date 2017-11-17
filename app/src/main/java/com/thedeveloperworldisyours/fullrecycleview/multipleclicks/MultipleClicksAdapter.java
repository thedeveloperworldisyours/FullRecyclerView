package com.thedeveloperworldisyours.fullrecycleview.multipleclicks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 16/11/2017.
 */

public class MultipleClicksAdapter extends RecyclerView
        .Adapter<MultipleClicksAdapter
        .DataObjectHolder> {

    private ArrayList<MultipleClickData> mDataset;
    private static MultipleClickListener sClickListener;

    static class DataObjectHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.multiple_clicks_one_textView)
        TextView mOne;
        @BindView(R.id.multiple_clicks_two_textView)
        TextView mTwo;
        @BindView(R.id.multiple_clicks_three_textView)
        TextView mThree;

        DataObjectHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mOne.setOnClickListener((View v) ->
                    sClickListener.onItemClickOne(getAdapterPosition(), mOne));

            mTwo.setOnClickListener((View v) ->
                    sClickListener.onItemClickTwo(getAdapterPosition(), mTwo));

            mThree.setOnClickListener((View v) ->
                    sClickListener.onItemClickThree(getAdapterPosition(), mThree));
        }

    }

    void setOnItemClickListener(MultipleClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    MultipleClicksAdapter(ArrayList<MultipleClickData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MultipleClicksAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.multiple_clicks_list_item, parent, false);

        MultipleClicksAdapter.DataObjectHolder dataObjectHolder = new MultipleClicksAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(MultipleClicksAdapter.DataObjectHolder holder, int position) {
        holder.mOne.setText(mDataset.get(position).getmTitle());
        holder.mTwo.setText(mDataset.get(position).getmSubTitle());
        holder.mThree.setText(mDataset.get(position).getmThirdTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    interface MultipleClickListener {
        void onItemClickOne(int position, View v);
        void onItemClickTwo(int position, View v);
        void onItemClickThree(int position, View v);
    }

}
