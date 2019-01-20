package testy.testCases.testBootstrapProgressBarDialogDemo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.bootstrapProgressBarDialogDemo.BootstrapProgressBarDialogDemo;
import testy.testCases.BaseTestCase;

public class TestBootstrapProgressBarDialogDemo extends BaseTestCase{
	@Test
	public void testBootstrapProgressBarDialogDemo(){
		BootstrapProgressBarDialogDemo bootstrapProgressBarDialogDemo = new BootstrapProgressBarDialogDemo(driver);
		PageFactory.initElements(driver,bootstrapProgressBarDialogDemo);
		
		bootstrapProgressBarDialogDemo.openChildPage();

		bootstrapProgressBarDialogDemo.simpleDialogButtonClick();
		
		assertTrue(bootstrapProgressBarDialogDemo.isModalBackdropActive());
		
		
		bootstrapProgressBarDialogDemo.waitForModal();

		assertFalse(bootstrapProgressBarDialogDemo.isModalBackdropActive());
		
		
		bootstrapProgressBarDialogDemo.dialogMessageButtonClick();
		bootstrapProgressBarDialogDemo.waitForModal();
		
		assertFalse(bootstrapProgressBarDialogDemo.isModalBackdropActive());
		
		
		bootstrapProgressBarDialogDemo.dialogSettingsButtonClick();
		bootstrapProgressBarDialogDemo.waitForModal();
		bootstrapProgressBarDialogDemo.hiddenDialogRunScrypt();
		bootstrapProgressBarDialogDemo.waitForAlert();
		assertTrue(bootstrapProgressBarDialogDemo.isAlertActive());


		bootstrapProgressBarDialogDemo.closeHiddenAlert();

		assertFalse(bootstrapProgressBarDialogDemo.isAlertActive());
		
	}
}
