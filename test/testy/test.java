package testy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

import org.junit.runner.JUnitCore;



public abstract class test {
	WebDriver driver;
	WebElement element;
	String mainUrl = "http://www.google.com";
	String searchElementName = "q";
	
//	public static void main(String[] args) throws Exception {  
//			JUnitCore.main("jakas.Testy");            
//	}
	
	public test(WebDriver driver){
		this.driver = driver;
	}
	public test(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void newChromeDriver(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}
	public void openMainPage(){
		driver.get(mainUrl);
	}
	
	public void searchOnMainPage(String query) throws Exception{
		try{
		element = driver.findElement(By.name(searchElementName));
        element.clear();
        element.sendKeys(query);
        element.submit();
        }catch(NoSuchElementException e){
        	throw e;
        }
	}
	public String pageBody(){
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}

	public void closeDriver(){
        driver.close();
        driver.quit();
	}
}
