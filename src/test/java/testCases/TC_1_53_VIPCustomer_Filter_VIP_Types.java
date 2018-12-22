package testCases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_53_VIPCustomer_Filter_VIP_Types extends MediatorClass {

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

	@Test(alwaysRun = true, enabled = true)
	public void tC_1_53_VIPCustomer_Filter_VIP_Types(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();
		String vip_Customers = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String colliersInternation = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String platinumVip = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);

		logger = extent.startTest("TC_1_53_VIPCustomer_Filter_VIP_Types")
				.assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to Reports then hover on Customers and select VIP Customer List and Verify All, Platinum VIP, Standard, VIP Filters");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// refreshBrowser();
//		Thread.sleep(60000);
		isassert = verifySubMenuHeadLine(reports, reports_customers,
				reports_customers_vipCustomerList,
				reports_reconciliation_subMenu_headline, vip_Customers);
		softassert.assertEquals(isassert, true, "Verify VIP Customers");

		type(customers_customer_search, colliersInternation,
				"search with customer name");
		Thread.sleep(60000);
		String defaultValue = selectedOptionDroDown(customers_vipCustomerList_customers_dropDown);
		System.out.println(defaultValue);
		softassert.assertTrue(defaultValue.contains(platinumVip));

		logPass("Verified if user is able to filter the list of customers on the VIP Customer page\r\n"
				+ "        and by using the following type:Platinum VIP");

		int platinum_vipReords = getAllElements(
				customers_vipCustomerList_Platinum_vipType_list).size();
		int totalReords1 = getAllElements(
				customers_vipCustomerList_customers_recordsInTable).size();
		Thread.sleep(60000);
		softassert.assertEquals(platinum_vipReords, totalReords1, "Verify platinum viprepords is equals customer records table");

		selectDropDownByVisibleText(customers_vipCustomerList_customers_dropDown, "VIP");
		logPass(" Verified if user is able to filter the list of customers on the VIP Customer page "
				+ "and by using the following type:Standard VIP");
		Thread.sleep(3000);

		int vipReords = getAllElements(customers_vipCustomerList_vipType_List)
				.size();
		int totalReords2 = getAllElements(
				customers_vipCustomerList_customers_recordsInTable).size();
		Thread.sleep(60000);
		softassert.assertEquals(vipReords, totalReords2, "Verify vip customer list and customer records in table");
		waitForElementPresent(customers_vipCustomerList_customers_dropDown, 200);
		selectDropDownByVisibleText(customers_vipCustomerList_customers_dropDown, "All");
		logPass(" Verified if user is able to filter the list of customers on the VIP Customer page "
				+ "and by using the following type:All");
		Thread.sleep(3000);
		waitForElementPresent(customers_vipCustomerList_recordsPerPage_dropDown, 200);
		selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "100");
		Thread.sleep(9000);
		int totalReords3 = getAllElements(customers_vipCustomerList_customers_recordsInTable).size();

		if (totalReords3 >= 50) {
			selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "50");
			Thread.sleep(3000);
			int totalReords4 = getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
			softassert.assertEquals(totalReords4, 50);
		}
		if (totalReords3 >= 25) {
			selectDropDownByVisibleText(
					customers_vipCustomerList_recordsPerPage_dropDown, "25");
			Thread.sleep(3000);
			int totalReords5 = getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
			softassert.assertEquals(totalReords5, 25);
		}
		if (totalReords3 >= 10) {
			selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "10");
			Thread.sleep(3000);
			int totalReords6 = getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
			softassert.assertEquals(totalReords6, 10);
		}
		
		// * Below method written to logout application
     	logOut();
     	softassert.assertAll();

	}

}
