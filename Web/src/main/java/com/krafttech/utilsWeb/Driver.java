package com.krafttech.utilsWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getMobileDriver() {
        if (driverPool.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("androidPackage", "com.android.chrome");
            driverPool.set(new ChromeDriver(options));
        }
        return driverPool.get();
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverPool.set(new ChromeDriver());
        }
        return driverPool.get();
    }
}
