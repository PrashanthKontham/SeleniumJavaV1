package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import frameworklibrary.GlobalVariables;

public class Driver {

	private static WebDriver driver = null;
	
	private Driver() {
		
	}
	
	public static WebDriver intialize() {

		if (driver == null) {

			if (GlobalVariables.browserName.equals("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else if (GlobalVariables.browserName.equals("ie")) {
				System.setProperty("webdriver.ie.driver", GlobalVariables.ieDriverPath);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}else{
				System.setProperty("webdriver.chrome.driver", GlobalVariables.chromeDriverPath);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}

			return driver;

		} else {
			return driver;
		}

	}

	public static WebDriver getDriver() {

		if (driver != null)
			return driver;
		else {
			intialize();
			return driver;
		}
	}

	protected static void closeBrowser() {
		driver.close();
		driver = null;
	}

	public static void quitBrowser() {
		driver.quit();
		driver = null;
	}
}
