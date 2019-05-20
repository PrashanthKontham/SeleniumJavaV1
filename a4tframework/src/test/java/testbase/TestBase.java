package testbase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import base.Driver;
import frameworklibrary.GlobalVariables;
import frameworklibrary.Utils;

public class TestBase{

	@BeforeTest
	@Parameters({ "browserType" })
	public void beforeTest(String btype) {

		GlobalVariables.browserName = btype;
		Driver.intialize();
	}

	@AfterTest
	public void afterTest() {
		Driver.quitBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {

		Driver.getDriver().get(GlobalVariables.appURL);

	}

	@BeforeSuite
	public void beforeSuit() {

		Utils.setUpResultsFolder();

	}
	
	
}
