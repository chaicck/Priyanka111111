package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_InvoicesAndPayments;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class PaymentsInvoiceVerification extends CommonReusables implements OR_InvoicesAndPayments, OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory {

    @Test
    public void paymentsInvoiceVerification() throws Throwable {
        logger=extent.startTest("Verify HomePage Icons");
        type(OR_LoginPage.userNameTxt,"zqa-admin","User name");
        type(OR_LoginPage.passTxt,"Q@eZL9Pw2D","Password");
        click(OR_LoginPage.submitBtn,"Submit button");
        click(srchDd,"Search");
        type(OR_SearchPage.srchTxt, "vienna","Search box");
        type(OR_SearchPage.srchTxt,"Search box",Keys.ENTER);
        selectBillingAndAccStatusActive(OR_SearchPage.noOfRows);
        click(OR_InvoicesAndPayments.exportBtn,"Export button");
        click(OR_InvoicesAndPayments.invoiceBtn,"Invoice button");
        click(OR_InvoicesAndPayments.invoiceCloseBtn,"Invoice Close button");
        logOut();
    }
}

