package frameworklibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReporterClass {

	public static ExtentReports er;
	public static ExtentTest et;
	public static Logger Log;

	public static void Intialize() throws IOException {

		setupLogFile();
		er = new ExtentReports(GlobalVariables.currentTestPath + "\\testSummary.html", true);

		Log = Logger.getLogger(ReporterClass.class.getName());
		PropertyConfigurator.configure(GlobalVariables.log4jPropFilePath);

	}

	public static void setupLogFile() throws IOException {
		FileInputStream in = new FileInputStream(GlobalVariables.log4jPropFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();

		FileOutputStream out = new FileOutputStream(GlobalVariables.log4jPropFilePath);

		props.setProperty("log4j.appender.FILE.File", GlobalVariables.currentTestlogPath + "\\htmlLogReport.html");
		props.setProperty("log4j.appender.FA.File", GlobalVariables.currentTestlogPath + "\\logReport.log");

		props.store(out, null);
		out.close();

	}

	public static void startTheTest(String tcName, String desc) {
		et = er.startTest(tcName, desc);
	}

	public static void writeToReport(String status, String stepDesc) {
		switch (status) {
		case "pass":
			et.log(LogStatus.PASS, stepDesc);
			break;

		case "fail":
			et.log(LogStatus.FAIL, stepDesc);
			break;

		case "info":
			et.log(LogStatus.INFO, stepDesc);
			break;

		case "error":
			et.log(LogStatus.ERROR, stepDesc);
			break;

		case "skip":
			et.log(LogStatus.SKIP, stepDesc);
			break;

		case "fatal":
			et.log(LogStatus.FATAL, stepDesc);
			break;

		case "warn":
			et.log(LogStatus.WARNING, stepDesc);
			break;
		}
	}

	public static void writeToLogFile(String status, String stepDesc) {
		switch (status) {

		case "info":
			Log.info(stepDesc);
			break;

		case "error":
			Log.error(stepDesc);
			break;

		}
	}

	public static void endTheTest() {
		er.endTest(et);
		er.flush();
	}

}
