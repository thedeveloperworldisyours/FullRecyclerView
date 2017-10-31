package com.thedeveloperworldisyours.fullrecycleview.updateData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.common.DividerVerticalItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 30/10/2017.
 */

public class UpdateDataFragment extends Fragment implements UpdateDataAdapter.UpdateDataClickListener {

    @BindView(R.id.update_fragment_recycler_view)
    RecyclerView mRecyclerView;

    private UpdateDataAdapter mAdapter;

    private static final int MULTIPLE = 0;

    public UpdateDataFragment() {
        // Required empty public constructor
    }

    public static UpdateDataFragment newInstance() {
        return new UpdateDataFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_data_fragment, container, false);
        ButterKnife.bind(this, view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new UpdateDataAdapter(getDataSet(), getActivity(), MULTIPLE);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerVerticalItemDecoration(getActivity());
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter.setOnItemClickListener(this);
        return view;
    }

    private ArrayList<UpdateData> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            UpdateData obj = new UpdateData("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    public void onItemClick(int position) {
        mAdapter.selected(position);
    }

    public void changeMode(int modo) {
        mAdapter.changeMode(modo);
    }

}
