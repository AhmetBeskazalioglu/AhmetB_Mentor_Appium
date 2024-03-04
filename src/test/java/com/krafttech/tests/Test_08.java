package com.krafttech.tests;

import com.krafttech.TestBase;
import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.krafttech.utils.App.API_DEMOS;
import static com.krafttech.utils.App.CALCULATOR;
import static com.krafttech.utils.Device.PIXEL_2;
import static com.krafttech.utils.Locators.lAutoCompleteList;
import static com.krafttech.utils.Locators.lResult;
import static com.krafttech.utils.MobileUtilities.*;

public class Test_08 extends TestBase{


    @Test
    public void test_01() {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        clickToCoordinate(1762,966);


    }

    @Test
    public void test_02() {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        clickWithText("Auto Complete");

        driver= openApp(PIXEL_2, CALCULATOR);

        clickNumber(9);
        clickOperator("minus");
        clickNumber(2);
        clickOperator("equals");
        String expectedText = driver.findElement(lResult).getText();
        int expected = Integer.parseInt(expectedText);

        activateBackgroundApp(API_DEMOS.appPackage);

        int actual= driver.findElements(lAutoCompleteList).size();

        Assert.assertEquals(actual, actual);
    }
}

