package com.thedeveloperworldisyours.fullrecycleview.multipleclicks;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

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

        MultipleClickData one3 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData two3 = new MultipleClickData("One", "Two", "Three");
        MultipleClickData three3 = new MultipleClickData("One", "Two", "Three");

        list.add(one);
        list.add(two);
        list.add(three);

        list.add(one1);
        list.add(two1);
        list.add(three1);

        list.add(one2);
        list.add(two2);
        list.add(three2);

        list.add(one3);
        list.add(two3);
        list.add(three3);

        return list;

    }

    @Override
    public void onItemClickOne(int position, View v) {
        showDialog(0);
    }

    @Override
    public void onItemClickTwo(int position, View v) {
        showDialog(1);
    }

    @Override
    public void onItemClickThree(int position, View v) {
        showDialog(2);
    }

    public void showDialog(int type) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.multiple_clicks_dialog);

        ImageView imageView = (ImageView) dialog.findViewById(R.id.dialgo_multiple_clicks_close_imageView);
        TextView oneText = (TextView) dialog.findViewById(R.id.dialog_multiple_clicks_one_textView);
        TextView twoText = (TextView) dialog.findViewById(R.id.dialog_multiple_clicks_two_textView);
        TextView threeText = (TextView) dialog.findViewById(R.id.dialog_multiple_clicks_three_textView);

        switch (type) {
            case 0:
                oneText.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.black));
                oneText.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_multiple_clicks_blue));
                break;
            case 1:
                twoText.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.black));
                twoText.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_multiple_clicks_blue));
                break;
            case 2:
                threeText.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.black));
                threeText.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_multiple_clicks_blue));
                break;
        }

        imageView.setOnClickListener((View view) -> dialog.dismiss());

        dialog.setCancelable(true);
        dialog.show();
    }

}
