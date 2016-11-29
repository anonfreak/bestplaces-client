package de.bestplaces.model;

/**
 * Created by franz on 29.11.2016.
 */
public class Geo {

    private double longitude;
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
