package com.thedeveloperworldisyours.fullrecycleview.addfavorites.model;

/**
 * Created by javierg on 03/08/2017.
 */

public class Fruit extends ElementList {


    private int mIndex;
    private boolean mFavourite;

    public Fruit(String name, boolean section, int index, boolean favourite) {
        this.setName(name);
        this.setSection(false);
        this.mIndex = index;
        this.mFavourite = favourite;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    public boolean isFavourite() {
        return mFavourite;
    }

    public void setFavourite(boolean mFavourite) {
        this.mFavourite = mFavourite;
    }
}
