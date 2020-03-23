package com.example.coronavirus.services;

import dagger.Component;

@Component
public interface FlagComponent {

    FlagManager getFlagManager();
}
