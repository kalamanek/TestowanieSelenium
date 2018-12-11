package testy;

import org.openqa.selenium.By;

public class test1 extends test{
	public void test1Prepare(){
        driver.get("http://www.google.com");
        element = driver.findElement(By.name("q"));
        element.sendKeys("kotki");
        element.submit();
        bodyText = driver.findElement(By.tagName("body")).getText();
	}
	public boolean test1Assertion(){
		return bodyText.contains("Obrazy dla kotki");
	}
}
