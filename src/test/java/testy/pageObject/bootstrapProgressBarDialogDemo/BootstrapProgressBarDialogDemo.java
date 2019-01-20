package testy.pageObject.bootstrapProgressBarDialogDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

import testy.pageObject.BasePage;

public class BootstrapProgressBarDialogDemo extends BasePage{
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement simpleDialogButton;		
	@FindBy(xpath = "//pre[contains(text(),'show();')]")
	private WebElement simpleDialogScrypt;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement dialogMessageButton;	
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	private WebElement dialogSettingsButton;	
	
	@FindBy(xpath= "//pre[contains(text(),'Callback!')]")
	private WebElement hiddenDialogScrypt;
	
	

	public BootstrapProgressBarDialogDemo(WebDriver driver) {
		super(driver);
		childUrl="bootstrap-progress-bar-dialog-demo.html";
	}
	
	private String addDialogWaiting(String scrypt,int time){
		return new String(scrypt + "setTimeout(function () {waitingDialog.hide();}," + time + ");" );
	}
	private String validateScrypt(String scrypt, int time){
		if(scrypt.contains("setTimeout(function () {waitingDialog.hide();},"))
			return scrypt;
		else
			return addDialogWaiting(scrypt,time);
	}
	
	public void simpleDialogButtonClick(){
		simpleDialogButton.click();
	}
	public void simpleDialogRunScrypt(){
		((JavascriptExecutor) driver).executeScript(
		validateScrypt(simpleDialogScrypt.getText(),2000));
	}
	
	public void hiddenDialogRunScrypt(){
		((JavascriptExecutor) driver).executeScript(
		validateScrypt(hiddenDialogScrypt.getText(),2000));
	}
	
	
	public void closeHiddenAlert(){
		driver.switchTo().alert().accept();
	}
	
	
	public void dialogMessageButtonClick(){
		dialogMessageButton.click();
	}
	public void dialogSettingsButtonClick(){
		dialogSettingsButton.click();
	}
	
	
}
