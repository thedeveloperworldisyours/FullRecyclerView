package com.thedeveloperworldisyours.fullrecycleview.addfavorites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.fullrecycleview.R;
import com.thedeveloperworldisyours.fullrecycleview.addfavorites.model.ElementList;
import com.thedeveloperworldisyours.fullrecycleview.addfavorites.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class AddFavoritesFragment extends Fragment implements AddFavoritesAdapter.MyClickListener {

    private ArrayList<ElementList> mList;
    private RecyclerView mRecyclerView;
    private AddFavoritesAdapter mAdapter;
    private ArrayList<ElementList> mFavoritesAndHeadersList;
    private ArrayList<Fruit> mRestList;

    public AddFavoritesFragment() {
        // Required empty public constructor
    }

    public static AddFavoritesFragment newInstance() {
        return new AddFavoritesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_favorites_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.add_favorites_fragment_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mList = getDataSet();
        mAdapter = new AddFavoritesAdapter(getActivity(), mList);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mRestList = new ArrayList<>();
        mFavoritesAndHeadersList = new ArrayList<>();

        return view;
    }

    private ArrayList<ElementList> getDataSet() {
        Fruit elementList;
        ArrayList results = new ArrayList<>();
        String[] fruits = getResources().getStringArray(R.array.fruits_array);

        for (int i = 0; i < fruits.length; i++) {
            elementList = new Fruit(fruits[i], false, i, false);
            results.add(i, elementList);
        }
        return results;
    }

    @Override
    public void onItemClick(int position, boolean addItem) {
        if (addItem) {
            mAdapter.refreshData(addFavorite(mList, position));
        } else {
            mAdapter.refreshData(deleteFavorite(mList, position));
        }
    }

    public List<ElementList> addFavorite(List<ElementList> list, int position) {

        List<ElementList> result = new ArrayList<>();
        Fruit fruit = (Fruit) list.get(position);
        fruit.setFavourite(true);


        result.add(0, new ElementList(getString(R.string.add_favorites_title), true));
        result.add(1, list.get(position));


        if (list.get(0).isSection()) {

            mFavoritesAndHeadersList.clear();
            //filled Favorite List
            mFavoritesAndHeadersList.add(0, new ElementList(getString(R.string.add_favorites_title), true));
            for (int i = 1; i < list.size(); i++) {
                if (i == 1) {
                    mFavoritesAndHeadersList.add(i, fruit);
                    mFavoritesAndHeadersList.add(i + 1, list.get(i));
                } else {
                    mFavoritesAndHeadersList.add(i + 1, list.get(i));
                    if (list.get(i).isSection()) {
                        break;
                    }
                }
            }

            //filled result List
            for (int i = 1; i < list.size(); i++) {
                if (position > i) {
                    result.add(i + 1, list.get(i));
                } else if (position < i) {
                    result.add(i, list.get(i));
                }
            }

            //removed item from rest list
            mRestList.remove(fruit);

        } else {
            //first favorite
            mFavoritesAndHeadersList.add(0, new ElementList(getString(R.string.add_favorites_title), true));
            mFavoritesAndHeadersList.add(1, list.get(position));
            mFavoritesAndHeadersList.add(2, new ElementList(getString(R.string.add_favorites_no_favorites), true));

            result.add(2, new ElementList(getString(R.string.add_favorites_no_favorites), true));

            for (int i = 0; i < list.size(); i++) {
                if (position > i) {
                    result.add(i + 3, list.get(i));
                    mRestList.add(i, (Fruit) list.get(i));
                } else if (position < i) {
                    result.add(i + 2, list.get(i));
                    mRestList.add(i - 1, (Fruit) list.get(i));
                }
            }
        }


        return result;
    }

    public List<ElementList> deleteFavorite(List<ElementList> list, int position) {

        List<ElementList> result = new ArrayList<>();
        Fruit fruit = (Fruit) list.get(position);
        fruit.setFavourite(false);
        mFavoritesAndHeadersList.remove(fruit);
        boolean addedFruit = false;

        if (countFavorite(list) > 0) {

            //Added favorites and headers
            for (int i = 0; i < mFavoritesAndHeadersList.size(); i++) {
                result.add(mFavoritesAndHeadersList.get(i));
            }
            //Added rest of elements
            for (int i = 0; i < mRestList.size(); i++) {
                if (fruit.getIndex() > mRestList.get(i).getIndex()) {
                    result.add(mRestList.get(i));
                } else {
                    if (!addedFruit) {

                        result.add(fruit);
                        addedFruit = true;
                    }
                    result.add(mRestList.get(i));
                }

            }

        } else {
            //there is not favorite remove both header
            result = getDataSet();
            mFavoritesAndHeadersList.clear();
            mRestList.clear();
        }
        return result;
    }

    private int countFavorite(List<ElementList> list) {
        int number = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isSection()) {
                if (((Fruit) list.get(i)).isFavourite()) {
                    number++;
                }
            }
        }
        return number;
    }

}
