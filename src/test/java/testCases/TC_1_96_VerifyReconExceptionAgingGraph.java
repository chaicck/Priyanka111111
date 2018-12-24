package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_ReconsiliationPage;

public class TC_1_96_VerifyReconExceptionAgingGraph extends CommonReusables
		implements OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC,
		OR_Inventory, OR_ReconsiliationPage {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Select Reconciliation-Recon Exception Aging Graph Recon Exception Aging Graph displays able to click on Export
	 */
	@Test(alwaysRun = true, enabled = true)
	public void verifyReconExceptionAgingGraphn(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file
		// -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];

		logger = extent
				.startTest(
						"TC_1_96_Zeus-Recon-10 Reconcilation Aging Graph and report (NA in QA)")
				.assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Select Reconciliation-Recon Exception Aging Graph Recon Exception Aging Graph displays able to click on Export");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		setBrowserToSize(70);
		waitForElementPresent(reports, 300);
		click(reports, "Reports");
		click(reportsReconsilation, "reportsReconsilation");
		Thread.sleep(1000);
		aJSClick(reconExceptionAgingOption, "reconExceptionAgingOption");
		waitForElementPresent(agingGraphGoBtn, 300);
		click(agingGraphGoBtn, "agingGraph Go Btn");

		isassert = isElementDisplayed(agingGraphChart, "aging Graph Chart");
		softassert.assertEquals(isassert, true, "Verify Aging Graph Chart");

		waitForElementPresent(agingGraphExport, 300);
		click(agingGraphExport, "aging Graph values Export");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}
}
