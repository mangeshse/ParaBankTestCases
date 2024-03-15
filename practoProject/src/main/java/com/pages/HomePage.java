package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumberSteps.BaseClass;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy(css="a[title='book'] div[class='product-tab__title']")
	WebElement findDoctor;
	public void findDoctorClick() {
		findDoctor.click();
	}

}
