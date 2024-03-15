package com.cucumberSteps;

import com.config.Configuration;
import com.keywords.KeyWord;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStep {
	KeyWord key = new KeyWord();
	Configuration con = new Configuration();
	HomePage page = new HomePage();
	@Given("Launched url")
	public void launchUrl() {
		key.launchUrl(con.getAppUrl("beta"));
	}
	@When("Click on find doctor button")
	public void clickFindDoctor() {
		page.findDoctorClick();
	}

}
