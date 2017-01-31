package com.thedeveloperworldisyours.fullrecycleview.vertical;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.swipe.DividerItemDecoration;

import java.util.ArrayList;

public class VerticalFragment extends Fragment implements VerticalRecyclerViewAdapter.MyClickListener, VerticalListener {

    private RecyclerView mRecyclerView;
    private VerticalRecyclerViewAdapter mAdapter;
    private static String LOG_TAG = "VerticalFragment-RecyclerViewActivity";

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
        mAdapter.setOnItemClickListener(this);

        return view;
    }


    private ArrayList<com.thedeveloperworldisyours.fullrecycleview.vertical.Data> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            com.thedeveloperworldisyours.fullrecycleview.vertical.Data obj = new com.thedeveloperworldisyours.fullrecycleview.vertical.Data("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    public void onItemClick(final int position, View v) {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.vertical_fragment_title_dialog))
                .setMessage(getString(R.string.vertical_fragment_question))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        mAdapter.deleteItem(position);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void addItem() {
        com.thedeveloperworldisyours.fullrecycleview.vertical.Data object = new com.thedeveloperworldisyours.fullrecycleview.vertical.Data("Some Primary Text " + mAdapter.getItemCount(),
                "Secondary " + mAdapter.getItemCount());
        mAdapter.addItem(object, mAdapter.getItemCount());

    }
}
