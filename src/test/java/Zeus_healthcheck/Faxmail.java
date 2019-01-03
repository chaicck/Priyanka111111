package Zeus_healthcheck;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Faxmail extends MediatorClass{
	
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
    String faxmail_btn = "id=notification-faxmail";
    String Verifytext_faxmail_user = "xpath=//caption[text()='FaxMail Users ']";
    String Verify_faxmail_table = "xpath=//div[@class='col-sm-12']";
 
	
	
	@Test(alwaysRun = true, enabled = true)
	public void customer_Search() throws Throwable {
		logger = extent.startTest("Faxmail").assignCategory("Faxmail");
	    type(userNameTxt, "ppundru", "User name");
	    type(passTxt, "Luckylasya1@", "Password"); 
		click(submitBtn, "Submit button");
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, "39382", "Search box");
		type(srchTxt, "39382", Keys.ENTER);
		verifyText(Customer_Dashboardverify, "TNL Test BroadsoftRAY V17", "Customer Name");
		click(voiceLnk, "Voice Link");
		click(faxmail_btn, "fax  mail");
		verifyText(Verifytext_faxmail_user, "FaxMail Users ", "verified faxmial header");
		verifyText(Verify_faxmail_table, "", "");
		logOut();
		
	}
}
