package com.thedeveloperworldisyours.fullrecycleview.chat;

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
 * Created by javierg on 25/10/2017.
 */

public class ChatAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private static final int TIME = 0;
    private static final int RECEIVE_MESSAGE = 1;
    private static final int SEND_MESSAGE = 2;

    private ArrayList<ChatData> mDataset;

    static class ReceiveObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        @BindView(R.id.receive_text_textView)
        TextView mReceiverText;

//        @BindView(R.id.receive_time_textView)
//        TextView mReceiverTime;

        ReceiveObjectHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    static class SendObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        @BindView(R.id.send_text_textView)
        TextView mSendText;

//        @BindView(R.id.send_time_textView)
//        TextView mSendTime;

        SendObjectHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    static class TimeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.chat_time)
        TextView mTimeTextView;

        TimeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public ChatAdapter(ArrayList<ChatData> dataset) {
        mDataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View viewReceiver = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item_list_receive_message, parent, false);

        View viewSender = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item_list_send_message, parent, false);

        View viewTime = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item_list_time, parent, false);

        switch (viewType) {
            case TIME:
                return new TimeHolder(viewTime);
            case RECEIVE_MESSAGE:
                return new ReceiveObjectHolder(viewReceiver);
            case SEND_MESSAGE:
                return new SendObjectHolder(viewSender);
            default:
                return new TimeHolder(viewTime);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case RECEIVE_MESSAGE:
                ReceiveObjectHolder receiveObjectHolder = (ReceiveObjectHolder) holder;
                receiveObjectHolder.mReceiverText.setText(mDataset.get(position).getTitle());
//                receiveObjectHolder.mReceiverTime.setText(mDataset.get(position).getTime());
                break;

            case SEND_MESSAGE:
                SendObjectHolder sendObjectHolder = (SendObjectHolder) holder;
                sendObjectHolder.mSendText.setText(mDataset.get(position).getTitle());
//                sendObjectHolder.mSendTime.setText(mDataset.get(position).getTime());
                break;

            case TIME:
                TimeHolder timeHolder = (TimeHolder) holder;
                timeHolder.mTimeTextView.setText(mDataset.get(position).getTime());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    @Override
    public int getItemViewType(int position) {

        switch (mDataset.get(position).getElement()) {
            case 0:
                return TIME;
            case 1:
                return RECEIVE_MESSAGE;
            case 2:
                return SEND_MESSAGE;
            default:
                return TIME;
        }
    }

}
