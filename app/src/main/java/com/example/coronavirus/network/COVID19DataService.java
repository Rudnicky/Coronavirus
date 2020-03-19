package com.example.coronavirus.network;

import com.example.coronavirus.models.CountryModel;
import com.example.coronavirus.models.TotalModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface COVID19DataService {

    @Headers("X-RapidAPI-Key: 8e593971f7mshcd97ef19ec3b516p148067jsn1247517c1cc6")
    @GET("/coronavirus/worldstat.php")
    Call<TotalModel> getTotal();

    @Headers("X-RapidAPI-Key: 8e593971f7mshcd97ef19ec3b516p148067jsn1247517c1cc6")
    @GET("/coronavirus/cases_by_country.php")
    Call<CountryModel> getCountries();
}
