package com.gmail.mozhgru;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
    strict = true,
    features = {"src/test/resources/features"},
        glue = "com.gmail.mozhgru.stepdefinition"
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
