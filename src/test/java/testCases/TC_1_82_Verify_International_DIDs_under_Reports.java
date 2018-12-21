package testCases;

import java.util.Set;

import org.junit.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_82_Verify_International_DIDs_under_Reports  extends MediatorClass{

	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tc_1_82_Verify_International_DIDs_under_Reports(String zUserName, String zPassword) throws Throwable {

		logger = extent.startTest("1.82 Test ID : 16858 - Verify there must be a new report called International DIDs under the Reports section").assignCategory("Reports");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description: Go to reports then hover on numbers and select on 'International DID Report page should load and verify the fields");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");	
	    waitForElementPresent(reports, 300);
		actionsClick(reports,"Reports");
		actionsClick(report_number,"Reports-Number");
		JSClick(report_number_international_DID_Report,"'International-DID-Report'");	
		waitForElementPresent(International_DIDs_TableHeaders, 300);
		verifyAllListValuesInOrder(International_DIDs_TableHeaders, AddElementsIntoList("Customer Name;International DID;State"));
	    logPass("Verified 'International_DIDs_TableHeaders' as Customer Name, International DID, State");
		//pending - need to write logic
		System.out.println(getAllTheTextIntoSet(International_DIDs_Table_stateValues));
		Set<String> s= getAllTheTextIntoSet(International_DIDs_Table_stateValues);
		for (String string : s) {
			Assert.assertTrue(string.contains("Not In Billing")||string.contains("Active")||string.contains("Installing")||string.contains("Disconnected-NOT BILLING"));
		}
	
		logPass("Verified IInternational DID table State values - Not in Billing, Disconnected-NOT BILLING, Active, Installing");
	}}

	
