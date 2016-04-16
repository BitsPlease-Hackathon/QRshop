package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;

/**
 * @author Chrisostomos Bakouras
 */
public class CustomerDto extends AbstractDto {

    private String firstname;
    private String lastname;
    private String addressStreet;
    private String addresNumber;
    private String city;
    private String postalcode;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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
