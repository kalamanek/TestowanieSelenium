package testy.testCases.testBasicFirstFromDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.basicFirstFormDemo.BasicFirstFromDemo;
import testy.testCases.BaseTestCase;

public class TestBasicFirstFromDemo extends BaseTestCase{

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
		
	}
}
