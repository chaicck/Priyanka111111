package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_SearchPage;


public class Export extends CommonReusables {

    @Test()
    public void verifyHomePage( ) throws Throwable {
        logger=extent.startTest("Verify HomePage Icons");
        type(OR_LoginPage.userNameTxt,"zqa-admin","User name");
        type(OR_LoginPage.passTxt,"Q@eZL9Pw2D","Password");
        click(OR_LoginPage.submitBtn,"Submit button");
        click(OR_HomePage.srchDd,"Search");
        type(OR_SearchPage.srchTxt, "vienna","Search box");
        type(OR_SearchPage.srchTxt,"Search box",Keys.ENTER);
        /*click(homeBtnDd,"Home button");
        click(customerInfoLnk,"Customer Information");
        isElementDisplayedE(format("Customer ID"),"Customer ID");
        isElementDisplayedE(format("Account Status"),"Account Status");
        isElementDisplayedE(format("Bill Cycle"),"Bill Cycle");
        isElementDisplayedE(cusSince,"Customer Since");
        isElementDisplayedE(cusExpire,"Contract Expire");
        isElementDisplayedE(format("Customer Name"),"Customer Name");
        isElementDisplayedE(format("Customer Alias"),"Customer Alias");
        isElementDisplayedE(format("Customer Industry"),"Customer Industry");
        isElementDisplayedE(format("Enterprise"),"Enterprise");
        isElementDisplayedE(format("Group"),"Group");
        isElementDisplayedE(market,"Market");
        isElementDisplayedE(format("Sales Person"),"Sales Person");
        isElementDisplayedE(format("Access Hours"),"Access Hours");
        isElementDisplayedE(cusPin,"Customer PIN");
        isElementDisplayedE(format("VPN ID"),"VPN ID");
        isElementDisplayedE(format("Authorization Notes"),"Authorization Notes");
        isElementDisplayedE(cusVipType,"Customer VIP type");
        isElementDisplayedE(billingStatus,"billing Status type");
        isElementDisplayedE(cusMrr,"cusMrr type");
        isElementDisplayedE(siteMrr,"siteMrr ty");
        isElementDisplayedE(cusRank,"cusRank");
        isElementDisplayedE(siteRank,"siteRank");
        isElementDisplayedE(csa,"csa");
        isElementDisplayedE(broadcastCluster,"broadcastCluster");
        isElementDisplayedE(monitoringStatus,"monitoringStatus");
        isElementDisplayedE(downTime,"downTime");
        isElementDisplayedE(shipAddr,"shipAddr");
        isElementDisplayedE(billingAddr,"billingAddr");
        isElementDisplayedE(childCusTable,"childCusTable");
        isElementDisplayedE(exportChildCus,"exportChildCus");
        isElementDisplayedE(eicTable,"eicTable");
        isElementDisplayedE(contactTable,"contactTable");
        isElementDisplayedE(contractTimeLine,"contractTimeLine");
        isElementDisplayedE(projectTimeLine,"projectTimeLine");
        isElementDisplayedE(ticketTimeLine,"ticketTimeLine");
        isElementDisplayedE(notes,"notes");
        isElementDisplayedE(logEntries,"logEntries");
        isElementDisplayedE(mrrTimeline,"mrrTimeline");
        logOut();
        Assert.assertTrue(baseUrl.equalsIgnoreCase("https://zeus.qa5.vonagenetworks.net/login/view/"));
*/
    }

}
