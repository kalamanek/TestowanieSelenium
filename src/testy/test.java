package testy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.runner.JUnitCore;



public class test {
	WebDriver driver;
	WebElement element;
	String bodyText;
	
	public static void main(String[] args) throws Exception {  
			JUnitCore.main("jakas.Testy");            
	}
	
	public void prepareTests(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}
	

	public void CleanDriver(){
        driver.close();
        driver.quit();
	}
}
