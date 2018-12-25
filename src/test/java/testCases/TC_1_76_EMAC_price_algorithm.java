package testCases;

import java.io.File;
import java.text.DecimalFormat;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_76_EMAC_price_algorithm extends MediatorClass{
	
	
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true)
    public void tc_1_76_EMAC_price_algorithm(ITestContext context) throws Throwable {
		 
		// * Below variables written to get input data from excelsheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String realogyTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String callRecordingTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String Mac_name="Test "+randomString(2);
		String Mac_ticket=randomNum(5);
		
		// * logger method for report starting from here
		logger = extent.startTest("1.76 Test ID : 16834 - Verify that EMAC price algorithm sets the price at the 10 percent discount level").assignCategory("Customer DashBoard");
		logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Add MAC for any customer with Contarct product and verify MRC and NRC price.");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);
		
        waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,searchTxt,Keys.ENTER);
		/*Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, customertxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		isassert = verifyText(customer_dashboard_name, customertxt2, "Customer Name");  
		softassert.assertEquals(isassert, true, "Verified customer id "+customertxt2+" in customer table");
		
		*/
		Thread.sleep(3000);
		scrollElementIntoView(customerDashboard_addMAC);
		JSClick(customerDashboard_addMAC,"customerDashboard_addMAC");
		waitForElementPresent(customerDashboard_addMAC_productAddNew, 200);
		type(customerDashboard_addMAC_productAddNew_macName, Mac_name, "AddMAC_productAddNew_macName");
		type(customerDashboard_addMAC_productAddNew_ticket, Mac_ticket, "AddMAC_productAddNew_ticket");
		Thread.sleep(3000);
		scrollElementIntoView(customerDashboard_addMAC_productAddNew);
		JSClick(customerDashboard_addMAC_productAddNew,"addMAC_productAddNew");
		
		int n=getAllElements(customerDashboard_addMAC_productAddNew_productTextBoxList).size();
		
		
		typeAndVerify10DiscountPrice(realogyTxt, n);
		logPass("Verified 10% discount price with 'Realogy Access Charge'");
		//typeAndVerify10DiscountPrice("Hunt Group");
		typeAndVerify10DiscountPrice(callRecordingTxt, n);	
		Thread.sleep(3000);
		logPass("Verified 10% discount price with 'Call Recording Storage 1 year'");
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();

    }
    
    
    
}

