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

    public static AppiumDriver<MobileElement> openApp(Device device, App app){
        runAppiumService();
        return getDriver(device, app);
    }

    public static void closeApp(){
        getDriver().closeApp();
        stopAppiumService();
    }

    public static WebElement getElementByText(String text){
        return getDriver().findElement(By.xpath("//*[@text='"+text+"']"));
    }

    public static By getLocatorByText(String text){
        return By.xpath("//*[@text='"+text+"']");
    }

    public static void clickWithText(String text) {
        getDriver().findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public static void swipeV(double startPoint, double endPoint){
        int width = getDriver().manage().window().getSize().width;
        int height = getDriver().manage().window().getSize().height;

        new TouchAction<>(getDriver())
                .press(PointOption.point(width/2, (int) (height*startPoint)))
                .moveTo(PointOption.point(width/2, (int) (height*endPoint)))
                .release()
                .perform();
    }

    public static void swipeUntil(By locator, double startPoint, double endPoint){
        while (getDriver().findElements(locator).size() == 0){
            swipeV(startPoint,endPoint);
        }
    }

    public static void swipeAndClick(By locator, double startPoint, double endPoint){
        while (getDriver().findElements(locator).size() == 0){
            swipeV(startPoint,endPoint);
        }
        getDriver().findElement(locator).click();
    }

    public static void clickToCoordinate(int x, int y){
        new TouchAction<>(getDriver())
                .press(PointOption.point(x,y))
                .release()
                .perform();
    }

    public static void clickNumber(Integer i){
        getDriver().findElementByAccessibilityId(String.valueOf(i)).click();
    }

    public static void clickOperator(String operator){
        getDriver().findElementByAccessibilityId(operator).click();
    }

    public static void activateBackgroundApp(String appPackage){
        ApplicationState applicationState = getDriver().queryAppState(appPackage);
        if (applicationState.equals(ApplicationState.RUNNING_IN_BACKGROUND)){
            getDriver().activateApp(appPackage);
        }
    }
}
