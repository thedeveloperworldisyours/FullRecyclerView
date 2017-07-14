package com.thedeveloperworldisyours.fullrecycleview.sections.model;

/**
 * Created by javierg on 04/07/2017.
 */

public class EventDomain extends ElementList{

    private String mImage;
    private String mVenue;
    private String mLocalDate;
    private String mGenre;
    private boolean mFavourite;

    public EventDomain(String name, String image, String venue, String localDate, String genre) {
        this.setName(name);
        this.mImage = image;
        this.mVenue = venue;
        this.mLocalDate = localDate;
        this.mGenre = genre;
        this.setSection(false);
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }

    public String getVenue() {
        return mVenue;
    }

    public void setVenue(String mVenue) {
        this.mVenue = mVenue;
    }

    public String getLocalDate() {
        return mLocalDate;
    }

    public void setLocalDate(String localDate) {
        this.mLocalDate = localDate;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        this.mGenre = genre;
    }

    public boolean isFavourite() {
        return mFavourite;
    }

    public void setFavourite(boolean mFavourite) {
        this.mFavourite = mFavourite;
    }
}
