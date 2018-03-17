package com.myexamplemetcast.citiescleanarch.data.repository;

import com.myexamplemetcast.citiescleanarch.domain.CitiesRepository;

/**
 * Created by Максим on 07.03.2018.
 */

public class RepositoryProvider  {


    private String lat;
    private String lon;


    public RepositoryProvider(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    private CitiesRepository citiesRepository;

    public  CitiesRepository  getCitiesRepository() {
        if (citiesRepository == null) {
            citiesRepository = new TownsDataRepository(lat,lon);
        }
        return citiesRepository;
    }


}
