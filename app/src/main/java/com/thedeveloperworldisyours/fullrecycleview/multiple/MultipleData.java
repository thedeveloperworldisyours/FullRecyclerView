package com.thedeveloperworldisyours.fullrecycleview.multiple;

/**
 * Created by javierg on 01/02/2017.
 */

public class MultipleData {

    private String mTitle;
    private boolean mBoolean;

    public MultipleData(String title, boolean mBoolean) {
        this.mTitle = title;
        this.mBoolean = mBoolean;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean isBoolean() {
        return mBoolean;
    }

    public void setBoolean(boolean mBoolean) {
        this.mBoolean = mBoolean;
    }
}
