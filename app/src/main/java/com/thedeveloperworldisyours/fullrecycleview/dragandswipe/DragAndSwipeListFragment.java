package com.thedeveloperworldisyours.fullrecycleview.dragandswipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.adapter.DragAndSwipeRecyclerListAdapter;
import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.helper.OnStartDragListener;
import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.helper.SimpleItemTouchHelperCallback;

/**
 * Created by javierg on 12/10/2016.
 */

public class DragAndSwipeListFragment extends Fragment implements OnStartDragListener {

    private ItemTouchHelper mItemTouchHelper;

    public DragAndSwipeListFragment() {
    }

    public static DragAndSwipeListFragment newInstance() {
        DragAndSwipeListFragment fragment = new DragAndSwipeListFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DragAndSwipeRecyclerListAdapter adapter = new DragAndSwipeRecyclerListAdapter(getActivity(), this);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
