package com.cucumberProject;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resources\\Feature",glue="com.cucumberSteps")
public class FeatureRunner extends AbstractTestNGCucumberTests{

}
