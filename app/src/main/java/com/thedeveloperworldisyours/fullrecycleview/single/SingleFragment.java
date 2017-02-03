package com.thedeveloperworldisyours.fullrecycleview.single;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.common.DividerVerticalItemDecoration;

public class SingleFragment extends Fragment implements SingleRecyclerViewAdapter.SingleClickListener {

    SingleRecyclerViewAdapter mAdapter;

    public SingleFragment() {
        // Required empty public constructor
    }

    public static SingleFragment newInstance() {
        return new SingleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.single_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.single_fragment_recycler_view);

        String[] list = new String[]{"Jimi Hendrix", "David Bowie", "Jim Morrison", "Elvis Presley",
                "Mick Jagger", "Kurt Cobain", "Bob Dylan", "John Lennon", "Freddie Mercury", "Elton John", "Eric Clapton"};

        mAdapter = new SingleRecyclerViewAdapter(list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration =
                new DividerVerticalItemDecoration(getActivity());
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClickListener(int position, View view) {
        mAdapter.selectedItem();
    }
}
