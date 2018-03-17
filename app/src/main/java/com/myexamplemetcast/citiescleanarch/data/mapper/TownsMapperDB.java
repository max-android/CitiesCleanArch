package com.myexamplemetcast.citiescleanarch.data.mapper;

import com.myexamplemetcast.citiescleanarch.data.model.entity.TownDB;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 08.03.2018.
 */

public class TownsMapperDB {


    public static List<TownDB> transform(List<Town> towns,String marker){

        List<TownDB> newList=new ArrayList<>();

        for(Town town:towns){
            newList.add(new TownDB(marker,town.getCity(),String.valueOf(town.getLon()),String.valueOf(town.getLat()),town.getLocalizedCountryName()));
        }
        return newList;
    }

}
