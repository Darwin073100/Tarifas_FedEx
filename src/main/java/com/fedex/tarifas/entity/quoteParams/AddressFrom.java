package com.fedex.tarifas.entity.quoteParams;

public class AddressFrom {
    private String zip;
    private String country;

    public AddressFrom(String zip, String country) {
        this.zip = zip;
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
