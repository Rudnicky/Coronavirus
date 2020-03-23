package com.example.coronavirus.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("countries_stat")
    @Expose
    private List<CountryModelList> countryModelList = null;
    @SerializedName("statistic_taken_at")
    @Expose
    private String statisticTakenAt;

    public List<CountryModelList> getCountryModelList() {
        return countryModelList;
    }

    public void setCountryModelList(List<CountryModelList> countryModelList) {
        this.countryModelList = countryModelList;
    }

    public String getStatisticTakenAt() {
        return statisticTakenAt;
    }

    public void setStatisticTakenAt(String statisticTakenAt) {
        this.statisticTakenAt = statisticTakenAt;
    }

}
