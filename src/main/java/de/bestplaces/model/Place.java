package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaadin.ui.Image;

import java.util.List;

/**
 * Created by franz on 25.11.2016.
 */
public class Place {

    @JsonProperty(value = "placeId")
    private String placeID;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "geo")
    private Geo geo;
    @JsonProperty(value = "formatted_address")
    private String formattedAddress;
    @JsonProperty(value = "openNow")
    private boolean openNow;
    @JsonProperty(value = "rating")
    private int averageStar;
    @JsonProperty(value = "photos")
    private List<String> pictures;
    @JsonProperty(value = "categories")
    private List<String> categories;

    public Place(){

    }

    public Place(String placeId, String name, Geo geo, String formattedAddress, boolean openNow, int averageStar, List<String> pictures, List<String> categories) {
        this.placeID = placeId;
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