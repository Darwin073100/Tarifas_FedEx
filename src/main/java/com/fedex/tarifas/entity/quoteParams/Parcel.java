package com.fedex.tarifas.entity.quoteParams;

public class Parcel {
    private int length;
    private int width;
    private int heigth;
    private String distanceUnit;
    private int weigth;
    private String massUnit;

    public Parcel(int length, int width, int heigth, String distanceUnit, int weigth, String massUnit) {
        this.length = length;
        this.width = width;
        this.heigth = heigth;
        this.distanceUnit = distanceUnit;
        this.weigth = weigth;
        this.massUnit = massUnit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getMassUnit() {
        return massUnit;
    }

    public void setMassUnit(String massUnit) {
        this.massUnit = massUnit;
    }
}
