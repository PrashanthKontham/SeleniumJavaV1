package appbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import base.Driver;
import frameworklibrary.GlobalVariables;
import frameworklibrary.ReporterClass;
import objectrepository.Locator;
import objectrepository.ObjectRepository;

public class Appbase implements ObjectRepository {

	public static WebDriver getDriver() {
		return Driver.getDriver();
	}
	
	protected void setText(String value, Locator locator) {

		if (value != null) {
			if (!value.isEmpty()) {
				if (displayedAndVisibleOnPage(locator)) {
					getDriver().findElement(locator.getLocator()).clear();
					getDriver().findElement(locator.getLocator()).sendKeys(value);
					ReporterClass.writeToReport("pass", "Entered value -> " + value + " in " + locator.getName());
				} else {
					ReporterClass.writeToReport("fail",
							"Failed to enter value -> " + value + " in " + locator.getName());
				}

			}
		}
	}

	protected void appendText(String value, Locator locator) {
		if (value != null) {
			if (!value.isEmpty()) {
				if (displayedAndVisibleOnPage(locator)) {
					getDriver().findElement(locator.getLocator()).sendKeys(value);
				} else {
					System.out.println("textbox " + locator.getName() + " not found on page");
				}

			}
		}
	}

	protected boolean displayedAndVisibleOnPage(final Locator locator) {
		try {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
						.withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(5))
				       .ignoring(NoSuchElementException.class);
			
			
			WebElement ele=wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(locator.getLocator());
			     }
			   });
			
			if(ele.isDisplayed())
			return true;
			else
			return false;	
			
				   
		} catch (Exception e) {
			System.out.println(
					"Element " + locator.getName() + " not found within " + GlobalVariables.maxTimeLoad + " seconds");
			return false;
		}
	}

	protected boolean locatorEnabled(Locator locator) {

		if (displayedAndVisibleOnPage(locator)) {
			if (getDriver().findElement(locator.getLocator()).isEnabled()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	protected void clickOn(Locator locator) {

		if (locatorEnabled(locator)) {
			getDriver().findElement(locator.getLocator()).click();
			ReporterClass.writeToReport("pass", "Clicked on -> " + locator.getName());
		} else {
			ReporterClass.writeToReport("fail", "Failed to click on -> " + locator.getName());
		}

	}

	protected void pressEscapeKey(Locator locator) {

		if (locatorEnabled(locator)) {
			getDriver().findElement(locator.getLocator()).sendKeys(Keys.ESCAPE);
			ReporterClass.writeToReport("pass", "Pressed ESCAPE button on -> " + locator.getName());
		} else {
			ReporterClass.writeToReport("fail", "Failed to Press ESCAPE button on -> " + locator.getName());
		}

	}
	
	protected void selectFromDropDown(String value,Locator locator) {

		if(value!=null){
		if(!value.trim().isEmpty()){
		if (locatorEnabled(locator)) {
			Select select=new Select(locator.getWebElement());
			try{
				select.selectByVisibleText(value);
				ReporterClass.writeToReport("pass", "Value " + value + " selected from " + locator.getName());
			}catch(Exception e){
				ReporterClass.writeToReport("fail", "Value " + value + " NOT selected from " + locator.getName());
			}
			
		} else {
			ReporterClass.writeToReport("fail", "Value " + value + " NOT selected from " + locator.getName());
		}
		}
		}
	}
	
	protected void openURL() {
		getDriver().get(GlobalVariables.appURL);
	}
	
	public static void takeScreenshot() {
		TakesScreenshot ts = ((TakesScreenshot) getDriver());
		File src = ts.getScreenshotAs(OutputType.FILE);

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		try {

			// String
			// imp=currentscreenshotPath+"//"+GlobalVariables.currentTestCaseName+"_"+dateFormat.format(now)+".png";
			// System.out.println("imp========= "+imp);
			
			FileHandler.copy(src, new File(GlobalVariables.currentscreenshotPath + "//" + GlobalVariables.currentTestCaseName + "_"
					+ dateFormat.format(now) + ".png"));
			
			/*FileUtils.copyFile(src, new File(GlobalVariables.currentscreenshotPath + "//" + GlobalVariables.currentTestCaseName + "_"
					+ dateFormat.format(now) + ".png"));*/
			
		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}
	
	public boolean verifyTableData(String expValue,Locator locator){
		
		List<WebElement> rows=getDriver().findElements(locator.getLocator());
		boolean flag=false;
		
		for(int j=0;j<rows.size();j++){
	
			List<WebElement> cells=rows.get(j).findElements(By.tagName("td"));
			
			if(cells.get(1).getText().equals(expValue)){
				flag=true;
				break;
			}
			
		}
		
		return flag;
		
	}
	

}
