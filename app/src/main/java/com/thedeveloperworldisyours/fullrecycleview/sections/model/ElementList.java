package com.thedeveloperworldisyours.fullrecycleview.sections.model;

/**
 * Created by javierg on 05/07/2017.
 */

public class ElementList {

    private String mName;
    boolean section;

    public ElementList(String mName, boolean section) {
        this.mName = mName;
        this.section = section;
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
