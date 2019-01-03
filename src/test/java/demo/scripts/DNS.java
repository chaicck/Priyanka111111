package demo.scripts;

//demo.scripts.DNS

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_AddDNS;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_DNSRecords;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class DNS extends CommonReusables implements OR_AddDNS, OR_DNSRecords, OR_SearchPage, OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

    @Test
    public void addDns() throws Throwable {

        logger = extent.startTest("Add DNS");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
        type(srchTxt, "31589","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        click(dataLnk,"Data Link");
        click(dnsLnk,"DNS Link");
        click(firstDeleteLnk,"Delete Icon");
        Assert.assertTrue(isAlertPresent());
        dismissAlert();
        click(viewOrEdit,"View Or Edit Icon");
        Assert.assertTrue(Driver.getCurrentUrl().toLowerCase().contains("dns"));
        Driver.navigate().back();
        click(addDnsEntryLnk,"Add DNS Entry Link");
        String name="*.proxy.adjik"+generateRandomString(5);
        type(dnsNameTxt,name,"Name");
        type(hostTxt,"172."+randomNum(3)+".72."+randomNum(3),"Host");
        click(addBtn,"Add button");
        verifyDNSRecordIsAdded(name);
        logOut();

    }
}
