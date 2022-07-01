package com.fedex.tarifas.entity;

import com.fedex.tarifas.entity.quoteParams.AddressFrom;
import com.fedex.tarifas.entity.quoteParams.AddressTo;
import com.fedex.tarifas.entity.quoteParams.Parcel;

public class QuoteParams {
    private AddressFrom addressFrom;
    private AddressTo addressTo;
    private Parcel parcel;

    public QuoteParams(AddressFrom addressFrom, AddressTo addressTo, Parcel parcel) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.parcel = parcel;
    }

    public AddressFrom getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(AddressFrom addressFrom) {
        this.addressFrom = addressFrom;
    }

    public AddressTo getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(AddressTo addressTo) {
        this.addressTo = addressTo;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
