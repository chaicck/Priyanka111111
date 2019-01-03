package demo.scripts;

import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_18_MacProject extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

    @Test
    public void addMac() throws Throwable {

        logger = extent.startTest("Verify Add MAC");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
        waitForElementPresent(searchTextBox, 10);
        click(prjLnk, "Project Link");
        click(prjByPMLnk, "Project DropDown");
        waitForElementPresent(projManagerDd, 10);
        click(projManagerDd, "Project Manager DropDown");
        click(allOpenProjLnk, "All open projects");
        click(srchBtn, "Search button");
        selectCusStatusRFFBAndCmpletion85Per();
        waitForElementPresent(newMacLable, 40);
        click(addMacLink, "Add New MAC button");
        type(nameTxt, "Test","Name");
        type(requestedInstallDateTxt, tomorrowDate(),"Requested Install Date");
        type(tktIdTxt, "12345","Ticket");
        type(notesTxt, "Test","Notes");
        selectDropDownByIndex(authorizedBySelect,1);
        selectDropDownByIndex(assignedToSelect,1);
        click(addNewProdBtn, "Add New Product");
        type(prodTxt, "Call Recording Storage 1 year","Product");
        Thread.sleep(2000);
        click(prodDropDown, "Product List");
        click(macSaveBtn, "Save button");
        click(approveAndEmailBtn, "Approve And Email Button");
        waitForElementPresent(sendToBillingBtn);
        click(sendToBillingBtn, "Send to Billing Button");
        logOut();

    }
}
