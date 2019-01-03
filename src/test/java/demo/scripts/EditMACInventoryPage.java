package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class EditMACInventoryPage extends CommonReusables implements OR_SearchPage, OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

    @Test
    public void editMACInventoryPage() throws Throwable {

        logger = extent.startTest("Verify Edit MAC Inventory Page");
        type(userNameTxt,"zqa-admin","User name");
        type(passTxt,"Q@eZL9Pw2D","Password");
        click(submitBtn,"Submit button");
        click(srchDd,"Search");
        type(srchTxt, "vienna","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        selectBillingAndAccStatusActiveAndIventory(noOfRows);
        logOut();

    }
}
