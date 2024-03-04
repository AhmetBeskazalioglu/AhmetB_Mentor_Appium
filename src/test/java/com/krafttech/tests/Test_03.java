package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_03 {

    AppiumDriver<MobileElement> driver;

    AppiumDriverLocalService service;

    App app=App.API_DEMOS;
    Device device=Device.PIXEL_2;


    @Test
    public void test_01() throws MalformedURLException, InterruptedException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // udid tek device icin gerekli değil. Birden fazla device varsa udid lazım
        capabilities.setCapability(MobileCapabilityType.UDID, device.udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.platform);
        capabilities.setCapability(MobileCapabilityType.VERSION, device.version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.deviceName);

        //adb shell +enter
        //dumpsys window | grep -E mCurrentFocus
        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);

        //driver ayarlayalım
        driver= new AppiumDriver<>(service.getUrl(), capabilities);

        clickWithText("Continue");
        Thread.sleep(3000);
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        Thread.sleep(3000);

        driver.closeApp();
        service.stop();
    }

    void clickWithText(String text){
        driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
    }
}
