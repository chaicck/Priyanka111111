package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_SearchPage;

public class Customer_DashBoard_information extends CommonReusables {
	/**
	 * @author ${Customer_DashBoard_information}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */

	/** TestCase Description:Verify Customer DashBoard Page */

	@Test(alwaysRun = true, enabled = true)
	public void verifyHomePage(ITestContext context) throws Throwable {

		// ** Below variables written to get input data from excel sheet-Testdata.xlsx

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 12), 1);
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		// * logger method for report starting from here
		logger = extent.startTest(" Customer DashBoard");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify Customer DashBoard Page");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Search customer id
		click(OR_HomePage.srchDd, "Search");
		type(OR_SearchPage.srchTxt, customer_id, "Search box");
		type(OR_SearchPage.srchTxt, "Search box", Keys.ENTER);
		
		// * Verify is element present or not in customer dashboard page
		isassert = isElementDisplayedOrNot(format("Customer ID"), "Customer ID");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Account Status"),"Account Status");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Bill Cycle"), "Bill Cycle");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusSince, "Customer Since");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusExpire, "Contract Expire");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Customer Name"),"Customer Name");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Customer Alias"),"Customer Alias");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Customer Industry"),"Customer Industry");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Enterprise"), "Enterprise");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Group"), "Group");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(market, "Market");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Sales Person"),"Sales Person");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Access Hours"),"Access Hours");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusPin, "Customer PIN");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("VPN ID"), "VPN ID");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(format("Authorization Notes"),"Authorization Notes");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusVipType, "Customer VIP type");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(billingStatus, "billing Status type");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusMrr, "Customer MRR");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(siteMrr, "Site MRR");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(cusRank, "Customer Rank");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(siteRank, "Site Rank");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(csa, "CSA");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(broadcastCluster, "Broadsoft Cluster");
		softassert.assertEquals(isassert, true);
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(downTime, "Solarwinds Downtime");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(shipAddr, "Site/Shipping Address");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(billingAddr, "Billing Address");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(contactTable, "contactTable");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(Thirdpartyproducts, "Third Party Products");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(contractTimeLine, "contractTimeLine");
		softassert.assertEquals(isassert, true);
		isassert = isElementDisplayedOrNot(projectTimeLine, "projectTimeLine");
		softassert.assertEquals(isassert, true);
		// * Below method written to logout application
		logOutt();
		softassert.assertAll();


	}

}
