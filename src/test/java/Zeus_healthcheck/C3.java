package Zeus_healthcheck;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class C3 extends MediatorClass {

	@Test(alwaysRun = true, enabled = true)
	public void c3() throws Throwable {
	
		String userNameTxt = "css=input[name='user']";   
	    String passTxt = "css=input[name='pass']";
	    String submitBtn = "css=button[type='submit']";
	    String usernameTextBox = "xpath=//input[@name='user']";
	    String passwordTextBox = "xpath=//input[@name='pass']";
	    String loginButton = "xpath=//button[@type='submit']";
		String Home = "xpath=//span[@id='notification-home']";
		String c3_configuration = "id=notification-client-configuration-call";
		String C3_Dashboard = "id=notification-dashboard";
		String Dashboard_verify = "xpath=//h1[text()='Checklist Builder']";
		String Global_parameter_verify = "xpath=//div[@class='container-fluid']";
		String Global_Parametrers = "id=notification-global-parameters";
		String C3_configure_users = "id=notification-configure-users";
		String Verify_C3_configure_users = "xpath=//div[@class='container-fluid']";
		String Build_enterprisegroup = "id=notification-build-enterprise/group";
		String Verify_Build_enterprisegroup = "xpath=//h4[text()='Global Parameters']";
		String Build_Iads = "id=notification-build-iads";
		String Verify_Build_Iads = "xpath=//th[text()='ID']";
		String E911 = "id=notification-e911-address-assignment";
		String E911_verify = "id=import-link";
		String Build_usersDevice = "id=notification-build-users-&-devices";
		String Verify_Build_usersDevice = "id=buildUsersAndDevices";
		String Build_ucc = "id=notification-build-ucc";
		String Verify_Build_ucc = "id=buildUCCServices";
		String Build_SCA = "id=notification-build-sca";
		String Verify_Build_SCA = "xpath=//div[@class='container']";
		String Colabirative_bridge = "id=notification-build-collaborative-bridge";
		String colabarativebridge_verify = "xpath=//div[@class='container-fluid']";
		String Speak2dail = "id=notification-build-speak2dial";
		String team_one = "id=notification-team-one";
		String verify_teamone = "xpath=//span[text()='Users to build in TeamOne']";
		String Customer_tag = "id=notification-custom-tags-management";
		String Verify_customertag = "id=DataTables_Table_0";
		String srchDd="id=dd-Search";
		String customerLnk="id=notification-customer";
	    String srchTxt = "css=input#search";
		
		logger = extent.startTest("C3").assignCategory("C3");
		String verifycustomer_header = "id=customer_id";
		String Assign_number_Inventory = "xpath=//*[@id=\"number_table\"]/caption/a[2]";
		String State = "id=state";
		String Npa = "id=npanxx";
		String State_Search = "xpath=(//button[@type='submit'])[2]'";
		String Customer_Dashboardverify = "xpath=//li[text()='TNL Test BroadsoftRAY V17']";
         type(userNameTxt, "ppundru", "User name");
         typePassword(passTxt, "Luckylasya1@", "Password");
		click(submitBtn, "Submit button");
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, "39382", "Search box");
		type(srchTxt, "39382", Keys.ENTER);
		verifyText(Customer_Dashboardverify, "TNL Test BroadsoftRAY V17", "Customer Name");
		
		String header="xpath=//*[@id='header_crumbs']";
		
		actionsClick(Home, "Home");		
		mouseHoverMove(c3_configuration, Global_Parametrers);		
		String a="xpath=//h1[@class='panel-title']";
		waitForElementPresent(a, 20);
		verifyText(header, "Global Parameters", "");		
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, C3_configure_users);		
		waitForElementPresent(header, 20);
		verifyText(header, "C3 User Info", "");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Build_enterprisegroup);	
		
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Build_Iads);
		waitForElementPresent(Verify_Build_Iads, 20);
		verifyText(Verify_Build_Iads, "ID", "Verify_Build_Iads");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, E911);				
		waitForElementPresent(E911_verify, 20);
		verifyText(E911_verify, "Import", "E911 page load verified");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Build_usersDevice);
		verifyText(Verify_Build_usersDevice, "Build Company Users and Devices in Broadworks","Build_usersDevice page load verified");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Build_ucc);
		verifyText(Verify_Build_ucc, "Build UCC Services", "Build_Ucc page load verified");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Build_SCA);
		verifyText(Verify_Build_SCA, "", "Build_SCA load Verified");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Colabirative_bridge);		
		verifyText(colabarativebridge_verify, "", "Colabarative bridge page load verified");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Speak2dail);
		verifyText(header,"Speak2Dial Service","");
		
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, team_one);		
		verifyText(verify_teamone, "Users to build in TeamOne", "verify_teamone");
		
		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, Customer_tag);
		verifyText(Verify_customertag, "", "Verify_customertag");
		logOut();
	}

}
