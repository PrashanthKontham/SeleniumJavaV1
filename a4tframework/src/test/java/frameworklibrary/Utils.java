package frameworklibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends GlobalVariables {

	public static File dir;

	public static void setUpResultsFolder() {

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		currentTestResultsPath = System.getProperty("user.dir") + "\\Test-Results\\" + dateFormat.format(now);
		dir = new File(currentTestResultsPath);
		dir.mkdir();

	}

	public static void createTestResultsFolder(String testName) {

		currentTestPath = currentTestResultsPath + "\\" + testName;
		dir = new File(currentTestPath);
		dir.mkdir();

	}

	public static void createTestLogResultsFolder() {

		currentTestlogPath = currentTestPath + "\\logFiles";
		dir = new File(currentTestlogPath);
		dir.mkdir();

	}

	public static void createScreenshotFolder() {
		currentscreenshotPath = currentTestPath + "\\screenshots";
		dir = new File(currentscreenshotPath);
		dir.mkdir();
	}

	public static void delay(int timeout) {

		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}
