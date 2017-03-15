package pl.sdacademy.model;

/**
 * Created by RENT on 2017-03-15.
 */
public class Address {

    private String streetName;
    private String houseNumber;
    private String flatNumber;
    private String postalCode;
    private String city;
    private String country;
    private StreetPrefix streetPrefix;


    public Address() {
    }

    public Address(String streetName, String houseNumber, String flatNumber, String postalCode, String city, String country, StreetPrefix streetPrefix) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.streetPrefix = streetPrefix;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StreetPrefix getStreetPrefix() {
        return streetPrefix;
    }

    public void setStreetPrefix(StreetPrefix streetPrefix) {
        this.streetPrefix = streetPrefix;
    }

    @Override
    public String toString() {
        return streetPrefix.getPrefix() + streetName + " " + houseNumber + "/" + flatNumber + "\n" + postalCode + " " + city;
    }
}

