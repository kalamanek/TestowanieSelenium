package testy.testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testy.data.Data;
public abstract class BaseTestCase {
	protected WebDriver driver;
	@Before
	 public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",Data.driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Data.defaultTimeout, TimeUnit.SECONDS);
	}

	@After
	public void cleanUp() throws InterruptedException{
        driver.close();
        driver.quit();
	}
}
