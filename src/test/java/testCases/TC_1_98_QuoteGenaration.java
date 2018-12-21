package testCases;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.MediatorClass;

public class TC_1_98_QuoteGenaration extends MediatorClass {
	/**
	 * @author ${TC_1_98_QuoteGenaration}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */

	/**
	 * TestCase Description:Admin Sales Tools Circuit Quote by Customer,Verify
	 * the Quotes with differetn customerID
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_98_QuoteGenaration(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx

		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 7), 1);
		String quote_term = getTestData(this.getClass().getSimpleName().substring(0, 7), 2);
		String success_status = getTestData(this.getClass().getSimpleName().substring(0, 7), 3);
		String subMenu_headLine = getTestData(this.getClass().getSimpleName().substring(0, 7), 4);
		String quoteId_DD = getTestData(this.getClass().getSimpleName().substring(0, 7), 5);
		String url_Qa5 = getTestData(this.getClass().getSimpleName().substring(0, 7), 6);
		String url_Qa6 = getTestData(this.getClass().getSimpleName().substring(0, 7), 7);
		String url_mst = getTestData(this.getClass().getSimpleName().substring(0, 7), 8);

		// * Below lines written initialize extent report

		logger = extent.startTest("Circuit Quote by Customer").assignCategory("Admin");
		logInfo("Currently Running on -- " + getCurrentUrl());
		System.out.println("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Admin Sales Tools Circuit Quote by Customer,Verify the Quotes with  differetn customerID");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		// * verifies expected text and its corresponding HTML tag are present on the page.
		isassert = verifySubMenuHeadLine(adminLInk, sales_tools, sales_tools_circuitQuoteByCustomers,engineering_subMenu_headLine, subMenu_headLine);
		softassert.assertEquals(true, isassert, "Verified customer id "+ subMenu_headLine + " in customer table");
		
		waitForElementPresent(admin_salesTools_cicuit_quote_customerId, 200);
		clearText(admin_salesTools_cicuit_quote_customerId);
		type(admin_salesTools_cicuit_quote_customerId, customer_id, "");
		actionsClick(admin_salesTools_cicuit_quote_OutSideClick);
		Thread.sleep(1000);
		selectDropDownByVisibleText(admin_salesTools_cicuit_quote_term,quote_term);
		actionsClick(admin_salesTools_cicuit_quote_submit);
		waitForElementPresent(admin_salesTools_cicuit_quote_submit_success_status, 20);
		
		// * verifies expected text and its corresponding HTML tag are present on the page
		isassert = verifyText(admin_salesTools_cicuit_quote_submit_success_status,success_status, "");
		softassert.assertEquals(true, isassert, "Verified success message "+ success_status);
		
		checkAll(admin_salesTools_cicuit_quote_checkBoxes);
		scrollElementIntoView(admin_salesTools_cicuit_quote_addBtn);
		String selectedQuote = selectedOptionDroDown(admin_salesTools_cicuit_quote_selectedQuoteId_DD);

		waitForElementPresent(admin_salesTools_cicuit_quote_addBtn, 300);
		JSClick(admin_salesTools_cicuit_quote_addBtn);
		waitForElementPresent(sugar_username, 300);
		if (getCurrentUrl().contains("qa5")) {
			type(sugar_username, zUserName, "view In sugar Username");
			type(sugar_password, zPassword, "view In sugar Password");
		} else if (getCurrentUrl().contains("qa6"))
		{ 
		// * change qa6 url & credentials
			type(sugar_username, zUserName, "view In sugar Username");
			type(sugar_password, zPassword, "view In sugar Password");
		} else { 
		// * change preDev credentials
			type(sugar_username, zUserName, "view In sugar Username");
			type(sugar_password, zPassword, "view In sugar Password");
		}

		click(sugar_loginBtn, "login Button");
		waitForElementPresent(sugar_comapniesMenu, 200);

		// * write logic to compare
		System.out.println("selected quote order1 " + selectedQuote);
		waitForElementPresent(sugar_salesOrder, 300);
		System.out.println("sugar salesOrder1 " + getText(sugar_salesOrder));

		String url = null;
		if (getCurrentUrl().contains("qa5")) {
			url = url_Qa5;
		} else if (getCurrentUrl().contains("qa6")) {
			url = url_Qa6;
		} else {
			url = url_mst;
		}
		navigateTo(url);

		waitForElementPresent(adminLInk, 300);

		// * below method written to verifies sub menu head line

		isassert = verifySubMenuHeadLine(adminLInk, sales_tools, sales_tools_circuitQuoteByCustomers,engineering_subMenu_headLine, subMenu_headLine);
		softassert.assertEquals(true, isassert);
		
		waitForElementPresent(admin_salesTools_cicuit_quote_customerId, 20);
		clearText(admin_salesTools_cicuit_quote_customerId);
		type(admin_salesTools_cicuit_quote_customerId, customer_id,"Circuit quote customerID textfield");
		waitForElementPresent(admin_salesTools_cicuit_quote_OutSideClick, 300);
		actionsClick(admin_salesTools_cicuit_quote_OutSideClick);
		Thread.sleep(1000);

		waitForElementPresent(admin_salesTools_cicuit_quote_submit, 300);
		JSClick(admin_salesTools_cicuit_quote_submit);
		waitForElementPresent(admin_salesTools_cicuit_quote_submit_success_status, 200);
		
		// * verifies expected text and its corresponding HTML tag are present on the page.
		isassert = verifyText(admin_salesTools_cicuit_quote_submit_success_status,success_status, "");
		softassert.assertEquals(true, isassert);	
		
		waitForElementPresent(admin_salesTools_cicuit_quote_checkBoxes, 300);
		actionsClick(admin_salesTools_cicuit_quote_checkBoxes);
		// * checkAll(admin_salesTools_cicuit_quote_checkBoxes);
		scrollElementIntoView(admin_salesTools_cicuit_quote_addBtn);

		selectDropDownByVisibleText(admin_salesTools_cicuit_quote_selectedQuoteId_DD, quoteId_DD);
		String selectedQuote2 = selectedOptionDroDown(admin_salesTools_cicuit_quote_selectedQuoteId_DD);
		waitForElementPresent(admin_salesTools_cicuit_quote_addBtn, 300);
		JSClick(admin_salesTools_cicuit_quote_addBtn);

		waitForElementPresent(sugar_comapniesMenu, 20);
		System.out.println("selected quote order2 " + selectedQuote2);
		String sugar_salesOrder2 = getText(sugar_salesOrder);
		System.out.println("sugar salesOrder2 " + sugar_salesOrder2);
		// * Below method written to logout application
		logOutt();
		softassert.assertAll();

	}

}
