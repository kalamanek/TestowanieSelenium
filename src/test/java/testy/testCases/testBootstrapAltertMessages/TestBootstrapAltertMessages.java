package testy.testCases.testBootstrapAltertMessages;

import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.data.Data;
import testy.pageObject.bootstrapAltertMessages.BootstrapAltertMessages;
import testy.testCases.BaseTestCase;

public class TestBootstrapAltertMessages extends BaseTestCase{
	@Test
	public void testBootstrapAltertMessages() throws TimeoutException{
		BootstrapAltertMessages bootstrapAltertMessages = new BootstrapAltertMessages(driver);
		PageFactory.initElements(driver,bootstrapAltertMessages);
		
		bootstrapAltertMessages.openChildPage();
		
		Assert.assertFalse(bootstrapAltertMessages.isAnyReplyMessageVisible());
		bootstrapAltertMessages.clickAllMessage();
		
		Assert.assertTrue(bootstrapAltertMessages.isAllReplyMessageVisible());
		Assert.assertTrue(bootstrapAltertMessages.isAllAutoclosableButtonDisabled());
		bootstrapAltertMessages.closeAllNormalReply();
		bootstrapAltertMessages.waitForAutoclosableReplyToDisappear(Data.defaultMaximumWaitingTime);
		Assert.assertFalse(bootstrapAltertMessages.isAnyReplyMessageVisible());
		
	}
}
