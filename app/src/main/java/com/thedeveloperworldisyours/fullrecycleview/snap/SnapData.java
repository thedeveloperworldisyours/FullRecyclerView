package com.thedeveloperworldisyours.fullrecycleview.snap;

/**
 * Created by javierg on 06/02/2017.
 */

public class SnapData {
    private String mText;
    private int mImage;

    public SnapData(String text, int image) {
        this.mText = text;
        this.mImage = image;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = image;
    }
}
