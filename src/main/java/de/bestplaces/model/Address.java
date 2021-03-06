package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by franz on 29.11.2016.
 */
public class Address {

    @JsonProperty(value = "street")
    private String street;
    @JsonProperty(value = "streetNumber")
    private int houseNumber;
    @JsonProperty(value = "town")
    private String town;
    @JsonProperty(value = "zipCode")
    private String zipCode;

    public Address()
    {

    }

    public Address(String street, int houseNumber, String town, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.town = town;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
