package demo.scripts;

import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_ReconsiliationPage;

public class TC_1_96_VerifyReconExceptionAgingGraph extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory, OR_ReconsiliationPage {

    @Test
    public void verifyReconExceptionAgingGraphn() throws Throwable {

        logger = extent.startTest("Verify HomePage Icons");
        type(userNameTxt, "zqa-admin", "User name");
        type(passTxt, "Q@eZL9Pw2D", "Password");
        click(submitBtn, "Submit button");
        click(reports,"Reports");
        click(reportsReconsilation,"reportsReconsilation");
        click(reconExceptionAgingOption,"reconExceptionAgingOption");
        click(agingGraphGoBtn,"agingGraph Go Btn");
        isElementDisplayed(agingGraphChart,"aging Graph Chart");
        waitForElementToBeClickable(agingGraphExport);
        click(agingGraphExport,"aging Graph values Export");
        logOut();
    }
}
