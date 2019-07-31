package com.example2.demo2.bean;

import javax.persistence.*;

public class Locations {
    @Id
    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country_id")
    private String countryId;

    public Locations(Integer locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public Locations() {
        super();
    }

    /**
     * @return location_id
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * @param locationId
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * @return street_address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
    }

    /**
     * @return postal_code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return state_province
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * @param stateProvince
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince == null ? null : stateProvince.trim();
    }

    /**
     * @return country_id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", locationId=").append(locationId);
        sb.append(", streetAddress=").append(streetAddress);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", city=").append(city);
        sb.append(", stateProvince=").append(stateProvince);
        sb.append(", countryId=").append(countryId);
        sb.append("]");
        return sb.toString();
    }
}