package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_79_Bulk_Edit extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory {

    @Test
    public void bulkEdit() throws Throwable {
        String id="47921";
        try

        {
            logger = extent.startTest("Verify Bulk Edit");
            userlogin("zqa-admin", "Q@eZL9Pw2D");
            waitForElementPresent(searchTextBox, 10);
            click(srchDd, "Search DropDown");
            click(customerLnk, "Customer Link");
            type(searchTextBox, id, "searchBox");
            type(searchTextBox, "searchBox", Keys.ENTER);
            if(isElementDisplayed(String.format(disCustomer,id),"Searched Customer")){
                click(dashBoardBillingLink, "Billing DropDown");
                click(inventoryLnk, "Inventory Link");
                isElementDisplayedE(bulkEditBtn, "Bulk Edit");
                isElementDisplayedE(chkBoxForAllEntries, "Bulk Edit");
                click(bulkEditBtn, "Bulk Edit");
                Assert.assertTrue(getAlertText().contains("No items selected"));
                acceptAlert();
                selectTwoCheckBoxs();
                click(bulkEditBtn, "Bulk Edit");
                type(locationId, "47922", "Location ID");
                type(ownerId, "47923", "Owner ID");
                click(saveBtn, "Save Button");
                logOut();
            }

        } catch (Exception e) {

        }
    }
}
