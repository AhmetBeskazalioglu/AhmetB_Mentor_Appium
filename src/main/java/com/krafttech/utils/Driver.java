package com.krafttech.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    static AppiumDriverLocalService service;

    private static AppiumDriver<MobileElement> driver;

    public static void runAppiumService() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }

    public static void stopAppiumService() {
        service.stop();
    }

    public static AppiumDriver<MobileElement> getDriver(Device device, App app) {
        driver = new AndroidDriver<>(service.getUrl(), desiredCapabilities(device, app));
        return driver;
    }

    private static DesiredCapabilities desiredCapabilities(Device device, App app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String apk="src/main/resources/"+app.appZipFile;

        capabilities.setCapability(MobileCapabilityType.UDID, device.udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.platform);
        capabilities.setCapability(MobileCapabilityType.VERSION, device.version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.deviceName);
        if (app.appZipFile.length() != 0) {
            capabilities.setCapability("app", apk);
        }

        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);
        return capabilities;
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
