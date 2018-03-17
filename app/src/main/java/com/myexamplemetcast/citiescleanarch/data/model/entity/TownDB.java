package com.myexamplemetcast.citiescleanarch.data.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.myexamplemetcast.citiescleanarch.presentation.general.Constants;

/**
 * Created by Максим on 06.03.2018.
 */

@Entity(tableName = Constants.NAME_TABLE)
public class TownDB {


    @PrimaryKey(autoGenerate = true)
    private int id;


    private String marker;

    private String city;


   private String lon;

    private String lat;


    private  String localized_country_name;


    public TownDB(String marker, String city, String lon, String lat, String localized_country_name) {
        this.marker = marker;
        this.city = city;
        this.lon = lon;
        this.lat = lat;
        this.localized_country_name = localized_country_name;
    }

    public int getId() {
        return id;
    }

    public String getMarker() {
        return marker;
    }

    public String getCity() {
        return city;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getLocalized_country_name() {
        return localized_country_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLocalized_country_name(String localized_country_name) {
        this.localized_country_name = localized_country_name;
    }
}
