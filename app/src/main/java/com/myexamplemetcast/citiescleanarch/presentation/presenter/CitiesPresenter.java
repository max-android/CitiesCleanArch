package com.myexamplemetcast.citiescleanarch.presentation.presenter;


import android.util.Log;

import com.myexamplemetcast.citiescleanarch.domain.usecase.CitiesUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Максим on 01.03.2018.
 */

public class CitiesPresenter {


    private CitiesView citiesView;
    private CitiesUseCase citiesUseCase;


    private CompositeDisposable subscrition = new CompositeDisposable();

    public CitiesPresenter(CitiesView citiesView, CitiesUseCase citiesUseCase) {
        this.citiesView = citiesView;
        this.citiesUseCase = citiesUseCase;
    }


    public void init(){

        subscrition.add(citiesUseCase.listTowns()
                .doOnError(error-> Log.d("LOG",error.getMessage()))
                 .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (towns -> citiesView.showCities(towns)
                        ,error -> citiesView.showError()));

    }


    public void disposed(){

        subscrition.clear();
    }

}
