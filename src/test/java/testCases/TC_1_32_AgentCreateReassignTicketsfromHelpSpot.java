package testCases;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_32_AgentCreateReassignTicketsfromHelpSpot extends MediatorClass {
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tc_1_32_AgentCreateReassignTicketsfromHelpSpot(String zUserName, String zPassword) throws Throwable {
		
		String customer_dashboard_contacts_ticketIds_parameterised="xpath=//*[@id='ticket_table']/tbody/tr[%s]/td[2]";
		
		String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1); //34596
		
		logger = extent.startTest("1.32 Test ID : 19784 - Premier Svc - 601_Agent create, reassigns tickets from HelpSpot and more...").assignCategory("Ticket");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:TestCase Description:Create a Ticket from HelpSpot and verify ticket under the Ticket Menu with group name");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");

		String email = "priyaka" + randomString(2) + "@live.com";
		String first_Name = "priyaka " + randomString(3);
		Thread.sleep(5000);
		waitForElementPresent(customer_dashboard_contacts_addTicket, 300);
		scrollElementIntoView(customer_dashboard_contacts_addTicket);
		JSClick(customer_dashboard_contacts_addTicket,"Contacts - AddTicket");

		switchToFrame(contacts_addTicket_loginPageFrame);
		waitForElementPresent(contacts_addTicket_loginPage_userName, 300);
		type(contacts_addTicket_loginPage_userName, "Zeus_QA@vonage.com", "contacts_addTicket_loginPage_userName");
		type(contacts_addTicket_loginPage_password, "pAs$w0rd%t3st", "contacts_addTicket_loginPage_password");
		scrollElementIntoView(contacts_addTicket_loginPage_signIn);
		waitForElementPresent(contacts_addTicket_loginPage_signIn, 300);
		JSClick(contacts_addTicket_loginPage_signIn,"addTicket - SignIn Button");
		waitForElementPresent(vonageBusiness_firstname, 300);
		type(vonageBusiness_firstname, first_Name, "vonageBusiness_firstname");
		type(vonageBusiness_lastname, "Automation", "vonageBusiness_lastname");
		selectDropDownByIndex(vonageBusiness_connectedVia, 2);
		logInfo("Selected 3rd option under connectedVia DropDown");
		type(vonageBusiness_Email, email, "vonageBusiness_Email");
		selectDropDownByVisibleText(vonageBusiness_Category, "Call Center");
		logInfo("Selected 'Call Center' option under Category DropDown");
		selectDropDownByIndex(vonageBusiness_CasePriority, 2);
		logInfo("Selected 3rd option under 'CasePriority' DropDown");
		type(vonageBusiness_ticketSummary, "test", "ticketSummary");
		scrollElementIntoView(vonageBusiness_groupAssignment);
		selectDropDownByIndex(vonageBusiness_groupAssignment, 2);
		String groupAssignment_DD_value=getDropdownSelectedValue(vonageBusiness_groupAssignment);
		logInfo("Selected "+groupAssignment_DD_value+" option under 'groupAssignment' DropDown");

		switchToFrame(contacts_addTicket_noteFrameinternal);
		waitForElementPresent(contacts_addTicket_notes, 300);
		type(contacts_addTicket_notes, "test", "addTicket_notes");
		switchToDefaultFrame();

		switchToFrame(contacts_addTicket_loginPageFrame);
		Thread.sleep(5000);
		scrollElementIntoView(vonageBusiness_createRequest);
		JSClick(vonageBusiness_createRequest,"Create Request");
		Thread.sleep(5000);

		if (verifyElementText(vonageBusiness_alertAccept, "")) {
			actionsClick(vonageBusiness_alertAccept);
		}

		switchToDefaultFrame();
		waitForElementPresent(srchDd, 300);
		click(srchDd, "Search");

		click(customerLnk, "Customer link");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);

		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");		
		Thread.sleep(300);
		scrollElementIntoView(customer_dashboard_contacts_addTicket);
		Assert.assertTrue(verifyTextPresentInList(openTickets_contactList, first_Name));
		String TicketId=verifyTextInColumnGetOtherColumnText(openTickets_contactList, customer_dashboard_contacts_ticketIds_parameterised, first_Name).trim();
		
		// verifying in Tickets Menu
		String tickets_search="xpath=//input[@type='search']";
		String tickets_group_Billing="xpath=//a[@href='/ticket/queues/?queue_name=Group%20-%20Billing']";
		String ticketsMenu_ticketIds="xpath=//*[@id='ticket_table']/tbody/tr/td[1]/a";
		String tickets_group_AdvancedTechnical="xpath=//a[@href='/ticket/queues/?queue_name=Group%20-%20Advanced%20Technical']";
		
        waitForElementPresent(ticketsMenu, 300);
		JSClick(ticketsMenu,"Tickets-Menu");
        waitForElementPresent(tickets_groupsMenu, 300);
        scrollElementIntoView(tickets_group_Billing);
        JSClick(tickets_group_Billing,"Tickets-Group Billing");
        waitForElementPresent(tickets_search, 300);
        type(tickets_search, TicketId, "searchBox");
        
        Assert.assertTrue(verifyTextPresentInList(ticketsMenu_ticketIds, TicketId));
        logPass("created ticket "+ TicketId+" Present under Group Billing");
        
        logInfo("changing created ticket's ("+ TicketId+") Automation-Group Assignment");
        
        waitForElementPresent(srchDd, 300);
        click(srchDd, "Search");
		click(customerLnk, "Customer link");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);

		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");
		scrollElementIntoView(customer_dashboard_contacts_addTicket);
        waitForElementPresent(openTickets_contactList, 300);
        verifyTextInColumnClickOtherColumn(openTickets_contactList, ticketMagnifierList, first_Name);
        Thread.sleep(1500);
		switchToFrame(contacts_addTicket_loginPageFrame);
		//String first_Name_edited = first_Name + randomString(2);
		//clearText(vonageBusiness_firstname);
		//type(vonageBusiness_firstname, first_Name_edited, "");
		scrollElementIntoView(vonageBusiness_groupAssignment);
		selectDropDownByIndex(vonageBusiness_groupAssignment, 1);
		String groupAssignment_DD_value1=getDropdownSelectedValue(vonageBusiness_groupAssignment);
		logInfo("Selected "+groupAssignment_DD_value1+" option under 'groupAssignment' DropDown");
		
		scrollElementIntoView(vonageBusiness_updateRequest);
        waitForElementPresent(vonageBusiness_updateRequest, 300);
		JSClick(vonageBusiness_updateRequest,"Update Request");
		scrollElementIntoView(vonageBusiness_editSave_successMsg);
		verifyText(vonageBusiness_editSave_successMsg, "Request updated", "");

		scrollElementIntoView(vonageBusiness_updateRequest);
		  waitForElementPresent(vonageBusiness_updateRequest, 300);
		JSClick(vonageBusiness_updateRequest,"Upadet&Request");

		switchToDefaultFrame();
		
		//Verifying tickets Menu
		 waitForElementPresent(ticketsMenu, 300);
		JSClick(ticketsMenu,"Tickets-Menu");
        waitForElementPresent(tickets_groupsMenu, 20);
        scrollElementIntoView(tickets_group_AdvancedTechnical);
        waitForElementPresent(ticketsMenu, 300);
        JSClick(tickets_group_AdvancedTechnical,"Tickets-Group Advanced Technical");
        Thread.sleep(10000);
        waitForElementPresent(tickets_search, 300);
        clearText(tickets_search);
        type(tickets_search, TicketId, "searchBox");
        
        Assert.assertTrue(verifyTextPresentInList(ticketsMenu_ticketIds, TicketId));
        logPass("created ticket "+ TicketId+" Present under Group AdvancedTechnical");
        logOut();
	}
}
