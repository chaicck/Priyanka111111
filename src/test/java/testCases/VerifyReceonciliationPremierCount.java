package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class VerifyReceonciliationPremierCount extends MediatorClass{
	String contractName="Test "+randomString(3);
	String ticket=randomNum(5);
	  @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void verifyReceonciliationPremierCount(String zUserName, String zPassword) throws Throwable {
    	
    	
        logger = extent.startTest("Verify Receonciliation PremierCount").assignCategory("Billing","Regression test");
	    logInfo("Currently Running on -- "+getCurrentUrl());
	logInfo("TestCase Description:Go to Billing Reconciliation then able to click on refresh");
        type(userNameTxt, zUserName, "User name");
	type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        type(srchTxt, "test","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        actionsClick(CustomersTable_1stCustomer, "1st customer in the table i.e.," +getText(CustomersTable_1stCustomer));
        actionsClick(billingMenu, "Billing");
	actionsClick(billing_Reconciliation,"Reconciliation");
	actionsClick(Reconciliation_refresh,"Refresh");
	Thread.sleep(5000);
        String contractedNo=verifyTextInColumnGetOtherColumnText(Reconciliation_tableProducts, Reconciliation_tableContractedParametarised, "	Premier Basic");
	logInfo("Before Premier Basic contract addion, Premier Basic contract no in the table is "+contractedNo);
	logOut();
        
      
	  }

	
}
