package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_13_CreditReq_Zeus_EngageIP extends MediatorClass {
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tc_1_13_creditReq_Zeus_EngageIP(String zUserName, String zPassword) throws Throwable {
		// test Data
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		String requestor = "Priya" + getRandomString(2);
		String RequestedAmount = getRandomInt(3);
		String TicketNumber = getRandomInt(7);
		String billing_credit_request_creditIDFromTable_parametarised="xpath=//*[@id='credit-request-table']/tbody/tr[%s]/td[1]/a";

		logger = extent.startTest("1.13 Test ID : 17100 - Portal User_Bandwidth Monitoring_loading graph");
		logInfo("Currently Running on -- "+getCurrentUrl());
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		
		logInfo("Logged into Zeus successfully");
		String url=getCurrentUrl();
		type(searchTextBox, id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		actionsClick(CustomersTableCustomerName);

		actionsClick(customerHome_billing, "Billing-Menu");
		JSClick(billing_creditRequest, "Billing_CreditRequest");
		actionsClick(billing_crediRequest_addNew, "Add New");
		waitForElementPresent(billing_addCustomerCredit_form_requestedBy, 20);

		typeWithClear(billing_addCustomerCredit_form_requestedBy, requestor, "Requestor Name");
		typeWithClear(billing_addCustomerCredit_form_phoneNo, "7654565", "Requestor Phone Number");
		typeWithClear(billing_addCustomerCredit_form_email, "priya@yahoo.com", "Requestor email id");
		// Optional - may not be present for all the customers
		// selectDropDownByIndex(billing_addCustomerCredit_form_invoice_DD, 2);

		selectDropDownByVisibleText(billing_addCustomerCredit_form_creditType_DD, "Write Off - Equipment");

		typeWithClear(billing_addCustomerCredit_form_ticketNumber, TicketNumber, "Ticket Number");

		Thread.sleep(10000);
		// selectDropDownByValue(billing_addCustomerCredit_form_CreditReason_DD, "Write
		// Off Credit");
		selectDropDownByIndex(billing_addCustomerCredit_form_CreditReason_DD, 1);
		logInfo("Selected second option under CreditReason DropDown");
		selectDropDownByIndex(billing_addCustomerCredit_form_CreditTaxable_DD, 2);
		logInfo("Selected second option under CreditTaxable DropDown");

		typeWithClear(billing_addCustomerCredit_form_CreditNotes, "test", "Notes");
		typeWithClear(billing_addCustomerCredit_form_CreditAmount, RequestedAmount, "Requested Amount");

		actionsClick(billing_addCustomerCredit_form_save_Btn, "AddCustomerCredit_form_Save_Btn");

		verifyText(billing_addCustomerCredit_successMsg, "The Credit Request was successfully submitted for",
				"Success Message");
		// Edit

		JSClick(Queues_Menu,"Queues");
		actionsClick(Queues_Menu_Creditreq,"Queues-Creditreq");
		waitForElementPresent(Queues_Menu_Creditreq_cretdate, 20);
		type(Queues_Menu_Creditreq_cretdate, toDaysdate(), "Create date");

		actionsClick(rightTopMenu,"rightTopMenu(3 dots)");

		actionsClick(rightTopMenu_loginAs,"rightTopMenu_loginAs");
		selectDropDownByVisibleText(loginAs_User_DD, "Kevin Knoll");
		Thread.sleep(3000);
		logPass("Logged in as 'Kevin Knoll' successfully");
		type(searchTextBox, id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		actionsClick(CustomersTableCustomerName);
		actionsClick(customerHome_billing);
		JSClick(billing_creditRequest);
		System.out.println("Requested Amount "+RequestedAmount);
		waitForElementPresent(billing_credit_request_amountFromTable, 200);
		Thread.sleep(2000);
		String searchBox ="xpath=//input[@type='search']";
		type(searchBox, TicketNumber, "SearchBox");
		Thread.sleep(1000);
		String creditId=verifyTextInColumnGetOtherColumnText(billing_credit_request_ticketFromTable, billing_credit_request_creditIDFromTable_parametarised, TicketNumber).trim();
		System.out.println("creditId "+creditId);
		verifyTextInColumnClickOtherColumn(billing_credit_request_ticketFromTable, billing_credit_request_creditIdFromTable, TicketNumber);
		int no=Integer.parseInt(RequestedAmount);
		scrollElementIntoView(billing_addCustomerCredit_editForm_save_confirm);
		String approvedAmt=Integer.toString(no-1);
		String approvedAmt1=Integer.toString(no);
		if (no > 2) {
			typeWithClear(billing_addCustomerCredit_form_approvedAmount, Integer.toString(no - 1), "Approved Amount");
		}
		if (no == 1)
			typeWithClear(billing_addCustomerCredit_form_approvedAmount, Integer.toString(no), "Approved Amount");

		actionsClick(billing_addCustomerCredit_editForm_save_confirm,"editForm_save_confirm");

		waitForElementPresent(billing_addCustomerCredit_successMsg, 30);

		verifyText(billing_addCustomerCredit_successMsg, "was successfully", "Success Message");

		JSClick(Queues_Menu,"Queues_Menu");
		actionsClick(Queues_Menu_Creditreq,"Queues_Menu_Creditreq");

		waitForElementPresent(Queues_Menu_Creditreq_Showprocedd, 10);
		scrollElementIntoView(Queues_Menu_Creditreq_Showprocedd);
		JSClick(Queues_Menu_Creditreq_Showprocedd,"Queues_Menu_Creditreq_Showprocedd");

		Thread.sleep(3000);

		// waitForElementPresent(Queues_Menu_Creditreq_Showprocedd_search, 10);
		scrollElementIntoView(Queues_Menu_Creditreq_Showprocedd_search);
		typeWithClear(Queues_Menu_Creditreq_Showprocedd_search, TicketNumber, "searchBox");
		Thread.sleep(1000);
		//type(Queues_Menu_Creditreq_Showprocedd_search, "TicketNumber", Keys.ENTER);
		// verifyTextInColumnClickOtherColumn(billing_addCustomerCredit_form_approvedAmount,
		// billing_credit_request_creditIdFromTable, RequestedAmount);

		actionsClick(Queues_Menu_Creditreq_Showprocedd_creditclick,"Queues_Menu_Creditreq_Showprocedd_creditclick");
		// Edit credit ID to save
		waitForElementPresent(billing_addCustomerCredit_form_phoneNo, 20);
		scrollElementIntoView(billing_addCustomerCredit_form_phoneNo);
		typeWithClear(Credit_Invoice_Requster, id, "Requestor");

		typeWithClear(billing_addCustomerCredit_form_phoneNo, "7654565123", "Requestor Phone Number");
		actionsClick(Credit_Save,"Credit_Save");
		Thread.sleep(1000);
		if(verifyElementText(Credit_Invoice, "")) {			
			Thread.sleep(1000);
			actionsClick(Credit_Invoice);
			waitForElementPresentE(Credit_Invoice_Close, 5);
			actionsClick(Credit_Invoice_Close);
			Thread.sleep(1000);
			logPass("Able to open Invoice and close it successfully");
			
		}
		else
			logPass("Invoice not generated for ticket number "+TicketNumber);
		

		actionsClick(rightTopMenu,"rightTopMenu (3 dots)");

		actionsClick(rightTopMenu_logout,"logout");
		logPass("Logged out from 'Kevin Knoll' successfully and logged in as  Admin");
		// logged in as previous user
		Thread.sleep(2000);
		navigateTo("https://zeus.qa5.vonagenetworks.net/");
		typeWithClear(searchTextBox, id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);

		actionsClick(CustomersTableCustomerName,"CustomersTableCustomerName");
		click(customerHome_viewInMenu, "customerHome_viewInMenu");
		click(customerHome_viewInMenu_engage, "customerHome viewIn Menu engage");
		navigateToChild();
		Thread.sleep(5000);
		type(engageIp_username, " ZeusQA", "Engage Ip Username");
		type(engageIp_password, " t3$tp@sS0rd", "Engage Ip Password");

		click(engageIp_loginBtn, "login Button");

		// view in engage
		waitForElementToBeClickable(ViewInEngage_Transaction);
		click(ViewInEngage_Transaction, "Enagage IP -transaction Tab");

		navigateTo(url);
		Thread.sleep(3000);
		logOut();
		
	}

	private void Verify(String menu, String submenu, String textElement, String text) throws Throwable {
		click(customerHome_billing, "customerHome billing");
		actionsClick(menu);
		JSClick(submenu);
		waitForElementPresent(textElement, 200);
		verifyText(textElement, text, "Verifying HeadLine text");
	}

}
