package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_52_DIDs_Displayed_Number_Activation extends MediatorClass{
	
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tC_1_52_DIDs_Displayed_Number_Activation(String zUserName, String zPassword) throws Throwable {
    	
    	String voice_broadWorks="id=notification-broadworks";
    	String voice_broadWorks_numberActivation="id=notification-number-activation";
    	String voice_broadWorks_numberActivation_Table_numbers="xpath=//*[@id='numbers_table']/tbody/tr/td[2]";
    	String customer_id = "35834";
    	//String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
    	String customer_name="nextcare - AZ - greenway";
    	

        logger = extent.startTest("1.52 Test ID : 20440 - Test if DIDs are displayed on number activation page").assignCategory("C3");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Go under Voice, then Broadworks and choose Number Activation ,You should see some numbers here.");
          type(userNameTxt, zUserName, "User name");
	 type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");	
        waitForElementPresent(searchTextBox, 300);
	    type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name"); 
		waitForElementPresent(customerDashboard_customerLink, 300);
		actionsClick(customerDashboard_customerLink,"customerDashboard_customerLink");
		waitForElementPresent(customer_dashboard_notification_voice, 300);
		aJSClick(customer_dashboard_notification_voice, "Voice");
		aJSClick(voice_broadWorks, "voice_broadWorks");
		aJSClick(voice_broadWorks_numberActivation, "voice_broadWorks_numberActivation");
		//mouseHoverMove(voice_broadWorks, voice_broadWorks_numberActivation);
		
		
		if(!verifyElementText(voice_broadWorks_numberActivation_Table_numbers, "")){
			logFail("Numbers are not present under the table 'Numbers'");
			
		}
		
		logPass("Numbers are present under Numbers Table");
		
			/* //Step 2 
		waitForElementPresent(Home, 300);
		 click(Home, "Home Menu");
		 aJSClick(Home_C3, "C3 Client Configuration Tool");
		 aJSClick(Home_C3_configureUsers, "Cogigure User");
	     //Pending - pick any user that has a phone number but ensure to add the following services such as: Nexmo SMS, Premier Plus and VVM auto 
		
		//Step 3
	 	waitForElementPresent(customer_dashboard_notification_voice, 300);
	    actionsClick(customer_dashboard_notification_voice, "Voice");
	    aJSClick(voice_broadWorks,"Broad Works");
	    aJSClick(voice_broadWorks_numberActivation,"BroadWorks - Number Activation");*/
		logOut();	
		
        }
}

