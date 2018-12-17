package testy;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class test2 extends test{

	public test2(WebDriver driver) {
		super(driver);
	}
	public test2() {
		super();
	}

	public void test1Assertion(){
		assertTrue(pageBody().contains("Obrazy dla pieski"));
	}
}
