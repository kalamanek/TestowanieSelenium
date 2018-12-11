package testy;

import org.openqa.selenium.By;

public class test2 extends test{

	public void test2Prepare(){
        driver.get("http://www.google.com");
		element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("pieski");
        element.submit();
        bodyText = driver.findElement(By.tagName("body")).getText();
	}
	public boolean test1Assertion(){
		return bodyText.contains("Obrazy dla pieski");
	}
}
