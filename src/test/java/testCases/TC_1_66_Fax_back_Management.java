package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_66_Fax_back_Management extends MediatorClass {
	
	
			
	 
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_66_Fax_back_Management(String zUserName, String zPassword) throws Throwable { 

		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		
		logger = extent.startTest("1.66 Test ID : 20438 - Verify if the page loads normally for the faxback management").assignCategory("Voice");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Verify if the page loads normally for the faxback management");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
	    waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

	    waitForElementPresent(voice_menu, 300);
		JSClick(voice_menu, "Voice");
		actionsClick(voice_menu_faxmail,"voice-faxmail");
	    waitForElementPresent(voice_menu_faxmail_records, 300);
		verifyText(voice_menu_faxmail_records, "FaxMail Users", "displayed FaxMail Users");
		logPass("Page ran much faster & User landed on faxmail users page");
		logOut();	
}
}
