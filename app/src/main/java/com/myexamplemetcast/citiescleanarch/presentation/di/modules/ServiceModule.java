package com.myexamplemetcast.citiescleanarch.presentation.di.modules;

import android.support.annotation.NonNull;

import com.myexamplemetcast.citiescleanarch.data.network.CitiesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Максим on 01.03.2018.
 */

@Module
@Singleton
public class ServiceModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){


        return new Retrofit.Builder()
                .baseUrl("https://api.meetup.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    @Provides
    @Singleton
    public CitiesService provideCitiesService(@NonNull Retrofit retrofit){

        return retrofit.create(CitiesService.class);

    }
}
