package testy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import testy.data.Data;;



public abstract class BasePage {
	protected WebDriver driver;
	protected String childUrl;
	protected String mainUrl = "www.seleniumeasy.com/test/";
	
	/*
	 * taking previous driver and its settings
	 */
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
//	public BasePage(){
//		newChromeDriver();
//	}
//	
//	public void newChromeDriver(){
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Data.defaultTimeout, TimeUnit.SECONDS);
//	}
//	
	
	public String pageBody(){
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public abstract void openChildPage();
	
	public WebDriver getDriver(){
		return this.driver;
	}

	public void closeDriver(){
        driver.close();
        driver.quit();
	}
	
}
