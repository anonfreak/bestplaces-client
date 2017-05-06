package de.bestplaces.model;

/**
 * Created by franz on 29.11.2016.
 */
public class Address {

    private String street;
    private int houseNumber;
    private String town;
    private int zipCode;

    public Address(String street, int houseNumber, String town, int zipCode) {
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
