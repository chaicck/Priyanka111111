package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_7_CustomerVoiceInterNationalDIDs extends MediatorClass{
	
	
	

	String voine_numbers_AssignNumbersFrmInventoryBtn="xpath=//*[@id='number_table']/caption/a[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD="name=rate_center_name";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search="xpath=(//button[@type='submit'])[3]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn="xpath=//a[@class='select_numbers']";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_mobileNumber="xpath=//*[@id='number_table']/tbody/tr[1]/td[4]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn_assign="xpath=//button[text()='Assign Numbers']";
	
	String voice_number_internationalDIDs="link=International DIDs";
	String voice_number_internationalDIDs_textBoxEntry="xpath=(//input[@type='text'])[2]";
	String voice_number_internationalDIDs_save="xpath=//button[@form='international_did']";
	String voice_number_internationalDIDs_helpIcon="xpath=//i[@class='fa  fa-question-circle ']";
	String voice_number_internationalDIDs_tooltipText="xpath=//div[@role='tooltip']";
	String voice_number_internationalDIDs_numbersCount="xpath=//*[@id='international_table']/caption/span";
	String voice_number_internationalDIDs_errorMsg="xpath=//div[@class='alert alert-danger alert-dismissable']";
	String voice_number_internationalDIDs_errorMsg_Xbtn="xpath=//div[@class='alert alert-danger alert-dismissable']/button";
	
	
	String voice_number_internationalDIDs_successMsg="xpath=//div[@class='alert alert-success alert-dismissable']";
	String voice_number_internationalDIDs_successMsg_Xbtn="xpath=//div[@class='alert alert-success alert-dismissable']/button";
	String voice_number_internationalDIDs_NumbersList="xpath=//div[@class='bootstrap-tagsinput']/span";
	String voice_number_internationalDIDs_NumbersList_X_parametarised="xpath=(//div[@class='bootstrap-tagsinput']/span/span)[%s]";
	
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_7_CustomerVoiceInterNationalDIDs(String zUserName, String zPassword) throws Throwable {
    	
    	String customer_id="35834";
    	
    	String Report_Numbers_InterNationalDIDReport_tableColumns="xpath=//*[@id='DataTables_Table_0']/thead/tr/th";
    	
        logger = extent.startTest("1.7 Test ID : 16832 - Customer_Voice_Numbers_International DIDs").assignCategory("Voice","Regression test");
	      logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Under Voice tab then select numbers add and delete International DIDs number and verify");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");
        
     /*   Verify(Report_Numbers, Report_Numbers_InterNationalDIDReport, Report_headLine, "International DID Report"); 
        verifyAllListValuesInOrder(Report_Numbers_InterNationalDIDReport_tableColumns, AddElementsIntoList("Customer Name;International DID;State"));
        logInfo("InterNationalDIDReport table headers verified");*/
	    waitForElementPresent(srchDd, 300);
        click(srchDd,"Search");        
        click(customerLnk,"Customer");        
        type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

		  waitForElementPresent(voiceLnk, 300);
        click(voiceLnk,"Voice Link");
        click(numbersBtn,"Numbers button");
        waitForElementPresent(voice_number_internationalDIDs, 200);
        verifyText(voice_number_internationalDIDs, "International DIDs", "");
        logInfo("'International DIDs' is present next to 'Number Ranges'");
        waitForElementPresent(voice_number_internationalDIDs, 300);
        actionsClick(voice_number_internationalDIDs,"'International DIDs'");
        Thread.sleep(3000);
        waitForElementPresent(voice_number_internationalDIDs_helpIcon, 300);
        actionsClick(voice_number_internationalDIDs_helpIcon,"Help Icon");
        waitForElementPresent(voice_number_internationalDIDs_tooltipText, 300);
        verifyText(voice_number_internationalDIDs_tooltipText, "How to Use", "");
        logPass("Verified By clicking on help icon, it displayed a tooltip on how to use");
        waitForElementPresent(voice_number_internationalDIDs_helpIcon, 300);
        actionsClick(voice_number_internationalDIDs_helpIcon,"Help Icon");
        Thread.sleep(6000);
        Assert.assertTrue(Integer.parseInt(getText(voice_number_internationalDIDs_numbersCount))>0);
        logPass("Result count appeard in the form of notifications next to the title i.e., "+getText(voice_number_internationalDIDs_numbersCount));
        
        String number =randomNum(5);
        waitForElementPresent(voice_number_internationalDIDs_textBoxEntry, 300);
        type(voice_number_internationalDIDs_textBoxEntry, number, "text box");
        logPass(number +" added into international numbers list");
        waitForElementPresent(voice_number_internationalDIDs_save, 300);
        actionsClick(voice_number_internationalDIDs_save);
        Thread.sleep(5000);
        waitForElementPresent(voice_number_internationalDIDs_successMsg, 300);
        verifyText(voice_number_internationalDIDs_successMsg, "Successfully added International Number", "");
        actionsClick(voice_number_internationalDIDs_successMsg_Xbtn);
        logPass("Number successfully added with message - Success: Successfully added International Number(s):"+number);
        //testing by alphanumerics
        waitForElementPresent(voice_number_internationalDIDs, 300);
        actionsClick(voice_number_internationalDIDs,"'International DIDs'");
        Thread.sleep(3000);
        String s=randomString(3);
        type(voice_number_internationalDIDs_textBoxEntry, s, "text box");
        logPass(number +" added into international numbers list");
        waitForElementPresent(voice_number_internationalDIDs_save, 300);
        actionsClick(voice_number_internationalDIDs_save);
        Thread.sleep(10000);
        waitForElementPresent(voice_number_internationalDIDs_errorMsg, 300);
        verifyText(voice_number_internationalDIDs_errorMsg, "Failed to add the following number(s). They most likely contained invalid characters", "");
        waitForElementPresent(voice_number_internationalDIDs_errorMsg_Xbtn, 300);
        actionsClick(voice_number_internationalDIDs_errorMsg_Xbtn);
        logPass("Error message displayed for adding alphaNumeric number i.e.,  Error(s): Failed to add the following number(s). They most likely contained invalid characters:"+s);
        waitForElementPresent(voice_number_internationalDIDs, 300);
        actionsClick(voice_number_internationalDIDs,"'International DIDs'");
        Thread.sleep(3000);
        
        verifyTextInColumnClickOtherColumn(voice_number_internationalDIDs_NumbersList, voice_number_internationalDIDs_NumbersList_X_parametarised, number);
        waitForElementPresent(voice_number_internationalDIDs_save, 300);
        actionsClick(voice_number_internationalDIDs_save);
        Thread.sleep(5000);
        waitForElementPresent(voice_number_internationalDIDs_successMsg, 300);
        verifyText(voice_number_internationalDIDs_successMsg, "Successfully deleted International Number", "");
        waitForElementPresent(voice_number_internationalDIDs_successMsg_Xbtn, 300);
        actionsClick(voice_number_internationalDIDs_successMsg_Xbtn);
        logPass("Number successfully deleted with message - Success: Successfully deleted International Number(s):"+number);
        logOut();
        
    }
    
    private void Verify(String menu,String submenu, String textElement, String text) throws Throwable {
		click(reports,"Reports Link");
		actionsClick(menu,menu);		
		JSClick(submenu,submenu);
		waitForElementPresent(textElement, 200);
		verifyText(textElement,  text, "Verifying HeadLine text");
	}
}
