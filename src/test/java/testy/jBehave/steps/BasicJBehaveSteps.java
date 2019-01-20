package testy.jBehave.steps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testy.data.Data;

public abstract class BasicJBehaveSteps extends Steps {
	protected WebDriver driver;
	@BeforeStory
	 public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",Data.driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Data.defaultTimeout, TimeUnit.SECONDS);
	}

	@AfterStory
	public void cleanUp() throws InterruptedException{
        driver.close();
        driver.quit();
	}
}
