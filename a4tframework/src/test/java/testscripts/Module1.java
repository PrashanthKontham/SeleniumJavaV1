package testscripts;

import org.testng.annotations.Test;

import pageobjects.LoginPage;
import testbase.TestBase;

public class Module1 extends TestBase {
	
	@Test
	public void TC01_searchDirectory(){
		
		LoginPage login=new LoginPage();
		login.loginToApplication();
		
		login.logoutFromApplication();
		
	}

}
