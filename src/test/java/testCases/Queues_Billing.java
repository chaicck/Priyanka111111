package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class Queues_Billing extends MediatorClass{
      
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
	
	 String fs= File.separator;
	 String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true)
	public void tc_1_48_Queues_Billing(ITestContext context) throws Throwable {
		
		 // * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String TicketNumber = getRandomInt(6);
		String billingDayLegend = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String hasBillCycle = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String parentHasBillCycle = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String recommendedBillCycle = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String pQ2CCustomer = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String nonBilling = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String noOfrecord = getTestData(this.getClass().getSimpleName().substring(0, 8), 7);
		String listData = getTestData(this.getClass().getSimpleName().substring(0, 8), 8);
		

			// * logger method for report starting from here
		logger = extent.startTest(" Queues-  - Billing").assignCategory("Queues");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Verify if user is able to view the Billing Day Legend\r\n" + "information shown on the top of the page." );
		
		
		// * Below Code written to verify login
		login(zUserName, zPassword);
				
		waitForElementPresent(Queues_Menu, 30);
		logInfo("Logged into Zeus successfully"); 
		actionsClick(Queues_Menu, "Queues");
		JSClick(Queues_Billing,"Queues_Billing");
		waitForElementPresent(Queues_Billing_BillingDayLegend, 300);
		
		isassert = verifyText(Queues_Billing_BillingDayLegend, billingDayLegend, "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		logPass("User is able to view Billing Day Legend information");

		isassert = verifyText(Queues_Billing_HasBillCycle_symbol, "#", "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifyText(Queues_Billing_HasBillCycle, hasBillCycle, "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		softassert.assertEquals(getAttributeValue(Queues_Billing_HasBillCycle_symbol, "style").contains("black"), true);
		
		isassert = verifyText(Queues_Billing_Parent_HasBillCycle_symbol, "#", "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifyText(Queues_Billing_Parent_HasBillCycle, hasBillCycle, "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		softassert.assertEquals(getAttributeValue(Queues_Billing_Parent_HasBillCycle_symbol, "style").contains("blue"), true);
		
		isassert = verifyText(Queues_Billing_RecomendedBillCycle_symbol, "#", "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifyText(Queues_Billing_RecomendedBillCycle, recommendedBillCycle, "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		softassert.assertEquals(getAttributeValue(Queues_Billing_RecomendedBillCycle_symbol, "style").contains("green"), true);
	

		isassert = verifyText(Queues_Billing_PQ2C_Customers_symbol, "#", "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifyText(Queues_Billing_PQ2C_Customers, pQ2CCustomer, "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		softassert.assertEquals(getAttributeValue(Queues_Billing_RecomendedBillCycle_symbol, "style").contains("purple"), true);
		
		isassert = verifyText(Queues_Billing_NonBilling, nonBilling, "");    
		softassert.assertEquals(isassert, true, "Verify text on page ");
		logPass("'Non Billing' information displayed as part of the Billing Day Legend section");
		//step 7 verification
		String noOfrecords=getDropdownSelectedValue(queues_billing_showRecords_DD);
		softassert.assertEquals(noOfrecord, noOfrecords);
		logPass("By default, " +noOfrecord+" records are displayed on the page");

		isassert =  verifyDropDownOptionsRespectiveRecordsDisplayed(queues_billing_showRecords_DD, queues_billing_tableRecords, AddElementsIntoList(listData));
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		logPass("user is able to switch to 10, 25, 50, 100 number of records & respective number of records displayed per page");
		//Step 8 verification
		softassert.assertEquals(getAttributeValue(queues_billing_searchBox, "placeholder").contains("Search"), true);
		clearText(queues_billing_searchBox);
		

		softassert.assertAll();
		
		// Below method writtent to do logout from application
		logOut();
	}
	
} 
