package testCases;

import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_90_OReilly_Rapid_List  extends  MediatorClass{

	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_90_OReilly_Rapid_List(String zUserName, String zPassword) throws Throwable  {
		
		 logger=extent.startTest("1.90 Test ID : 15003 - ZEUS-PM-30 OReilly Rapid Builder List").assignCategory("Projects");
		logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Navigate to the projects to O'Reilly Rapid Builder List,Click on Build");
		 type(userNameTxt, zUserName, "User name");
			type(passTxt, zPassword, "Password");
	     click(submitBtn,"Submit button");
	 	logInfo("Logged into Zeus successfully");
	 	 waitForElementPresent(Project_Menu, 300);
	    JSClick(Project_Menu,"Projects_Menu");
	    actionsClick(Project_Menu_Oreilly_rapidlist,"Project_Menu_Oreilly_rapidlist");
	 	 waitForElementPresent(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown, 300);
	    selectDropDownByIndex(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown, 1);
	    logInfo("2nd option selected under Selectproject_dropdown");
	    waitForElementPresent(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder, 300);
	    actionsClick(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder,"Selectproject_dropdown_GotoBuilder");
	    String customerName=getText(Customer_DashBoard);
		//verifyText(Customer_DashBoard_review, customerName, ""); 
	    waitForElementPresent(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder_Build, 300);
	    scrollElementIntoView(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder_Build);
		 actionsClick(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder_Build,"Selectproject_dropdown_GotoBuilder_Build");
		 Thread.sleep(5000);	
		  waitForElementPresent(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder_Buildsucess, 300);
		verifyText(Project_Menu_Oreilly_rapidlist_Selectproject_dropdown_GotoBuilder_Buildsucess, "", ""); 
		logPass("Reviewed the order and clicked on Build");
	}

}
