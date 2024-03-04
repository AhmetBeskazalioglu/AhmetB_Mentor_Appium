package com.krafttech.runners;


import com.krafttech.utilsWeb.Driver;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/com/krafttech/features",
        glue = "com/krafttech/stepDefs",
        dryRun = true,
        tags = "",

        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("environment")
    public void beforeTest(String environment) {
        if (environment.equals("pc")) {
            Driver.getDriver();
        } else if (environment.equals("mobile")) {
            Driver.getMobileDriver();
        }

    }
}
