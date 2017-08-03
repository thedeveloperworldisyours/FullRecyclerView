package com.thedeveloperworldisyours.fullrecycleview.addfavorites.model;

/**
 * Created by javierg on 03/08/2017.
 */

public class Section extends ElementList {
    public Section(String name) {
        this.setName(name);
        this.setSection(true);
    }
}
