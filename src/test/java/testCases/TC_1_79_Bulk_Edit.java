package testCases;

import java.io.File;

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
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void bulkEdit(String zUserName, String zPassword) throws Throwable {
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
        try

        {
            logger = extent.startTest("1_79_Verify that there must be a Bulk Edit button on the Inventory page").assignCategory("Billing");
            logInfo("TestCase Description: Any customer Go to Billing Inventory verify user ia able to click on EditBilk");
            userlogin(zUserName, zPassword); 
            waitForElementPresent(searchTextBox, 300);
            click(srchDd, "Search DropDown");
            click(customerLnk, "Customer Link");
            waitForElementPresent(searchTextBox, 300);
            type(searchTextBox, id, "searchBox");
            type(searchTextBox, "searchBox", Keys.ENTER);
            Thread.sleep(3000);
            if(isElementDisplayed(String.format(disCustomer,id),"Searched Customer")){
            	Thread.sleep(9000);
                click(dashBoardBillingLink, "Billing DropDown");
                click(inventoryLnk, "Inventory Link");
                isElementDisplayedOrNot(bulkEditBtn, "Bulk Edit");
                isElementDisplayedOrNot(chkBoxForAllEntries, "Bulk Edit");
                waitForElementPresent(bulkEditBtn, 300);
                click(bulkEditBtn, "Bulk Edit");
                Thread.sleep(9000);
                Assert.assertTrue(getAlertText().contains("No items selected"));
                Thread.sleep(9000);
                acceptAlert();
                waitForElementPresent(bulkEditBtn, 300);
                click(bulkEditBtn, "Bulk Edit");
                type(locationId, "47922", "Location ID");
                type(ownerId, "47923", "Owner ID");
                click(saveBtn, "Save Button");
                logOut();
            }

        } catch (Exception e) {
        	
        	e.printStackTrace();

        }
    }
}
