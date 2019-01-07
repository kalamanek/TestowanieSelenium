package testy.pageObject.basicRadiobuttonDemo;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testy.data.Data;
import testy.pageObject.BasePage;

public class BasicRadiobuttonDemo extends BasePage{
	
	private final String childUrl = "basic-radiobutton-demo.html";
	

	@FindBy(xpath = "//input[@value='Male' and @name='optradio']")
	private WebElement radiobuttonMale;
	@FindBy(xpath = "//input[@value='Female' and @name='optradio']")
	private WebElement radiobuttonFemale;
	
	@FindBy(xpath = "//button[@id='buttoncheck']")
	private WebElement buttonGetCheckedValue;

	@FindBy(xpath = "//p[@class='radiobutton']")
	private WebElement checkbutton;
	
	
	@FindBy(xpath = "//button[@onclick='getValues();']")
	private WebElement groupButtonGetValue;

	@FindBy(xpath = "//p[@class='groupradiobutton']")
	private WebElement groupCheckbutton;
	

	public BasicRadiobuttonDemo (WebDriver driver) {
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
	
	public void checkMaleAndClickButton(){
		radiobuttonMale.click();
		buttonGetCheckedValue.click();
	}
	
	public void checkFemaleAndClickButton(){
		radiobuttonFemale.click();
		buttonGetCheckedValue.click();
	}
	
	public String getCheckbuttonText(){
		return checkbutton.getText();
	}

	
	//return radioButton by name and value
	public WebElement getWebElementByValue(String value , String name){
		try{
			return driver.findElement(By.xpath("//input[@value='" + value + "' and @name='" + name + "']"));
		} catch(NoSuchElementException e) {
			throw e;
	    }
		
	}
	
	public void groupRadioButtonCheckAndClickButton(String sexValue, String ageValue){
		getWebElementByValue(sexValue,"gender").click();
		getWebElementByValue(ageValue,"ageGroup").click();
		groupButtonGetValue.click();
		
	}
	
	public String getGroupCheckbuttonText(){
		return groupCheckbutton.getText();
	}
	
	
	
	
}
