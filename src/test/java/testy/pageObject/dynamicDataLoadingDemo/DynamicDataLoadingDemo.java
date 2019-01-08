package testy.pageObject.dynamicDataLoadingDemo;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import testy.pageObject.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicDataLoadingDemo extends BasePage{
	
	@FindBy(xpath = "//button[@id='save']")
	private WebElement buttonNewUser;	
	

	@FindBy(xpath = "//div[@id='loading']")
	private WebElement replyData;	
	
	@FindBy(xpath = "//div[@id='loading']//img")
	private WebElement replyDataImageUrl;	
	
	public DynamicDataLoadingDemo(WebDriver driver) {
		super(driver);
		childUrl = "dynamic-data-loading-demo.html";
	}
	
	//wait for all the connections to the server to close
	public void waitForAllConnectionToClose() {
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() { 
	        public Boolean apply(WebDriver wdriver) { 
	            return ((JavascriptExecutor) driver).executeScript(
	                    "return jQuery.active == 0").equals(true);
	        }
	    }); 
	}
	
	//loop till message change or 
		public void waitForDataChange(int timeout) throws  TimeoutException, InterruptedException {
			String loadingString = "loading...";
			do{
				timeout--;
				Thread.sleep(1);
			}while (timeout > 0 && replyData.getText().contains(loadingString) );
			
			if(timeout==0){
				throw new TimeoutException("timeout waiting for ajax");
			}
		}
	
	public void clickButtonNewUser(){
		buttonNewUser.click();
	}
	public String getReplyData(){
			return replyData.getText();
	}
	
	public String getReplyDataImageUrl(){
		return replyDataImageUrl.getAttribute("src");
	}
	
}
