package testy.pageObject.checkboxDemo;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.data.Data;
import testy.pageObject.BasePage;

public class CheckboxDemo extends BasePage{
	
	private final String childUrl = "basic-checkbox-demo.html";
	
	@FindBy(xpath = "//input[@id='isAgeSelected']")
	private WebElement singleCheckbox;
	
	@FindBy(xpath = "//div[@id='txtAge']")
	private WebElement singleCheckboxText;
	
	@FindBy(xpath = "//input[@id='check1']")
	private WebElement checkboxSetButton;

	@FindBy(xpath = "//*[text()[contains(.,'Option 1')]]")
	private WebElement checkboxSet1;
	@FindBy(xpath = "//*[text()[contains(.,'Option 2')]]")
	private WebElement checkboxSet2;
	@FindBy(xpath = "//*[text()[contains(.,'Option 3')]]")
	private WebElement checkboxSet3;
	@FindBy(xpath = "//*[text()[contains(.,'Option 4')]]")
	private WebElement checkboxSet4;
	

	public CheckboxDemo(WebDriver driver) {
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
	
	public void singleCheckboxClick(){
		singleCheckbox.click();
	}
	
	public boolean isSingleCheckboxMarked(){
		return singleCheckboxText.isDisplayed();
	}
	
	public void setCheckboxClick(){
		checkboxSet1.click();
		checkboxSet2.click();
		checkboxSet3.click();
		checkboxSet4.click();
	}
	
	public void setCheckboxByButton(){
		checkboxSetButton.click();
	}
	
	public String setCheckboxButtonText(){
		return checkboxSetButton.getAttribute("value");
	}
	

}
