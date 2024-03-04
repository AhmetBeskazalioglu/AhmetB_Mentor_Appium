package com.krafttech.cucumber;

import com.krafttech.utils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

import static com.krafttech.utils.App.CALCULATOR;
import static com.krafttech.utils.Device.PIXEL_2;
import static com.krafttech.utils.Driver.*;
import static com.krafttech.utils.MobileUtilities.*;

public class CalculatorStepDefs {
    @Given("The user is on the start page")
    public void theUserIsOnTheStartPage() {
        openApp(PIXEL_2, CALCULATOR);
    }

    @When("The user sums of following numbers")
    public void theUserSumsOfFollowingNumbers(List<Integer> numbers) {
        clickNumber(numbers.get(0));
        clickOperator("plus");
        clickNumber(numbers.get(1));
        clickOperator("plus");
        clickNumber(numbers.get(2));
        clickOperator("equals");
    }

    @Then("The result should be {int}")
    public void theResultShouldBe(int expected) {
        String actualText = Driver.getDriver().findElement(Locators.lResult).getText();
        int actual = Integer.parseInt(actualText);

        Assert.assertEquals(actual,expected);
    }
}
