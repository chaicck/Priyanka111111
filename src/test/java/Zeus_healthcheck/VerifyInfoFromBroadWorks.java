package Zeus_healthcheck;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class VerifyInfoFromBroadWorks extends MediatorClass {

	String Customer_Dashboardverify = "xpath=//li[text()='TNL Test BroadsoftRAY V17']";
	String srchDd="id=dd-Search";
	String customerLnk="id=notification-customer";
    String srchTxt = "css=input#search";
    String userNameTxt = "css=input[name='user']";   
    String passTxt = "css=input[name='pass']";
    String submitBtn = "css=button[type='submit']";
    String usernameTextBox = "xpath=//input[@name='user']";
    String passwordTextBox = "xpath=//input[@name='pass']";
    String loginButton = "xpath=//button[@type='submit']";
    
    String voice="id=dd-Voice";
    String voice_broadWorks="id=notification-broadworks";
    String voice_broadWorks_details="xpath=//a[starts-with(@href,'/broadworks/groupDetail/customer')]";
    String voice_broadWorks_details_header="id=header_crumbs";
    String voice_broadWorks_details_page ="className=panel-title";
    

	@Test(alwaysRun = true, enabled = true)
	public void verifyInfoFromBroadWorks() throws Throwable {
		logger = extent.startTest("Verify BraodWorks Details page").assignCategory("Voice");
	     type(userNameTxt, "ppundru", "User name");
	    type(passTxt, "Luckylasya1@", "Password"); 
		click(submitBtn, "Submit button");
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, "39382", "Search box");
		type(srchTxt, "39382", Keys.ENTER);
		verifyText(Customer_Dashboardverify, "TNL Test BroadsoftRAY V17", "Customer Name");
		
		
		//verifying with valid data
		navigateTo("https://zeus.telesphere.com/broadworks/groupDetail/customer_id:39382");
		waitForElementPresent(voice_broadWorks_details_page, 20);
		verifyText(voice_broadWorks_details_page, "Broadworks group detail report for", "");
		logPass("Broadworks Details page successfully loaded for customer with id 39382");
		
		actionsClick(voice);
		actionsClick(voice_broadWorks);
		actionsClick(voice_broadWorks_details);
		waitForElementPresent(voice_broadWorks_details_header, 20);
		System.out.println(getText(voice_broadWorks_details_header));
		verifyText(voice_broadWorks_details_header, "Group Detail", "");
		logPass("Broadworks - Details page has been loaded successfully");
		
		

	}
}
