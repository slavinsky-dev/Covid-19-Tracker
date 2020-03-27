package com.slavinskydev.covid19tracker.api;

import com.slavinskydev.covid19tracker.pojo.CountriesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/summary")
    Observable<CountriesResponse> getCountries();
}
