package com.thedeveloperworldisyours.fullrecycleview.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.chat.VerticalData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 25/10/2017.
 */

public class ChatAdapter extends RecyclerView
        .Adapter<ChatAdapter
        .DataObjectHolder> {

    private ArrayList<VerticalData> mDataset;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        @BindView(R.id.message_text_textView)
        TextView mText;

        @BindView(R.id.message_time_textView)
        TextView mDateTime;

        DataObjectHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }


    public ChatAdapter(ArrayList<VerticalData> dataset) {
        mDataset = dataset;
    }

    @Override
    public ChatAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item_list, parent, false);

        ChatAdapter.DataObjectHolder dataObjectHolder = new ChatAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.DataObjectHolder holder, int position) {
        holder.mText.setText(mDataset.get(position).getmTitle());
        holder.mDateTime.setText(mDataset.get(position).getmSubTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
