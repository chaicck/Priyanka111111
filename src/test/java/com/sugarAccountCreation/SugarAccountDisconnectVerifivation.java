package com.sugarAccountCreation;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_Admin;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;

import demo.objectrepository.OR_Projects;
import demo.objectrepository.OR_ReconsiliationPage;
import demo.objectrepository.OR_Reports;
import demo.objectrepository.OR_SearchPage;

public class SugarAccountDisconnectVerifivation extends CommonReusables implements OR_Projects, OR_Reports,OR_Admin, OR_SearchPage, OR_HomePage, OR_CustInfo,OR_NewMAC,OR_Inventory, OR_ReconsiliationPage {

	 @Test
	    public void userDisconnectFlowVrification() throws Throwable {
			String userName="Zqa-admin";
		 	String password="Q@eZL9Pw2D";
		    String customer_id="920250";
		 	String contract_id;
	        logger = extent.startTest("Verifying customer Home");
	        type(userNameTxt, userName, "User name");
	        type(passTxt, password, "Password");
	        click(submitBtn, "Submit button");
	        
	        type(searchTextBox, customer_id, "Search Box");
	        type(searchTextBox,"search box",Keys.ENTER);
	        
	        if(verifyElementText(customerTableHeadline, "Customers")) {
	        	
		    	verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
	        	
		      }
	    
		      
	        verifyText(customer_dashboard_name, "Customer:", "Customer Name"); //Name To verify - eg.Customer: Novell & Jimenez-Corp (31589)
	               
	       
	       
	        click(customerHome_viewInMenu, "customerHome_viewInMenu");
	        click(customerHome_viewInMenu_sugarr, "customerHome viewIn Menu engage");
	        navigateToChild();
	        Thread.sleep(5000);
	        // need to edit ************* 
	        type(sugar_username, userName, "view In sugar Username");
	        type(sugar_password,password, "view In sugar Password");
	        click(sugar_loginBtn, "login Button");
	        waitForElementToBeClickable(viewInSugar_editButton);
	        
	      
	        
	        actionsClick(viewInSugar_editButton);
	        selectDropDownByIndex(viewInSugar_edit_market_DD, 2);
	        selectDropDownByIndex(viewInSugar_edit_industry_DD, 2);
	        actionsClick(viewInSugar_edit_saveBtn);        
	        
	        currentWindowClose();
	        navigateBackToParentWindow();
	        
	        // Clicking on view in engage
	        Thread.sleep(1000);
	        click(customerHome_viewInMenu, "customerHome_viewInMenu");
	        click(customerHome_viewInMenu_engage, "customerHome viewIn Menu engage");
	        navigateToChild();
	        Thread.sleep(5000);
	        
	        type(engageIp_username, " ZeusQA", "Engage Ip Username");
	        type(engageIp_password, " t3$tp@sS0rd", "Engage Ip Password");
	        click(engageIp_loginBtn, "login Button");
	        waitForElementToBeClickable(engageIp_contactsTab);
	        
	        String engageCurrentUser="id=CurrentUsername";
	        if(!getText(engageCurrentUser).contains(customer_id)) {
	        	System.out.println("Customer Id is not correct in Engage");
	        	currentWindowClose();
	        	navigateBackToParentWindow();
	        	Thread.sleep(1000);
	        	click(customerHome_viewInMenu, "customerHome_viewInMenu");
		        click(customerHome_viewInMenu_engage, "customerHome viewIn Menu engage");
		        navigateToChild();
		        Thread.sleep(5000);
	        }
	        System.out.println(getText(engageCurrentUser));
	        Assert.assertTrue(getText(engageCurrentUser).contains(customer_id));    
	        actionsClick(viewInEngage_status);
	        actionsClick(viewInEngage_status_magnifier);
	        actionsClick(viewInEngage_status_writeOff_Option);
	        actionsClick(viewInEngage_status_saveBtn);
	        waitForElementPresent(viewInEngage_status_immediatelyWithNoTransaction, 10);
	        actionsClick(viewInEngage_status_immediatelyWithNoTransaction);
	        actionsClick(viewInEngage_status_saveBtn);
	        
	        click(engageIp_overViewTab, "Enagage IP OverviewTab");
	        
	        String getStatusSrc =getAttributeValue(viewInEngage_overView_status_logo , "src");
	        Assert.assertTrue(getStatusSrc.contains("https://premierbilling.vonage.com/AdminPortal/images/canceled.gif"));
	       
	       navigateBackToParentWindow();
	        
	       	click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	        	
	 	 

	         type(queue_billing_search, "Look up account in sugar DB sync up ops,zeus and engage db accordingly", "");
	         Thread.sleep(1000);
	         	         
	         //verifyTextInColumnClickOtherColumn(Admin_automation_name, Admin_automation_runButton, "syncAccount");
	         
	         
	         actionsClick(automation_runBtn);
	         
	         waitForElementPresentE(Admin_automation_runSynchAccount_customerId, 20);
	         type(Admin_automation_runSynchAccount_customerId, customer_id, "");
	         actionsClick(Admin_automation_runSynchAccount_runBtn);
	         
	         waitForElementPresent(Admin_automation_runSynchAccount_successMsg, 60);
	         verifyText(Admin_automation_runSynchAccount_successMsg, "Successful", "");
	         
	         //sync all accounts
	         click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	         
	         type(queue_billing_search, "@param string interval - the mysql interval of last updated ex:", "");
	         Thread.sleep(1000);
	         //verifyTextInColumnClickOtherColumn(Admin_automation_name, Admin_automation_runButton, "syncAccount");
	        
	         actionsClick(automation_syncAllBtn);
	         waitForElementPresentE(Admin_automation_runSynchAccount_interval, 20);
	         type(Admin_automation_runSynchAccount_interval, "5 MINUTE", "");
	         actionsClick(Admin_automation_runSynchAccount_runBtn);
	         
	         waitForElementPresent(Admin_automation_runSynchAccount_successMsg, 60);
	         verifyText(Admin_automation_runSynchAccount_successMsg, "Successful", "");
	         
	         
	         click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	         type(queue_billing_search, "ENGAGE", "");
	         //16th point - 1 stpe (clicking on Run)
	         Thread.sleep(1000);
	         actionsClick(queue_billing_run);
	         Thread.sleep(2000);
	         waitForElementToBeClickable(queue_billing_run_run);
	         actionsClick(queue_billing_run_run);
	        
	         Thread.sleep(15000);
	         waitForElementPresent(queue_billing_run_successText, 30);
	         verifyText(queue_billing_run_successText, "Successful", "Successful Msg");
	         
	         click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	        	
	 	 

	         type(queue_billing_search, "Look up account in sugar DB sync up ops,zeus and engage db accordingly", "");
	         Thread.sleep(1000);
	         	         
	         //verifyTextInColumnClickOtherColumn(Admin_automation_name, Admin_automation_runButton, "syncAccount");
	         
	         
	         actionsClick(automation_runBtn);
	         
	         waitForElementPresentE(Admin_automation_runSynchAccount_customerId, 20);
	         type(Admin_automation_runSynchAccount_customerId, customer_id, "");
	         actionsClick(Admin_automation_runSynchAccount_runBtn);
	         
	         waitForElementPresent(Admin_automation_runSynchAccount_successMsg, 60);
	         verifyText(Admin_automation_runSynchAccount_successMsg, "Successful", "");
	         
	         //sync all accounts
	         click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	         
	         type(queue_billing_search, "@param string interval - the mysql interval of last updated ex:", "");
	         Thread.sleep(1000);
	         //verifyTextInColumnClickOtherColumn(Admin_automation_name, Admin_automation_runButton, "syncAccount");
	        
	         actionsClick(automation_syncAllBtn);
	         waitForElementPresentE(Admin_automation_runSynchAccount_interval, 20);
	         type(Admin_automation_runSynchAccount_interval, "5 MINUTE", "");
	         actionsClick(Admin_automation_runSynchAccount_runBtn);
	         
	         waitForElementPresent(Admin_automation_runSynchAccount_successMsg, 60);
	         verifyText(Admin_automation_runSynchAccount_successMsg, "Successful", "");
	         
	         
	         click(adminLInk,"Admin LInk");
	         click(automation, "Automation");
	         JSClick(automation_automation_viewAutomation);
	         type(queue_billing_search, "ENGAGE", "");
	         //16th point - 1 stpe (clicking on Run)
	         Thread.sleep(1000);
	         actionsClick(queue_billing_run);
	         Thread.sleep(2000);
	         waitForElementToBeClickable(queue_billing_run_run);
	         actionsClick(queue_billing_run_run);
	        
	         Thread.sleep(15000);
	         waitForElementPresent(queue_billing_run_successText, 30);
	         verifyText(queue_billing_run_successText, "Successful", "Successful Msg");
	         
	         click(srchDd,"Search");	         
	         click(customerLnk,"Customer link");        
	         type(srchTxt, customer_id,"Search box"); //search text
	         type(srchTxt,"Search box",Keys.ENTER); 
	         
	         if(verifyElementText(customerTableHeadline, "Customers")) {		        	
			    	verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
		       }    
			   verifyText(customer_dashboard_name, "Customer:", "Customer Name"); //Name To verify - eg.Customer: Novell & Jimenez-Corp (31589)
		     
			 System.out.println("Account Status - "+getText(customer_home_accountStatus));  
	        
			 String status=getAttributeValue(customer_home_accountStatus, "value");
			 System.out.println(status);
			 Assert.assertTrue(status.contains("Canceled"));
			 
	         
	       
	        
	 }

}
