package com.thedeveloperworldisyours.fullrecycleview.swipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.daimajia.swipe.util.Attributes;
import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.swipe.adapter.SwipeRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by javierg on 12/10/2016.
 */

public class SwipeListFragment extends Fragment {

    private ArrayList<Employee> mDataSet;

    public static SwipeListFragment newInstance() {
        SwipeListFragment fragment = new SwipeListFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_swipe_recycler_view);

        SwipeRecyclerViewAdapter adapter = new SwipeRecyclerViewAdapter(getActivity(), mDataSet);

//        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

//         Layout Managers:
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDataSet = new ArrayList<Employee>();

        loadData();

        if (mDataSet.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
//        tvEmptyView.setVisibility(View.VISIBLE);

        } else {
            recyclerView.setVisibility(View.VISIBLE);
//        tvEmptyView.setVisibility(View.GONE);
        }

        // Creating Adapter object
        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(getActivity(), mDataSet);

        // Setting Mode to Single to reveal bottom View for one item in List
        // Setting Mode to Mutliple to reveal bottom Views for multile items in List
        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        recyclerView.setAdapter(mAdapter);

        /* Scroll Listeners */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        return view;
    }


    // load initial data
    public void loadData() {

        for (int i = 0; i <= 20; i++) {
            mDataSet.add(new Employee("Employee " + i, "androidstudent" + i + "@gmail.com"));

        }

    }

}