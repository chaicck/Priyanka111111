package testCases;

import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_ReconsiliationPage;

public class TC_1_96_VerifyReconExceptionAgingGraph extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory, OR_ReconsiliationPage {
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void verifyReconExceptionAgingGraphn(String zUserName, String zPassword) throws Throwable {

        logger = extent.startTest("TC_1_96_Zeus-Recon-10 Reconcilation Aging Graph and report (NA in QA)").assignCategory("Reports");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Select Reconciliation-Recon Exception Aging Graph Recon Exception Aging Graph displays able to click on Export");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit Reports_tasks_CalanderMonth button");
        setBrowserToSize(70);
        waitForElementPresent(reports, 300);
        click(reports,"Reports");
        click(reportsReconsilation,"reportsReconsilation");
        Thread.sleep(1000);
       aJSClick(reconExceptionAgingOption,"reconExceptionAgingOption");
        waitForElementPresent(agingGraphGoBtn, 300);
        click(agingGraphGoBtn,"agingGraph Go Btn");
        isElementDisplayed(agingGraphChart,"aging Graph Chart");
        waitForElementPresent(agingGraphExport, 300);
        click(agingGraphExport,"aging Graph values Export");
        logOut();
    }
}
