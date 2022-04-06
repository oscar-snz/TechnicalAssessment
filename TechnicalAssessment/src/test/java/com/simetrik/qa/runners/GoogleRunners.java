package com.simetrik.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Google/search.feature", glue = { "com.simetrik.qa.steps" })

public class GoogleRunners {

}
