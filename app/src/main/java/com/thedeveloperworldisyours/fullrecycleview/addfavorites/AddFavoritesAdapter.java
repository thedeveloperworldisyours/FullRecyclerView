package com.thedeveloperworldisyours.fullrecycleview.addfavorites;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.addfavorites.model.ElementList;
import com.thedeveloperworldisyours.fullrecycleview.addfavorites.model.Fruit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 03/08/2017.
 */

public class AddFavoritesAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private static final int SECTION = 0;
    private static final int NORMAL = 1;
    private Context mContext;
    private List<ElementList> mList;
    private static AddFavoritesAdapter.MyClickListener sClickListener;
    // Allows to remember the last item shown on screen
    private int mLastPosition = -1;

    static class SectionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.add_favorites_list_item_text)
        TextView mTextViewSection;

        SectionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        @BindView(R.id.add_favorites_item_name)
        TextView mName;

        @BindView(R.id.add_favorites_item_favorite)
        CheckBox mFavorite;


        DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setOnItemClickListener(AddFavoritesAdapter.MyClickListener myClickListener) {
        sClickListener = myClickListener;
    }

    AddFavoritesAdapter(Context context, List<ElementList> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_favorites_list_item, parent, false);

        View viewSection = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_favorites_section_list_item, parent, false);

        switch (viewType) {
            case NORMAL:
                return new AddFavoritesAdapter.DataObjectHolder(view);
            case SECTION:
                return new AddFavoritesAdapter.SectionHolder(viewSection);
            default:
                return new AddFavoritesAdapter.SectionHolder(viewSection);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case NORMAL:
                AddFavoritesAdapter.DataObjectHolder dataObjectHolder = (AddFavoritesAdapter.DataObjectHolder) holder;
                Fruit fruit = (Fruit) mList.get(position);
                dataObjectHolder.mName.setText(fruit.getName());
                dataObjectHolder.mFavorite.setChecked(fruit.isFavourite());
                dataObjectHolder.mFavorite.setOnClickListener((View view) -> {
                    if (fruit.isFavourite()) {
                        sClickListener.onItemClick(position, false);
                    } else {
                        sClickListener.onItemClick(position, true);
                    }
                });
                break;

            case SECTION:
                AddFavoritesAdapter.SectionHolder sectionHolder = (AddFavoritesAdapter.SectionHolder) holder;
                sectionHolder.mTextViewSection.setText(mList.get(position).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void refreshData(List<ElementList> dataset) {
        mList.clear();
        mList.addAll(dataset);
        notifyDataSetChanged();
    }

    interface MyClickListener {
        void onItemClick(int position, boolean addItem);
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).isSection()) {
            return SECTION;
        } else {
            return NORMAL;
        }
    }
}
