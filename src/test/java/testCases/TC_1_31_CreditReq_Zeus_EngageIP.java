package testCases;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_31_CreditReq_Zeus_EngageIP  extends MediatorClass{

	String Queues_Menu= "id=notification-queues";
	String Queues_Menu_Creditreq="id=notification-credit-requests";
	String Queues_Menu_Creditreq_cretdate="id=query[CreatedDate]";
	String Queues_Menu_Creditreq_Showprocedd="xpath=//a[@class='small']";

	String Queues_Menu_Creditreq_Showprocedd_search="xpath=//input[@type='search']";
	String Queues_Menu_Creditreq_Showprocedd_creditclick="xpath=//td[@class='small text-center sorting_1']/a";

	String Credit_Save="xpath=(//button[@form='credit-request-save'])[2]";
	String Credit_Invoice ="xpath=//*[@id='credit-request-table']/tbody/tr[1]/td[5]/a";

	String Credit_Invoice_Close ="xpath=//div[@class='modal-header']/button";
	String Credit_Invoice_Requster="id=Requestor";
	String ViewInEngage_Transaction="id=Transactions_tab";
	
	String billing_credit_request_ticketFromTable="xpath=//*[@id='credit-request-table']/tbody/tr/td[4]";
	String billing_credit_request_creditIDFromTable_parametarised="xpath=//*[@id='credit-request-table']/tbody/tr[%s]/td[1]/a";

	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tc_1_31_CreditReq_Zeus_EngageIP(String zUserName, String zPassword) throws Throwable {
		//test Data
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);		
		 String requestor="Priya"+getRandomString(2);
		String RequestedAmount=getRandomInt(2);
		String TicketNumber =getRandomInt(6);
	        logger = extent.startTest("1.31 Test ID : 19906 - Premier Pay - 502_Make a credit Request from Zeus and confirm in Engage IP");
		logInfo("Currently Running on -- "+getCurrentUrl());
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		waitForElementPresent(searchTextBox, 300);
		String url=getCurrentUrl();
		type(searchTextBox, id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		if(verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, id); 
		}
		waitForElementPresent(CustomersTableCustomerName, 30);
		actionsClick(customerHome_billing);
		waitForElementPresent(billing_creditRequest, 300);
		JSClick(billing_creditRequest);
		waitForElementPresent(billing_crediRequest_addNew, 300);
		JSClick(billing_crediRequest_addNew);
		waitForElementPresent(billing_addCustomerCredit_form_requestedBy, 200);
		type(billing_addCustomerCredit_form_requestedBy, requestor, "Requestor Name");
		waitForElementPresent(billing_addCustomerCredit_form_phoneNo, 300);
		type(billing_addCustomerCredit_form_phoneNo, "7654565", "Requestor Phone Number");
		type(billing_addCustomerCredit_form_email, "priya@yahoo.com", "Requestor email id");
		//Optional - may not be present for all the customers
		// selectDropDownByIndex(billing_addCustomerCredit_form_invoice_DD, 2); 
		waitForElementPresent(billing_addCustomerCredit_form_creditType_DD, 30);
		selectDropDownByVisibleText(billing_addCustomerCredit_form_creditType_DD, "Credit Adjustment");
		type(billing_addCustomerCredit_form_ticketNumber, TicketNumber, "Ticket Number");
		Thread.sleep(3000);
		System.out.println("Ticket Number "+TicketNumber);
		// selectDropDownByValue(billing_addCustomerCredit_form_CreditReason_DD, "Write Off Credit");
		waitForElementPresent(billing_addCustomerCredit_form_CreditReason_DD, 30);
		
		selectDropDownByIndex(billing_addCustomerCredit_form_CreditReason_DD, 1);
		
		selectDropDownByIndex(billing_addCustomerCredit_form_CreditTaxable_DD, 2);
		type(billing_addCustomerCredit_form_CreditNotes, "test", "Notes");
		type(billing_addCustomerCredit_form_CreditAmount, RequestedAmount, "Requested Amount");
		actionsClick(billing_addCustomerCredit_form_save_Btn);
		logPass("Requested Amount is "+RequestedAmount);
		verifyText(billing_addCustomerCredit_successMsg, "The Credit Request was successfully submitted for", "Success Message");
		//Edit
		JSClick(Queues_Menu);
		actionsClick(Queues_Menu_Creditreq);
		waitForElementPresent(Queues_Menu_Creditreq_cretdate, 20);
		//enterDate(Queues_Menu_Creditreq_cretdate, dateAftersomeDays(0, "dd"), dateAftersomeDays(0, "MM"), dateAftersomeDays(0, "yyyy"));
		// type(Queues_Menu_Creditreq_cretdate, toDaysdate(), "Create date");
		actionsClick(rightTopMenu);
		actionsClick(rightTopMenu_loginAs);
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
		
		if(no>2) {
			type(billing_addCustomerCredit_form_approvedAmount, approvedAmt, "Approved Amount");
		}
		if(no==1)
			type(billing_addCustomerCredit_form_approvedAmount, approvedAmt1, "Approved Amount");
		actionsClick(billing_addCustomerCredit_editForm_save_confirm);
		logPass("Approved Amount is "+approvedAmt);
		waitForElementPresent(billing_addCustomerCredit_successMsg, 30);
		verifyText(billing_addCustomerCredit_successMsg, "was successfully", "Success Message");
		JSClick(Queues_Menu);
		actionsClick(Queues_Menu_Creditreq);
		waitForElementPresent(Queues_Menu_Creditreq_Showprocedd, 10);
		scrollElementIntoView(Queues_Menu_Creditreq_Showprocedd);
		JSClick(Queues_Menu_Creditreq_Showprocedd);
		Thread.sleep(7000);		
		type(Queues_Menu_Creditreq_Showprocedd_search,TicketNumber,"SearchBox");
				
		Thread.sleep(2000);
		/*//Edit credit ID to save
		actionsClick(Queues_Menu_Creditreq_Showprocedd_creditclick,"Credit Id");
		Thread.sleep(3000);			
		scrollElementIntoView(billing_addCustomerCredit_form_phoneNo);     
		type(Credit_Invoice_Requster, id, "Requestor ");
		type(billing_addCustomerCredit_form_phoneNo, "7654565123", "Requestor Phone Number");
		actionsClick(Credit_Save);*/
		
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
		
		actionsClick(rightTopMenu);
		JSClick(rightTopMenu_logout);
		logPass("Logged out from 'Kevin Knoll' successfully and logged in as  Admin");
		
		Thread.sleep(2000);
		navigateTo("https://zeus.qa5.vonagenetworks.net/");
		waitForElementPresent(searchTextBox, 15);
		type(searchTextBox, id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		if(verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, id); 
		}
		waitForElementPresent(CustomersTableCustomerName, 30);
		actionsClick(customerHome_billing);
		JSClick(billing_creditRequest);
		
		String queues_creditRequest_showProcessed="xpath=//*[@id='credit-request-table']/caption/a[1]";
		String queues_creditRequest_approvedAmount="xpath=//*[@id='credit-request-table']/tbody/tr/td[12]/span";
		actionsClick(queues_creditRequest_showProcessed, "'Show Processed'");
		Thread.sleep(5000);
		waitForElementPresentE(Queues_Menu_Creditreq_Showprocedd_search, 20);
		type(Queues_Menu_Creditreq_Showprocedd_search, TicketNumber, "Search Box");
		verifyText(queues_creditRequest_approvedAmount, approvedAmt, "");
		
		logPass("Approved Amount has been verified i.e., "+approvedAmt+" for ticket Number - "+TicketNumber+" with credit Id - "+creditId );
		
		
		click(customerHome_viewInMenu, "customerHome_viewInMenu");
		click(customerHome_viewInMenu_engage, "customerHome viewIn Menu engage");
		navigateToChild();
		Thread.sleep(5000);
		type(engageIp_username, " ZeusQA", "Engage Ip Username");
		type(engageIp_password, " t3$tp@sS0rd", "Engage Ip Password");

		click(engageIp_loginBtn, "login Button");

		//view in engage
		waitForElementToBeClickable(ViewInEngage_Transaction);
		click(ViewInEngage_Transaction, "Enagage IP -transaction Tab");
        
		navigateTo(url);
		Thread.sleep(3000);
		logOut();
		

	}
	
	
	 public static String getRandomInt(int length) {
	        final String characters = "123456789";
	        StringBuilder result = new StringBuilder();
	        while(length > 0) {
	            Random rand = new Random();
	            result.append(characters.charAt(rand.nextInt(characters.length())));
	            length--;
	        }
	        return result.toString();
	     }

}
