package com.thedeveloperworldisyours.fullrecycleview.indexed;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class IndexedFragment extends Fragment {

    HashMap<String, Integer> mMapIndex;
    String[] mSections;
    List<String> fruits;

    private RecyclerView mRecyclerView;
    private IndexedAdapter mAdapter;

    public IndexedFragment() {
        // Required empty public constructor
    }

    public static IndexedFragment newInstance() {
        return new IndexedFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.indexed_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.indexed_fragment_recycler_view);
        mRecyclerView.setScrollbarFadingEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new IndexedAdapter(getActivity(), getDataSet(), mSections, mMapIndex);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    private ArrayList<ElementList> getDataSet() {

        String[] fruits = getResources().getStringArray(R.array.fruits_array);


        List<String> fruitList = Arrays.asList(fruits);
        getListIndexed(fruitList);

        ArrayList results = new ArrayList<>();
        ElementList obj;
        int section = 0;
        int normal = 0;
        String fruit;
        String ch;
        int total = fruitList.size() + mSections.length;
        for (int index = 0; index < total; index++) {

            fruit = fruitList.get(normal);
            ch = fruit.substring(0, 1);

            if (index == 0 || ch.equals(mSections[section])) {

                obj = new ElementList(ch, true);
                mMapIndex.put(ch, index);
                if (section < mSections.length -1) {
                    section++;
                } else {
                    section = 0;
                }
            } else {
                obj = new ElementList(fruitList.get(normal), false);
                normal++;
            }

            results.add(index, obj);
        }
        return results;
    }


    public void getListIndexed(List<String> fruitList) {

        this.fruits = fruitList;
        mMapIndex = new LinkedHashMap<>();

        for (int x = 0; x < fruits.size(); x++) {
            String fruit = fruits.get(x);
            String ch = fruit.substring(0, 1);
            ch = ch.toUpperCase(Locale.US);

            // HashMap will prevent duplicates
            mMapIndex.put(ch, x);
        }

        Set<String> sectionLetters = mMapIndex.keySet();

        // create a list from the set to sort
        ArrayList<String> sectionList = new ArrayList<>(sectionLetters);

        Collections.sort(sectionList);

        mSections = new String[sectionList.size()];

        sectionList.toArray(mSections);
    }

}
