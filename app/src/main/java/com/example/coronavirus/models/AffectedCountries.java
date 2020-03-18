package com.example.coronavirus.models;

import java.util.ArrayList;

public class AffectedCountries {

    private ArrayList<Country> mAffectedCountries = new ArrayList<Country>();
    private String mStatisticTakenAt;

    public String getStatisticTakenAt() {
        return mStatisticTakenAt;
    }

    public void setStatisticTakenAt(String statisticTakenAt) {
        mStatisticTakenAt = statisticTakenAt;
    }
}
