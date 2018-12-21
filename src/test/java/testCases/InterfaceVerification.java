package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class InterfaceVerification extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/18/2018}
	 */

	/**
	 * TestCase Description:Verify all menu's under the Search Dropdown and
	 * perform search functinolity with respective data
	 */

	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs + "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void interfaceVerification(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file
		// -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);

		// * logger method for report starting from here
		logger = extent.startTest("Payment and InvoiceVerification and Export");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Invoice & Payments, Should be able to export and verify page load");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		
		isassert = verifyText(customer_dashboard_name, "Customer:", "Customer Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		Thread.sleep(3000);

		JSClick(dashboard_data);
		actionsClick(data_devices);

		Thread.sleep(5000);
		if (verifyElementText(data_devices_1StMagnifier, "")) {
			String deviceId = getText(data_devices_1StDeviceId);
			actionsClick(data_devices_1StMagnifier);
			logPass("Clicking on Device Id i.e., -" + deviceId);
		} else {
			logFail("No devices are present under data -> Devices -> Device Table");
		}

		waitForElementPresent(data_devices_magnifierNameTable_deviceMonitorType_DD, 20);
		isassert = selectDropDownByVisibleText(data_devices_magnifierNameTable_deviceMonitorType_DD, "SW");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		softassert.assertAll();
		// Below method written to do logout from application
		logOut();
	}

}
