package com.krafttech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_01 {

    public static AppiumDriver<MobileElement> driver;


    @Test
    public void test_01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // udid tek device icin gerekli değil. Birden fazla device varsa udid lazım
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //adb shell +enter
        //dumpsys window | grep -E mCurrentFocus
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

        //driver ayarlayalım
        driver= new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();
        Thread.sleep(3000);

        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(3000);
        driver.rotate(ScreenOrientation.PORTRAIT);

        driver.closeApp();

    }
}
