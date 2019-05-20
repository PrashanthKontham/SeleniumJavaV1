package objectrepository;

import org.openqa.selenium.By;


public interface ObjectRepository {
	
	// login objects
	public final static Locator txt_userName = new Locator(By.name("txtUsername"),"User ID Textbox");
	public final static Locator txt_userName_New = new Locator("FirstName Textbox",By.id("asdsa"),By.xpath("asdsa"),By.name("txtUsername"));
	public final static Locator txt_passWord = new Locator(By.id("txtPassword"), "Password Textbox");
	public final static Locator btn_Login = new Locator(By.xpath("//input[@value='LOGIN']"), "Login Button");
	
	// Home Page Objects
	public final static Locator lnk_myInfo = new Locator(By.xpath("//a[@id='menu_pim_viewMyDetails']"), "myInfo link");
	public final static Locator lnk_Directory = new Locator(By.xpath("//a[@id='menu_directory_viewDirectory']"), "Directory link");

	// MyInfo Page Objects
	public final static Locator lnk_EmergectContacts = new Locator(By.linkText("Emergency Contacts"), "EmergectContacts link");
	
	// Emergency Contact Page Objects
	public final static Locator btn_EC_Add = new Locator(By.xpath("//input[@value='Add']"), "EmergectContacts Add Button");
	public final static Locator btn_EC_Save = new Locator(By.xpath("//input[@value='Save']"), "EmergectContacts Link");
	public final static Locator msg_EC_Save = new Locator(By.xpath("//*[contains(text(),'Successfully Saved')"), "EmergectContacts Save Button");
	public final static Locator btn_EC_AddAttachment = new Locator(By.id("btnAddAttachment"), "EmergectContacts Add attachment Button");
	
	// MyInfo Page Objects
	public final static Locator txt_Name = new Locator(By.id("emgcontacts_name"), "Name Textbox");
	public final static Locator txt_Relationship = new Locator(By.id("emgcontacts_relationship"), "Relationship Textbox");
	public final static Locator txt_HomeTelephone = new Locator(By.id("emgcontacts_homePhone"), "HomeTelephone Textbox");
	public final static Locator txt_Mobile = new Locator(By.id("emgcontacts_mobilePhone"), "Mobile Textbox");
	public final static Locator txt_WorkTelephone = new Locator(By.id("emgcontacts_workPhone"), "WorkTelephone Textbox");
	
	// logout objects
	public final static Locator lnk_Welcome = new Locator(By.id("welcome"), "Welcome link");
	public final static Locator lnk_Logout = new Locator(By.xpath("//a[text()='Logout']"), "Logout link");

}
