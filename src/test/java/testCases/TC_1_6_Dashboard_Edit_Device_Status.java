package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_6_Dashboard_Edit_Device_Status extends MediatorClass{

	  
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tC_1_6_Dashboard_Edit_Device_Status(String zUserName, String zPassword) throws Throwable {

		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
        logger = extent.startTest("1.6 Test ID : 16995 - Customer Dashboard_Edit Device Status ").assignCategory("Customer_DashBoard");
        logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Go to customer dashboard page,verify Device Statusa and now select Data and click on Devices,Verify "
        		+ "SNMP status must be shown underneath SNMP for any Device");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
	    waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
	
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

		
		String customer_dashBoard_device_status="xpath=//label[@for='monitoring_status']";
		String customer_dashBoard_device_status_btn="xpath=//a[@id='monitoring_status']";
		String customer_dashBoard_device_status_btn_info="xpath=//h3[@class='modal-title center']";  //Monitoring Status
		String customer_dashBoard_device_status_btn_info_closeBtn="xpath=//button[@class='close']";
		String Home_data_devices_magnifier="xpath=//a[starts-with(@href,'/device/view/device_id')]";
		
		String Home_data_devices_magnifier_snmp="xpath=//label[@for='device_snmp_id']";
		String Home_data_devices_magnifier_snmp_DD="id=device_snmp_id";
		String Home_data_devices_magnifier_deviceName="id=device_name";
		String Home_data_devices_magnifier_saveBtn="xpath=(//button[@type='submit'])[2]";
		String Home_data_devices_magnifier_saveBtn_successPopUp="xpath=//button[@class='btn btn-default center-block']";
		String Home_data_devices_1stDeviceName_table="xpath=//*[@id='device_table']/tbody/tr[1]/td[3]";
		
		waitForElementPresent(customer_dashBoard_device_status, 300);
		verifyText(customer_dashBoard_device_status, "Device Status", "");
		waitForElementToBeClickable(customer_dashBoard_device_status_btn);
		waitForElementPresent(customer_dashBoard_device_status_btn, 300);
		//verifyText(customer_dashBoard_device_status_btn, "UNKNOWN", "");
		//waitForElementPresent(customer_dashBoard_device_status_btn, 300);
		actionsClick(customer_dashBoard_device_status_btn);
		
		waitForElementPresent(customer_dashBoard_device_status_btn_info, 200);
		verifyText(customer_dashBoard_device_status_btn_info, "Monitoring Status", "");
		waitForElementPresent(customer_dashBoard_device_status_btn_info_closeBtn, 300);
		actionsClick(customer_dashBoard_device_status_btn_info_closeBtn);
		waitForElementPresent(Home_data, 300);
		click(Home_data, "Home Data");
		JSClick(Home_data_devices);
	     Thread.sleep(9000);
		if(!verifyElementText(Home_data_devices_magnifier, "")) {
			Assert.assertTrue(false); 
		}
		Thread.sleep(1000);
		logPass("Device details displayed");
		waitForElementPresentE(Home_data_devices_magnifier, 30);
		actionsClick(Home_data_devices_magnifier);
		logPass("Selected on the magnifying glass icon present within the device row");
		waitForElementPresent(Home_data_devices_magnifier_snmp, 300);
		verifyText(Home_data_devices_magnifier_snmp, "Device SNMP / WMI", "");
		logPass("Verified SNMP status shown underneath SNMP Status field");
        String snmp_selectedValue=selectedOptionDroDown(Home_data_devices_magnifier_snmp_DD);
		Assert.assertTrue(snmp_selectedValue.contains("SNMP")||snmp_selectedValue.contains("WMI"));
		
		String deviceName=randomString(5);
		clearText(Home_data_devices_magnifier_deviceName);
		waitForElementPresent(Home_data_devices_magnifier_deviceName, 300);
		type(Home_data_devices_magnifier_deviceName, deviceName, "Device name");
		waitForElementPresent(Home_data_devices_magnifier_saveBtn, 300);
		actionsClick(Home_data_devices_magnifier_saveBtn);
		logPass("Save Device");
		waitForElementPresent(Home_data_devices_magnifier_saveBtn_successPopUp, 200);
		actionsClick(Home_data_devices_magnifier_saveBtn_successPopUp);
		logOut();
		
		
	}
		
	
}
