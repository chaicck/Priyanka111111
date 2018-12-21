package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_67_VerifyNewInterfacecreatedForPlatformConfigured extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_67_VerifyNewInterfacecreatedForPlatformConfigured(String zUserName, String zPassword) throws Throwable {
    	
        String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
        logger = extent.startTest("1.67 Test ID : 20469 - Verify if there is a new interface created for platform configuration within customer context menu").assignCategory("Voice");
        logInfo("Currently Running on -- "+getCurrentUrl());
	logInfo("TestCase Description:Verify if there is a new interface created for platform configuration within customer context menu under Voice-Broadworks-Platform\r\n" + 
        		"Configuration and verify Broadsoft Cluster value on customer dashboard page");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");
        waitForElementPresent(searchTextBox, 300);
        type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

	    waitForElementPresent(voice_menu, 300);
		JSClick(voice_menu,"Voice");
		actionsClick(voice_notificationBroadWorks,"voice_notificationBroadWorks");
		JSClick(voice_notificationBroadWorks_platform_configuration,"voice_notificationBroadWorks_platform_configuration");
		//verifying labels
	    waitForElementPresent(voice_notificationBroadWorks_platform_configuration_nameLabel, 300);
	    Thread.sleep(8000);
		verifyText(voice_notificationBroadWorks_platform_configuration_nameLabel, "Name", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_codeLabel, "Code", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_ProvisioningLabel, "Provisioning", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_BillingLabel, "Billing", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_CRMLabel, "CRM", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_DeviceManagementLabel, "Device Management", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_PopRegionsLabel, "Pop Regions", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_DBMailLabel, "DB Mail", "");
		verifyText(voice_notificationBroadWorks_platform_configuration_CircuitProfileLabel, "Circuit Profile", "");
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_Provisioning_DD, 300);
		selectDropDownByVisibleText(voice_notificationBroadWorks_platform_configuration_Provisioning_DD, "icore");
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_saveBtn, 300);
		actionsClick(voice_notificationBroadWorks_platform_configuration_saveBtn, "Save Button");
		Thread.sleep(9000);
		acceptAlert();
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_saveBtn_successPopUp, 200);
		actionsClick(voice_notificationBroadWorks_platform_configuration_saveBtn_successPopUp);
		//verifying dash board
		waitForElementPresent(customerHome_dashBoard, 200);
		aJSClick(customerHome_dashBoard,"customerHome_DashBoard");
		waitForElementPresent(customerHome_dashBoard_broadSoftCluster, 200);
		String valueDisplayed=getDropdownSelectedValue(customerHome_dashBoard_broadSoftCluster);
		Assert.assertTrue(valueDisplayed.contains("icore"));
		
		logPass("middle section of the cluster name matches to the \"Provisioning\" value set previously i.e., 'icore'");
		logOut();	
	    
	    
		
    }}

