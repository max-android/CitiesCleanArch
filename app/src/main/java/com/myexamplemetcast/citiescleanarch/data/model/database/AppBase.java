package com.myexamplemetcast.citiescleanarch.data.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.myexamplemetcast.citiescleanarch.data.model.entity.TownDB;


@Database(entities = {TownDB.class}, version = 1)
public abstract class AppBase extends RoomDatabase {

    public abstract CitiesDao getCitiesDao();

}
