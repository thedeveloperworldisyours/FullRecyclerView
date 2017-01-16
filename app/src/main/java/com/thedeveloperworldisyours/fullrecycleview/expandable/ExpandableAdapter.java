package com.thedeveloperworldisyours.fullrecycleview.expandable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by javierg on 16/01/2017.
 */

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder, KidViewHolder> {

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandable_parent_list_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public KidViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandable_kid_list_item, parent, false);
        return new KidViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(KidViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final Artist artist = ((Genre) group).getItems().get(childIndex);
        holder.setArtistName(artist.getName());
    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setGenreTitle(group);
    }
}
