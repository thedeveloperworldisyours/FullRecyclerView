package com.thedeveloperworldisyours.fullrecycleview.contacts;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.List;

/**
 * Created by javierg on 18/09/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements TextGetter {

    private List<String> mDataSet;
    char[] mIndexList;

    // Constructor
    public RecyclerViewAdapter (List<String> contacts, char[] indexList) {
        this.mDataSet = contacts;
        this.mIndexList = indexList;
    }

    // Callbacks
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contacts_row_details, parent, false);

        return new ContactsViewHolder (view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ContactsViewHolder contactHolder = (ContactsViewHolder) holder;

        contactHolder.contactName.setText(mDataSet.get(position));
        contactHolder.firstLetter.setText(String.valueOf(mIndexList[position]));


        setRegularLineLayout(contactHolder);
    }

    private void setRegularLineLayout(ContactsViewHolder vh) {
        vh.firstLetter.setTextColor(Color.parseColor("#ffffff"));
        vh.firstLetter.setTextSize(26);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    // Bubbler Filler
    @Override
    public String getTextFromAdapter(int pos) {
        return String.valueOf(mDataSet.get(pos));
    }

    // ViewHolder class
    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView firstLetter;
        TextView contactName;

        public ContactsViewHolder (View v) {
            super (v);
            firstLetter = (TextView) v.findViewById(R.id.contact_first_letter);
            contactName = (TextView) v.findViewById(R.id.contact_name);
        }
    }
}
