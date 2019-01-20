package testy.testCases.testAjaxFormSubmitDemo;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.ajaxFormSubmitDemo.AjaxFormSubmitDemo;
import testy.testCases.BaseTestCase;

public class TestAjaxFormSubmitDemo extends BaseTestCase {

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
		
		ajaxFormSubmitDemo.waitForAjaxMessageToChange(1000);
		assertThat(ajaxFormSubmitDemo.getAjaxMessage(), CoreMatchers.containsString("Form submited Successfully!"));
		
	}
}
