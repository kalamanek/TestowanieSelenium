package testy.pageObject.bootstrapAltertMessages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.pageObject.BasePage;

public class BootstrapAltertMessages  extends BasePage{

	@FindBy(xpath = "//button[@id='autoclosable-btn-success']")
	private WebElement autoclosableSuccesButton;	
	@FindBy(xpath = "//div[@class='alert alert-success alert-autocloseable-success']")
	private WebElement autoclosableSuccesReply;
	
	
	@FindBy(xpath = "//button[@id='normal-btn-success']")
	private WebElement normalSuccesButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-normal-success']")
	private WebElement normalSuccesReply;
	@FindBy(xpath = "//div[@class='alert alert-success alert-normal-success']/button[@class='close']")
	private WebElement normalSuccesReplyClose;
	
	
	@FindBy(xpath = "//button[@id='autoclosable-btn-warning']")
	private WebElement autoclosableWarningButton;
	@FindBy(xpath = "//div[@class='alert alert-warning alert-autocloseable-warning']")
	private WebElement autoclosableWarningReply;
	
	
	@FindBy(xpath = "//button[@id='normal-btn-warning']")
	private WebElement normalWarrningButton;
	@FindBy(xpath = "//div[@class='alert alert-warning alert-normal-warning']")
	private WebElement normalWarrningReply;
	@FindBy(xpath = "//div[@class='alert alert-warning alert-normal-warning']/button[@class='close']")
	private WebElement normalWarrningReplyClose;
	
	
	@FindBy(xpath = "//button[@id='autoclosable-btn-danger']")
	private WebElement autoclosableDangerButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-autocloseable-danger']")
	private WebElement autoclosableDangerReply;
	
	
	@FindBy(xpath = "//button[@id='normal-btn-danger']")
	private WebElement normalDangerButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-normal-danger']")
	private WebElement normalDangerReply;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-normal-danger']/button[@class='close']")
	private WebElement normalDangerReplyClose;	
	
	
	@FindBy(xpath = "//button[@id='autoclosable-btn-info']")
	private WebElement autoclosableInfoButton;
	@FindBy(xpath = "//div[@class='alert alert-info alert-autocloseable-info']")
	private WebElement autoclosableInfoReply;
	
	
	@FindBy(xpath = "//button[@id='normal-btn-info']")
	private WebElement normalInfoButton;
	@FindBy(xpath = "//div[@class='alert alert-info alert-normal-info']")
	private WebElement normalInfoReply;
	@FindBy(xpath = "//div[@class='alert alert-info alert-normal-info']/button[@class='close']")
	private WebElement normalInfoReplyClose;
	

	

	public BootstrapAltertMessages(WebDriver driver) {
		super(driver);
		childUrl = "bootstrap-alert-messages-demo.html";
	}
	
	public void clickAllMessage(){
		autoclosableSuccesButton.click();
		normalSuccesButton.click();

		autoclosableWarningButton.click();
		normalWarrningButton.click();

		autoclosableDangerButton.click();
		normalDangerButton.click();

		autoclosableInfoButton.click();
		normalInfoButton.click();
	}
	
	private boolean isElementVisible(WebElement element){
		return element.isDisplayed();
	//	return element.getAttribute("style").contains("display: block;");
	}
	
	public void closeAllNormalReply(){
		normalSuccesReplyClose.click();
		normalWarrningReplyClose.click();
		normalDangerReplyClose.click();
		normalInfoReplyClose.click();;
	}
	
	public boolean isAllReplyMessageVisible(){
		if(!isElementVisible(autoclosableSuccesReply))
			return false;
		if(!isElementVisible(normalSuccesReply))
			return false;
		if(!isElementVisible(autoclosableWarningReply))
			return false;
		if(!isElementVisible(normalWarrningReply))
			return false;
		if(!isElementVisible(autoclosableDangerReply))
			return false;
		if(!isElementVisible(normalDangerReply))
			return false;
		if(!isElementVisible(autoclosableInfoReply))
			return false;
		if(!isElementVisible(normalInfoReply))
			return false;
		
		return true;
	}
	
	public boolean isAnyReplyMessageVisible(){
		if(isElementVisible(autoclosableSuccesReply))
			return true;
		if(isElementVisible(normalSuccesReply))
			return true;
		if(isElementVisible(autoclosableWarningReply))
			return true;
		if(isElementVisible(normalWarrningReply))
			return true;
		if(isElementVisible(autoclosableDangerReply))
			return true;
		if(isElementVisible(normalDangerReply))
			return true;
		if(isElementVisible(autoclosableInfoReply))
			return true;
		if(isElementVisible(normalInfoReply))
			return true;
		
		return false;
	}
	
	
	public boolean isAllAutoclosableButtonDisabled(){
		if(autoclosableSuccesButton.isEnabled())
			return false;
		if(autoclosableWarningButton.isEnabled())
			return false;
		if(autoclosableDangerButton.isEnabled())
			return false;
		if(autoclosableInfoButton.isEnabled())
			return false;
		
		return true;
	}
	public boolean isAnyAutoclosableButtonDisabled(){
		if(!autoclosableSuccesButton.isEnabled())
			return true;
		if(!autoclosableWarningButton.isEnabled())
			return true;
		if(!autoclosableDangerButton.isEnabled())
			return true;
		if(!autoclosableInfoButton.isEnabled())
			return true;
		
		return false;
	}

	public void waitForAutoclosableReplyToDisappear(int timeout) throws TimeoutException {
		try{
			do{
				timeout--;
				Thread.sleep(1);
	
			}while (timeout > 0 && isAnyAutoclosableButtonDisabled());
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		if(timeout==0){
			throw new TimeoutException("timeout waiting for isAnyAutoclosableButtonEnabled");
		}
	}

}
