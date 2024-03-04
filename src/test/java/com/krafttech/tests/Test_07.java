package com.krafttech.tests;

import com.krafttech.TestBase;
import com.krafttech.utils.MobileUtilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.krafttech.utils.MobileUtilities.*;

public class Test_07 extends TestBase {


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
        swipeV(.9, .2);
        swipeV(.8, .3);
        swipeV(.2, .9);
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
        swipeUntil(getLocatorByText("WebView"),.8,0.2);
    }

    @Test
    public void test_03() {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileUtilities.getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        swipeAndClick("WebView",.8,.2);
    }

}

