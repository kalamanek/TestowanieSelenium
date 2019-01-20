package testy.testCases.testTablePaginationDemo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import testy.pageObject.tablePaginationDemo.TablePaginationDemo;
import testy.testCases.BaseTestCase;

public class TestTablePaginationDemo extends BaseTestCase{
	@Test
	public void testTablePaginationDemo() throws InterruptedException{
		TablePaginationDemo tablePaginationDemo = new TablePaginationDemo(driver);
		PageFactory.initElements(driver,tablePaginationDemo);
		
		tablePaginationDemo.openChildPage();
		
		assertTrue(tablePaginationDemo.isNextButtonVisible());
		assertFalse(tablePaginationDemo.isPrevButtonVisible());
		
		assertTrue("Too many records ", tablePaginationDemo.countVisibleRecords() <= 5	);
		tablePaginationDemo.clickButtonTwo();

		assertTrue("Too many records ", tablePaginationDemo.countVisibleRecords() <= 5	);
		assertTrue(tablePaginationDemo.isNextButtonVisible());
		assertTrue(tablePaginationDemo.isPrevButtonVisible());

		tablePaginationDemo.clickButtonThree();
		
		assertTrue("Too many records ", tablePaginationDemo.countVisibleRecords() <= 5	);
		assertFalse(tablePaginationDemo.isNextButtonVisible());
		assertTrue(tablePaginationDemo.isPrevButtonVisible());
	}
}
