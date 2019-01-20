package testy.testCases.testDragAndDropDemo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.dragAndDropDemo.DragAndDropDemo;
import testy.testCases.BaseTestCase;

public class TestDragAndDropDemo extends BaseTestCase{
	@Test
	public void testDragAndDropDemo() {
		DragAndDropDemo dragAndDropDemo = new DragAndDropDemo(driver);
		PageFactory.initElements(driver,dragAndDropDemo);
		
		dragAndDropDemo.openChildPage();
		
		dragAndDropDemo.dragElements();
		
		assertThat(dragAndDropDemo.getDroppedList(), containsString("Draggable 1"));
		assertThat(dragAndDropDemo.getDroppedList(), containsString("Draggable 2"));
		assertThat(dragAndDropDemo.getDroppedList(), containsString("Draggable 3"));
		assertThat(dragAndDropDemo.getDroppedList(), containsString("Draggable 4"));
		
	}
}
