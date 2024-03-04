package com.krafttech.stepDefs;

import com.krafttech.utilsWeb.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

import static com.krafttech.utilsWeb.LocatorsWeb.*;

public class KraftLoginStepDefs {
    WebDriver driver;

    @Given("The user is on the Kraft login page")
    public void theUserIsOnTheKraftLoginPage() {
        driver = Driver.getDriver();
        driver.get(url);
    }

    @When("The user enters in following credentials")
    public void theUserEntersInFollowingCredentials(Map<String, String> credentials) {
        login(credentials.get("email"), credentials.get("password"));
    }

    @Then("The user should be able to see own name : {string} at the dashboard page")
    public void theUserShouldBeAbleToSeeOwnNameAtTheDashboardPage(String expected) {
        String actual = driver.findElement(lUserName).getText();
        Assert.assertEquals(actual,expected);

    }

    @And("The user closes browser")
    public void theUserClosesBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
