package testy.pageObject.ajaxFormSubmitDemo;


import java.util.concurrent.TimeoutException;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.data.Data;
import testy.pageObject.BasePage;

public class AjaxFormSubmitDemo extends BasePage{

	private final String childUrl = "ajax-form-submit-demo.html";

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
	}
	
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
	
	//wait for all the connections to the server to close
//	public void waitForAjax() {
//		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() { 
//	        public Boolean apply(WebDriver wdriver) { 
//	            return ((JavascriptExecutor) driver).executeScript(
//	                    "return jQuery.active == 0").equals(true);
//	        }
//	    }); 
//	}
	
	//loop till message change or 
	public void waitForAjaxMessageToChange(int timeout) throws InterruptedException, TimeoutException {
		String ajaxMessage = ajaxResponse.getText();
		String newAjaxMessage;
		do{
			newAjaxMessage = ajaxResponse.getText();
			
			timeout--;
			Thread.sleep(1000);
		}while (timeout > 0 && newAjaxMessage == ajaxMessage );
		
		if(timeout==0){
			throw new TimeoutException("timeout waiting for ajax");
		}
	}
	
	public String getAjaxMessage(){
		return ajaxResponse.getText();
	}
	
}
