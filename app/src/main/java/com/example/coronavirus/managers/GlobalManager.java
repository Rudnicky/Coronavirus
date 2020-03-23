package com.example.coronavirus.managers;

public class GlobalManager {

    private static GlobalManager globalManager = null;

    public boolean isTotalActive = false;

    private GlobalManager() {}

    public static GlobalManager GetInstance() {
        if (globalManager == null) {
            globalManager = new GlobalManager();
        }
        return globalManager;
    }
}
