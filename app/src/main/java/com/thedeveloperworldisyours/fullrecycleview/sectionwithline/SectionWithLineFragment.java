package com.thedeveloperworldisyours.fullrecycleview.sectionwithline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionWithLineFragment extends Fragment {

    HashMap<String, Integer> mMapIndex;
    String[] mSections;
    List<String> fruits;

    @BindView(R.id.section_with_line_fragment_recycler_view)
    RecyclerView mRecyclerView;

    SectionWithLineAdapter mAdapter;

    public SectionWithLineFragment() {
        // Required empty public constructor
    }

    public static SectionWithLineFragment newInstance() {
        return new SectionWithLineFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.section_with_line_fragment, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView.setScrollbarFadingEnabled(true);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new SectionWithLineAdapter(getActivity(), getDataSet(), mSections, mMapIndex);
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
        String fruit, fruitPlus;
        String ch, chPlus;
        int total = fruitList.size() + mSections.length;

        for (int index = 0; index < total; index++) {

            fruit = fruitList.get(normal);
            ch = fruit.substring(0, 1);

            if (index == 0 || ch.equals(mSections[section])) {
                if (index != 0) {
                    obj = new ElementList(fruitList.get(normal-1), false, true);
                    results.add(index-1, obj);
                }
                obj = new ElementList(ch, true, false);
                mMapIndex.put(ch, index);
                if (section < mSections.length - 1) {
                    section++;
                } else {
                    section = 0;
                }
            } else {

                obj = new ElementList(fruitList.get(normal), false, false);

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
