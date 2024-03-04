package com.krafttech.runners;


import com.krafttech.utilsWeb.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/com/krafttech/features",
        glue = "com/krafttech/stepDefs",
        dryRun = false,
        tags = ""
)

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("environment")
    public void beforeTest(String environment) {
        if (environment.equalsIgnoreCase("pc")) {
            Driver.getDriver();
        } else if (environment.equalsIgnoreCase("mobile")) {
            Driver.getMobileDriver();
        }

    }
}
