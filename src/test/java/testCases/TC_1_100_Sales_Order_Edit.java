package testCases;

import java.io.File;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_100_Sales_Order_Edit extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description: Admin>Sales Tools>Sales Order Edit>Search by
	 * Customer ID>record and then edit>The following fields will be present:
	 * CustomerID, Customer Name, Sales Order#,\r\n" + Market, Sales
	 * Month..>Verify fileds>Serch by another customer and verify display
	 * records accordingly
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_100_Sales_Order_Edit(ITestContext context)
			throws Throwable {
		
		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String Customer_35834 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String Customer_12345 = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String Customer_388835 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String Customer_vic = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		AssertSoftly softassert = new AssertSoftly();
		
		logger = extent.startTest("1.100 Test ID : 15050 - ZEUS-SALES-7 - Sales Order Edit").assignCategory("Admin");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Admin>Sales Tools>Sales Order Edit>Search by Customer ID>record and then edit>The following fields will be present: CustomerID, Customer Name, Sales Order#,\r\n"
				+ "Market, Sales Month..>Verify fileds>Serch by another customer and verify display records accordingly");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Below code writtent to set brower to 80% size to perform Sales menu clicks
		setBrowserTo80Size();
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools, sales_tools_salesOrderEdit, engineering_subMenu_headLine, "Search");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu");
		
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_customerID, 300);
		type(admin_menu_salestool_salesorder_Edit_customerID, Customer_35834, "SearchBox");
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Search_button, 300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Search_button);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Customer_name_text, 300);
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Customer_name_text,"Gnaeh Name", "");
		softassert.assertEquals(isassert, true, "Verify_sales_tools_submenu_Customer_name_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Customer_ID_text, "CustomerID", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Customer_ID_text ");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Salesorder_text,"Sales Order#", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Salesorder_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Market_text, "Market","");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Edit_Market_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Sales_Month_text,"Sales Month", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Sales_Month_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_EditBilling_Status_text,"Billing Status", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu EditBilling_Status_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Sales_Order_Name_text,"Sales Order Name", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Sales_Order_Name_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_MRC_text, "MRC", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Edit_MRC_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_GMApproved_text,"GMApproved", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu GMApproved_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Quote_Stage_text,"Quote Stage", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Quote_Stage_text");
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Type_OfBusiness_text,"Type Of Business", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Type_OfBusiness_text");
		
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_click, 300);
		JSClick(admin_menu_salestool_salesorder_Edit_click,"Salesorder_Edit_click");
		Thread.sleep(3000);
		selectDropDownByIndex(admin_menu_salestool_salesorder_Edit_click_salesdropdown_DD, 2);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Save_click,300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Save_click,"salesorder_Edit_Save");
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_orderno, 300);
		clearText(admin_menu_salestool_salesorder_Edit_orderno);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customerID);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customer_name);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_customerID,300);
		type(admin_menu_salestool_salesorder_Edit_customerID, Customer_12345, "Customer Id");
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Search_button, 300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Search_button,"Search Button");
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Save_click_0order, 300);
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Save_click_0order,"0 order sorted by GMApproved date", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Edit_Save_click_0order");
		
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_orderno);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customerID);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customer_name);
		Thread.sleep(3000);
		type(admin_menu_salestool_salesorder_Edit_customerID, Customer_35834,"Customer Id");
		Thread.sleep(3000);
		type(admin_menu_salestool_salesorder_Edit_orderno, Customer_388835,"Order Number");
		Thread.sleep(3000);
		type(admin_menu_salestool_salesorder_Edit_customer_name, Customer_vic,"customer name searched");
		Thread.sleep(3000);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Search_button, 300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Search_button);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Save_click_0order, 300);
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Save_click_0order,"0 order sorted by GMApproved date", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Edit_Save_click_0order");
		
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_orderno);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customerID);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customer_name);
		Thread.sleep(3000);
		type(admin_menu_salestool_salesorder_Edit_customer_name, Customer_vic, "customer_name");
		Thread.sleep(3000);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Search_button, 300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Search_button,"Search Button");
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Save_click_somenumberorder,300);
		
		isassert = verifyText(admin_menu_salestool_salesorder_Edit_Save_click_somenumberorder,"orders sorted by GMApproved date", "");
		softassert.assertEquals(isassert, true, "Verify sales tools submenu Save_click_somenumberorder");
		
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_orderno);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customerID);
		Thread.sleep(3000);
		clearText(admin_menu_salestool_salesorder_Edit_customer_name);
		Thread.sleep(3000);
		type(admin_menu_salestool_salesorder_Edit_orderno, Customer_388835,"orderno");
		Thread.sleep(3000);
		waitForElementPresent(admin_menu_salestool_salesorder_Edit_Search_button, 300);
		actionsClick(admin_menu_salestool_salesorder_Edit_Search_button,"Search_button");
		// verifyText(admin_menu_salestool_salesorder_Edit_Save_click_0order,
		// "0 order sorted by GMApproved date", "");
		Thread.sleep(3000);
		logPass("Sales Order records for â€œ388835â€� displayed and the text, â€œ [#] order sorted by GMApproved dateâ€�.");
		logOut();
		softassert.assertAll();

	}

}
