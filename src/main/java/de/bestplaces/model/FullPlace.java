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
    @JsonProperty(value = "\n" +
            "categories restaurant, food, poi")
    private List<String> categories;

    private Address address;
    private String phonenumber;
    private String website;
   // private OpeningHours[] openingHours;
    private boolean favourite;
    private Review review;


    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
