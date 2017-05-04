package de.bestplaces.model;

/**
 * Created by franz on 04.05.2017.
 */
public class FullPlace {

    private int placeID;
    private String name;
    private Geo geo;
    private Adress adress;
    private String phonenumber;
    private String website;
    private int[] openingHours;
    private boolean favourite;
    private String reviewText;
    private int averageStar;
    private Review review;

    public FullPlace(int placeID, String name, Geo geo, Adress adress, String phonenumber, String website, int[] openingHours, boolean favourite, String reviewText, int averageStar, Review review) {
        this.placeID = placeID;
        this.name = name;
        this.geo = geo;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.website = website;
        this.openingHours = openingHours;
        this.favourite = favourite;
        this.reviewText = reviewText;
        this.averageStar = averageStar;
        this.review = review;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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

    public int[] getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(int[] openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getAverageStar() {
        return averageStar;
    }

    public void setAverageStar(int averageStar) {
        this.averageStar = averageStar;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
