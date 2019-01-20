package testy.pageObject;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testy.data.Data;;





public abstract class BasePage {
	protected WebDriver driver;
	protected String childUrl;
	
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
	
	public void openChildPage() throws InvalidArgumentException{
		if(childUrl != "" ){
		    driver.get(Data.mainUrl + childUrl);
		}else{
			throw new IllegalArgumentException("nie ma childUrl");
		}
	
	}
	
	//wait for all the connections to the server to close
	public void waitForAllConnectionToClose() {
		new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver ->  
		((JavascriptExecutor) driver).executeScript(
	            		"return jQuery.active == 0")
							.equals(true)); 
	}
	
	public void documentReadyState(){
		new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver ->  
		((JavascriptExecutor) driver).executeScript(
				"return document.readyState")
					.toString().equals("complete"));
	}
	
	public void waitForElementStringToChange(WebElement element , int timeout) throws TimeoutException, InterruptedException{
		
		String loadingString = element.getText();
		do{
			timeout--;
			Thread.sleep(1);
		}while (timeout > 0 && element.getText().contains(loadingString) );
		
		if(timeout==0){
			throw new TimeoutException("timeout waiting for element " + element.toString());
		}
		
	}
	public void waitForElement(int timeout , WebElement element, WaitForElementInterface operation) throws InterruptedException, TimeoutException{
		do{
			timeout--;
			Thread.sleep(1);

		}while (timeout > 0 && !operation.condition(element));
		
		if(timeout==0){
			throw new TimeoutException("timeout waiting for element " + element.toString());
		}
	}

	
	public void waitForModal(){
		new WebDriverWait(driver, 10)
			.until((ExpectedCondition<Boolean>) driver -> 
				driver.findElements(By.className("modal-backdrop")).size() == 0) ;
		
	}
	
	public boolean isModalBackdropActive(){
		return driver.findElements(By.className("modal-backdrop")).size() > 0;
	}
	
	public void waitForAlert(){
		 new WebDriverWait(driver, 10)
		 	.until(ExpectedConditions.alertIsPresent());
	}
	public boolean isAlertActive(){
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}

	public void closeDriver(){
        driver.close();
        driver.quit();
	}
	
}
