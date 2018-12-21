package testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_91_CancelReason_CBBReport extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_91_CancelReason_CBBReport(String zUserName, String zPassword) throws Throwable {
    	
    	
        logger = extent.startTest("1.91 Test ID : 16005 - ZEUS-PM-36 Cancel Reason Dropdown iin CBB Report").assignCategory("Reports");
      logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Reports Menu The following menus are under the Reports tab: Accounting, Circuits, Customers,Devices, Engineering, Finance, Inventory, IPs, Monitoring, Numbers, Operations,Service\r\n" + 
        		"delivery, Reconciliation, Sales, Tickets Under the Accounting Menu, click on the Cancelled Before Billing submenu");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");  
	    waitForElementPresent(reports, 300);
       aactionsClick(reports, "Reports");
        aJSClick(reports_accounting,"Reports-Accounting");
        aJSClick(reports_accounting_cancelledBeforeBilling,"reports-accounting-cancelledBeforeBilling");
        waitForElementPresent(reports_accounting_cancelledBeforeBilling_cancelReasonDD, 200);
        aactionsClick(reports_accounting_cancelledBeforeBilling_cancelReasonDD,"cancelledBeforeBilling-cancelReason-DropDown");
        logPass("Cancel Reason Code has list of options to select");
     }
    }

