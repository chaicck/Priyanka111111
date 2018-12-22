package testCases;

import java.io.File;

import org.apache.log4j.lf5.util.LogFileParser;
import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_Billing;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_ReconsiliationPage;
import demo.objectrepository.OR_SearchPage;

public class Reconciliation1971 extends CommonReusables implements OR_HomePage,
		OR_CustInfo, OR_ProjectManager, OR_NewMAC, OR_Inventory,
		OR_ReconsiliationPage, OR_Billing {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/** TestCase Description:Verify Billing Contract DropDown */

	@Test(alwaysRun = true, enabled = true)
	public void reconciliation1971(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent.startTest("Reconcile Email Check and notes")
				.assignCategory("Customer_DashBoard");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Reconcile of Email check");
		String searchTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Search for customerID in search box
		type(OR_SearchPage.srchTxt, searchTxt1, "Search box");
		type(OR_SearchPage.srchTxt, searchTxt2, Keys.ENTER);

		isassert = click(OR_SearchPage.Symbol1stCustomer, "Symbol1stCustomer");
		softassert.assertEquals(isassert, true);

		isassert = click(OR_SearchPage.reconsilation1stCustomer,
				"reconsilation Option of 1stCustomer");
		softassert.assertEquals(isassert, true);

		isassert = actionsClick(Reconciliation_refresh, "Refresh");
		softassert.assertEquals(isassert, true);

		logPass("Sucessfully clicked on Reconcile");
		Thread.sleep(5000);

		// Below method writtent to do logout from application
		logOut();
		softassert.assertAll();
	}
}
