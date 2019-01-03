package demo.scripts;

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
        click(OR_HomePage.homeBtnDd,"Home button");
        click(OR_HomePage.customerInfoLnk,"Customer Information");
        isElementDisplayedE(format("Customer ID"),"Customer ID");
        isElementDisplayedE(format("Account Status"),"Account Status");
        isElementDisplayedE(format("Bill Cycle"),"Bill Cycle");
        isElementDisplayedE(OR_CustInfo.cusSince,"Customer Since");
        isElementDisplayedE(OR_CustInfo.cusExpire,"Contract Expire");
        isElementDisplayedE(format("Customer Name"),"Customer Name");
        isElementDisplayedE(format("Customer Alias"),"Customer Alias");
        isElementDisplayedE(format("Customer Industry"),"Customer Industry");
        isElementDisplayedE(format("Enterprise"),"Enterprise");
        isElementDisplayedE(format("Group"),"Group");
        isElementDisplayedE(OR_CustInfo.market,"Market");
        isElementDisplayedE(format("Sales Person"),"Sales Person");
        isElementDisplayedE(format("Access Hours"),"Access Hours");
        isElementDisplayedE(OR_CustInfo.cusPin,"Customer PIN");
        isElementDisplayedE(format("VPN ID"),"VPN ID");
        isElementDisplayedE(format("Authorization Notes"),"Authorization Notes");
        isElementDisplayedE(OR_CustInfo.cusVipType,"Customer VIP type");
        isElementDisplayedE(OR_CustInfo.billingStatus,"billing Status type");
        isElementDisplayedE(OR_CustInfo.cusMrr,"cusMrr type");
        isElementDisplayedE(OR_CustInfo.siteMrr,"siteMrr ty");
        isElementDisplayedE(OR_CustInfo.cusRank,"cusRank");
        isElementDisplayedE(OR_CustInfo.siteRank,"siteRank");
        isElementDisplayedE(OR_CustInfo.csa,"csa");
        isElementDisplayedE(OR_CustInfo.broadcastCluster,"broadcastCluster");
        isElementDisplayedE(OR_CustInfo.monitoringStatus,"monitoringStatus");
        isElementDisplayedE(OR_CustInfo.downTime,"downTime");
        isElementDisplayedE(OR_CustInfo.shipAddr,"shipAddr");
        isElementDisplayedE(OR_CustInfo.billingAddr,"billingAddr");
        isElementDisplayedE(OR_CustInfo.childCusTable,"childCusTable");
        isElementDisplayedE(OR_CustInfo.exportChildCus,"exportChildCus");
        isElementDisplayedE(OR_CustInfo.eicTable,"eicTable");
        isElementDisplayedE(OR_CustInfo.contactTable,"contactTable");
        isElementDisplayedE(OR_CustInfo.contractTimeLine,"contractTimeLine");
        isElementDisplayedE(OR_CustInfo.projectTimeLine,"projectTimeLine");
        isElementDisplayedE(OR_CustInfo.ticketTimeLine,"ticketTimeLine");
        isElementDisplayedE(OR_CustInfo.notes,"notes");
        isElementDisplayedE(OR_CustInfo.logEntries,"logEntries");
        isElementDisplayedE(OR_CustInfo.mrrTimeline,"mrrTimeline");
        logOut();
        Assert.assertTrue(baseUrl.equalsIgnoreCase("https://zeus.qa5.vonagenetworks.net/login/view/"));

    }

}
