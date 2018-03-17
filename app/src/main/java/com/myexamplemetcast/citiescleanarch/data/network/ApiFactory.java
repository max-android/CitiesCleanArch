package com.myexamplemetcast.citiescleanarch.data.network;

import com.myexamplemetcast.citiescleanarch.presentation.di.App;
import javax.inject.Inject;

/**
 * Created by Максим on 06.03.2018.
 */

public class ApiFactory {


    @Inject
    CitiesService citiesService;


    public ApiFactory() {
        App.getAppComponent().injectApiFactory(this);
    }

    public  CitiesService getCitiesService(){

        return citiesService;
    }


}
