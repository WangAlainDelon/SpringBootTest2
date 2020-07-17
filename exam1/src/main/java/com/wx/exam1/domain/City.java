package com.wx.exam1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;


public class City {
    private short city_id;
    private String city;
    private short country_id;
    private Timestamp last_update;

    //City里面要包含国家国家的对象
    private Country countryObj;

    public Country getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Country countryObj) {
        this.countryObj = countryObj;
    }

    public short getCity_id() {
        return city_id;
    }

    public void setCity_id(short city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public short getCountry_id() {
        return country_id;
    }

    public void setCountry_id(short country_id) {
        this.country_id = country_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

}
