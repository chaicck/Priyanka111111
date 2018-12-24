package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_97_SubmitTheReconFix extends MediatorClass {
	
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Billing Reconcillation,click the checkboxes EMAC and Billing Only Able to Click Reconcile "
				+ "Select Email Recipients Submit
	 */
	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void verifyReceonciliationPremierCount(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String text1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String retext2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String preText3 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String urlQa5 = "qa5";
		String urlQa6 = "qa6";
		String contractName = text1 + randomString(3);
		String ticket = randomNum(5);

		// * logger method for report starting from here
		logger = extent.startTest("1.97 Test ID : 15331 - ZEUS-Recon-3 Submit the Recon Fix ").assignCategory("Billing", "Regression test");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Billing Reconcillation,click the checkboxes EMAC and Billing Only Able to Click Reconcile "
				+ "Select Email Recipients Submit");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(srchTxt, 300);
		type(srchTxt, text1, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);
		waitForElementPresent(CustomersTable_1stCustomer, 300);
		actionsClick(CustomersTable_1stCustomer,"1st customer in the table i.e.,"+ getText(CustomersTable_1stCustomer));
		waitForElementPresent(billingMenu, 300);
		actionsClick(billingMenu, "Billing");
		actionsClick(billing_Reconciliation, "Reconciliation");
		waitForElementPresent(Report_headLine, 300);

		isassert = verifyText(Report_headLine, retext2, "");
		softassert.assertEquals(true, isassert, "Verified report headline "+ retext2 + " ");

		waitForElementPresent(Reconciliation_refresh, 300);
		actionsClick(Reconciliation_refresh, "Refresh");
		Thread.sleep(5000);
		waitForElementPresent(Reconciliation_EMAC_CheckALl, 300);
		actionsClick(Reconciliation_EMAC_CheckALl, "'Check All' check box");
		waitForElementPresent(Reconciliation_ReconcileBtn, 300);
		scrollElementIntoView(Reconciliation_ReconcileBtn);

		actionsClick(Reconciliation_ReconcileBtn, "Reconcile");

		waitForElementPresent(addContract_name, 200);
		logInfo("Redirected to Mac page");
		waitForElementPresent(addContract_name, 300);
		type(addContract_name, contractName, "Edit MAC name");

		String contractedNo = verifyTextInColumnGetOtherColumnText(Reconciliation_tableProducts, Reconciliation_tableContractedParametarised, "Premier Basic");
		logInfo("Before Premier Basic contract addion, Premier Basic contract no in the table is "+ contractedNo);
		waitForElementPresent(addContract_ticket, 300);

		type(addContract_ticket, ticket, "Add MAC Ticket");
		waitForElementPresent(addContract_RequestedInstallDate, 300);
		if (getCurrentUrl().contains(urlQa6)) {
			enterDate(addContract_RequestedInstallDate,
					dateAftersomeDays(4, "dd"), dateAftersomeDays(4, "MM"),
					dateAftersomeDays(4, "yyyy"));
		}
		if (getCurrentUrl().contains(urlQa5)) {
			enterDate(addContract_RequestedInstallDate,
					dateAftersomeDays(4, "dd"), dateAftersomeDays(4, "MM"),
					dateAftersomeDays(4, "yyyy"));
		}
		waitForElementPresent(addContract_authorizedBy, 300);
		scrollElementIntoView(addContract_authorizedBy);
		selectDropDownByIndex(addContract_authorizedBy, 1);
		selectDropDownByIndex(addContract_AssignedTo, 2);
		waitForElementPresent(addContract_productsAddNew, 300);
		scrollElementIntoView(addContract_productsAddNew);
		actionsClick(addContract_productsAddNew);

		int n = getAllElements(customerDashboard_addMAC_productAddNew_productTextBoxList).size();

		System.out.println("product locator "+ String.format(addContract_productTextBox_parametarised, n));
		waitForElementPresent(addContract_productTextBox_parametarised, 300);
		type(String.format(addContract_productTextBox_parametarised, n), preText3, "Product name-Premier Basic");
		type(String.format(addContract_productTextBox_parametarised, n), preText3, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
		waitForElementPresent(Reconciliation_ReconcileBtn_save, 300);
		JSClick(Reconciliation_ReconcileBtn_save, "Save Button");

		Thread.sleep(5000);

		// * Below method written to logout application
		logOut();

	}

}
