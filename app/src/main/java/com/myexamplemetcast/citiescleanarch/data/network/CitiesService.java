package com.myexamplemetcast.citiescleanarch.data.network;


import com.myexamplemetcast.citiescleanarch.data.model.response.CitiesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Максим on 01.03.2018.
 */

public interface CitiesService {


@GET("/2/cities")
Single<CitiesResponse> cities(@Query("lat") String lat, @Query("lon") String lon);


}
