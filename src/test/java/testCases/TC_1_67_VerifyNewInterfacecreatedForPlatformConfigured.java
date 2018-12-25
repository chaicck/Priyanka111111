package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_67_VerifyNewInterfacecreatedForPlatformConfigured extends MediatorClass{
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Verify if there is a new interface created for platform configuration within customer context menu under Voice-Broadworks-Platform\r\n" + 
        		"Configuration and verify Broadsoft Cluster value on customer dashboard page
	 */
	
	 @Test(alwaysRun=true,enabled=true)
    public void tc_1_67_VerifyNewInterfacecreatedForPlatformConfigured(ITestContext context) throws Throwable {
    	
		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
        String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 8),1);
        String searchBox=getTestData(this.getClass().getSimpleName().substring(0, 8),2);
        String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
        String nametxt=getTestData(this.getClass().getSimpleName().substring(0, 8),5);
        String codetxt=getTestData(this.getClass().getSimpleName().substring(0, 8),6);
        String provisioningtxt=getTestData(this.getClass().getSimpleName().substring(0, 8),7);
        String billingtxt=getTestData(this.getClass().getSimpleName().substring(0, 8),8);
        String crmtxt=getTestData(this.getClass().getSimpleName().substring(0, 8),9);
        String devicetxt=getTestData(this.getClass().getSimpleName().substring(0, 8),10);
        String popRegiontxt=getTestData(this.getClass().getSimpleName().substring(0, 8),11);
        String dbtxt=getTestData(this.getClass().getSimpleName().substring(0, 8), 12);
        String circuitxt=getTestData(this.getClass().getSimpleName().substring(0, 8),13);
        String icoreTxt=getTestData(this.getClass().getSimpleName().substring(0, 8),14);
 
     // * logger method for report starting from here
        logger = extent.startTest("1.67 Test ID : 20469 - Verify if there is a new interface created for platform configuration within customer context menu").assignCategory("Voice");
        logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Verify if there is a new interface created for platform configuration within customer context menu under Voice-Broadworks-Platform\r\n" + 
        		"Configuration and verify Broadsoft Cluster value on customer dashboard page");
        
        // * Below Code written to verify login
     	login(zUserName, zPassword);

        waitForElementPresent(searchTextBox, 300);
        type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,searchBox,Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, customertxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		isassert = verifyText(customer_dashboard_name, customertxt2, "Customer Name");  
		softassert.assertEquals(isassert, true, "Verified customer id "+customertxt2+" in customer table");

	    waitForElementPresent(voice_menu, 300);
		JSClick(voice_menu,"Voice");
		actionsClick(voice_notificationBroadWorks,"voice_notificationBroadWorks");
		JSClick(voice_notificationBroadWorks_platform_configuration,"voice_notificationBroadWorks_platform_configuration");
		//verifying labels
	    waitForElementPresent(voice_notificationBroadWorks_platform_configuration_nameLabel, 300);
	    Thread.sleep(8000);
	    
	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_nameLabel, nametxt, "Name");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+nametxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_codeLabel, codetxt, "Code");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+codetxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_ProvisioningLabel, provisioningtxt, "Provisioning");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+provisioningtxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_BillingLabel, billingtxt, "Billing");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+billingtxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_CRMLabel, crmtxt, "CRM");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+crmtxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_DeviceManagementLabel, devicetxt, "Device Management");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+devicetxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_PopRegionsLabel, popRegiontxt, "Pop region");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+popRegiontxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_DBMailLabel, dbtxt, "DB Mail");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+dbtxt+" in notification board");

	    isassert = verifyText(voice_notificationBroadWorks_platform_configuration_CircuitProfileLabel, circuitxt, "Circuit Profile");
	    softassert.assertEquals(isassert, true, "Verified configuration name label "+circuitxt+" in notification board");
		
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_Provisioning_DD, 300);
		selectDropDownByVisibleText(voice_notificationBroadWorks_platform_configuration_Provisioning_DD, "icore");
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_saveBtn, 300);
		actionsClick(voice_notificationBroadWorks_platform_configuration_saveBtn, "Save Button");
		Thread.sleep(9000);
		acceptAlert();
		waitForElementPresent(voice_notificationBroadWorks_platform_configuration_saveBtn_successPopUp, 200);
		actionsClick(voice_notificationBroadWorks_platform_configuration_saveBtn_successPopUp);
		//verifying dash board 
		// failing here - need discussion 
		waitForElementPresent(customerHome_dashBoard, 200);
		aJSClick(customerHome_dashBoard,"customerHome_DashBoard");
		waitForElementPresent(customerHome_dashBoard_broadSoftCluster, 20);
		String valueDisplayed=getDropdownSelectedValue(customerHome_dashBoard_broadSoftCluster);
		softassert.assertTrue(valueDisplayed.contains(icoreTxt));
	
		// * Below method written to logout application
		logOut();
		softassert.assertAll();	
	    
	    
		
    }}

