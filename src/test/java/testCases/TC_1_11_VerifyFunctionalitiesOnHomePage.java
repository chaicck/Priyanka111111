package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;
import utils.AssertSoftly;


public class TC_1_11_VerifyFunctionalitiesOnHomePage extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description: Verify the search functionality and different
	 * settings menu options on the homepage on the right side: Profile
	 * Settings, Zeus News, History, Share, " + "About,Status, Downloads, Log In
	 * As, View in Staging, View in Production, Who has permissions, Logout
	 */
	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_11_VerifyFunctionalitiesOnHomePage(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties// * Below variables written to get input data from excel  sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();

		String Customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String Customer_search = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);

		// * logger method for report starting from here
		logger = extent
				.startTest(
						"1.11 Test ID : 18762 - High level test to verify the functionalities on home page")
				.assignCategory("Menu profile settings");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Verify the search functionality and different settings menu options on the homepage on the right side: Profile Settings, Zeus News, History, Share, "
				+ "About,Status, Downloads, Log In As, View in Staging, View in Production, Who has permissions, Logout");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Search for customerID in search box
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, Customer_id, "Search Box");
		type(searchTextBox, Customer_search, Keys.ENTER);
		waitForElementPresent(menu_notification, 300);

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_profile, paneTitle, "User Settings");
		softassert.assertEquals(isassert, true ,"Verify User Settings");

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_zeus_news, paneTitle, "Zeus News");
		softassert.assertEquals(isassert, true,"Verify Zeus News");

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_history, paneTitle, "History");
		softassert.assertEquals(isassert, true, "Verify History");

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_share, paneTitle, "Add Message");
		softassert.assertEquals(isassert, true, "Verify Add Message");

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_about, paneTitle, "About");
		softassert.assertEquals(isassert, true, "Verify About");

		isassert = verifyMenuNotification(menu_notification,
				menu_notification_downloads, paneTitle, "Downloads");
		softassert.assertEquals(isassert, true, "Verify Downloads");

		logInfo("Following menus are not testable as per TestCase document, Click 2 Call, Active Call Lookup (HPBR-3727), Call Log (HPBR-3742), View in Dev, View in QA, View in staging");
		// * Below method writtent to do logout from application
		logOut();
		softassert.assertAll();
	}
}
