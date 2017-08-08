package com.thedeveloperworldisyours.fullrecycleview.sectionwithline;

/**
 * Created by javierg on 08/08/2017.
 */

public class ElementList {

    private String mName;
    boolean mSection;
    boolean mNextSection;


    public ElementList(String name, boolean section, boolean nextSection) {
        this.mName = name;
        this.mSection = section;
        this.mNextSection = nextSection;
    }

    public boolean isSection() {
        return mSection;
    }

    public void setSection(boolean mSection) {
        this.mSection = mSection;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public boolean ismNextSection() {
        return mNextSection;
    }

    public void setmNextSection(boolean mNextSection) {
        this.mNextSection = mNextSection;
    }

}

