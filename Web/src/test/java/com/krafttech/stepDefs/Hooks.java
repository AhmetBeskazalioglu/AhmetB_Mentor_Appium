package com.krafttech.stepDefs;

import io.cucumber.java.Before;

import static com.krafttech.utilsWeb.Driver.*;

public class Hooks {
    @Before
    public void setUp() {
        getMobileDriver().manage().window().maximize();
    }


}
