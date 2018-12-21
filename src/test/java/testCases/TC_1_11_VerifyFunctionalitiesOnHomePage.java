package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_11_VerifyFunctionalitiesOnHomePage extends MediatorClass{
	
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_11_VerifyFunctionalitiesOnHomePage(String zUserName, String zPassword) throws Throwable {
    	
    	
        logger = extent.startTest("1.11 Test ID : 18762 - High level test to verify the functionalities on home page").assignCategory("Menu profile settings");
	logInfo("Currently Running on -- "+getCurrentUrl());    
        logInfo("TestCase Description: Verify the search functionality and different settings menu options on the homepage on the right side: Profile Settings, Zeus News, History, Share, "
        		+ "About,Status, Downloads, Log In As, View in Staging, View in Production, Who has permissions, Logout");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");        
        logInfo("Logged into Zeus successfully");  
        waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, "36834", "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);         	
        waitForElementPresent(menu_notification, 300);
        verify(menu_notification,menu_notification_profile, "User Settings");
        verify(menu_notification,menu_notification_zeus_news, "Zeus News");
        verify(menu_notification,menu_notification_history, "History");
        verify(menu_notification,menu_notification_share, "Add Message");
        verify(menu_notification,menu_notification_about, "About");        
        verify(menu_notification,menu_notification_downloads, "Downloads");
        logInfo("Following menus are not testable as per TestCase document, Click 2 Call, Active Call Lookup (HPBR-3727), Call Log (HPBR-3742), View in Dev, View in QA, View in staging");
       // logPass("Remaining menus are working Properly");
        logOut();
    }

	private void verify(String menu,String subMenu, String text) throws Throwable {
		JSClick(menu);
		JSClick(subMenu);
		String paneTitle="css=#header_crumbs";
		waitForElementPresent(paneTitle, 60);
		verifyText(paneTitle, text, "");
		
	}

	

	
}

