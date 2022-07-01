package com.fedex.tarifas.entity;

import com.fedex.tarifas.entity.tarifa.ServiceLevel;

public class Tarifa {
    private float price;
    private String currency;
    private ServiceLevel serviceLevel;

    public Tarifa(float price, String currency, ServiceLevel serviceLevel) {
        this.price = price;
        this.currency = currency;
        this.serviceLevel = serviceLevel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }
}
