package testy.pageObject.dynamicDataLoadingDemo;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;

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
	
	
	//loop till message change or 
	public void waitForDataChange(int timeout) throws  TimeoutException, InterruptedException{
		waitForElementStringToChange(replyData , timeout);
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
