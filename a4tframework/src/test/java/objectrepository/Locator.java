package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import base.Driver;

public class Locator {

	String name;
	By loc;
	ByAll locAll;
	
	WebElement element;
	
	public Locator(By loc,String logicalName) {
		this.loc = loc;
		this.name = logicalName;
	}
	
	public Locator(String logicalName,By ...locAll) {
		this.locAll = new ByAll(locAll);
		this.name = logicalName;
	}
	
	public String getName() {
		return this.name;
	}

	public By getLocator() {
		
		if(loc!=null)
		return this.loc;
		else
		return this.locAll;	
	
	}
	
	public WebElement getWebElement() {
		element=Driver.getDriver().findElement(this.getLocator());
		return this.element;
	}

}
