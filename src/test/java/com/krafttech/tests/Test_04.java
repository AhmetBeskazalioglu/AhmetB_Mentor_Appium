package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_04 {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriverLocalService service;

    App app=App.API_DEMOS;
    Device device=Device.PIXEL_2;


    @Test
    public void test_01() throws MalformedURLException, InterruptedException {

        Driver.runAppiumService();
        driver= Driver.getDriver(device,app);

        clickWithText("Continue");
        Thread.sleep(3000);
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        Thread.sleep(3000);

        driver.closeApp();
        Driver.stopAppiumService();
    }

    public void clickWithText(String text){
        driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
    }
}
