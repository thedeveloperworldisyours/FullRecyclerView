package com.thedeveloperworldisyours.fullrecycleview.sections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.sections.model.ElementList;

import java.util.ArrayList;

public class SectionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SectionAdapter mAdapter;

    public SectionFragment() {
        // Required empty public constructor
    }

    public static SectionFragment newInstance() {
        SectionFragment fragment = new SectionFragment();
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
        View view = inflater.inflate(R.layout.section_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.event_fragment_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new SectionAdapter(getActivity(), getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private ArrayList<ElementList> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 30; index++) {

            ElementList obj;

            if (index == 0 || index % 5 == 0) {
                obj = new ElementList("" + index, true);
            } else {
                obj = new ElementList("" + index, false);
            }

            results.add(index, obj);
        }
        return results;
    }

}
