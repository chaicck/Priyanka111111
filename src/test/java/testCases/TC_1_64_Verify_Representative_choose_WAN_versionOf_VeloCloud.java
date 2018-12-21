

package testCases;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_64_Verify_Representative_choose_WAN_versionOf_VeloCloud extends MediatorClass {
	  
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tC_1_64_Test_Whether_care_representative_is_able_to_choose_SmartWAN_version_Of_VeloCloud_devices(String zUserName, String zPassword)
			throws Throwable {
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		logger = extent.startTest("1.64 Test ID : 18919 - Test whether care representative is able to choose Smart WAN version of VeloCloud devices").assignCategory("Device");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Add Device under the Data-Device,Ensure the device type you select"
		 		+ " is from the VeloCloud and Check if user is able to choose SmartWAN version i.e. vco8-usca1.velocloud.net or "
		 		+ "vco15-usca1.velocloud.net and click on Add");
	    type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
        waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);

		// locators from OR_Customer Info
	    waitForElementPresent(Home_data, 300);
		click(Home_data, "Home Data");
		actionsClick(Home_data_devices, "Home-Data-Devices");
		waitForElementToBeClickable(Home_data_devices_addDevice, 300);
		scrollUp();
	    waitForElementPresent(Home_data_devices_addDevice, 300);
		JSClick(Home_data_devices_addDevice, "Add device");

		String deviceName = "gw1.adji.oak" + getRandomString(3);
		String ipAddress = "10.252.3." + getRandomInt(2);
		waitForElementPresent(addDevice_deviceName, 300);
		type(addDevice_deviceName, deviceName, "Device Name");
		type(addDevice_ipAddress, ipAddress, "Device IP address");
		Thread.sleep(6000);
		selectDropDownByVisibleText(addDevice_deviceType_DD, "VeloCloud - VCG");
		logInfo("Selected Device Type As - 'VeloCloud - VCG'");

		selectDropDownByIndex(addDevice_SNMP_DD, 2);
		selectDropDownByIndex(addDevice_Devision_DD, 2);
		Thread.sleep(6000);
		selectDropDownByIndex(addDevice_device_type_DD, 2);
		selectDropDownByVisibleText(addDevice_monitorType_DD, "SW");
		logInfo("Enterd All mandetory fields in the Add device form");
		scrollUp();
		waitForElementPresent(addDevice_add, 300);
		actionsClick(addDevice_add);
		waitForElementPresent(devices_verifyDeviceNameInTable, 300);
		verifyTextInColumnClickOtherColumn(devices_verifyDeviceNameInTable, device_verifyDeviceName_magnifyingSymbol,
				deviceName);
		logPass("Device successfully added with name " + deviceName);

		waitForElementPresent(addDevice_deviceName, 300);

		logInfo("Verifying the relation between VeloCloud under Device Type & SmartWAN Versions dropwown");
		// verifying step 5,6,7

		String ipAddressModified = "10.10." + getRandomInt(2) + "." + getRandomInt(1);
		clearText(addDevice_ipAddress);
		waitForElementPresent(addDevice_ipAddress, 300);
		type(addDevice_ipAddress, ipAddressModified, "Device IP address");
		
		Thread.sleep(3000);
		waitForElementPresent(addDevice_SmartWAN_Versions_DD, 300);
		actionsClick(addDevice_SmartWAN_Versions_DD, "SmartWAN_Versions DropDown");
		selectDropDownByVisibleText(addDevice_deviceType_DD, "VeloCloud - VCG");
		logInfo("Verifying SmartWAN_Versions Drop down options");
	   
		selectDropDownByIndex(addDevice_deviceType_DD, 2);
		logInfo("Selected Device Type is other than 'VeloCloud' family");
		Thread.sleep(3000);
		waitForElementPresent(addDevice_SmartWAN_Versions_DD, 300);
		actionsClick(addDevice_SmartWAN_Versions_DD, "SmartWAN_Versions DropDown");
		logInfo("Verifying SmartWAN_Versions Drop down options");
		Assert.assertTrue(verifyTextPresentInList(addDevice_SmartWAN_Versions_DD_options, ""));
		logPass("---None--- opetion present under SmartWAN_Versions DropDown when other than VeloCloud family selected in DeviceType DropDown");
        Thread.sleep(8000);
        waitForElementPresent(addDevice_SmartWAN_Versions_DD, 300);
		actionsClick(addDevice_SmartWAN_Versions_DD, "SmartWAN_Versions DropDown");
		logInfo("Verifying SmartWAN_Versions Drop down options");
		Assert.assertTrue(!getText(addDevice_SmartWAN_Versions_DD).equalsIgnoreCase(""));
		logPass("selected value under SmartWAN_Versions DropDown is " + getText(addDevice_SmartWAN_Versions_DD)
		+ " when VeloCloud family selected in DeviceType DropDown");
		waitForElementPresent(addDevice_add, 300);
		actionsClick(addDevice_add);
		if (verifyElementText(addDevice_Modify_SuccessMsg_OK_Btn, "OK")) {
			actionsClick(addDevice_Modify_SuccessMsg_OK_Btn);
		}
		logOut();	
		
	}
}
