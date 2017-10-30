package com.thedeveloperworldisyours.fullrecycleview.updateData;

/**
 * Created by javierg on 25/01/2017.
 */

public class UpdateData {
    private String mTitle;
    private String mSubTitle;

    UpdateData(String title, String subTitle){
        mTitle = title;
        mSubTitle = subTitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSubTitle() {
        return mSubTitle;
    }

    public void setmSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }
}