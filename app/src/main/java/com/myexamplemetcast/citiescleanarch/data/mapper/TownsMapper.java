package com.myexamplemetcast.citiescleanarch.data.mapper;

import com.myexamplemetcast.citiescleanarch.data.model.entity.TownDB;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 08.03.2018.
 */

public class TownsMapper {

    public static List<Town> transform(List<TownDB> towns) {

        List<Town> newList=new ArrayList<>();

        for(TownDB town:towns){
            newList.add(new Town(town.getLocalized_country_name(),town.getCity(),Double.parseDouble(town.getLon()),Double.parseDouble(town.getLat())));
        }
        return newList;
    }
}
