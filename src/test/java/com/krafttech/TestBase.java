package com.krafttech;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.MobileUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = MobileUtilities.openApp(Device.PIXEL_2, App.API_DEMOS);
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void afterTest() {
        MobileUtilities.closeApp();
    }

}
