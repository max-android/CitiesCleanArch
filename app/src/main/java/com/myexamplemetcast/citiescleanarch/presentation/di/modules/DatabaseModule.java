package com.myexamplemetcast.citiescleanarch.presentation.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.myexamplemetcast.citiescleanarch.data.model.database.AppBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
@Singleton
public class DatabaseModule {

    private Context context;


    public DatabaseModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public AppBase provideDatabase(){

        return Room.databaseBuilder(context,AppBase.class, "db_towns").build();
    }


}
