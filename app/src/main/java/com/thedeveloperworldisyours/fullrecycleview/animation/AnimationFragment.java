package com.thedeveloperworldisyours.fullrecycleview.animation;

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
import com.thedeveloperworldisyours.fullrecycleview.common.DividerVerticalItemDecoration;

import java.util.ArrayList;

public class AnimationFragment extends Fragment implements AnimationRecyclerViewAdapter.MyClickListener {

    private RecyclerView mRecyclerView;
    private AnimationRecyclerViewAdapter mAdapter;
    private static String LOG_TAG = "AnimationFragment-RecyclerViewActivity";

    public AnimationFragment() {
        // Required empty public constructor
    }

    public static AnimationFragment newInstance() {
        return new AnimationFragment();
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

        mRecyclerView = (RecyclerView) view.findViewById(R.id.vertical_fragment_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new AnimationRecyclerViewAdapter(getActivity(), getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerVerticalItemDecoration(getActivity());
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter.setOnItemClickListener(this);

        return view;
    }


    private ArrayList<AnimationData> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            AnimationData obj = new AnimationData("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    public void onItemClick(final int position, View v) {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.vertical_fragment_title_dialog_delete))
                .setMessage(getString(R.string.vertical_fragment_question_delete))
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

    public void addItem() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.vertical_fragment_title_dialog_add))
                .setMessage(getString(R.string.vertical_fragment_question_add))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        actionAdd();
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

    public void actionAdd() {
        AnimationData object = new AnimationData("Some Primary Text " + mAdapter.getItemCount(),
                "Secondary " + mAdapter.getItemCount());
        mAdapter.addItem(object, mAdapter.getItemCount());

        mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

    }
}
