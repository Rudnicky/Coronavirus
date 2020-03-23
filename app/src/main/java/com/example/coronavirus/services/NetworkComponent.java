package com.example.coronavirus.services;

import android.content.Context;

import dagger.Component;

@Component
public interface NetworkComponent {

    NetworkConnectivity getNetworkConnectivity();
}
