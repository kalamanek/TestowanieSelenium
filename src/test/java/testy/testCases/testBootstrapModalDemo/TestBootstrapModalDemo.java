package testy.testCases.testBootstrapModalDemo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.data.Data;
import testy.pageObject.bootstrapModalDemo.BootstrapModalDemo;
import testy.testCases.BaseTestCase;

public class TestBootstrapModalDemo extends BaseTestCase{
	@Test
	public void testBootstrapModalDemo() throws InterruptedException, TimeoutException{
		BootstrapModalDemo bootstrapModalDemo = new BootstrapModalDemo(driver);
		PageFactory.initElements(driver,bootstrapModalDemo);
		
		bootstrapModalDemo.openChildPage();
		
		assertFalse(bootstrapModalDemo.isSingleModalDialogVisible());
		
		bootstrapModalDemo.singleModalButtonClick();
		bootstrapModalDemo.waitForSingleModalDialogVisible(Data.defaultMaximumWaitingTime);
		
		assertTrue(bootstrapModalDemo.isSingleModalDialogVisible());
		
		bootstrapModalDemo.singleModalDialogCloseClick();
		bootstrapModalDemo.waitForSingleModalDialogNotVisible(Data.defaultMaximumWaitingTime);
		
		assertFalse(bootstrapModalDemo.isSingleModalDialogVisible());
		
		bootstrapModalDemo.singleModalButtonClick();
		bootstrapModalDemo.waitForSingleModalDialogVisible(Data.defaultMaximumWaitingTime);
		
		assertTrue(bootstrapModalDemo.isSingleModalDialogVisible());
		
		bootstrapModalDemo.singleModalDialogSaveClick();
		bootstrapModalDemo.waitForAllConnectionToClose();
		
		assertFalse(bootstrapModalDemo.isSingleModalDialogVisible());

		bootstrapModalDemo.multipleModalButtonClick();
		bootstrapModalDemo.waitForMultipleModalDialogVisible(Data.defaultMaximumWaitingTime);
		bootstrapModalDemo.insideMultipleModalButtonClick();
		bootstrapModalDemo.waitForInsideMultipleModalDialogVisible(Data.defaultMaximumWaitingTime);
		bootstrapModalDemo.insideMultipleModalDialogSaveClick();
		bootstrapModalDemo.waitForAllConnectionToClose();
		
		assertFalse(bootstrapModalDemo.isAnyDialogVisible());
		
	}
}
