package pageobjects;

import java.util.Map;

import appbase.Appbase;
import frameworklibrary.Utils;

public class MyInfoPage extends Appbase {

	public void fillEmergencyDetails(Map<String, String> data) {
		
		clickOn(lnk_myInfo);
		clickOn(lnk_EmergectContacts);
		clickOn(btn_EC_Add);
		
		setText(data.get("Name"), txt_Name);
		setText(data.get("Reletionship"), txt_Relationship);
		setText(data.get("HTelPhone"), txt_HomeTelephone);
		setText(data.get("Mobile"), txt_Mobile);
		setText(data.get("WTelNumb"), txt_WorkTelephone);
		
		clickOn(btn_EC_Save);
		
		Utils.delay(5);
		
	}

}
