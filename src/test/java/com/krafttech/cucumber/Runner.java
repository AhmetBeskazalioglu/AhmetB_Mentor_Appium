package com.krafttech.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/krafttech/cucumber",
        glue = "com.krafttech.cucumber",
        dryRun = true,

        plugin = {"pretty", "html:target/cucumber-reports"}
)


public class Runner extends AbstractTestNGCucumberTests {

}
