package com.example.coronavirus.components.flagcomponent;

import dagger.Component;

@Component
public interface FlagComponent {

    FlagManager getFlagManager();
}
