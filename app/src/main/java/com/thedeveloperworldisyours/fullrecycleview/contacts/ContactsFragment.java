package com.thedeveloperworldisyours.fullrecycleview.contacts;

/**
 * Created by javierg on 18/09/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import com.thedeveloperworldisyours.fullrecycleview.R;

import br.com.stickyindex.StickyIndex;

public class ContactsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    char[] mIndexList;


    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contacts_fragment, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        StickyIndex indexContainer = (StickyIndex) rootView.findViewById(R.id.sticky_index_container);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        String[] fruits = getResources().getStringArray(R.array.fruits_array);

        List<String> fruitList = Arrays.asList(fruits);
        mIndexList = getIndexList(fruitList);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter (fruitList, mIndexList);
        mRecyclerView.setAdapter(adapter);

        indexContainer.setDataSet(mIndexList);
        indexContainer.setOnScrollListener(mRecyclerView);

        return rootView;
    }

    private char[] getIndexList (List<String> list) {
        char[] result = new char[list.size()];
        int i = 0;

        for (String c : list) {
            result[i] = c.charAt(0);
            i++;
        }

        return result;
    }

}
