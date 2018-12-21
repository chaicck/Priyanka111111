package demo.businesslogic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;

public class TicketCreation extends MediatorClass {
	
public List<String> ticketCreation(String customer_id) throws Throwable {
	
	click(srchDd,"Search");     
    click(customerLnk,"Customer link");        
    type(searchTextBox, customer_id, "Search Box");
	type(searchTextBox,"search box",Keys.ENTER);
	if(verifyElementText(customerTableHeadline, "Customers")) {
		verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
	}
	verifyText(customer_dashboard_name, "Customer:", "Customer Name"); 				
	
	String email1="priyaka"+randomString(2)+"@live.com";
	String first_Name1="priyaka "+randomString(3);
	
	scrollElementIntoView(customer_dashboard_contacts_addTicket);
	JSClick(customer_dashboard_contacts_addTicket,"contacts_addTicket");
	
	switchToFrame(contacts_addTicket_loginPageFrame);
	
	if(verifyElementText(contacts_addTicket_loginPage_userName, "")) {
		type(contacts_addTicket_loginPage_userName, "Zeus_QA@vonage.com", "");
		type(contacts_addTicket_loginPage_password, "pAs$w0rd%t3st", "");
		actionsClick(contacts_addTicket_loginPage_signIn);
	}
	
	type(vonageBusiness_firstname, first_Name1, "vonageBusiness_firstname");
	type(vonageBusiness_lastname, "ppundru", "vonageBusiness_lastname");
	selectDropDownByIndex(vonageBusiness_connectedVia, 2);
	logInfo("Selected 3rd option under connectedVia DropDown");
	type(vonageBusiness_Email, email1, "vonageBusiness_Email");
	selectDropDownByVisibleText(vonageBusiness_Category, "Call Center");
	
	selectDropDownByIndex(vonageBusiness_CasePriority, 2);
	logInfo("Selected 3rd option under CasePriority DropDown");
	type(vonageBusiness_ticketSummary, "test", "vonageBusiness_ticketSummary");
	scrollElementIntoView(vonageBusiness_groupAssignment);
	selectDropDownByIndex(vonageBusiness_groupAssignment, 2);
	logInfo("Selected 3rd option under groupAssignment DropDown");
	
	
	switchToFrame(contacts_addTicket_noteFrameinternal);
	type(contacts_addTicket_notes, "test", "contacts_addTicket_notes");
	switchToDefaultFrame();
	
	switchToFrame(contacts_addTicket_loginPageFrame);
	scrollElementIntoView(vonageBusiness_createRequest);
	JSClick(vonageBusiness_createRequest,"createRequest");
	Thread.sleep(5000);
	
	if(verifyElementText(vonageBusiness_alertAccept, "")) {
		actionsClick(vonageBusiness_alertAccept,"alertAccept");
	}
	
	switchToDefaultFrame();
	 click(srchDd,"Search");
        
        click(customerLnk,"Customer link");        
        type(srchTxt, customer_id,"Search box");
        type(srchTxt,"Search box",Keys.ENTER);        
	
        if(verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");
		scrollElementIntoView(customer_dashboard_contacts_addTicket);				
	    Assert.assertTrue(verifyTextPresentInList(openTickets_contactList, first_Name1));
	
       String ticket1=verifyTextInColumnGetOtherColumnText(openTickets_contactList, customer_dashboard_contacts_ticketId, first_Name1);

		 List<String> list = new ArrayList<>();
		 list.add(ticket1);
		 list.add(email1);
		 list.add(first_Name1+" ppundru");
		
		return list;	
		}
		}
