package com.myexamplemetcast.citiescleanarch.domain;

import com.myexamplemetcast.citiescleanarch.domain.model.Town;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Максим on 06.03.2018.
 */

public interface CitiesRepository {

    Single<List<Town>> listTowns();

}
