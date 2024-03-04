package com.krafttech.utilsWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public interface LocatorsWeb {
    String url = "https://www.krafttechexlab.com/login";

    By lEmail = By.id("email");
    By lPassword = By.id("yourPassword");
    By lButton = By.tagName("button");

    By lUserName = By.xpath("//h2");

    static void login(String email, String password){
        Driver.getDriver().findElement(lEmail).sendKeys(email);
        Driver.getDriver().findElement(lPassword).sendKeys(password+ Keys.TAB+Keys.TAB+Keys.ENTER);

    }

}
