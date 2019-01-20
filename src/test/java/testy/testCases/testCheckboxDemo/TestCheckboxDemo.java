package testy.testCases.testCheckboxDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.checkboxDemo.CheckboxDemo;
import testy.testCases.BaseTestCase;

public class TestCheckboxDemo extends BaseTestCase{
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
	}
}
