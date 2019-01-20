package testy.pageObject.ajaxFormSubmitDemo;


import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.pageObject.BasePage;

public class AjaxFormSubmitDemo extends BasePage{

	@FindBy(xpath = "//input[@id='title']")
	private WebElement nameField;
	
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement commentField;	
	
	@FindBy(xpath = "//input[@onclick='ajaxSubmit();']")
	private WebElement sumbmitButton;	

	@FindBy(xpath = "//div[@id='submit-control']")
	private WebElement ajaxResponse;
	
	
	public AjaxFormSubmitDemo(WebDriver driver) {
		super(driver);
		childUrl = "ajax-form-submit-demo.html";
	}

	
	public void clickSubmitButton(){
		sumbmitButton.click();
	}
	
	public boolean isNameFieldColorRed(){
		return nameField.getAttribute("style").contains("border: 1px solid rgb(255, 0, 0);");
	}
	
	public void setNameField(String name){
		nameField.sendKeys(name);
	}
	public void setCommentField(String comment){
		commentField.sendKeys(comment);
	}
	
	//loop till message change 
	public void waitForAjaxMessageToChange(int timeout) throws TimeoutException, InterruptedException {
		waitForElementStringToChange(ajaxResponse , timeout);
	}
	
	
	public String getAjaxMessage(){
		return ajaxResponse.getText();
	}
	
}
