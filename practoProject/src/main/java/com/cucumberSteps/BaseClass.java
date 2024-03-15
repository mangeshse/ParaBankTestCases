package com.cucumberSteps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import com.config.Configuration;
import com.exceptions.InvaliBrowserNameError;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass extends AbstractTestNGCucumberTests{
	private static final Logger log = Logger.getLogger(BaseClass.class);
	public static RemoteWebDriver driver;
	public Configuration config;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@Before
	public void setUp() {

		config = new Configuration();
		if (config.getExecutionMode().equalsIgnoreCase("local")) {
			log.info("Executing suite on local");
			if (config.getBrowsername().equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				//config.getAppUrl("beta");
			} else if (config.getBrowsername().equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				//config.getAppUrl("beta");
			} else if (config.getBrowsername().equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
				//config.getAppUrl("beta");
			} else {
				throw new InvaliBrowserNameError(config.getBrowsername());
			}
		} else {
			log.info("Executing suite on grid");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("se:name", "My simple test");
			firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");

			// driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"),
			// firefoxOptions);
		}

	}

	@After
	public void takeScreenShotOnTestFailure(Scenario scenario) throws IOException {

		try {
			if (scenario.isFailed()) {
				Date date = new Date();
				String screnShotFname = date.toString().replace(" ", "-").replace(":", "-");

				System.out.println(date);

				AShot ashot = new AShot();
				BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
						.takeScreenshot(BaseClass.getDriver()).getImage();
				String baseDir = System.getProperty("user.dir");
				ImageIO.write(img, "png", new File(
						baseDir + "\\src\\main\\resources\\FaildTestCaseScreenShot\\" + screnShotFname + ".png"));

			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		driver.quit();

	}

}
