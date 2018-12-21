package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_84_Admin_SalesTool_EnganeeringICB  extends MediatorClass{
	
	String Queues_engineeringICB="xpath=//a[@href='/eicb/queue/']";
	String Queues_engineeringICB_searchBox="xpath=//input[@type='search']";
	String Queues_engineeringICB_table_subjects="xpath=//*[@id='queue']/tbody/tr/td[2]";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	 public void tc_1_84_salesTool_EnganeeringICB(String zUserName, String zPassword) throws Throwable {
	

		logger = extent.startTest("1.84 Test ID : 15750 - ZEUS-ADMIN-48_Admin_Sales Tools Engineering ICB").assignCategory("Admin");
		logInfo("Currently Running on -- "+getCurrentUrl());
		 logInfo("TestCase Description:Hover on Sales Tools and select Create External EICB Quote and submit the Engineering ICB");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
		String subject ="Automation "+randomString(5);
		String description="Auto test "+randomString(5);
		String excustomerid =randomNum(4);	
		String excustomerquoteid =randomNum(4);
		String excustomercaseid =randomNum(4);
		setBrowserTo80Size();
		setBrowserToSize(70);
		waitForElementPresent(admin_menu, 300);
		click(admin_menu, "Admin");
		click(admin_menu_salestools, "Admin Salestools");
		aJSClick(admin_menu_salestools_create_ecib, "create external EICB Queue");
	
		

		//product
		waitForElementPresent(Create_external_engineering_icb_product_DD, 300);
        actionsClick(Create_external_engineering_icb_product_DD,"Create_external_engineering_icb_product_DD");
    	waitForElementPresent(Create_external_engineering_icb_product_DD_type_insearch_product, 300);
        type(Create_external_engineering_icb_product_DD_type_insearch_product, "WH EdgeMarc 4552 - 30 Calls, quad T1", "product_Type_DD");
        type(Create_external_engineering_icb_product_DD_type_insearch_product, "", Keys.ENTER);
        //category
        Thread.sleep(15000);
    	scrollElementIntoView(Create_external_engineering_icb_category_DD);
        actionsClick(Create_external_engineering_icb_category_DD,"icb_category_DD");
        waitForElementPresent(Create_external_engineering_icb_category_DD_type_Search_category, 300);
        type(Create_external_engineering_icb_category_DD_type_Search_category, "WH EdgeMarc 4552 - 30 Calls, quad T1", "icb_category_DD");
        type(Create_external_engineering_icb_category_DD_type_Search_category, "", Keys.ENTER);
        waitForElementPresent(Create_external_engineering_icb_submit, 300);
		scrollElementIntoView(Create_external_engineering_icb_submit);
		JSClick(Create_external_engineering_icb_submit,"Create_external_engineering_icb_submit");
		//required filed
		Thread.sleep(6000);
		 waitForElementPresent(Create_external_engineering_icb_subject, 300);
		type(Create_external_engineering_icb_subject, subject, "Subject");
        String selectedText=getText(Create_external_engineering_icb_subject);
   	    waitForElementPresent(Create_external_engineering_icb_description, 300);
		type(Create_external_engineering_icb_description, description, "Description");
		Thread.sleep(9000);
		type(Create_external_engineering_icb_externalid, excustomerid, "external customer ID");
		type(Create_external_engineering_icb_external_quote_id, excustomerquoteid, "external quote id");
		type(Create_external_engineering_icb_external_case_id, excustomercaseid, "external case id");
	    waitForElementPresent(Create_external_engineering_icb_submit, 300);
		scrollElementIntoView(Create_external_engineering_icb_submit);
		JSClick(Create_external_engineering_icb_submit,"Create_external_engineering_icb_submit");
		Thread.sleep(600);
		 waitForElementPresent(Create_external_engineering_icb_verify, 300);
		verifyElementText(Create_external_engineering_icb_verify, "");
		
		logPass("Engineering ICB Request submitted without any issues");
		 waitForElementPresent(Queues_Menu, 300);
		actionsClick(Queues_Menu, "Queues");
		actionsClick(Queues_engineeringICB,"Engineering ICB");
		waitForElementPresentE(Queues_engineeringICB_searchBox, 200);
		type(Queues_engineeringICB_searchBox, subject, "Search Box");
		Thread.sleep(9000);
		Assert.assertTrue(verifyTextPresentInList(Queues_engineeringICB_table_subjects, subject));
		logPass("Engineering ICB created with subject '"+subject+"' has been present under Engineering ICB Queue");
		
		
		
	}
}
