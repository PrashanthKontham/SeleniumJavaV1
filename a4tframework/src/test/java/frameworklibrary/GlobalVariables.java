package frameworklibrary;

public class GlobalVariables {

	public final static String runManagerExlPath = System.getProperty("user.dir") + "\\TestData\\RunManager.xlsx";
	public final static String testDataExlPath = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";
	public final static String log4jPropFilePath = System.getProperty("user.dir") + "\\log4j.properties";

	public final static String runManagerExlSheetName = "RunManager";
	public final static String testDataExlSheetName = "TestData";

	public static String currentMethodNameForData="";
	
	public static String browserName = "";
	public static final String appURL = "https://opensource-demo.orangehrmlive.com";

	public static final String userID = "automation";
	public static final String password = "Pass1234";

	public static final String ieDriverPath = System.getProperty("user.dir")
			+ "\\BrowserServers\\IEDriverServer.exe";
	public final static String chromeDriverPath = System.getProperty("user.dir")
			+ "\\BrowserServers\\chromedriver.exe";

	public final static String ffDriverPath = System.getProperty("user.dir")
			+ "\\BrowserServers\\geckodriver.exe";
	
	public static final long maxTimeLoad = 5;

	public static String currentTestResultsPath;
	public static String currentTestPath;
	public static String currentTestlogPath;
	public static String currentscreenshotPath;
	public static String currentTestName;
	public static String currentTestCaseName;

}
