package com.myexamplemetcast.citiescleanarch.data.repository;

import android.util.Log;
import com.myexamplemetcast.citiescleanarch.data.mapper.TownsMapper;
import com.myexamplemetcast.citiescleanarch.data.mapper.TownsMapperDB;
import com.myexamplemetcast.citiescleanarch.data.model.database.AppBase;
import com.myexamplemetcast.citiescleanarch.data.model.entity.TownDB;
import com.myexamplemetcast.citiescleanarch.data.model.response.CitiesResponse;
import com.myexamplemetcast.citiescleanarch.data.network.ApiFactory;
import com.myexamplemetcast.citiescleanarch.domain.CitiesRepository;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;
import com.myexamplemetcast.citiescleanarch.presentation.di.App;
import com.myexamplemetcast.citiescleanarch.presentation.general.NetInspector;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

/**
 * Created by Максим on 06.03.2018.
 */

public class TownsDataRepository implements CitiesRepository {


    private String lat;
    private String lon;
    private String marker;

    @Inject
    NetInspector netInspector;

    @Inject
    AppBase database;


    private ApiFactory apiFactory = new ApiFactory();

    public TownsDataRepository(String lat, String lon) {

        App.getAppComponent().injectTownsDataRepository(this);

        this.lat = lat;
        this.lon = lon;
        marker = String.valueOf(Double.parseDouble(lat)+Double.parseDouble(lon));
    }

    @Override
    public Single<List<Town>> listTowns() {



        if (netInspector.isOnline()) {

            return apiFactory.getCitiesService()
                    .cities(lat, lon)
                    .map(CitiesResponse::getResults)
                    .doOnError(error ->   Log.d("Online",error.getMessage()))
                    .doOnSuccess(results -> {

                        for (Town town:results ){

                            Log.d("Online",town.getCity());

                        }

                             if(database.getCitiesDao().getCitiesForSize(marker).isEmpty()){
                            database.getCitiesDao().insertCities(TownsMapperDB.transform(results,marker));
                        }

                            for (TownDB townDB:database.getCitiesDao().getCitiesForSize(marker)){

                                Log.d("Online",townDB.getCity());

                            }

                    });
        }else{

            return database.getCitiesDao().getCities(marker)
              .doOnError(error ->   Log.d("No-Online",error.getMessage()))
                    .doOnSuccess(townDBS ->{

                    })
                    .map(townDBS -> TownsMapper.transform(townDBS));
                   // .map(TownsMapper::transform);
        }

    }

}

