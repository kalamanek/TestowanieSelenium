package testy.testCases.testBasicRadiobuttonDemo;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.basicRadiobuttonDemo.BasicRadiobuttonDemo;
import testy.testCases.BaseTestCase;

public class TestBasicRadiobuttonDemo extends BaseTestCase {
	@Test
	public void testBasicRadiobuttonDemo()throws Exception{
		BasicRadiobuttonDemo basicRadiobuttonDemo = new BasicRadiobuttonDemo(driver);
		PageFactory.initElements(driver,basicRadiobuttonDemo);
		
		
		basicRadiobuttonDemo.openChildPage();
		
		basicRadiobuttonDemo.checkMaleAndClickButton();
		Assert.assertEquals(basicRadiobuttonDemo.getCheckbuttonText() , "Radio button 'Male' is checked");
		basicRadiobuttonDemo.checkFemaleAndClickButton();
		Assert.assertEquals(basicRadiobuttonDemo.getCheckbuttonText() , "Radio button 'Female' is checked");
		
//		String[] avalableGrander = {"Male" , "Female"};
//		String[] avalableAgeRange = {"0 - 5" , "5 - 15" , "15 - 50"};
//		
//		for(String grander: avalableGrander){
//			for(String ageRange: avalableAgeRange){
//				basicRadiobuttonDemo.groupRadioButtonCheckAndClickButton(grander , ageRange);
//				assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(grander));
//				assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(ageRange));
//			}
//		}
		
		String grander = "Male";
		String ageRange = "5 - 15";
		basicRadiobuttonDemo.groupRadioButtonCheckAndClickButton(grander , ageRange);
		assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(grander));
		assertThat(basicRadiobuttonDemo.getGroupCheckbuttonText(), CoreMatchers.containsString(ageRange));
		
	}
}
