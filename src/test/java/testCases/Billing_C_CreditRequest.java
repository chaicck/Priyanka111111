package testCases;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.MediatorClass;

public class Billing_C_CreditRequest extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_C_CreditRequest}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */
	
	/** TestCase Description::Add credit request and approve amount */
	
	@Test(alwaysRun = true, enabled = true)
	public void billing_CreditRequest(ITestContext context) throws Throwable {
		

		// * Below variables written to get input data from excel sheet-Testdata.xlsx	
		boolean istextPresent;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String id = getTestData(this.getClass().getSimpleName().substring(0, 9), 1);
		String requestor = getTestData(this.getClass().getSimpleName().substring(0, 9), 2) + getRandomString(2);
		String customers = getTestData(this.getClass().getSimpleName().substring(0, 9), 3);
		String customer = getTestData(this.getClass().getSimpleName().substring(0, 9), 4);
		String phoneNumber = getTestData(this.getClass().getSimpleName().substring(0, 9), 5);
		String emailID = getTestData(this.getClass().getSimpleName().substring(0, 9), 6);
		String creditType_DD = getTestData(this.getClass().getSimpleName().substring(0, 9), 7);
		String creditReason_DD = getTestData(this.getClass().getSimpleName().substring(0, 9), 8);
		String creditTaxable_DD = getTestData(this.getClass().getSimpleName().substring(0, 9), 9);
		String creditNotes = getTestData(this.getClass().getSimpleName().substring(0, 9), 10);
		String creditAmount = getTestData(this.getClass().getSimpleName().substring(0, 9), 11);
		String successMsg = getTestData(this.getClass().getSimpleName().substring(0, 9), 12);
		String user_DD = getTestData(this.getClass().getSimpleName().substring(0, 9), 13);
		String approvedAmount = getTestData(this.getClass().getSimpleName().substring(0, 9), 14);
		String successMsg1 = getTestData(this.getClass().getSimpleName().substring(0, 9), 15);
		AssertSoftly softassert = new AssertSoftly();
		String TicketNumber = null;
		
		logger = extent.startTest("Billing_CreditRequest").assignCategory("Billing", "Regression test");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description::Add credit request and approve amount");
		// * Below Code written to verify login
		login(zUserName, zPassword);
		// * Search customer id
		type(searchTextBox, id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		actionsClick(customerHome_billing, "Billing");
		JSClick(billing_creditRequest, "Credit Request");
		Thread.sleep(5000);
		JSClick(billing_crediRequest_addNew,"Add New Credit");
		Thread.sleep(5000);
		// * Fill required fields
		type(billing_addCustomerCredit_form_requestedBy, requestor, "Requested By (Customer)");
		type(billing_addCustomerCredit_form_phoneNo, phoneNumber, "Requestor Phone");
		type(billing_addCustomerCredit_form_email, emailID, "Requestor Email");
		selectDropDownByVisibleText(billing_addCustomerCredit_form_creditType_DD, creditType_DD);
		TicketNumber = getRandomInt(5);
		type(billing_addCustomerCredit_form_ticketNumber, TicketNumber, "Ticket #");
		Thread.sleep(2000);
		System.out.println("Ticket Number " + TicketNumber);
		selectDropDownByVisibleText(billing_addCustomerCredit_form_CreditReason_DD, creditReason_DD);
		selectDropDownByVisibleText(billing_addCustomerCredit_form_CreditTaxable_DD, creditTaxable_DD);
		type(billing_addCustomerCredit_form_CreditNotes, creditNotes, "Notes");
		type(billing_addCustomerCredit_form_CreditAmount, creditAmount, "Amount Requested");
		// * Save credit request
		actionsClick(billing_addCustomerCredit_form_save_Btn,"Save Customer credit");
		logPass("Requested Amount is " + creditAmount);
		// * Verify success message
		istextPresent = verifyText(billing_addCustomerCredit_successMsg, successMsg, "Success message text validation");
		softassert.assertEquals(istextPresent, true);
		
		System.out.println("Requested Amount is " + creditAmount);
		Thread.sleep(5000);
		// * Login as kevinknoll
		actionsClick(rightTopMenu);
		actionsClick(rightTopMenu_loginAs, "login AS");
		selectDropDownByVisibleText(loginAs_User_DD, user_DD);
		Thread.sleep(3000);
		logPass("Logged in as +" + user_DD + " successfully");
		System.out.println("Logged in as +" + user_DD + " successfully");
		// * Search for Customer id to which credit was created before
		type(searchTextBox, id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		Thread.sleep(1000);
		actionsClick(customerHome_billing, "Billing");
		JSClick(billing_creditRequest, "Credit Request");
		Thread.sleep(1000);
		// * Search with ticket number and approve amount
		type(Queues_Menu_Creditreq_Showprocedd_search, TicketNumber, "Search for credit with ticket number");
		Thread.sleep(1000);
		// * Verify ticket number is there in ticket table or not
		istextPresent = verifyTextInColumnClickOtherColumn(billing_credit_request_ticketFromTable,
				billing_credit_request_creditIdFromTable, TicketNumber);

		softassert.assertEquals(true, istextPresent, "Verified Customer id present in the cutomer table"); 
		waitForElementPresent(Credit_Invoice_Close, 30);
		actionsClick(Credit_Invoice_Close);
		clearText(Queues_Menu_Creditreq_Showprocedd_search);
		Thread.sleep(2000);
		waitForElementPresent(billing_credit_request_amountFromTable, 30);
		actionsClick(Queues_Menu_Creditreq_Showprocedd_creditclick, "Credit Id");
	
		Thread.sleep(3000);
		scrollElementIntoView(billing_addCustomerCredit_editForm_save_confirm);
		type(billing_addCustomerCredit_form_approvedAmount, approvedAmount, " Amount Approved");
		actionsClick(billing_addCustomerCredit_editForm_save_confirm,"Save Customer Credit");
		logPass("Approved Amount is " + "21");
		waitForElementPresent(billing_addCustomerCredit_successMsg, 30);
		// * Amount was approved and verify success message
		istextPresent = verifyText(billing_addCustomerCredit_successMsg, "Success: The Credit Request", "Success: The Credit Request was successfully submitted");
		softassert.assertEquals(true, istextPresent, "Verified the Credit Request was successfully submitted"); 
		// * Below method written to logout application
	
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	
	}

}
