package demo.scripts;


import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;
import demo.objectrepository.OR_VBLoginPage;


public class TC_1_55_CDRReports extends CommonReusables implements OR_VBLoginPage,OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC, OR_SearchPage {

    @Test
    public void cDRReports() throws Throwable {

        logger = extent.startTest("Verify if user is able to perform CDR reports");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
        type(srchTxt, "NextCare","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        click(firstCustomerRecord,"Customer");
        click(homeBtnDd,"Home Button");
        click(portalUserhLnk,"Portal users link");
        selectUser("nextcareval@test.com");
        switchToChildWindow();
        Driver.navigate().to("https://customer.qa5.vonagenetworks.net");
        type(vbUserNameTxt, "nextcareval@test.com","User name");
        type(vbPwdTxt, "123456789L","password");
        click(vbsubmitbtn,"Login button");
        click(firstSite,"First site");
        Thread.sleep(10000);
        click(callAnalyticsBtn,"Call Analytics");
        Thread.sleep(10000);
        click(migratedReportsBtn,"Migrated Reports");
        Thread.sleep(20000);
        Assert.assertTrue(isElementDisplayed(cdrReportsHeadre,"CDR Reports Page"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Graphs"),"Graphs"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Company Level Reports"),"Company Level Reports"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Individuals/Station Level Reports"),"Individuals/Station Level Reports"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Department Level Reports"),"Department Level Reports"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Call Center and Hunt Group Level Reports"),"Call Center and Hunt Group Level Reports"));
        Assert.assertTrue(isElementDisplayed(String.format(cdrReports,"Billing and Charge Summary Reporting"),"Billing and Charge Summary Reporting"));
        switchToParentWindow();
        logOut();

    }
}
