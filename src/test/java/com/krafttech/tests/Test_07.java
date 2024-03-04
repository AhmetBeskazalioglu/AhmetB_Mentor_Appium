package com.krafttech.tests;

import com.krafttech.TestBase;
import com.krafttech.utils.MobileUtilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.krafttech.utils.MobileUtilities.*;

public class Test_07 extends TestBase {


    @Test
    public void test1()  {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        swipeV(.9,.2);
        swipeV(.8,.3);
        swipeV(.2,.9);

    }

    @Test
    public void test2()  {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        swipeUntil(getLocatorByText("WebView"),.8,.3);
        clickWithText("WebView");
    }

    @Test
    public void test3()  {

        clickWithText("Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByText("OK")));
        clickWithText("OK");
        clickWithText("OK");
        clickWithText("API Demos");
        clickWithText("Accessibility");
        driver.navigate().back();
        clickWithText("Views");
        swipeAndClick(getLocatorByText("WebView"),.8,.3);

    }

}

