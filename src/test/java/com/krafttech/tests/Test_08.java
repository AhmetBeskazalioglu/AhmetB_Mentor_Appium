package com.krafttech.tests;

import com.krafttech.TestBase;
import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Locators;
import com.krafttech.utils.MobileUtilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.krafttech.utils.MobileUtilities.*;

public class Test_08 extends TestBase implements Locators{


    @Test
    public void test_01() {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileUtilities.getLocatorByText("OK")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileUtilities.getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        clickWithText("Auto Complete");

        int actualSize = driver.findElements(lAutoCompleteList).size();

        //driver.openApp(Device.PIXEL_2, App.CALCULATOR);

        clickNumber(1);
        clickOperator("minus");
        clickNumber(2);
        clickOperator("equals");

        String expectedText = driver.findElement(lResult).getText();

        //activateBackgroundApp(API_Demos.appPackage);

        int actual= driver.findElements(lAutoCompleteList).size();

        Assert.assertEquals(actualSize, actual);
    }
}

