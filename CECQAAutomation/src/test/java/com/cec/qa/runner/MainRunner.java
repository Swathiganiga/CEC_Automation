package com.cec.qa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//com//cec//qa//features",
glue= {"com.cec.qa.stepdefinations"},
plugin= { "pretty", "html:target/cucumber-html-report",
    "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
    "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
tags= {"@test20"}  //~@ignore
		)


public class MainRunner extends AbstractTestNGCucumberTests {
	public static Scenario scenario;


}


//plugin = {"json:target/cucumber-json.json","html:target/selenium-report"},
//plugin= {"html:target/cucumber-html-report","json:target/cucumber.json"	},