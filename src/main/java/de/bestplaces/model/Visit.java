package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by franz on 25.11.2016.
 */
public class Visit {
    @JsonProperty(value = "visitid")
    private int visitId;
    @JsonProperty(value = "place")
    private String placeId;
    @JsonProperty(value = "user")
    private String userString;
    @JsonProperty(value = "visittime")
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Date visitTime;
    @JsonProperty(value = "money")
    private double money;
    @JsonProperty(value = "notes")
    private String notes;
    @JsonIgnore
    @JsonProperty(value = "duration")
    private int duration;

    public Visit()
    {

    }

    public Visit(String placeId, String userString, Date visitTime, double money, String notes) {
        this.placeId = placeId;
        this.userString = userString;
        this.visitTime = visitTime;
        this.money = money;
        this.notes = notes;
    }

    public Visit(int visitId, String placeId, String userString, Date visitTime, double money, String notes) {
        this.visitId = visitId;
        this.placeId = placeId;
        this.userString = userString;
        this.visitTime = visitTime;
        this.money = money;
        this.notes = notes;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getUserString() {
        return userString;
    }

    public void setUserString(String userString) {
        this.userString = userString;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public String getFormattedVisitTime()
    {
        Date today = getVisitTime();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
        String time = formatter.format(today);
        return time;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
