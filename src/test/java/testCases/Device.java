package testCases;

import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Device extends MediatorClass {

	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void verifyAddDevice(String zUserName, String zPassword) throws Throwable {

		logger = extent.startTest("Device").assignCategory("Device","Regression test");
		logInfo("TestCase Description:Customer DashBoard go to Data Device then Add Device,Push to SW and Remove from solarwind");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");

		type(searchTextBox, "36363", "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);

		// locators from OR_Customer Info 
		waitForElementPresent(Home_data, 300);
		click(Home_data, " Data");
		actionsClick(Home_data_devices,"Device");
        waitForElementPresent(Home_data_devices_addDevice, 300);
		actionsClick(Home_data_devices_addDevice,"Add Device");
		String deviceName="gw1.adji.oak"+dateAftersomeDays(0, "yyyyMMddHHmmss");
		String ipAddress="10.252.3."+getRandomInt(2);
	    waitForElementPresent(addDevice_deviceName, 300);
		type(addDevice_deviceName, deviceName, "Device Name");
		Thread.sleep(8000);
		if(isAlertPresent())
			acceptAlert();
	
		type(addDevice_ipAddress, ipAddress, "Device IP address");
		Thread.sleep(8000);
		if(isAlertPresent())
			acceptAlert();
	
		String addDevice_SNMP_DD="id=device_snmp_id";
	    String addDevice_Devision_DD="id=solar_winds_division";	 
	    String addDevice_monitorType_DD="id=monitor_type";
	    waitForElementPresent(addDevice_SNMP_DD, 300);
		selectDropDownByIndex(addDevice_SNMP_DD, 2);
		Thread.sleep(1000);
		if(isAlertPresent())
			acceptAlert();
	         selectDropDownByIndex(addDevice_Devision_DD, 2);
			Thread.sleep(1000);
		if(isAlertPresent())
			acceptAlert();
		waitForElementPresent(addDevice_device_type_DD, 300);
		selectDropDownByIndex(addDevice_device_type_DD, 2);
			Thread.sleep(1000);
		if(isAlertPresent())
			acceptAlert();
		selectDropDownByVisibleText(addDevice_monitorType_DD, "SW");
			Thread.sleep(1000);
		if(isAlertPresent())
			acceptAlert();
	    waitForElementPresent(addDevice_add, 300);

		actionsClick(addDevice_add,"Add");
		Thread.sleep(5000);
	    waitForElementPresent(devices_verifyDeviceNameInTable, 300);
		verifyTextInColumnClickOtherColumn(devices_verifyDeviceNameInTable, device_verifyDeviceName_magnifyingSymbol, deviceName);
               	Thread.sleep(1000);
		if(isAlertPresent())
			acceptAlert();
		waitForElementPresent(device_details_SolarWindMaintenance, 300);
		scrollElementIntoView(device_details_SolarWindMaintenance); 
		actionsClick(device_details_SolarWindMaintenance,"SolarWind Maintenance");
              	Thread.sleep(8000);
		if(isAlertPresent())
			acceptAlert();
		waitForElementPresent(device_details_SolarWindMaintenance_grouping_DD, 300);
		selectDropDownByIndex(device_details_SolarWindMaintenance_grouping_DD, 2);
		
		waitForElementPresent(device_details_SolarWindMaintenance_moveToSW, 300);
		waitForElementPresent(device_details_SolarWindMaintenance_moveToSW, 300);
		actionsClick(device_details_SolarWindMaintenance_moveToSW,"Move To SW");
		Thread.sleep(8000);
		if(isAlertPresent())
			acceptAlert();
		Thread.sleep(8000);
		//comes only after move to SW operation
		waitForElementToBeClickable(device_details_SolarWindMaintenance_removeFromSW, 300);		
		System.out.println(getText(device_details_SolarWindMaintenance_removeFromSW));
		Thread.sleep(15000);
		waitForElementToBeClickable(device_details_SolarWindMaintenance_removeFromSW, 300);	
		verifyText(device_details_SolarWindMaintenance_removeFromSW, "Remove From SW", "");
		
		String addDevice_fromDateUtc="id=sw_from_date";
		String addDevice_fromHour="id=sw_from_hour";
		String addDevice_untillDate="id=sw_until_date";
		String addDevice_savedowntime="id=save_downtime";
		
		String fromDate=dateAftersomeDays(1, "MMddyyy");
		String untillDate=dateAftersomeDays(5, "MMddyyy");
		
		scrollElementIntoView(addDevice_fromDateUtc);

		waitForElementToBeClickable(addDevice_fromDateUtc, 300);		
		type(addDevice_fromDateUtc, fromDate, "addDevice_fromDateUtc");
			Thread.sleep(8000);
		if(isAlertPresent())
			acceptAlert();
		waitForElementToBeClickable(addDevice_fromHour, 300);
		selectDropDownByVisibleText(addDevice_fromHour, "23:00");
		waitForElementToBeClickable(addDevice_untillDate, 300);
		type(addDevice_untillDate, untillDate, "addDevice_untillDate");
		waitForElementToBeClickable(addDevice_savedowntime, 300);
		JSClick(addDevice_savedowntime,"Device down time");
		Thread.sleep(15000);
		if(isAlertPresent())
			acceptAlert();
		Thread.sleep(15000);

		String solarWinds_downTimeRecords_downTimeUTC="xpath=//*[@id='swDowntime']/table/tbody/tr/td[1]";
		String solarWinds_downTimeRecords_upTimeUTC="xpath=//*[@id='swDowntime']/table/tbody/tr/td[2]";
		
		String fromdate=dateAftersomeDays(1, "yyy-MM-dd")+" 23:00:00";
		String untilldate=dateAftersomeDays(5, "yyy-MM-dd")+" 00:00:00";
		Thread.sleep(15000);
		if(isAlertPresent())
			acceptAlert();
		Thread.sleep(4000);
		waitForElementToBeClickable(solarWinds_downTimeRecords_downTimeUTC, 300);	
		assertTrue(verifyTextPresentInList(solarWinds_downTimeRecords_downTimeUTC, fromdate));
		Thread.sleep(15000);
		if(isAlertPresent())
			acceptAlert();
		Thread.sleep(15000);
		waitForElementToBeClickable(solarWinds_downTimeRecords_upTimeUTC, 300);
		assertTrue(verifyTextPresentInList(solarWinds_downTimeRecords_upTimeUTC, untilldate));				
        logOut();
	}

}
