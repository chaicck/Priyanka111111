package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_84_Admin_SalesTool_EnganeeringICB  extends MediatorClass{
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:In CDRConfig Page Verify On/Off Buttons And Add
	 * Link_Manage_SFTP_Credentials Account
	 */
	
	 @Test(alwaysRun=true,enabled=true)
	 public void tc_1_84_salesTool_EnganeeringICB(ITestContext context) throws Throwable {
	
		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String searchProductTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String text1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String text2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String subject =text1+randomString(5);
		String description=text2+randomString(5);
		String excustomerid =randomNum(4);	
		String excustomerquoteid =randomNum(4);
		String excustomercaseid =randomNum(4);
		String selectedText= null;

		// * logger method for report starting from here
		logger = extent.startTest("1.84 Test ID : 15750 - ZEUS-ADMIN-48_Admin_Sales Tools Engineering ICB").assignCategory("Admin");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Hover on Sales Tools and select Create External EICB Quote and submit the Engineering ICB");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);

		setBrowserTo80Size();
		setBrowserToSize(70);
		waitForElementPresent(admin_menu, 300);
		click(admin_menu, "Admin");
		click(admin_menu_salestools, "Admin Salestools");
		aJSClick(admin_menu_salestools_create_ecib, "create external EICB Queue");
	
		// * Below code is to perform product
		waitForElementPresent(Create_external_engineering_icb_product_DD, 300);
        actionsClick(Create_external_engineering_icb_product_DD,"Create_external_engineering_icb_product_DD");
    	waitForElementPresent(Create_external_engineering_icb_product_DD_type_insearch_product, 300);
        type(Create_external_engineering_icb_product_DD_type_insearch_product, searchProductTxt, "product_Type_DD");
        type(Create_external_engineering_icb_product_DD_type_insearch_product, "", Keys.ENTER);
        // * Below code is to perform category
        Thread.sleep(15000);
    	scrollElementIntoView(Create_external_engineering_icb_category_DD);
        actionsClick(Create_external_engineering_icb_category_DD,"icb_category_DD");
        waitForElementPresent(Create_external_engineering_icb_category_DD_type_Search_category, 300);
        type(Create_external_engineering_icb_category_DD_type_Search_category, searchProductTxt, "icb_category_DD");
        type(Create_external_engineering_icb_category_DD_type_Search_category, "", Keys.ENTER);
        waitForElementPresent(Create_external_engineering_icb_submit, 300);
		scrollElementIntoView(Create_external_engineering_icb_submit);
		JSClick(Create_external_engineering_icb_submit,"Create_external_engineering_icb_submit");
		// * Below code is to perform required filed
		Thread.sleep(6000);
		 waitForElementPresent(Create_external_engineering_icb_subject, 300);
		type(Create_external_engineering_icb_subject, subject, "Subject");
        selectedText=getText(Create_external_engineering_icb_subject);
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
		isassert = verifyElementText(Create_external_engineering_icb_verify, "");
		softassert.assertEquals(isassert, true);
		
		logPass("Engineering ICB Request submitted without any issues");
		waitForElementPresent(Queues_Menu, 300);
		actionsClick(Queues_Menu, "Queues");
		actionsClick(Queues_engineeringICB,"Engineering ICB");
		waitForElementPresentE(Queues_engineeringICB_searchBox, 200);
		type(Queues_engineeringICB_searchBox, subject, "Search Box");
		Thread.sleep(9000);
		softassert.assertTrue(verifyTextPresentInList(Queues_engineeringICB_table_subjects, subject));
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
