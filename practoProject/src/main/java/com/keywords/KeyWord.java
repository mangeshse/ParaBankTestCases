package com.keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.constance.Browser;
import com.cucumberSteps.BaseClass;

public class KeyWord {
	private static RemoteWebDriver driver;

	public void openBrowser(String browserName) {
		if (browserName == null) {
			browserName = "Chrome";
		}
		if (browserName.equalsIgnoreCase(Browser.CHROME)) {
			BaseClass.driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase(Browser.FIREFOX)) {
			BaseClass.driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase(Browser.INTERNETEXPLORER)) {
			BaseClass.driver = new InternetExplorerDriver();

		} else {
			System.out.println("Invalid browser Name");
		}
	}

	public void launchUrl(String url) {
		BaseClass.getDriver().get(url);
	}

	public void enterText(WebElement e, String textToEnter) {
		e.sendKeys(textToEnter);

	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return BaseClass.driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return BaseClass.driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return BaseClass.driver.findElements(By.cssSelector(locatorValue));
		} else {
			return null;
		}
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return BaseClass.driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return BaseClass.driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return BaseClass.driver.findElement(By.cssSelector(locatorValue));
		} else {
			return null;
		}
	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public String getText(String locatorType, String locatorValue) {
		String text = getWebElement(locatorType, locatorValue).getText();
		return text;
	}

	public List<String> getTexts(String locatorType, String locatorValue) {
		List<WebElement> data = getWebElements(locatorType, locatorValue);
		List<String> stringData = new ArrayList<>();
		for (WebElement element : data) {
			stringData.add(element.getText());
			System.out.println(stringData);

		}
		return stringData;
	}

	public void enterText(String locator, String textToEnter) {
		String parts[] = locator.split("##");
		enterText(parts[0], parts[1], textToEnter);
	}

	public void click(String locator) {
		String parts[] = locator.split("##");
		click(parts[0], parts[1]);
	}

	public List<String> getText(String locator) {
		String parts[] = locator.split("##");
		return getTexts(parts[0], parts[1]);
	}

	public void selectByVisibleText(String locatorType, String locatorValue, String textToSelect) {
		WebElement select = getWebElement(locatorType, locatorValue);
		Select s = new Select(select);
		s.selectByVisibleText(textToSelect);
	}

	public void refresh(RemoteWebDriver driver) {
		driver.navigate().refresh();

	}

	public void maximize(RemoteWebDriver driver) {
		driver.manage().window().maximize();

	}

	public void minimize(RemoteWebDriver driver) {
		driver.manage().window().minimize();

	}

	public void alertAccept() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void quitBrowser() {
		BaseClass.getDriver();
	}

	public List<String> getTexts(List<WebElement> elements) {
		List<String> data = new ArrayList<>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

}
