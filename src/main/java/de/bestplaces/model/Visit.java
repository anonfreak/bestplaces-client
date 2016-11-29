package de.bestplaces.model;

import com.vaadin.ui.Calendar;

/**
 * Created by franz on 25.11.2016.
 */
public class Visit {
    private int visitId;
    private User user;
    private Place place;
    private Calendar visitTime;
    private String notes;
    private double money;

    public Visit(int visitId, User user, Place place, Calendar visitTime, String notes, double money) {
        this.visitId = visitId;
        this.user = user;
        this.place = place;
        this.visitTime = visitTime;
        this.notes = notes;
        this.money = money;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Calendar getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Calendar visitTime) {
        this.visitTime = visitTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
