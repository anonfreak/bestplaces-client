package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by franz on 04.05.2017.
 */
public class FullPlace {

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
    @JsonProperty(value = "address")
    private Address address;
    @JsonProperty(value = "phone_number")
    private String phonenumber;
    @JsonProperty(value = "website")
    private String website;
    @JsonProperty(value = "openingHours")
    private List<String> openingHours;
    @JsonProperty(value = "favorite")
    private boolean favorite;
    @JsonProperty(value = "review_list")
    private Review review;

    public FullPlace()
    {

    }

    public FullPlace(String placeID, String name, Geo geo, String formattedAddress, boolean openNow, int averageStar, List<String> pictures, List<String> categories, Address address, String phonenumber, String website, List<String> openingHours, boolean favorite, Review review) {
        this.placeID = placeID;
        this.name = name;
        this.geo = geo;
        this.formattedAddress = formattedAddress;
        this.openNow = openNow;
        this.averageStar = averageStar;
        this.pictures = pictures;
        this.categories = categories;
        this.address = address;
        this.phonenumber = phonenumber;
        this.website = website;
        this.openingHours = openingHours;
        this.favorite = favorite;
        this.review = review;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<String> openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
