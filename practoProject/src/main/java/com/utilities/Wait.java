package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.cucumberSteps.BaseClass;


public class Wait {
	private static FluentWait<WebDriver> wait;
	static {
		wait = new FluentWait<WebDriver>(BaseClass.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.withTimeout(Duration.ofSeconds(60));

	}

	public static void staleElement(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public void visibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.ByCssSelector) element));
	}

	public static void elementToBePresentInList(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitImplicit() {
		com.cucumberSteps.BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}

}
