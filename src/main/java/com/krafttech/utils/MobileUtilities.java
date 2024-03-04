package com.krafttech.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static com.krafttech.utils.Driver.*;

public class MobileUtilities {

    public static AppiumDriver<MobileElement> openApp(Device device, App app) {
        runAppiumService();
        return getDriver(device, app);
    }

    public static void closeApp() {
        getDriver().closeApp();
        stopAppiumService();
    }

    public static WebElement getElementWithText(String text) {
        return getDriver().findElementByXPath("//*[@text='" + text + "']");
    }

    public static void clickWithText(String text) {
        getDriver().findElementByXPath("//*[@text='" + text + "']").click();
    }

    public static By getLocatorByText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    public static void swipeV(double start, double end) {
        int height = getDriver().manage().window().getSize().getHeight();
        int width = getDriver().manage().window().getSize().getWidth();

        new TouchAction<>(getDriver())
                .press(PointOption.point(width / 2, (int) (height * start)))
                .moveTo(PointOption.point(width / 2, (int) (height * end)))
                .release()
                .perform();

    }

    public static void swipeUntil(By by, double start, double end){
        while(getDriver().findElements(by).size()==0){
            swipeV(start, end);
        }

    }

    public static void swipeAndClick(String text, double start, double end){
        while(getDriver().findElements(getLocatorByText(text)).size()==0){
            swipeV(start, end);
        }
        clickWithText(text);
    }

    public static void clickToCoordinate(int x, int y){
        new TouchAction<>(getDriver())
                .press(PointOption.point(x, y))
                .release()
                .perform();
    }

    public static void clickNumber(Integer number) {
        getDriver().findElementByAccessibilityId(String.valueOf(number)).click();
    }

    public static void clickOperator(String operator) {
        getDriver().findElementByAccessibilityId(operator).click();
    }

    public static void activateBackgroundApp(String appPackage) {
        ApplicationState applicationState = getDriver().queryAppState(appPackage);
        if (applicationState.equals(ApplicationState.RUNNING_IN_BACKGROUND)) {
            getDriver().activateApp(appPackage);
        }
    }
}
