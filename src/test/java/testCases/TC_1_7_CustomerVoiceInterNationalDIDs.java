package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_7_CustomerVoiceInterNationalDIDs extends MediatorClass{
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Under Voice tab then select numbers add and delete International DIDs number and verify
	 */
	 @Test(alwaysRun=true,enabled=true)
    public void tc_1_7_CustomerVoiceInterNationalDIDs(ITestContext context) throws Throwable {
    	
    	// * Below variables written to get input data from excel sheet-Testdata.xlsx	
		boolean isassert;
    	String[] loginDetails;
    	loginDetails = getCredentails(context);
    	String zUserName = loginDetails[0];
    	String zPassword = loginDetails[1];
    	AssertSoftly softassert = new AssertSoftly();
    	
    	String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 9), 1);
   		String searchtxt = getTestData(this.getClass().getSimpleName().substring(0, 9), 2);
    	String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 9), 3);
    	String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 9), 4);
    	String interNationIdTxt = getTestData(this.getClass().getSimpleName().substring(0, 9), 5);
    	String interNationIdTooldTipTxt = getTestData(this.getClass().getSimpleName().substring(0, 9), 6);
    	String interNationIdSuccessMsg= getTestData(this.getClass().getSimpleName().substring(0, 9), 7);
    	String interNationIdErrorMsg= getTestData(this.getClass().getSimpleName().substring(0, 9), 8);
   		String interNationIdDelSuccessMsg= getTestData(this.getClass().getSimpleName().substring(0, 9), 9);
    	String s=randomString(3);
        String number =randomNum(5);
    	
    	// * logger method for report starting from here
        logger = extent.startTest("1.7 Test ID : 16832 - Customer_Voice_Numbers_International DIDs").assignCategory("Voice","Regression test");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Under Voice tab then select numbers add and delete International DIDs number and verify");
        
        // * Below Code written to verify login
     		login(zUserName, zPassword);
       
        
	    waitForElementPresent(srchDd, 300);
        click(srchDd,"Search");        
        click(customerLnk,"Customer");  
        
        type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchtxt ,Keys.ENTER);
		Thread.sleep(3000);
		
		if (verifyElementText(customerTableHeadline, customertxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		
		isassert = verifyText(customer_dashboard_name, customertxt2,"Customer Name"); 
		softassert.assertEquals(isassert, true, "Verified customer id "+customertxt2+" in customer table");
		
		waitForElementPresent(voiceLnk, 300);
        click(voiceLnk,"Voice Link");
        click(numbersBtn,"Numbers button");
        waitForElementPresent(voice_number_internationalDIDs, 200);
        
        isassert  = verifyText(voice_number_internationalDIDs, interNationIdTxt, "");
        softassert.assertEquals(isassert, true, "Verified voice number interational text "+interNationIdTxt);
        
        logInfo("'International DIDs' is present next to 'Number Ranges'");
        waitForElementPresent(voice_number_internationalDIDs, 300);
        actionsClick(voice_number_internationalDIDs,"'International DIDs'");
        Thread.sleep(3000);
        waitForElementPresent(voice_number_internationalDIDs_helpIcon, 300);
        actionsClick(voice_number_internationalDIDs_helpIcon,"Help Icon");
        waitForElementPresent(voice_number_internationalDIDs_tooltipText, 300);
        
        isassert  = verifyText(voice_number_internationalDIDs_tooltipText, interNationIdTooldTipTxt, "");
        softassert.assertEquals(isassert, true, "Verified voice number interational tool tips text "+interNationIdTooldTipTxt);
        
        waitForElementPresent(voice_number_internationalDIDs_helpIcon, 300);
        actionsClick(voice_number_internationalDIDs_helpIcon,"Help Icon");
        Thread.sleep(6000);
        
        softassert.assertTrue(Integer.parseInt(getText(voice_number_internationalDIDs_numbersCount))>0);
        logPass("Result count appeard in the form of notifications next to the title i.e., "+getText(voice_number_internationalDIDs_numbersCount));
        

        waitForElementPresent(voice_number_internationalDIDs_textBoxEntry, 300);
        type(voice_number_internationalDIDs_textBoxEntry, number, "text box");
        logPass(number +" added into international numbers list");
        waitForElementPresent(voice_number_internationalDIDs_save, 300);
        actionsClick(voice_number_internationalDIDs_save);
        Thread.sleep(5000);
        waitForElementPresent(voice_number_internationalDIDs_successMsg, 300);
        
        isassert  = verifyText(voice_number_internationalDIDs_successMsg, interNationIdSuccessMsg, "");
        softassert.assertEquals(isassert, true, "Verified voice number interational success message "+interNationIdSuccessMsg);
        
        actionsClick(voice_number_internationalDIDs_successMsg_Xbtn);
        logPass("Number successfully added with message - Success: Successfully added International Number(s):"+number);
        //testing by alphanumerics
        waitForElementPresent(voice_number_internationalDIDs, 300);
        actionsClick(voice_number_internationalDIDs,"'International DIDs'");
        Thread.sleep(3000);
        type(voice_number_internationalDIDs_textBoxEntry, s, "text box");
        logPass(number +" added into international numbers list");
        waitForElementPresent(voice_number_internationalDIDs_save, 300);
        actionsClick(voice_number_internationalDIDs_save);
        Thread.sleep(10000);
        waitForElementPresent(voice_number_internationalDIDs_errorMsg, 300);
        
        isassert  = verifyText(voice_number_internationalDIDs_errorMsg, interNationIdErrorMsg, "");
        softassert.assertEquals(isassert, true, "Verified voice number interational error message "+interNationIdSuccessMsg);
        
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
        
        isassert  = verifyText(voice_number_internationalDIDs_successMsg, interNationIdDelSuccessMsg, "");
        softassert.assertEquals(isassert, true, "Verified voice number interational success message "+interNationIdSuccessMsg);
        
        waitForElementPresent(voice_number_internationalDIDs_successMsg_Xbtn, 300);
        actionsClick(voice_number_internationalDIDs_successMsg_Xbtn);
       
     // * Below method written to logout application
		logOut();
		softassert.assertAll();
        
    }
    
}
