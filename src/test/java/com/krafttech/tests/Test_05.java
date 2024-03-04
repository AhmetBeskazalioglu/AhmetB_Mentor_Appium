package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Driver;
import com.krafttech.utils.MobileUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.krafttech.utils.MobileUtilities.*;

public class Test_05 {

    AppiumDriver<MobileElement> driver;

    WebDriverWait wait;


    @Test
    public void test_01() {

        driver= MobileUtilities.openApp(Device.PIXEL_2, App.API_DEMOS);
        wait = new WebDriverWait(driver, 10);

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");

        MobileUtilities.closeApp();
    }
}
