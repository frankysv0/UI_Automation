package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//fselvakumar//New Eclipse 2024//E_Commerce//src//test//java//com//feature//openCart.feature", glue = { "com.stepDef",
		"com.hooks" }, plugin = { "pretty", "json:target/cucumber_reports/Cucumber.json"})

public class TestRunner {

}
