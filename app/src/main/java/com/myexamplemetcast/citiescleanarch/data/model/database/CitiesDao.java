package com.myexamplemetcast.citiescleanarch.data.model.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.myexamplemetcast.citiescleanarch.data.model.entity.TownDB;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface CitiesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCities(List<TownDB> towns);


 @Query("SELECT * FROM cities WHERE marker = :select_marker")
 Single<List<TownDB>> getCities(String select_marker);


 @Query("DELETE  FROM cities WHERE marker = :select_marker")
   void deleteCities(String select_marker);


    @Query("SELECT * FROM cities WHERE marker = :select_marker")
     List<TownDB> getCitiesForSize(String select_marker);

}
