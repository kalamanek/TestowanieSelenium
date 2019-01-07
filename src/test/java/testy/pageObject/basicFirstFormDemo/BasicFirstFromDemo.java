package testy.pageObject.basicFirstFormDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.pageObject.*;
import testy.data.*;

public final class BasicFirstFromDemo extends BasePage {
	private final String childUrl = "basic-first-form-demo.html";
	
	@FindBy(id = "user-message")
	private WebElement userMessage;
	
	@FindBy(xpath = ("//button[@onclick='showInput();']"))
	private WebElement messageShowButton;
	
	@FindBy(id = "sum1")
	private WebElement firstSum;

	@FindBy(id = "sum2")
	private WebElement secondSum;
	
	@FindBy(xpath = ("//button[contains(text(),'Get Total')]"))
	private WebElement getTotalButton;
	
	@FindBy(xpath = ("//span[@id='display']"))
	private WebElement inputMessageResponse;
	
	public BasicFirstFromDemo(WebDriver driver) {
		super(driver);
	}
//	public BasicFirstFromDemo() {
//		super();
//		childUrl = "basic-first-form-demo.html";
//	}

	@Override
	public void openChildPage() throws InvalidArgumentException{
		{
		    try{       
		        driver.get(Data.mainUrl + childUrl);
		    }catch(InvalidArgumentException e){
		        System.out.println(Data.mainUrl + childUrl);
		    }
		}
	}
	
	public void insertMessage(String text){
		userMessage.sendKeys(text);
	}
	
	public void clickMessageButton(){
		messageShowButton.click();
	}
	
	public String getInputMessageResponse(){
		return inputMessageResponse.getText();
	}
	
	public void insertSum(String a , String b){
		firstSum.sendKeys(a);
		secondSum.sendKeys(b);
	}

	public void clickGetTotal(){
		getTotalButton.click();
	}
	
	public String getTotalResponse(){
		return driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
	}
}
