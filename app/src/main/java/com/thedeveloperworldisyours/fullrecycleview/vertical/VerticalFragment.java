package com.thedeveloperworldisyours.fullrecycleview.vertical;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.swipe.DividerItemDecoration;

import java.util.ArrayList;

public class VerticalFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    public VerticalFragment() {
        // Required empty public constructor
    }

    public static VerticalFragment newInstance() {
        return new VerticalFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.vertical_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_vertical_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new VerticalRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((VerticalRecyclerViewAdapter) mAdapter).setOnItemClickListener(new VerticalRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<com.thedeveloperworldisyours.fullrecycleview.vertical.Data> getDataSet() {
        ArrayList results = new ArrayList<com.thedeveloperworldisyours.fullrecycleview.horizontal.Data>();
        for (int index = 0; index < 20; index++) {
            com.thedeveloperworldisyours.fullrecycleview.vertical.Data obj = new com.thedeveloperworldisyours.fullrecycleview.vertical.Data("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

}
