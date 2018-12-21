package testCases;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class ReportingDropDown extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:Verifying by clicking on Active Customer Contacts
	 * file should be downloaded and Verifying by clicking on Reconciliation
	 * Daily Recon Exception Report & Recon Exception Aging graph
	 * 
	 **/

	@Test(alwaysRun = true, enabled = true)
	public void reportingDropDown(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();
		String recongraphText = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);

		// * logger method for report starting from here
		logger = extent.startTest("ReportingDropDown").assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verifying by clicking on Active Customer Contacts file should be downloaded and \r\n"
				+ "Verifying by clicking on Reconcilliation Daily Recon Exception Report & Recon Exception Aging graph");



		// * Below Code written to verify login
		login(zUserName, zPassword);

		isassert = verifyClicksInPage(reports, "Reports", reports_customers,
				"Reprorts-Customer", reports_customers_activeCustomerContacts,
				"Active customer contacts");
		softassert.assertEquals(isassert, true);

		logInfo("Active Customer Contacts file has been downloaded");
		Thread.sleep(10000);
		setBrowserToSize(80);
		
		isassert = verifyClicksInPage(reports, "Reports", reportsReconsilation, "reportsReconsilation", reconExceptionAgingOption, "reconExceptionAgingOption" );
		softassert.assertEquals(isassert, true);

		waitForElementPresent(recongraph, 300);
		
		// * Below method written to verify recongraph text
		isassert = verifyText(recongraph, "Recon Exception Aging Graph",
				recongraphText);
		softassert.assertEquals(isassert, true);
		softassert.assertAll();
		// * Below method written to logout application
		logOut();
	}

}
