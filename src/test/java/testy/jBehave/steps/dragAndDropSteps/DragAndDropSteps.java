package testy.jBehave.steps.dragAndDropSteps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.support.PageFactory;

import testy.jBehave.steps.basicFirstFormSteps.BasicFirstFormSteps;
import testy.pageObject.dragAndDropDemo.DragAndDropDemo;

public class DragAndDropSteps extends BasicFirstFormSteps{
	DragAndDropDemo page;
	 
	 @Given("open DragAndDropDemo page")
	 public void theGameIsRunning() {
			page = new DragAndDropDemo(driver);
			PageFactory.initElements(driver,page);
			page.openChildPage();
	 }
	 
	 @When("drag all elements")
	 public void dragElements(){
		 page.dragElements();
	 }
	 
	 @Then("they should be in drop zone")
	 public void checkDropZone(){
			assertThat(page.getDroppedList(), containsString("Draggable 1"));
			assertThat(page.getDroppedList(), containsString("Draggable 2"));
			assertThat(page.getDroppedList(), containsString("Draggable 3"));
			assertThat(page.getDroppedList(), containsString("Draggable 4"));
	 }
	
}
