package com.thedeveloperworldisyours.fullrecycleview.multipleclicks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.common.DividerVerticalItemDecoration;
import com.thedeveloperworldisyours.fullrecycleview.multiple.MultipleData;
import com.thedeveloperworldisyours.fullrecycleview.multiple.MultipleRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 16/11/2017.
 */

public class MultipleClicksFragment extends Fragment implements MultipleClicksAdapter.MultipleClickListener {

    MultipleClicksAdapter mAdapter;

    @BindView(R.id.multiple_clicks_fragment_recycler_view)
    RecyclerView mRecyclerView;

    public MultipleClicksFragment() {
        // Required empty public constructor
    }

    public static MultipleClicksFragment newInstance() {
        return new MultipleClicksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.multiple_clicks_fragment, container, false);

        ButterKnife.bind(this, view);

        mAdapter = new MultipleClicksAdapter(getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration =
                new DividerVerticalItemDecoration(getActivity());
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.setOnItemClickListener(this);

        return view;
    }

    public ArrayList<MultipleClickData> getData() {

        ArrayList<MultipleClickData> list = new ArrayList<>();
        MultipleClickData one = new MultipleClickData("One", "Two", "Three");
        MultipleClickData two = new MultipleClickData("One", "Two", "Three");
        MultipleClickData three = new MultipleClickData("One", "Two", "Three");

        MultipleClickData one1 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData two1 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData three1 = new MultipleClickData("One", "Two", "Three");

        MultipleClickData one2 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData two2 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData three2 = new MultipleClickData("One", "Two", "Three");

        list.add(one);
        list.add(two);
        list.add(three);

        list.add(one1);
        list.add(two1);
        list.add(three1);

        list.add(one2);
        list.add(two2);
        list.add(three2);

        return list;

    }

    @Override
    public void onItemClickOne(int position, View v) {

    }

    @Override
    public void onItemClickTwo(int position, View v) {

    }

    @Override
    public void onItemClickThree(int position, View v) {

    }

}
