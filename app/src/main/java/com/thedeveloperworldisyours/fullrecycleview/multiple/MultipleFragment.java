package com.thedeveloperworldisyours.fullrecycleview.multiple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.swipe.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MultipleFragment extends Fragment implements MultipleRecyclerViewAdapter.MultipleClickListener{

    MultipleRecyclerViewAdapter mAdapter;

    public MultipleFragment() {
        // Required empty public constructor
    }

    public static MultipleFragment newInstance() {
        return new MultipleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.multiple_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.multiple_fragment_recycler_view);

        MultipleData hendrix = new MultipleData("Jimi Hendrix", false);
        MultipleData bowie = new MultipleData("David Bowie", false);
        MultipleData morrison = new MultipleData("Jim Morrison", false);

        MultipleData presley = new MultipleData("Elvis Presley", false);
        MultipleData jagger = new MultipleData("Mick Jagger", false);
        MultipleData cobain = new MultipleData("Kurt Cobain", false);

        MultipleData dylan = new MultipleData("Bob Dylan", false);
        MultipleData lennon = new MultipleData("John Lennon", false);
        MultipleData mercury = new MultipleData("Freddie Mercury", false);

        MultipleData elton = new MultipleData("Elton John", false);
        MultipleData clapton = new MultipleData("Eric Clapton", false);

        List<MultipleData> list = new ArrayList<>();
        list.add(0, hendrix);
        list.add(1, bowie);
        list.add(2, morrison);

        list.add(3, presley);
        list.add(4, jagger);
        list.add(5, cobain);

        list.add(6, dylan);
        list.add(7, lennon);
        list.add(8, mercury);

        list.add(9, elton);
        list.add(10, clapton);

        mAdapter = new MultipleRecyclerViewAdapter(list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(int position, View v) {
        mAdapter.changedData(position);
    }
}
