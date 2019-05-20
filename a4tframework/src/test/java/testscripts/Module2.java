package testscripts;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.MyInfoPage;
import testbase.TestBase;

public class Module2 extends TestBase {
	
	
	@Test
	public void TC02_addEmergnecyDetails(List<Map<String, String>> testdata){
		
		LoginPage login=new LoginPage();
		login.loginToApplication();
		
		MyInfoPage page=new MyInfoPage();
		for(Map<String, String> eachTestData:testdata) {
			page.fillEmergencyDetails(eachTestData);
		}		
		
		login.logoutFromApplication();
		
	}

}
