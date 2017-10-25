package com.thedeveloperworldisyours.fullrecycleview.chat;

/**
 * Created by javierg on 25/01/2017.
 */

public class ChatData {
    private int element;
    private String mTitle;
    private String mTime;


    public ChatData(int element, String mTitle, String mSubTitle) {
        this.element = element;
        this.mTitle = mTitle;
        this.mTime = mSubTitle;
    }

    public int getElement() {
        return element;
    }

    public String getTitle() {
        return mTitle;
    }


    public String getTime() {
        return mTime;
    }

}