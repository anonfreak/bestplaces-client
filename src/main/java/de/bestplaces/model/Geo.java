package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by franz on 29.11.2016.
 */
public class Geo {

    @JsonProperty(value = "longitude")
    private double longitude;
    @JsonProperty(value = "latitude")
    private double latitude;

    public Geo(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
