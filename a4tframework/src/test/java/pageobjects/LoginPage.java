package pageobjects;

import appbase.Appbase;
import frameworklibrary.GlobalVariables;
import objectrepository.ObjectRepository;

public class LoginPage extends Appbase implements ObjectRepository {

	public static int loginPageObjCount=0;
	
	public LoginPage() {
		loginPageObjCount=loginPageObjCount+1;
		System.out.println("loginPageObjCount = " + loginPageObjCount );
	}	
	
	public void loginToApplication(){
		
		setText(GlobalVariables.userID, txt_userName_New);
		setText(GlobalVariables.password, txt_passWord);
		clickOn(btn_Login);
		
	}
	
	public void logoutFromApplication(){
		
		clickOn(lnk_Welcome);
		clickOn(lnk_Logout);
		
	}
	
}
