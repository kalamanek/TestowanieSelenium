package jakas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.JUnitCore;
import org.junit.Test;

@FixMethodOrder()
public class Testy {
	WebDriver driver;
	WebElement element;
	String bodyText;
	
	public static void main(String[] args) throws Exception {  
			JUnitCore.main("jakas.Testy");            
	}
	
	@Before
	public void prepareTests(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1(){
        driver.get("http://www.google.com");
        element = driver.findElement(By.name("q"));
        element.sendKeys("kotki");
        element.submit();
        bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(bodyText.contains("Obrazy dla kotki"));
        element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("pieski");
        element.submit();
        bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(bodyText.contains("Obrazy dla pieski"));
	}
	
//	@Test
//	public void test2(){
//        element = driver.findElement(By.name("q"));
//        element.clear();
//        element.sendKeys("pieski");
//        element.submit();
//        bodyText = driver.findElement(By.tagName("body")).getText();
//        assertTrue(bodyText.contains("Obrazy dla pieski"));
//	}
	
	
	@After
	public void CleanDriver(){
        driver.close();
        driver.quit();
	}
	
	
}
