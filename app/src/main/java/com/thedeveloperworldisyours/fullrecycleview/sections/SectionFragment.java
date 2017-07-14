package com.thedeveloperworldisyours.fullrecycleview.sections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.vertical.VerticalRecyclerViewAdapter;

public class SectionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private VerticalRecyclerViewAdapter mAdapter;

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

        return view;
    }

}
