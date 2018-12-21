package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_SearchPage;


public class ZeusDemo extends CommonReusables {

    @Test()
    public void verifyHomePage( ) throws Throwable {
        logger=extent.startTest("Verify HomePage Icons");
        type(OR_LoginPage.userNameTxt,"zqa-admin","User name");
        type(OR_LoginPage.passTxt,"Q@eZL9Pw2D","Password");
        click(OR_LoginPage.submitBtn,"Submit button");
        type(OR_SearchPage.srchTxt,"Nextcare","Search box");
        type(OR_SearchPage.srchTxt,"Search box",Keys.ENTER);
        click(OR_SearchPage.firstParentIdLnk,"Parent ID");
        click(OR_HomePage.homeBtnDdd,"Home button");
        click(OR_HomePage.customerInfoLnk,"Customer Information");
        isElementDisplayedOrNot(format("Customer ID"),"Customer ID");
        isElementDisplayedOrNot(format("Account Status"),"Account Status");
        isElementDisplayedOrNot(format("Bill Cycle"),"Bill Cycle");
        isElementDisplayedOrNot(OR_CustInfo.cusSince,"Customer Since");
        isElementDisplayedOrNot(OR_CustInfo.cusExpire,"Contract Expire");
        isElementDisplayedOrNot(format("Customer Name"),"Customer Name");
        isElementDisplayedOrNot(format("Customer Alias"),"Customer Alias");
        isElementDisplayedOrNot(format("Customer Industry"),"Customer Industry");
        isElementDisplayedOrNot(format("Enterprise"),"Enterprise");
        isElementDisplayedOrNot(format("Group"),"Group");
        isElementDisplayedOrNot(OR_CustInfo.market,"Market");
        isElementDisplayedOrNot(format("Sales Person"),"Sales Person");
        isElementDisplayedOrNot(format("Access Hours"),"Access Hours");
        isElementDisplayedOrNot(OR_CustInfo.cusPin,"Customer PIN");
        isElementDisplayedOrNot(format("VPN ID"),"VPN ID");
        isElementDisplayedOrNot(format("Authorization Notes"),"Authorization Notes");
        isElementDisplayedOrNot(OR_CustInfo.cusVipType,"Customer VIP type");
        isElementDisplayedOrNot(OR_CustInfo.billingStatus,"billing Status type");
        isElementDisplayedOrNot(OR_CustInfo.cusMrr,"cusMrr type");
        isElementDisplayedOrNot(OR_CustInfo.siteMrr,"siteMrr ty");
        isElementDisplayedOrNot(OR_CustInfo.cusRank,"cusRank");
        isElementDisplayedOrNot(OR_CustInfo.siteRank,"siteRank");
        isElementDisplayedOrNot(OR_CustInfo.csa,"csa");
        isElementDisplayedOrNot(OR_CustInfo.broadcastCluster,"broadcastCluster");
        isElementDisplayedOrNot(OR_CustInfo.monitoringStatus,"monitoringStatus");
        isElementDisplayedOrNot(OR_CustInfo.downTime,"downTime");
        isElementDisplayedOrNot(OR_CustInfo.shipAddr,"shipAddr");
        isElementDisplayedOrNot(OR_CustInfo.billingAddr,"billingAddr");
        isElementDisplayedOrNot(OR_CustInfo.childCusTable,"childCusTable");
        isElementDisplayedOrNot(OR_CustInfo.exportChildCus,"exportChildCus");
        isElementDisplayedOrNot(OR_CustInfo.eicTable,"eicTable");
        isElementDisplayedOrNot(OR_CustInfo.contactTable,"contactTable");
        isElementDisplayedOrNot(OR_CustInfo.contractTimeLine,"contractTimeLine");
        isElementDisplayedOrNot(OR_CustInfo.projectTimeLine,"projectTimeLine");
        isElementDisplayedOrNot(OR_CustInfo.ticketTimeLine,"ticketTimeLine");
        isElementDisplayedOrNot(OR_CustInfo.notes,"notes");
        isElementDisplayedOrNot(OR_CustInfo.logEntries,"logEntries");
        isElementDisplayedOrNot(OR_CustInfo.mrrTimeline,"mrrTimeline");
        logOut();
        Assert.assertTrue(baseUrl.equalsIgnoreCase("https://zeus.qa5.vonagenetworks.net/login/view/"));

    }

}
