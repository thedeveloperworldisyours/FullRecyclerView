package com.thedeveloperworldisyours.fullrecycleview.addfavorites.model;

/**
 * Created by javierg on 03/08/2017.
 */

public class ElementList {

    private String mName;
    boolean section;

    public ElementList(String mName, boolean section) {
        this.mName = mName;
        this.section = section;
    }

    public ElementList() {
    }


    public boolean isSection() {
        return section;
    }

    public void setSection(boolean section) {
        this.section = section;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

}
