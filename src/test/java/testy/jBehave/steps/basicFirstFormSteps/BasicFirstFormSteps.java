package testy.jBehave.steps.basicFirstFormSteps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import testy.jBehave.steps.BasicJBehaveSteps;
import testy.pageObject.basicFirstFormDemo.BasicFirstFromDemo;

public class BasicFirstFormSteps extends BasicJBehaveSteps{
	 BasicFirstFromDemo page;
	
	 @Given("open BasicFirstForm page")
	 public void theGameIsRunning() {
			page = new BasicFirstFromDemo(driver);
			PageFactory.initElements(driver,page);
			page.openChildPage();
	 }
	 
	 @When("add $a to $b")
	 public void add(String a , String b){
		page.insertSum(a,b);
		page.clickGetTotal();
	 }
	 @When("insert message $message")
	 public void insertMessage(String message){
		 page.insertMessage(message);
		 page.clickMessageButton();
	 }
	 
	 @Then("add result should be $result")
	 public void checkResult(String result){
		 Assert.assertEquals(result , page.getTotalResponse());
	 }
	 
	 @Then("message should contains $message")
	 public void checkMessage(String message){
		 Assert.assertTrue(page.getInputMessageResponse().contains(message));
	 }
}
