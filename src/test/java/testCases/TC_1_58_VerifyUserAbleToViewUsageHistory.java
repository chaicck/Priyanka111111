package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_58_VerifyUserAbleToViewUsageHistory extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description: Voice then hover on CDRs, select Usage History and Verify the page
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tc_1_58_VerifyUserAbleToViewUsageHistory(ITestContext context)
			throws Throwable {
		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String domain = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		logger = extent.startTest("1.58 Test ID : 17073 - Test that if user is able to view usage history").assignCategory("Voice");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Voice then hover on CDRs, select Usage History and Verify the page");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(searchTextBox, 200);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchTxt, Keys.ENTER);
		Thread.sleep(3000);
		/*if (verifyElementText(customerTableHeadline, customertxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName,
					customer_id);
		}
		isassert = verifyText(customer_dashboard_name, customertxt2, "Customer Name");
		softassert.assertEquals(isassert, true, "Verified customer id "+customertxt2+" in customer table");*/

		String email = randomString(5) + domain;
		waitForElementPresent(voiceLnk, 200);
		click(voiceLnk, "Voice Link");
		mouseHoverMove(Voice_CDR, "Voice-CDR", Voice_CDR_usuageHistory,
				"Usuage History");
		logInfo("Navigated to CDR-Usuage History");

		if (verifyElementText(Voice_CDR_usuageHistory_filter_DD, "")) {
			logPass("'Filter by Type' drop down field present with a list of values");
		}
		waitForElementPresent(Voice_CDR_usuageHistory_filter_DD, 200);
		logInfo("Following values are present under filter "
				+ getDropDownValues(Voice_CDR_usuageHistory_filter_DD, ""));
		selectDropDownByIndex(Voice_CDR_usuageHistory_filter_DD, 1);
		waitForElementPresent(Voice_CDR_usuageHistory_filerBtn, 200);

		actionsClick(Voice_CDR_usuageHistory_filerBtn, "Filter Button");
		logPass("Filter Button available and it it clickble");

		isassert = verifyAllListValuesInOrder(
				Voice_CDR_usuageHistory_tableColumnHeaders,
				AddElementsIntoList("Date;DoW;LD;Local;Dir Assistance;Ext-to-Ext;Inbound;Toll Free;International;LD - Extended Toll"));
		softassert.assertEquals(isassert, true);
		
		logPass("Column headers Date, DoW, LD, Local, Dir Assistance, Ext-to-Ext, Inbound, Toll Free, International, LD - Extended Toll are present on the table");
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}
}
