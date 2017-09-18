package com.thedeveloperworldisyours.fullrecycleview.stickyheader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;

/**
 * Created by javierg on 18/09/2017.
 */

public class StickyHeaderFragment extends Fragment {

    public StickyHeaderFragment() {
        // Required empty public constructor
    }

    public static StickyHeaderFragment newInstance() {
        return new StickyHeaderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.sticky_header_fragment, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        // Set adapter populated with example dummy data
        final AnimalsHeadersAdapter adapter = new AnimalsHeadersAdapter(getActivity());
        adapter.add("");
        adapter.addAll(getDummyDataSet());
        recyclerView.setAdapter(adapter);

        // Set layout manager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Add the sticky headers decoration
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(adapter);
        recyclerView.addItemDecoration(headersDecor);


        // Add touch listeners
        StickyRecyclerHeadersTouchListener touchListener =
                new StickyRecyclerHeadersTouchListener(recyclerView, headersDecor);
        touchListener.setOnHeaderClickListener((View header, int position, long headerId) -> {
            Toast.makeText(getActivity(), "Header position: " + position + ", id: " + headerId,
                    Toast.LENGTH_SHORT).show();
        });
        recyclerView.addOnItemTouchListener(touchListener);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                headersDecor.invalidateHeaders();
            }
        });

        return view;
    }

    private String[] getDummyDataSet() {
        return getResources().getStringArray(R.array.animals);
    }

}
