package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_87_HyperLinks_Log_0n_MAC_Inventory extends MediatorClass{
	String contractName="Test "+randomString(3);
	String ticket=randomNum(5);
	  @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void verifyReceonciliationPremierCount(String zUserName, String zPassword) throws Throwable {
		 	 String CustomersTable_1stCustomer="xpath=//*[@id='customer_table']/tbody/tr[3]/td[4]/a";
		 	 String Report_headLine="className=clearfix";
		     String billingMenu = "id=dd-Billing";
			 String billing_inventory="xpath=//a[starts-with(@href,'/inventory/listByCustomer/customer_id')]";			 
			 
			
        logger = extent.startTest("1.87 Test ID : 15058 - ZEUS-BILLING-8-Hyperlinks and log on Mac Inventory").assignCategory("Billing");
	logInfo("Currently Running on -- "+getCurrentUrl());	
	logInfo("TestCase Description:Verify Billing-Inventory page ");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");  
        waitForElementPresent(srchTxt, 300);
        type(srchTxt, "test","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        waitForElementPresent(CustomersTable_1stCustomer, 300);
        actionsClick(CustomersTable_1stCustomer, "1st customer in the table i.e.," +getText(CustomersTable_1stCustomer));
    	actionsClick(billingMenu, "Billing");
		actionsClick(billing_inventory,"Inventory");
	     waitForElementPresent(Report_headLine, 300);
		verifyText(Report_headLine, "Inventory", "");
		
		
		
	  }

	
}
