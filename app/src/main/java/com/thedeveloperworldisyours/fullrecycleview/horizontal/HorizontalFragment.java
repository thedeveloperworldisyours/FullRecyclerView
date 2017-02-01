package com.thedeveloperworldisyours.fullrecycleview.horizontal;

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

public class HorizontalFragment extends Fragment implements HorizontalRecyclerViewAdapter.MyClickListener{
    private RecyclerView mRecyclerView;
    private HorizontalRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    public HorizontalFragment() {
        // Required empty public constructor
    }

    public static HorizontalFragment newInstance() {
        HorizontalFragment fragment = new HorizontalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.horizontal_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_horizontal_recycler_view);
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);//new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new HorizontalRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter.setOnItemClickListener(this);


        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);


        return view;
    }

    private ArrayList<HorizontalData> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            HorizontalData obj = new HorizontalData("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }


    @Override
    public void onItemClick(int position, View v) {
        Log.i(LOG_TAG, " Clicked on Item " + position);
    }
}
