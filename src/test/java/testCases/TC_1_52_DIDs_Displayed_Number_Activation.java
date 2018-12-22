package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_52_DIDs_Displayed_Number_Activation extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:Go under Voice, then Broadworks and choose Number
	 * Activation ,You should see some numbers here.
	 */
	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void tC_1_52_DIDs_Displayed_Number_Activation(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchBox = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customerTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);

		// * logger method for report starting from here
		logger = extent.startTest("1.52 Test ID : 20440 - Test if DIDs are displayed on number activation page").assignCategory("C3");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go under Voice, then Broadworks and choose Number Activation ,You should see some numbers here.");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchBox, Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, customerTxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName,
					customer_id);
		}
		
		isassert= verifyText(customer_dashboard_name, customerTxt2, "Customer Name");
		softassert.assertEquals(isassert, true, "Verify customer name");
		waitForElementPresent(customerDashboard_customerLink, 300);
		actionsClick(customerDashboard_customerLink,
				"customerDashboard_customerLink");
		waitForElementPresent(customer_dashboard_notification_voice, 300);
		aJSClick(customer_dashboard_notification_voice, "Voice");
		aJSClick(voice_broadWorks, "voice_broadWorks");
		aJSClick(voice_broadWorks_numberActivation,
				"voice_broadWorks_numberActivation");

		if (!verifyElementText(voice_broadWorks_numberActivation_Table_numbers,
				"")) {
			logFail("Numbers are not present under the table 'Numbers'");

		}

		logPass("Numbers are present under Numbers Table");
		
		// * Below method written to do logout from application
		logOut();
		softassert.assertAll();

	}
}
