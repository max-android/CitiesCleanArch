package com.myexamplemetcast.citiescleanarch.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Максим on 01.03.2018.
 */

public class Town implements Serializable {


    @SerializedName("localized_country_name")
    @Expose
    private String localizedCountryName;


    @SerializedName("city")
    @Expose
    private String city;


    @SerializedName("lon")
    @Expose
    private double lon;


    @SerializedName("lat")
    @Expose
    private double lat;

    public Town(String localizedCountryName, String city, double lon, double lat) {
        this.localizedCountryName = localizedCountryName;
        this.city = city;
        this.lon = lon;
        this.lat = lat;
    }

    public String getLocalizedCountryName() {
        return localizedCountryName;
    }

    public String getCity() {
        return city;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLocalizedCountryName(String localizedCountryName) {
        this.localizedCountryName = localizedCountryName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
