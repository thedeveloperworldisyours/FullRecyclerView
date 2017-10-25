package com.thedeveloperworldisyours.fullrecycleview.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.chat.VerticalData;
import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 25/10/2017.
 */

public class ChatFragment extends Fragment {

    @BindView(R.id.chat_recycler_view)
    RecyclerView mRecyclerView;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.chat_fragment, container, false);
        ButterKnife.bind(this, view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ChatAdapter adapter = new ChatAdapter(getDataSet());
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<VerticalData> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            VerticalData obj = new VerticalData("Hello Text " + index,
                    "22:01 ");
            results.add(index, obj);
        }
        return results;
    }
}
