package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_12_Number_management_Search_customerForEdit extends
		MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description: Go to voice then select numbersfor any numver edit
	 * the Customer and Shipping Address filed
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_12_Number_management_Search_customerForEdit(
			ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();
		String customer_name = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String Customer_search = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String CustomerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String CustomerTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);

		// * logger method for report starting from here
		logger = extent.startTest("1.12 Test ID : 20696 - Number management - Search customer for edit").assignCategory("Voice");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Go to voice then select numbersfor any numver edit the Customer and Shipping Address filed");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_name, "Search Box");
		type(searchTextBox, Customer_search, Keys.ENTER);
		waitForElementPresent(customerTableHeadline, 300);

		if (verifyElementText(customerTableHeadline, CustomerTxt1)) {
			verifyTextInColumnClickOtherColumn(customerNameList, customerName,
					customer_name);
			Thread.sleep(1000);
			actionsClick(customerNameList);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		
		isassert = verifyText(customer_dashboard_name, CustomerTxt2,"Customer Name");
		softassert.assertEquals(isassert, true, "Verified customer id "+CustomerTxt2+" in customer table");
		
		waitForElementPresent(customerDashboard_customerLink, 300);
		actionsClick(customerDashboard_customerLink,"customerDashboard_customerLink");
		actionsClick(customer_dashboard_notification_voice, "Voice");
		actionsClick(customer_dashboard_notification_numbers, "Numbers");
		waitForElementPresent(customer_dashboard_notification_voice_number_penIcons, 300);
		actionsClick(customer_dashboard_notification_voice_number_penIcons);
		logPass("Clicked on pen icon for any telephone number");
		Thread.sleep(5000);

		if (verifyElementText(
				customer_dashboard_notification_voice_number_penIcons_subList,
				"")) {
			Thread.sleep(1000);
			actionsClick(customer_dashboard_notification_voice_number_penIcons_subList);
		}

		waitForElementPresent(voice_number_penIcons_customer_shippingAddress_DD_edit, 300);
		actionsClick(voice_number_penIcons_customer_shippingAddress_DD_edit);
		Thread.sleep(7000);
		actionsClick(voice_number_penIcons_customer_shippingAddress_DD);
		logPass("Edit Shipping Address filed section under customer");

		type(voice_number_penIcons_customer_shippingAddress_searchBox, "ada", "ada");
		logPass("Search Criteria workingas expected");

		// * Below method written to do logout from application
		logOut();
		softassert.assertAll();

	}

}
