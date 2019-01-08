package testy.cases;

import testy.pageObject.ajaxFormSubmitDemo.AjaxFormSubmitDemo;
import testy.pageObject.basicFirstFormDemo.BasicFirstFromDemo;
import testy.pageObject.basicRadiobuttonDemo.BasicRadiobuttonDemo;
import testy.pageObject.checkboxDemo.CheckboxDemo;
import testy.pageObject.dragAndDropDemo.DragAndDropDemo;
import testy.pageObject.dynamicDataLoadingDemo.DynamicDataLoadingDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import junit.framework.*;
import testy.data.*;

public class TestsOnAllWebsites {

	private WebDriver driver;
	@Before
	 public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Data.defaultTimeout, TimeUnit.SECONDS);
	}
	
	//first page test
	@SuppressWarnings("deprecation")
	/*
	@Test
	public void testBasicFirstFromDemo(){
		BasicFirstFromDemo basicFirstFromDemo = new BasicFirstFromDemo(driver);
		PageFactory.initElements(driver,basicFirstFromDemo);
		
		String messageTestString = "costam";
		
		basicFirstFromDemo.openChildPage();
		
		basicFirstFromDemo.insertMessage(messageTestString);
		basicFirstFromDemo.clickMessageButton();
		
		Assert.assertEquals(messageTestString, basicFirstFromDemo.getInputMessageResponse());
		
		
		String a = "32";
		String b = "22";
		String expectedReply = "54";
		
		basicFirstFromDemo.insertSum(a,b);
		basicFirstFromDemo.clickGetTotal();

		Assert.assertEquals(expectedReply , basicFirstFromDemo.getTotalResponse());
		
		//Thread.sleep(3000);
	}
	
	//second page test
	@Test
	public void testDragAndDropDemo() {
		DragAndDropDemo dragAndDropDemo = new DragAndDropDemo(driver);
		PageFactory.initElements(driver,dragAndDropDemo);
		
		dragAndDropDemo.openChildPage();
		
		dragAndDropDemo.dragElements();
		
		//System.out.println(dragAndDropDemo.getDroppedList());

		assertThat(dragAndDropDemo.getDroppedList(), CoreMatchers.containsString("Draggable 1"));
		assertThat(dragAndDropDemo.getDroppedList(), CoreMatchers.containsString("Draggable 2"));
		assertThat(dragAndDropDemo.getDroppedList(), CoreMatchers.containsString("Draggable 3"));
		assertThat(dragAndDropDemo.getDroppedList(), CoreMatchers.containsString("Draggable 4"));
		
		//Thread.sleep(3000);
	}
	//third page test
	
	@Test
	public void testCheckboxDemo() throws Exception {
		CheckboxDemo checkboxDemo = new CheckboxDemo(driver);
		PageFactory.initElements(driver,checkboxDemo);
		
		
		checkboxDemo.openChildPage();

		
		checkboxDemo.singleCheckboxClick();
		Assert.assertTrue(checkboxDemo.isSingleCheckboxMarked());

		checkboxDemo.singleCheckboxClick();
		Assert.assertFalse(checkboxDemo.isSingleCheckboxMarked());

		
		checkboxDemo.setCheckboxClick();
		Assert.assertEquals(checkboxDemo.setCheckboxButtonText() , "Uncheck All");

		checkboxDemo.setCheckboxByButton();
		Assert.assertEquals(checkboxDemo.setCheckboxButtonText() , "Check All");

		//Thread.sleep(3000);
	}
	//4
	@Test
	public void testBasicRadiobuttonDemo()throws Exception{
		BasicRadiobuttonDemo basicRadiobuttonDemo = new BasicRadiobuttonDemo(driver);
		PageFactory.initElements(driver,basicRadiobuttonDemo);
		
		
		basicRadiobuttonDemo.openChildPage();
		
		basicRadiobuttonDemo.checkMaleAndClickButton();
		Assert.assertEquals(basicRadiobuttonDemo.getCheckbuttonText() , "Radio button 'Male' is checked");

		basicRadiobuttonDemo.checkFemaleAndClickButton();
		Assert.assertEquals(basicRadiobuttonDemo.getCheckbuttonText() , "Radio button 'Female' is checked");

		

		String[] avalableGrander = {"Male" , "Female"};
		String[] avalableAgeRange = {"0 - 5" , "5 - 15" , "15 - 50"};
		
		for(String grander: avalableGrander){
			for(String ageRange: avalableAgeRange){
				basicRadiobuttonDemo.groupRadioButtonCheckAndClickButton(grander , ageRange);
				assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(grander));
				assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(ageRange));
			}
		}
		//Thread.sleep(3000);
		
	}
	//5
	@Test
	public void testAjaxFormSubmitDemo()throws Exception{
		AjaxFormSubmitDemo ajaxFormSubmitDemo = new AjaxFormSubmitDemo(driver);
		PageFactory.initElements(driver,ajaxFormSubmitDemo);
		
		ajaxFormSubmitDemo.openChildPage();
		
		Assert.assertFalse(ajaxFormSubmitDemo.isNameFieldColorRed());
		ajaxFormSubmitDemo.clickSubmitButton();
		Assert.assertTrue(ajaxFormSubmitDemo.isNameFieldColorRed());

		ajaxFormSubmitDemo.setNameField("lubie Placki");
		ajaxFormSubmitDemo.setCommentField("a jestem glodny");
		ajaxFormSubmitDemo.clickSubmitButton();
		assertThat(ajaxFormSubmitDemo.getAjaxMessage(), CoreMatchers.containsString("Ajax Request is Processing!"));
		ajaxFormSubmitDemo.waitForAjaxMessageToChange(10000);
		assertThat(ajaxFormSubmitDemo.getAjaxMessage(), CoreMatchers.containsString("Form submited Successfully!"));
		
		
		//Thread.sleep(3000);
	}
	*/
	
	@Test
	public void testDynamicDataLoadingDemo() throws InterruptedException, TimeoutException{
		DynamicDataLoadingDemo dynamicDataLoadingDemo = new DynamicDataLoadingDemo(driver);
		PageFactory.initElements(driver,dynamicDataLoadingDemo);
		
		dynamicDataLoadingDemo.openChildPage();
		
		String prevFirstNameAndLastName = "";
		String PrevImageUrl = "";
		
		for(int i = 0 ; i < 10 ; i++){
//			System.out.println(i);
			dynamicDataLoadingDemo.clickButtonNewUser();
			dynamicDataLoadingDemo.waitForAllConnectionToClose();
			dynamicDataLoadingDemo.waitForDataChange(10000);

			synchronized(prevFirstNameAndLastName){
				assertThat(prevFirstNameAndLastName, not(dynamicDataLoadingDemo.getReplyData()));
			}
			synchronized(prevFirstNameAndLastName){
				prevFirstNameAndLastName = dynamicDataLoadingDemo.getReplyData();
			}
			

			assertThat(PrevImageUrl, not(dynamicDataLoadingDemo.getReplyDataImageUrl()));
			PrevImageUrl = dynamicDataLoadingDemo.getReplyDataImageUrl();
//			System.out.println(PrevImageUrl);
			
		}
		
	}
	
	@After
	public void cleanUp(){
        driver.close();
        driver.quit();
	}
	
}
