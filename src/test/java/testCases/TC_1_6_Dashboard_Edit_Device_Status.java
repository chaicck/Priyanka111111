package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_6_Dashboard_Edit_Device_Status extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Go to customer dashboard page,verify Device Status and now select Data and click on Devices,Verify "
				+ "SNMP status must be shown underneath SNMP for any Device
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tC_1_6_Dashboard_Edit_Device_Status(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file -
		// LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchBox = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customerTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String deviceStatus = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String monitorStatsu = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String magnifier = getTestData(this.getClass().getSimpleName().substring(0, 8), 7);
		String snmp = getTestData(this.getClass().getSimpleName().substring(0, 8), 8);
		String wmi = getTestData(this.getClass().getSimpleName().substring(0, 8), 9);

		// * logger method for report starting from here
		logger = extent.startTest(
				"1.6 Test ID : 16995 - Customer Dashboard_Edit Device Status ")
				.assignCategory("Customer_DashBoard");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to customer dashboard page,verify Device Statusa and now select Data and click on Devices,Verify "
				+ "SNMP status must be shown underneath SNMP for any Device");
		// * Below Code written to verify login
		login(zUserName, zPassword);
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchBox, Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, customerTxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName,
					customer_id);
		}

		isassert = verifyText(customer_dashboard_name, customerTxt2,"Customer Name");
		softassert.assertEquals(isassert, true, "Verified customer id "+ customerTxt2 + " in customer table");

		waitForElementPresent(customer_dashBoard_device_status, 300);
		verifyText(customer_dashBoard_device_status, deviceStatus, "");
		waitForElementToBeClickable(customer_dashBoard_device_status_btn);
		waitForElementPresent(customer_dashBoard_device_status_btn, 300);
		// verifyText(customer_dashBoard_device_status_btn, "UNKNOWN", "");
		// waitForElementPresent(customer_dashBoard_device_status_btn, 300);
		actionsClick(customer_dashBoard_device_status_btn);

		waitForElementPresent(customer_dashBoard_device_status_btn_info, 200);
		isassert = verifyText(customer_dashBoard_device_status_btn_info,monitorStatsu, "Monitor status");
		softassert.assertEquals(isassert, true, "Verified dashboard device "+ monitorStatsu + " info");
		
		waitForElementPresent(customer_dashBoard_device_status_btn_info_closeBtn, 300);
		actionsClick(customer_dashBoard_device_status_btn_info_closeBtn);
		waitForElementPresent(Home_data, 300);
		click(Home_data, "Home Data");
		JSClick(Home_data_devices);
		Thread.sleep(9000);
		if (!verifyElementText(Home_data_devices_magnifier, "Device Mannifier")) {
			softassert.assertTrue(false);
		}
		Thread.sleep(1000);
		logPass("Device details displayed");
		waitForElementPresentE(Home_data_devices_magnifier, 30);
		actionsClick(Home_data_devices_magnifier);
		logPass("Selected on the magnifying glass icon present within the device row");
		waitForElementPresent(Home_data_devices_magnifier_snmp, 300);
		
		isassert = verifyText(Home_data_devices_magnifier_snmp, magnifier, "Device SNMP / WMI");
		softassert.assertEquals(isassert, true, "Verified device magnifier "+ magnifier + " info");

		logPass("Verified SNMP status shown underneath SNMP Status field");
		String snmp_selectedValue = selectedOptionDroDown(Home_data_devices_magnifier_snmp_DD);

		softassert.assertTrue(snmp_selectedValue.contains(snmp)|| snmp_selectedValue.contains(wmi), "Verify text " + snmp+ "and text" + wmi + "");

		String deviceName = randomString(5);
		clearText(Home_data_devices_magnifier_deviceName);
		waitForElementPresent(Home_data_devices_magnifier_deviceName, 300);
		type(Home_data_devices_magnifier_deviceName, deviceName, "Device name");
		waitForElementPresent(Home_data_devices_magnifier_saveBtn, 300);
		actionsClick(Home_data_devices_magnifier_saveBtn);
		logPass("Save Device");
		waitForElementPresent(Home_data_devices_magnifier_saveBtn_successPopUp,
				200);
		actionsClick(Home_data_devices_magnifier_saveBtn_successPopUp);

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}

}
