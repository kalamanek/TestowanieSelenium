package testy;

import static org.junit.Assert.assertTrue;

public class Main {

	public static void main(String[] args) throws Exception {
		test1 test1 = new test1();
		test1.openMainPage();
		test1.searchOnMainPage("kotki");
		assertTrue(test1.pageBody().contains("Obrazy dla kotki"));
		test2 test2 = new test2(test1.getDriver());
		test2.searchOnMainPage("pieski");
		assertTrue(test2.pageBody().contains("Obrazy dla pieski"));
		test2.closeDriver();
		
	}

}

