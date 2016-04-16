package com.bitsplease.qrshop.domain.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Chrisostomos Bakouras
 */
@Embeddable
public class Address {

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_number")
    private String addresNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalcode;

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddresNumber() {
        return addresNumber;
    }

    public void setAddresNumber(String addresNumber) {
        this.addresNumber = addresNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
}
