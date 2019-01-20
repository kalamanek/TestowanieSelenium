package testy.data;

public final class Data {
	
	public static final String mainUrl = "https://www.seleniumeasy.com/test/";
	
	public static final int defaultTimeout = 2;
	
	public static String driverPath;
	
	public static int defaultMaximumWaitingTime = 10000;
	
	
	public static String nativeJsDragAndDropHelper;
	static{
		nativeJsDragAndDropHelper = System.getProperty("user.dir") 
				+ "/src/test/java/testy/pageObject/dragAndDropDemo/native_js_drag_and_drop_helper.js";
		driverPath = System.getProperty("user.dir") + "/chrome/chromedriver.exe";
	}
	
}
