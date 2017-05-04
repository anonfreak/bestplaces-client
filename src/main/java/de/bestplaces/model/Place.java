package de.bestplaces.model;

import com.vaadin.ui.Image;

import java.util.List;

/**
 * Created by franz on 25.11.2016.
 */
public class Place {

    private String placeID;
    private String name;
    private Geo geo;
    private String formattedAddress;
    private boolean openNow;
    private int averageStar;
    private List<String> pictures;
    private List<String> categories;

    public Place(String placeID, String name, Geo geo, String formattedAddress, boolean openNow, int averageStar, List<String> pictures, List<String> categories) {
        this.placeID = placeID;
        this.name = name;
        this.geo = geo;
        this.formattedAddress = formattedAddress;
        this.openNow = openNow;
        this.averageStar = averageStar;
        this.pictures = pictures;
        this.categories = categories;
    }

    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    public int getAverageStar() {
        return averageStar;
    }

    public void setAverageStar(int averageStar) {
        this.averageStar = averageStar;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
