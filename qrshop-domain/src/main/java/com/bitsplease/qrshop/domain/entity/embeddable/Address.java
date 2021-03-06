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
    private String addressNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
