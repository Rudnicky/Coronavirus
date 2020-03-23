package com.example.coronavirus.components.networkcomponent;

import dagger.Component;

@Component
public interface NetworkComponent {

    NetworkConnectivity getNetworkConnectivity();
}
