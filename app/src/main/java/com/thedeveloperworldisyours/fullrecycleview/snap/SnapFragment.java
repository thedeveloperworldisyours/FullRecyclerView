package com.thedeveloperworldisyours.fullrecycleview.snap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

public class SnapFragment extends Fragment {

    public SnapFragment() {
        // Required empty public constructor
    }

    public static SnapFragment newInstance() {
        return new SnapFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.snap_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.snap_fragment_horizontal_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));

        SnapData dataThe = new SnapData("The", R.drawable.thedeveloperworldisyours);
        SnapData dataDeveloper = new SnapData("Developer", R.drawable.thedeveloperworldisyours);
        SnapData dataWorld = new SnapData("World", R.drawable.thedeveloperworldisyours);
        SnapData dataIs = new SnapData("Is", R.drawable.thedeveloperworldisyours);
        SnapData dataYours = new SnapData("Yours", R.drawable.thedeveloperworldisyours);
        SnapData dataCom = new SnapData(".com", R.drawable.thedeveloperworldisyours);

        ArrayList<SnapData> list = new ArrayList<>();

        list.add(0, dataThe);
        list.add(1, dataDeveloper);
        list.add(2, dataWorld);
        list.add(3, dataIs);
        list.add(4, dataYours);
        list.add(5, dataCom);

        SnapHorizontalRecyclerViewAdapter adapter = new SnapHorizontalRecyclerViewAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
