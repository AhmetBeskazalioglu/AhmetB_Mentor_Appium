package com.krafttech.utils;

public enum App {
    GETIR("com.getir.casestudy.dev", "com.getir.casestudy.modules.splash.ui.SplashActivity",""),
    API_DEMOS("com.touchboarder.android.api.demos", "com.touchboarder.androidapidemos.MainActivity",""),
    CALCULATOR("com.android.calculator2", "com.android.calculator2.Calculator","");

    public String appPackage;
    public String appActivity;

    public String appZipFile;

    App(String appPackage, String appActivity, String appZipFile) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.appZipFile = appZipFile;

    }
}
