package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.TicketCreation;
import demo.objectrepository.OR_CustInfo;

public class TC_1_56_TicketMergeVerification extends TicketCreation{
	
	 
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	    public void tc_1_56_TicketMergeVerification(String zUserName, String zPassword) throws Throwable {	 
		 
		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
				
				logger = extent.startTest("1.56 Test ID : 17961 - Test if user is able to search for merged tickets in customer portal site").assignCategory("Ticket");
			logInfo("Currently Running on -- "+getCurrentUrl());	
		    logInfo("TestCase Description:Cutomer DashBoard-Pick two tickets (A & B) that has not already been merged (No check marks on\r\n" + 
						"Merged column).\r\n" + 
						"merge the ticket number B into ticket A. and search for a ticket  and verified tha ticket has been merged or not in merger column");
				type(userNameTxt, zUserName, "User name");
				type(passTxt, zPassword, "Password");
				click(submitBtn, "Submit button");		
				
				List<String> ticket1=ticketCreation(customer_id);
				logPass("1st ticket has been Created successfully with details "+ticket1);
				List<String> ticket2=ticketCreation(customer_id);
				logPass("2nd ticket has been Created successfully with details "+ticket2);
				
				verifyTextInColumnClickOtherColumnJS(customer_dashboard_contacts_ticketIdList, customer_dashboard_contacts_magnifier, ticket1.get(0));
				
				switchToFrame(OR_CustInfo.contacts_addTicket_loginPageFrame);
				
				waitForElementPresent(vonageBusiness_options, 200);
				JSClick(vonageBusiness_options,"vonageBusiness_options");
				JSClick(vonageBusiness_options_mergeRequest,"vonageBusiness_options_mergeRequest");
				Thread.sleep(3000);
				type(vonageBusiness_mergeRequest_requestIdToMerge, ticket2.get(0), "");
				waitForElementPresent(vonageBusiness_mergeRequest_startMegeBtn, 200);
				JSClick(vonageBusiness_mergeRequest_startMegeBtn,"vonageBusiness_mergeRequest_startMegeBtn");
				Thread.sleep(5000);
				waitForElementPresent(vonageBusiness_mergeRequest_startMege_confirmMergeBtn, 300);
				Thread.sleep(1000);
				waitForElementPresent(vonageBusiness_mergeRequest_startMege_confirmMergeBtn, 300);
				JSClick(vonageBusiness_mergeRequest_startMege_confirmMergeBtn,"startMege_confirmMergeBtn");
				Thread.sleep(10000);
				waitForElementPresent(vonageBusiness_ticketId, 300);
				//verifyText(vonageBusiness_ticketId, ticket2.get(0), "");
				
				// verifying in table
				switchToDefaultFrame();
				waitForElementPresent(srchDd, 200);
				 click(srchDd,"Search");
			        
			        click(customerLnk,"Customer link");        
			        type(srchTxt, customer_id,"Search box");
			        type(srchTxt,"Search box",Keys.ENTER);        
				
			        if(verifyElementText(customerTableHeadline, "Customers")) {
						verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
					}
					verifyText(customer_dashboard_name, "Customer:", "Customer Name");
					Thread.sleep(7000);
					
					scrollElementIntoView(customer_dashboard_contacts_addTicket);	
					Thread.sleep(8000);
					String ticket1Name=verifyTextInColumnGetOtherColumnText(customer_dashboard_contacts_ticketIdList, openTickets_contactListParametarised, ticket1.get(0));
					logInfo("ticket1Name after merge "+ticket1Name);
					Assert.assertTrue(ticket1Name.contains(ticket2.get(2)));
					
					logPass("Merge successfully completed, ticket1Name after merge "+ticket1Name);
					//String ticket1tickMark=verifyTextInColumnGetOtherColumnText(customer_dashboard_contacts_ticketIdList, customer_dashboard_openTicketsMergedTickMark, ticket1.get(0));
					//System.out.println(ticket1tickMark);
				
					logOut();		
				
}
	
	 
}
