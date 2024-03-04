package com.krafttech.utilsWeb;

import org.openqa.selenium.By;

public interface LocatorsWeb {
    String URL= "https://www.krafttechexlab.com/login";

    By lEmail = By.id("email");
    By lPassword = By.id("yourPassword");
    By lLogin = By.tagName("button");

    By lUserName = By.xpath("//h2");

    By lLogout = By.xpath("//a[text()='Logout']");

}
