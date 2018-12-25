package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;
import utils.AssertSoftly;
import utils.ExcelUtils;

public class TC_1_10_ExportChildCustomerList extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:verify that child customer pane must display a new
	 * button 'Export Child Customers'\r\n" +Export Child Customers' button should
	 * be present within Child Customers pane\r\n" "Test by clicking on Export
	 * button .CSV file must be downloaded automatically" TestCase
	 * Description:Verify Billing Contract DropDown
	 */

	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs + "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_10_ExportChildCustomerList(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchBox = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String url = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent.startTest("1.10 Test ID : 16338 - Export Child Customer List")
				.assignCategory("Customer DashBoard");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:verify that child customer pane must display a new button 'Export Child Customers'\r\n"
				+ "'Export Child Customers' button should be present within Child Customers pane\r\n"
				+ "Test by clicking on Export button .CSV file must be downloaded automatically");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchBox, Keys.ENTER);
		Thread.sleep(2000);
		actionsClick(customerDashboard_customerLink, "customerDashboard_customerLink");
		// url may differ based on environment & user id - qa5, qa6, master
//		softassert.assertTrue(getCurrentUrl().contains(url));
		scrollElementIntoView(childCustomerTableName);
		JSClick(childCustomerTableName, "childCustomerTableName");
		isassert = JSClick(customerDashboard_customerLink_exportChildCustomers, "exportChildCustomers");
		softassert.assertEquals(isassert, true,
				"Verify .CSV output file downloaded after clicking on the Export button");
		logPass(".CSV output file downloaded after clicking on the Export button");
		softassert.assertAll();
		logOut();

	}

}
