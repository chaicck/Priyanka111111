package testCases;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Ticket extends MediatorClass{
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	    public void ticket(String zUserName, String zPassword) throws Throwable {	 
		 
			 //String customer_id="34596";
		        String customer_id="900488";
			
				logger = extent.startTest("Ticket").assignCategory("Ticket");
				logInfo("Currently Running on -- "+getCurrentUrl());
		    logInfo("TestCase Description:Customer DashBoard then Add Ticket from HelpSpot and verify ");
				type(userNameTxt, zUserName, "User name");
				type(passTxt, zPassword, "Password");
				click(submitBtn, "Submit button");
				waitForElementPresent(searchTextBox, 300);
				type(searchTextBox, customer_id, "Search Box");
				type(searchTextBox,"search box",Keys.ENTER);
				Thread.sleep(3000);
				if (verifyElementText(customerTableHeadline, "Customers")) {
					verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
				}
				waitForElementPresent(customer_dashboard_name, 300);
				verifyText(customer_dashboard_name, "Customer:", "Customer Name");  
			
				String customer_dashboard_contacts_addTicket="xpath=//a[starts-with(@href,'/ticket/add/customer_id')]";
				String contacts_addTicket_loginPageFrame="id=helpspot";
				String contacts_addTicket_loginPage_userName="id=username";
				String contacts_addTicket_loginPage_password="id=password";
				String contacts_addTicket_loginPage_signIn="xpath=//button[text()='Sign In']";
				 String vonageBusiness_firstname = "id=sFirstName";
				 String vonageBusiness_lastname="id=sLastName";
				 String vonageBusiness_Category="id=xCategory";
				 String vonageBusiness_Email="id=sEmail";
				 String vonageBusiness_connectedVia="id=fOpenedVia";
				 String contacts_addTicket_noteFrameinternal="className=ephox-hare-content-iframe";
				 String contacts_addTicket_notes="xpath=//body[@class='ephox-candy-mountain ephox-candy-mountain-active']";
				 
				 String vonageBusiness_CasePriority="id=Custom1";
				 String vonageBusiness_ticketSummary="id=Custom27";
				 String vonageBusiness_groupAssignment="id=Custom26"; 
				 String vonageBusiness_createRequest="id=sub_create";
				 
				 String vonageBusiness_alertAccept="xpath=//button[@id='alert-button-ok']";
				 
				 String openTickets_contactList= "xpath=//*[@id='ticket_table']/tbody/tr/td[7]";
				 
				String email="priyaka"+randomString(2)+"@live.com";
				String first_Name="priyaka "+randomString(3);
				waitForElementPresent(customer_dashboard_contacts_addTicket, 300);
				scrollElementIntoView(customer_dashboard_contacts_addTicket);
				waitForElementPresent(customer_dashboard_contacts_addTicket, 300);
				JSClick(customer_dashboard_contacts_addTicket);
				
				switchToFrame(contacts_addTicket_loginPageFrame);
				waitForElementPresent(contacts_addTicket_loginPage_userName, 300);
				type(contacts_addTicket_loginPage_userName, "Zeus_QA@vonage.com", "");
				type(contacts_addTicket_loginPage_password, "pAs$w0rd%t3st", "");
				actionsClick(contacts_addTicket_loginPage_signIn);
				waitForElementPresent(vonageBusiness_firstname, 300);
				type(vonageBusiness_firstname, first_Name, "");
				type(vonageBusiness_lastname, "test", "");
				selectDropDownByIndex(vonageBusiness_connectedVia, 2);
				type(vonageBusiness_Email, email, "");
				selectDropDownByVisibleText(vonageBusiness_Category, "Call Center");
				Thread.sleep(4000);
				selectDropDownByIndex(vonageBusiness_CasePriority, 2);
				type(vonageBusiness_ticketSummary, "test", "");
				scrollElementIntoView(vonageBusiness_groupAssignment);
				selectDropDownByIndex(vonageBusiness_groupAssignment, 2);
				waitForElementPresent(contacts_addTicket_noteFrameinternal, 300);
				switchToFrame(contacts_addTicket_noteFrameinternal);
				type(contacts_addTicket_notes, "test", "");
				switchToDefaultFrame();
				Thread.sleep(4000);
				switchToFrame(contacts_addTicket_loginPageFrame);
				waitForElementPresent(vonageBusiness_createRequest, 300);
				scrollElementIntoView(vonageBusiness_createRequest);
				JSClick(vonageBusiness_createRequest);
				Thread.sleep(5000);
				
				if(verifyElementText(vonageBusiness_alertAccept, "")) {
					actionsClick(vonageBusiness_alertAccept);
				}
				
				switchToDefaultFrame();
				waitForElementPresent(srchDd, 300);
				 click(srchDd,"Search");
			        
			        click(customerLnk,"Customer link");  
			    	waitForElementPresent(srchTxt, 300);
			        type(srchTxt, customer_id,"Search box");
			        type(srchTxt,"Search box",Keys.ENTER);        
				
			        if(verifyElementText(customerTableHeadline, "Customers")) {
						verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
					}
					verifyText(customer_dashboard_name, "Customer:", "Customer Name");
					waitForElementPresent(customer_dashboard_contacts_addTicket, 300);
					scrollElementIntoView(customer_dashboard_contacts_addTicket);				
				Assert.assertTrue(verifyTextPresentInList(openTickets_contactList, first_Name));
				logPass("Created Ticket has been verified under tickets");
				
				
				//a[starts-with(@href,'/ticket/listByCustomer/filter')]
				
				// editing ticket
				
				String ticketMagnifierList="xpath=//*[@id='ticket_table']/tbody/tr/td[%s]";
				//openTickets_contactList
			    Thread.sleep(6000);
				verifyTextInColumnClickOtherColumn(openTickets_contactList, ticketMagnifierList, first_Name);
				
				
				switchToFrame(contacts_addTicket_loginPageFrame);
				
				String vonageBusiness_editSave_successMsg="xpath=//*[@id='hdfeedbackbox']/tbody";
				String vonageBusiness_updateRequest="id=sub_update";
				String vonageBusiness_updateClose="id=sub_updatenclose";
				
				
				String first_Name_edited=first_Name+randomString(2);
				waitForElementPresent(vonageBusiness_firstname, 300);
				clearText(vonageBusiness_firstname);
				type(vonageBusiness_firstname, first_Name_edited, "");
				waitForElementPresent(vonageBusiness_updateRequest, 300);
				scrollElementIntoView(vonageBusiness_updateRequest);
				JSClick(vonageBusiness_updateRequest);
				scrollElementIntoView(vonageBusiness_editSave_successMsg);
				waitForElementPresent(vonageBusiness_editSave_successMsg, 300);
				verifyText(vonageBusiness_editSave_successMsg, "Request updated", "");
				
				/*scrollElementIntoView(vonageBusiness_updateClose);
				JSClick(vonageBusiness_updateClose);*/
				
				switchToDefaultFrame();
				waitForElementPresent(srchDd, 300);
				click(srchDd,"Search");
		        
		        click(customerLnk,"Customer link");        
		        type(srchTxt, customer_id,"Search box");
		        type(srchTxt,"Search box",Keys.ENTER);        
			
		        if(verifyElementText(customerTableHeadline, "Customers")) {
					verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
				}
				verifyText(customer_dashboard_name, "Customer:", "Customer Name");
				waitForElementPresent(customer_dashboard_contacts_addTicket, 300);
				scrollElementIntoView(customer_dashboard_contacts_addTicket);				
			Assert.assertTrue(verifyTextPresentInList(openTickets_contactList, first_Name));
			logPass("updated ticket has been verified");
			
			//update & Close
		
		verifyTextInColumnClickOtherColumn(openTickets_contactList, ticketMagnifierList, first_Name);
		Thread.sleep(1000);
		switchToFrame(contacts_addTicket_loginPageFrame);	
waitForElementPresent(vonageBusiness_updateClose, 300);
		scrollElementIntoView(vonageBusiness_updateClose);
		Thread.sleep(3000);
		actionsClick(vonageBusiness_updateClose);
		Thread.sleep(2000);
		 String addTicket_updateClose_closingStatus_DD="id=close_status_select";
		 selectDropDownByIndex(addTicket_updateClose_closingStatus_DD, 3);
		switchToDefaultFrame();	
		Thread.sleep(4000);
		
		
		//verifying the closed ticket
		/*click(srchDd, "Search");
		click(customerLnk, "Customer link");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");
		scrollElementIntoView(customer_dashboard_contacts_addTicket);		*/
		String Tickets="xpath=//a[starts-with(@href,'/ticket/listByCustomer/filter')]";
		String dashBoard_openTickets_ClosedTicketsList="xpath=//a[starts-with(@href,'/ticket/listByCustomer/customer_id')]";
		String Tickets_closedTickets_TableContacts="xpath=//*[@id='ticket_table']/tbody/tr/td[7]";
		actionsClick(Tickets,"Tickets");
		waitForElementPresent(dashBoard_openTickets_ClosedTicketsList, 300);
		JSClick(dashBoard_openTickets_ClosedTicketsList,"Closed Tickets");
		Assert.assertTrue(verifyTextPresentInList(Tickets_closedTickets_TableContacts, first_Name));
		logPass("Closed Ticket has been verified under the closed tickets table with contact name "+first_Name);
		
	}
}
