package com.thedeveloperworldisyours.fullrecycleview.sections;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.sections.model.ElementList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 14/07/2017.
 */

public class SectionAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private static final int SECTION = 0;
    private static final int NORMAL = 1;
    private Context mContext;
    private List<ElementList> mList;
    private static SectionAdapter.MyClickListener sClickListener;
    // Allows to remember the last item shown on screen
    private int mLastPosition = -1;
    static class SectionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.section_list_item_text)
        TextView mTextViewSection;

        SectionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        @BindView(R.id.section_item_name)
        TextView mName;




        DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setOnItemClickListener(SectionAdapter.MyClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    public SectionAdapter(Context context, List<ElementList> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_item_list, parent, false);

        View viewSection = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_section_list_item, parent, false);

        switch (viewType) {
            case NORMAL:
                return new DataObjectHolder(view);
            case SECTION:
                return new SectionHolder(viewSection);
            default:
                return new SectionHolder(viewSection);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case NORMAL:
                DataObjectHolder dataObjectHolder = (DataObjectHolder) holder;
                dataObjectHolder.mName.setText(mList.get(position).getName());
                setAnimation(dataObjectHolder.itemView, position);
                break;

            case SECTION:
                SectionHolder sectionHolder = (SectionHolder) holder;
                sectionHolder.mTextViewSection.setText(mList.get(position).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > mLastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            mLastPosition = position;
        }
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
