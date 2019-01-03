package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_ReconsiliationPage;
import demo.objectrepository.OR_SearchPage;

public class Reconciliation1971 extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory, OR_ReconsiliationPage {

    @Test
    public void paymentsInvoiceVerification() throws Throwable {

        logger = extent.startTest("Verify HomePage Icons");
        type(userNameTxt, "zqa-admin", "User name");
        type(passTxt, "Q@eZL9Pw2D", "Password");
        click(submitBtn, "Submit button");
        click(srchDd, "Search");
        type(OR_SearchPage.srchTxt, "vienna", "Search box");
        type(OR_SearchPage.srchTxt, "Search box", Keys.ENTER);

        click(OR_SearchPage.Symbol1stCustomer,"Symbol1stCustomer");
        click(OR_SearchPage.reconsilation1stCustomer,"reconsilation Option of 1stCustomer");

        type(ReconsiliationNotes,"test","Reconsilation Notes");

        click(emacCheckBox,"emacCheckBox");
        click(billOnly,"billOnlyCheckBox");
        click(reconsileSubmitButton,"reconsileSubmitButton");

        selectDropDownByIndex(selectEmailReceipient,0);

        click(reconsilationSubmitButtonFix,"reconsilationSubmitButtonFix");
        Thread.sleep(5000);



        logOut();
    }
}
