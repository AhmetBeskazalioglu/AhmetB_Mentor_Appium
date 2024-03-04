package com.krafttech.stepDefs;

import com.krafttech.utils.Driver;
import com.krafttech.utilsWeb.LocatorsWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

import static com.google.gson.internal.bind.TypeAdapters.URL;
import static com.krafttech.utilsWeb.LocatorsWeb.URL;

public class KraftLoginStepDefs {
    WebDriver driver;

    @Given("The user is on the Kraft login page")
    public void theUserIsOnTheKraftLoginPage() {
        driver.get(URL);
    }

    @When("The user enters in following credentials")
    public void theUserEntersInFollowingCredentials(Map<String, String> credentials) {
        driver.findElement(LocatorsWeb.lEmail).sendKeys(credentials.get("email"));
        driver.findElement(LocatorsWeb.lPassword).sendKeys(credentials.get("password"));
        driver.findElement(LocatorsWeb.lLogin).click();

    }

    @Then("The user should be able to see own name : {string} at the dashboard page")
    public void theUserShouldBeAbleToSeeOwnNameAtTheDashboardPage(String arg0) {
        String ActualText = driver.findElement(LocatorsWeb.lUserName).getText();
        Assert.assertEquals(ActualText, arg0);

    }

    @And("The user closes browser")
    public void theUserClosesBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
