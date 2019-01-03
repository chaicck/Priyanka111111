package demo.scripts;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static demo.objectrepository.OR_SearchPage.noOfRows;
import static demo.objectrepository.OR_SearchPage.srchTxt;

public class VerifyAccountsIfActive extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory {

    @Test
    public void verifyAccountsIfActive() throws Throwable {

        logger=extent.startTest("Verify Account links when Active");
        type(userNameTxt,"zqa-admin","User name");
        type(passTxt,"Q@eZL9Pw2D","Password");
        click(submitBtn,"Submit button");
        click(srchDd,"Search");
        type(srchTxt, "vienna","Search box");
        type(srchTxt,"Search box",Keys.ENTER);
        VerifyAccountBillingStatus(noOfRows,"NoOfRows");
        logOut();
    }
}

