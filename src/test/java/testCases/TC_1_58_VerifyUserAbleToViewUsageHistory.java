package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_58_VerifyUserAbleToViewUsageHistory extends MediatorClass{
	
	String voine_numbers_AssignNumbersFrmInventoryBtn="xpath=//*[@id='number_table']/caption/a[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD="name=rate_center_name";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search="xpath=(//button[@type='submit'])[3]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn="xpath=//a[@class='select_numbers']";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_mobileNumber="xpath=//*[@id='number_table']/tbody/tr[1]/td[4]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn_assign="xpath=//button[text()='Assign Numbers']";
	 
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_58_VerifyUserAbleToViewUsageHistory(String zUserName, String zPassword) throws Throwable {
    	
		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
    	String Voice_CDR="id=notification-cdrs";
    	String Voice_CDR_usuageHistory="xpath=//a[starts-with(@href,'/cdr/usageHistory/customer')]";
    	String Voice_CDR_usuageHistory_filter_DD="id=type";
    	String Voice_CDR_usuageHistory_filerBtn="xpath=(//button[@type='submit'])[2]";
    	String Voice_CDR_usuageHistory_tableColumnHeaders="xpath=//*[@id='usage']/thead/tr/th";
    	
        logger = extent.startTest("1.58 Test ID : 17073 - Test that if user is able to view usage history").assignCategory("Voice");
	    logInfo("Currently Running on -- "+getCurrentUrl());
  	  logInfo("TestCase Description: Voice then hover on CDRs, select Usage History and Verify the page");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");   
    	waitForElementPresent(searchTextBox, 200);
        type(searchTextBox, customer_id, "Search Box");
        type(searchTextBox,"search box",Keys.ENTER);
        Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

		String email=randomString(5)+"@gmail.com";
		waitForElementPresent(voiceLnk, 200);
		click(voiceLnk,"Voice Link");
		mouseHoverMove(Voice_CDR,"Voice-CDR",Voice_CDR_usuageHistory,"Usuage History");
		logInfo("Navigated to CDR-Usuage History");
		
		if(verifyElementText(Voice_CDR_usuageHistory_filter_DD, "")) {
			logPass("'Filter by Type' drop down field present with a list of values");
		}
		waitForElementPresent(Voice_CDR_usuageHistory_filter_DD, 200);
		logInfo("Following values are present under filter "+getDropDownValues(Voice_CDR_usuageHistory_filter_DD, ""));
		selectDropDownByIndex(Voice_CDR_usuageHistory_filter_DD, 1);
		waitForElementPresent(Voice_CDR_usuageHistory_filerBtn, 200);
		
		actionsClick(Voice_CDR_usuageHistory_filerBtn, "Filter Button");
		logPass("Filter Button available and it it clickble");
		
		//Step 5 not available in QA as per test case
		verifyAllListValuesInOrder(Voice_CDR_usuageHistory_tableColumnHeaders, AddElementsIntoList("Date;DoW;LD;Local;Dir Assistance;Ext-to-Ext;Inbound;Toll Free;International;LD - Extended Toll"));
    logPass("Column headers Date, DoW, LD, Local, Dir Assistance, Ext-to-Ext, Inbound, Toll Free, International, LD - Extended Toll are present on the table");
		// step 7 ------
	logOut();	
    }}

