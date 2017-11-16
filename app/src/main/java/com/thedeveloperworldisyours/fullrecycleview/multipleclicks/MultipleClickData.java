package com.thedeveloperworldisyours.fullrecycleview.multipleclicks;

/**
 * Created by javierg on 16/11/2017.
 */

public class MultipleClickData {

    private String mTitle;
    private String mSubTitle;
    private String mThirdTitle;

    MultipleClickData(String title, String subTitle, String thirdTitle) {
        mTitle = title;
        mSubTitle = subTitle;
        mThirdTitle = thirdTitle;
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

    public String getmThirdTitle() {
        return mThirdTitle;
    }

    public void setmThirdTitle(String mThirdTitle) {
        this.mThirdTitle = mThirdTitle;
    }
}
