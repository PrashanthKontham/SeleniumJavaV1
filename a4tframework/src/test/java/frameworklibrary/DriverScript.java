package frameworklibrary;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import appbase.Appbase;

public class DriverScript implements IAnnotationTransformer, IInvokedMethodListener, ITestListener {
	
	String type;

	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation iAno, Class arg1, Constructor arg2, Method method) {

		try {

			System.out.println("Driver script started");
			if (ExcelUtility.getExecuteStatus(GlobalVariables.runManagerExlPath, GlobalVariables.runManagerExlSheetName,
					method.getName())) {
				iAno.setEnabled(true);
				iAno.setPriority(ExcelUtility.getPriority(GlobalVariables.runManagerExlPath,
						GlobalVariables.runManagerExlSheetName, method.getName()));
				iAno.setDescription(ExcelUtility.getDescription(GlobalVariables.runManagerExlPath,
						GlobalVariables.runManagerExlSheetName, method.getName()));

				  GlobalVariables.currentMethodNameForData=method.getName();
				  iAno.setDataProviderClass(TestDataClass.class);
				  iAno.setDataProvider("setData"); 
			}

			else {
				iAno.setEnabled(false);
			}

		}

		catch (IOException e) {
			System.out.println("Please check the path of run manager & test data file");
			System.exit(0);

		}

	}

	
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		//donothing
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		//do nothing
	}

	
	public void onFinish(ITestContext arg0) {
		ReporterClass.endTheTest();
		ReporterClass.writeToLogFile("info", "*********** Test ===> " + arg0.getName() + " Ended *******");
	}

	
	public void onStart(ITestContext arg0) {

		System.out.println("Test ==> " + arg0.getName() + " started ");
		try {

			GlobalVariables.currentTestName = arg0.getName();
			Utils.createTestResultsFolder(GlobalVariables.currentTestName);
			Utils.createTestLogResultsFolder();
			Utils.createScreenshotFolder();

			ReporterClass.Intialize();

		} catch (IOException e) {
			e.printStackTrace();
		}
		ReporterClass.writeToLogFile("info", "*********** Test ===> " + arg0.getName() + " Started *******");

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	
	public void onTestFailure(ITestResult arg0) {

		ReporterClass.writeToLogFile("error",
				"*********** Test Case ==> " + arg0.getMethod().getMethodName()
						+ ">> failed ******* pls check in class == " + arg0.getTestClass().getName() + " Reason is == "
						+ arg0.getThrowable());
		ReporterClass.writeToReport("fail",
				"*********** Test Case ==> " + arg0.getMethod().getMethodName()
						+ ">> failed ******* pls check in class == " + arg0.getTestClass().getName() + " Reason is == "
						+ arg0.getThrowable());
		Appbase.takeScreenshot();

	}

	
	public void onTestSkipped(ITestResult arg0) {
		ReporterClass.writeToLogFile("error",
				"*********** Test Case << " + arg0.getMethod().getMethodName()
						+ ">> skipped ******* pls check in class == " + arg0.getTestClass().getName()
						+ " and reason is " + arg0.getThrowable());
		ReporterClass.writeToReport("skip", "skippped TC pls check reason is == " + arg0.getThrowable());
	}

	
	public void onTestStart(ITestResult arg0) {

		int cnt = arg0.getMethod().getCurrentInvocationCount();
		String name = arg0.getMethod().getMethodName() + "_Iteration = " + (cnt + 1);
		ReporterClass.startTheTest(name, arg0.getMethod().getDescription());
		ReporterClass.writeToLogFile("info", "*********** Test Case ===>" + name + " Started *******");
		ReporterClass.writeToLogFile("info", "*********** Iteration ===> " + (cnt + 1) + " Started *******");

	}

	
	public void onTestSuccess(ITestResult arg0) {
		ReporterClass.writeToLogFile("info",
				"*********** Test Case ===> " + arg0.getMethod().getMethodName() + " completed succssfully *******");

	}

}
