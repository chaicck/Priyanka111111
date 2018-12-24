package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_87_HyperLinks_Log_0n_MAC_Inventory extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Verify Billing-Inventory page
	 */
	
	@Test(alwaysRun = true, enabled = true)
	public void verifyReceonciliationPremierCount(ITestContext context)
			throws Throwable {
		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String text1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String inventoryTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);

		// * logger method for report starting from here
		logger = extent.startTest("1.87 Test ID : 15058 - ZEUS-BILLING-8-Hyperlinks and log on Mac Inventory").assignCategory("Billing");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify Billing-Inventory page ");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(srchTxt, 300);
		type(srchTxt, text1, "Search box");
		type(srchTxt, searchTxt, Keys.ENTER);
		waitForElementPresent(CustomersTable_1stCustomer, 300);
		actionsClick(CustomersTable_1stCustomer,"1st customer in the table i.e.,"+ getText(CustomersTable_1stCustomer));
		actionsClick(billingMenu, "Billing");
		actionsClick(billing_inventory, "Inventory");
		waitForElementPresent(Report_headLine, 300);
		isassert = verifyText(Report_headLine, inventoryTxt, "");
		softassert.assertEquals(isassert, true, "Verified text " + inventoryTxt+ " in report headline");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}

}
