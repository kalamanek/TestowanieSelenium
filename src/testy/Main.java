package testy;

public class Main {

	public static void main(String[] args) {
		test1 testowanie1 = new test1();
		testowanie1.prepareTests();
		testowanie1.test1Prepare();
		System.out.println("test 1 : " + testowanie1.test1Assertion());
		testowanie1.CleanDriver();

		test2 testowanie2 = new test2();
		testowanie2.prepareTests();
		testowanie2.test2Prepare();
		System.out.println("test 1 : " + testowanie2.test1Assertion());
		testowanie2.CleanDriver();
	}

}

