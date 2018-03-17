package com.myexamplemetcast.citiescleanarch.domain.usecase;

import com.myexamplemetcast.citiescleanarch.domain.CitiesRepository;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Максим on 06.03.2018.
 */

public class CitiesUseCase {

    private CitiesRepository citiesRepository;


    public CitiesUseCase(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;

    }

    public Single<List<Town>> listTowns(){

        return citiesRepository.listTowns();
    }


}



