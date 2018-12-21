package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_97_SubmitTheReconFix extends MediatorClass{
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	String contractName="Test "+randomString(3);
	String ticket=randomNum(5);
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void verifyReceonciliationPremierCount(String zUserName, String zPassword) throws Throwable {
		 	 String CustomersTable_1stCustomer="xpath=//*[@id='customer_table']/tbody/tr[3]/td[4]/a";
		 	 String Report_headLine="className=clearfix";
		     String billingMenu = "id=dd-Billing";
			 String billing_contracts= "xpath=//span[@id='notification-contracts']";
			 String billing_contracts_list="xpath=(//a[starts-with(@href,'/contract/listByCustomer/customer')])[2]";
			 String billing_Reconciliation="xpath=//a[starts-with(@href,'/recon/customerdetails/CustomerID')]";			 
			 
			 //list-elements
			 String billing_contracts_list_TableNames="xpath=//*[@id='contract_table']/tbody/tr/td[3]";
			 String billing_contracts_list_TableStatusParametarised="xpath=//*[@id='contract_table']/tbody/tr[%s]/td[5]";
			 String billing_contracts_list_addContract="xpath=//a[starts-with(@href,'/quote/view/customer_id')]";
			 String addContract_name="id=quote[name]";
			 String addContract_ticket="id=quote[ticket_id]";
			 String addContract_RequestedInstallDate="id=quote_cstm[requested_install_date_c]";
			 String addContract_authorizedBy="id=quote[AuthorizedBy]";
			 String addContract_AssignedTo="name=quote_cstm[project_manager_c]";
			 String addContract_productsAddNew="xpath=//a[@onclick='addRow();']";
			 String addContract_productTextBox_parametarised="xpath=//*[@id='ptable']/tbody/tr[%s]/td[1]/span/input[2]";
			
			 String addContract_approveEmail="xpath=(//button[@onclick='lockAndEmail();'])";
			 String addContract_sendToBilling="xpath=//a[starts-with(@href,'/quote/sendToBilling/customer_id')]";

			 //Reconciliation
			 String Reconciliation_refresh="xpath=//i[@class='fa  fa-refresh ']";
			 String Reconciliation_tableProducts="xpath=//*[@id='recon']/tbody/tr/td[2]";
			 String Reconciliation_tableContractedParametarised="xpath=//*[@id='recon']/tbody/tr[%s]/td[3]";  
			 String Reconciliation_EMAC_CheckALl="xpath=//input[@type='checkbox']";
			 String Reconciliation_ReconcileBtn ="xpath=(//button[@type='submit'])[3]";
			 String Reconciliation_ReconcileBtn_save="xpath=(//button[@type='submit'])[4]";
    	
        logger = extent.startTest("1.97 Test ID : 15331 - ZEUS-Recon-3 Submit the Recon Fix ").assignCategory("Billing","Regression test");
       logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Billing Reconcillation,click the checkboxes EMAC and Billing Only Able to Click Reconcile "
        		+ "Select Email Recipients Submit");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");      
        waitForElementPresent(srchTxt, 300);
        type(srchTxt, "test","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        waitForElementPresent(CustomersTable_1stCustomer, 300);
        actionsClick(CustomersTable_1stCustomer, "1st customer in the table i.e.," +getText(CustomersTable_1stCustomer));
        waitForElementPresent(billingMenu, 300);
    	actionsClick(billingMenu, "Billing");
		actionsClick(billing_Reconciliation,"Reconciliation");
		waitForElementPresent(Report_headLine, 300);
		verifyText(Report_headLine, "Reconciliation", "");
		waitForElementPresent(Reconciliation_refresh, 300);
		actionsClick(Reconciliation_refresh,"Refresh");
		Thread.sleep(5000);
		waitForElementPresent(Reconciliation_EMAC_CheckALl, 300);
		actionsClick(Reconciliation_EMAC_CheckALl,"'Check All' check box");
		waitForElementPresent(Reconciliation_ReconcileBtn, 300);
		scrollElementIntoView(Reconciliation_ReconcileBtn);
		
		actionsClick(Reconciliation_ReconcileBtn,"Reconcile");
		
		    waitForElementPresent(addContract_name, 200);
	        logInfo("Redirected to Mac page");
			waitForElementPresent(addContract_name, 300);
	        type(addContract_name, contractName, "Edit MAC name");  
	
		String contractedNo=verifyTextInColumnGetOtherColumnText(Reconciliation_tableProducts, Reconciliation_tableContractedParametarised, "	Premier Basic");
		logInfo("Before Premier Basic contract addion, Premier Basic contract no in the table is "+contractedNo);
		waitForElementPresent(addContract_ticket, 300);
        type(addContract_ticket, ticket, "Add MAC Ticket");	
        waitForElementPresent(addContract_RequestedInstallDate, 300);
		if (getCurrentUrl().contains("qa6")) {
			enterDate(addContract_RequestedInstallDate, dateAftersomeDays(4,"dd"), dateAftersomeDays(4,"MM"), dateAftersomeDays(4,"yyyy"));
		}
		if (getCurrentUrl().contains("qa5")) {
			//type(addContract_RequestedInstallDate, dateAftersomeDays(4,"MMddyyyy"), "Date Field");
			enterDate(addContract_RequestedInstallDate, dateAftersomeDays(4,"dd"), dateAftersomeDays(4,"MM"), dateAftersomeDays(4,"yyyy"));
		}
		waitForElementPresent(addContract_authorizedBy, 300);
		scrollElementIntoView(addContract_authorizedBy);
		selectDropDownByIndex(addContract_authorizedBy, 1);
		selectDropDownByIndex(addContract_AssignedTo, 2);
		waitForElementPresent(addContract_productsAddNew, 300);
		scrollElementIntoView(addContract_productsAddNew);
		actionsClick(addContract_productsAddNew);
		
		 int n=getAllElements(customerDashboard_addMAC_productAddNew_productTextBoxList).size();
		 
		 System.out.println("product locator "+String.format(addContract_productTextBox_parametarised, n));
		waitForElementPresent(addContract_productTextBox_parametarised, 300);
		 type(String.format(addContract_productTextBox_parametarised, n), "Premier Basic", "Product name-Premier Basic");
		 type(String.format(addContract_productTextBox_parametarised, n), "Premier Basic", Keys.ARROW_DOWN , Keys.ENTER);
		Thread.sleep(2000);
		waitForElementPresent(Reconciliation_ReconcileBtn_save, 300);
		 JSClick(Reconciliation_ReconcileBtn_save,"Save Button");
		
		Thread.sleep(5000);
	    logOut();
		
		
		
		
		
		
		
		
		
		/*scrollElementIntoView(addContract_approveEmail);
		Thread.sleep(1000);		
		JSClick(addContract_approveEmail,"Approve & Email");
		Thread.sleep(10000);
		scrollElementIntoView(addContract_sendToBilling);
		Thread.sleep(1000);
		JSClick(addContract_sendToBilling,"Send To Billing");
		Thread.sleep(5000);*/
		
		
	  }

	
}
