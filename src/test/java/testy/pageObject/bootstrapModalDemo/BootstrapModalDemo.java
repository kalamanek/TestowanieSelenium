package testy.pageObject.bootstrapModalDemo;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.pageObject.BasePage;

public class BootstrapModalDemo extends BasePage{
	
	@FindBy(xpath = "//a[contains(@href,'#myModal0')]")
	private WebElement singleModalButton;	

	@FindBy(xpath = "//div[contains(text(),'Multiple Modal Example')]/parent::div//div/a[contains(@href,'#myModal')]")
	private WebElement multipleModalButton;	
	
	@FindBy(xpath = "//a[contains(@href,'#myModal2')]")
	private WebElement InsideMultipleModalButton;	
	
	@FindBy(xpath = "//div[@id='myModal0']")
	private WebElement singleModalDialog;	
	@FindBy(xpath = "//div[@id='myModal0']/div/div/div/a[contains(text(),'Close')]")
	private WebElement singleModalDialogClose;	
	@FindBy(xpath = "//div[@id='myModal0']/div/div/div/a[contains(text(),'Save changes')]")
	private WebElement singleModalDialogSave;	
	
	@FindBy(xpath = "//div[@id='myModal']")
	private WebElement multipleModalDialog;	
	
	@FindBy(xpath = "//div[@id='myModal2']")
	private WebElement insideMultipleModalDialog;
	@FindBy(xpath = "//div[@id='myModal2']/div/div/div/a[contains(text(),'Save changes')]")
	private WebElement insideMultipleModalDialogSave;	
	
	public BootstrapModalDemo(WebDriver driver) {
		super(driver);
		childUrl="bootstrap-modal-demo.html";
	}
	public void singleModalButtonClick(){
		singleModalButton.click();
	}
	public void multipleModalButtonClick(){
		multipleModalButton.click();
	}
	public void insideMultipleModalButtonClick(){
		InsideMultipleModalButton.click();
	}
	public boolean isSingleModalDialogVisible(){
		return singleModalDialog.isDisplayed();
	}
	public void waitForSingleModalDialogVisible(int timeout) throws InterruptedException, TimeoutException{
		waitForElement(timeout , singleModalDialog ,  elem -> elem.isDisplayed());
	}
	public void waitForMultipleModalDialogVisible(int timeout) throws InterruptedException, TimeoutException{
		waitForElement(timeout , multipleModalDialog ,  elem -> elem.isDisplayed());
	}
	public void waitForInsideMultipleModalDialogVisible(int timeout) throws InterruptedException, TimeoutException{
		waitForElement(timeout , insideMultipleModalDialog ,  elem -> elem.isDisplayed());
	}
	
	public void insideMultipleModalDialogSaveClick(){
		insideMultipleModalDialogSave.click();
	}
	
	public void waitForSingleModalDialogNotVisible(int timeout) throws InterruptedException, TimeoutException{
		waitForElement(timeout , singleModalDialog , elem -> elem.isDisplayed());
		//waitForElement(timeout , singleModalDialog , elem -> elem.getText().contains("modal-backdrop fade modal-stack"));
		waitForModal();
		
	}
	
	public void singleModalDialogCloseClick(){
		singleModalDialogClose.click();
	}
	public void singleModalDialogSaveClick(){
		singleModalDialogSave.click();
	}
	
	public boolean isAnyDialogVisible(){
		return singleModalDialog.isDisplayed() || multipleModalDialog.isDisplayed() || insideMultipleModalDialog.isDisplayed();
	}

}
