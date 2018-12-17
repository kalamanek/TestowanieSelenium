package testy;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class test1 extends test{

	public test1(WebDriver driver) {
		super(driver);
	}
	public test1() {
		super();
	}

	public void test1Assertion(){
		assertTrue(pageBody().contains("Obrazy dla pieski"));
	}
}
