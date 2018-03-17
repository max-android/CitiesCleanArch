package com.myexamplemetcast.citiescleanarch.presentation.presenter;

import android.support.annotation.NonNull;

import com.myexamplemetcast.citiescleanarch.domain.model.Town;

import java.util.List;

/**
 * Created by Максим on 08.03.2018.
 */

public interface CitiesView {

    void showCities(@NonNull List<Town> towns);

    void showError();
}
