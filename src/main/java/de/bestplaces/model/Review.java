package de.bestplaces.model;

/**
 * Created by franz on 29.11.2016.
 */
public class Review {

    private int stars;
    private boolean showName;
    private String text;

    public Review(int stars, boolean showName, String text) {
        this.stars = stars;
        this.showName = showName;
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isShowName() {
        return showName;
    }

    public void setShowName(boolean showName) {
        this.showName = showName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
