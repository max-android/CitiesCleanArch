package com.myexamplemetcast.citiescleanarch.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 01.03.2018.
 */

public class CitiesResponse {

    @SerializedName("results")
    @Expose
    private List<Town> results;


    public List<Town> getResults() {

        if(results==null){
            return new ArrayList<>();
        }

        return results;
    }

}





