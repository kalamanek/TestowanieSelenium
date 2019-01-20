package testy.testCases.testDynamicDataLoadingDemo;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.data.Data;
import testy.pageObject.dynamicDataLoadingDemo.DynamicDataLoadingDemo;
import testy.testCases.BaseTestCase;

public class TestDynamicDataLoadingDemo extends BaseTestCase{
	@Test
	public void testDynamicDataLoadingDemo() throws InterruptedException, TimeoutException{
		DynamicDataLoadingDemo dynamicDataLoadingDemo = new DynamicDataLoadingDemo(driver);
		PageFactory.initElements(driver,dynamicDataLoadingDemo);
		
		dynamicDataLoadingDemo.openChildPage();
		
		String prevFirstNameAndLastName = "";
		String PrevImageUrl = "";
		
		for(int i = 0 ; i < 10 ; i++){
			dynamicDataLoadingDemo.clickButtonNewUser();
			dynamicDataLoadingDemo.waitForAllConnectionToClose();
			dynamicDataLoadingDemo.waitForDataChange(Data.defaultMaximumWaitingTime);

			assertThat(prevFirstNameAndLastName, not(dynamicDataLoadingDemo.getReplyData()));
			prevFirstNameAndLastName = dynamicDataLoadingDemo.getReplyData();

			assertThat(PrevImageUrl, not(dynamicDataLoadingDemo.getReplyDataImageUrl()));
			PrevImageUrl = dynamicDataLoadingDemo.getReplyDataImageUrl();
			
		}
	
	}

}
