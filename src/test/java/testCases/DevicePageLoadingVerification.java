package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class DevicePageLoadingVerification extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description::Device page loading verification
	 */

	@Test(alwaysRun = true, enabled = true)
	public void customer_Search(ITestContext context) throws Throwable {

		// * Below variables written to get input data from LogingCredentails.properties

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();

		String url_telesphere = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String devicName = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		
		// * Below Code written to verify login
		logger = extent.startTest("Device Verification").assignCategory("Device");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description::Device page loading verification");
		System.out.println("TestCase Description::Device page loading verification");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		navigateTo(url_telesphere);
		waitForElementPresent(devicePage_header, 30);
		isassert = verifyText(devicePage_header, devicName, "Device Name");
		softassert.assertEquals(isassert, true, "Verify Device page header");

		System.out.println("Device displayed is "+ getText(devicePage_deviceName).trim());
		logInfo("Device displayed is " + getText(devicePage_deviceName).trim());
		logInfo("Solar wind status when script excecuted is "+ getText(devicePage_solarWindStatus));

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}
}