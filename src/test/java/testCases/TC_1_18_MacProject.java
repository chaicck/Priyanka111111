package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class TC_1_18_MacProject extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_SearchPage{
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void addMac(String zUserName, String zPassword) throws Throwable {
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
        logger = extent.startTest("1.18 Test ID : 19758 - Premier GET - 302_Add service on existing customer via MAC and Project");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description: Go to customer dashboard page select Add MAC then verify and  Push to Billing button");
        userlogin(zUserName, zPassword); 
        type(searchTextBox, id, "Search Box");
        type(searchTextBox,"search box",Keys.ENTER); 
        Thread.sleep(6000);
	if(verifyElementText(customerTableHeadline, "Customers")) {
	verifyTextInColumnClickOtherColumn(customerIdList, customerName, id); 
	}
	verifyText(customer_dashboard_name, "Customer:", "Customer Name");
	logInfo("User navigated to Customer Dashboard");
        waitForElementPresent(addMacLink, 300);
        scrollElementIntoView(addMacLink);
        click(addMacLink, "Add New MAC button");
		navigateToChild();
        waitForElementPresent(nameTxt, 300); 
        type(nameTxt, "Test","Name");
        waitForElementPresent(requestedInstallDateTxt, 300);
        type(requestedInstallDateTxt, tomorrowDate(),"Requested Install Date");
        waitForElementPresent(tktIdTxt, 300);
        type(tktIdTxt, "12345","Ticket");
        type(notesTxt, "Test","Notes");
        waitForElementPresent(authorizedBySelect, 300);
        selectDropDownByIndex(authorizedBySelect,1);
        selectDropDownByIndex(assignedToSelect,1);
        waitForElementPresent(addNewProdBtn, 300);
        click(addNewProdBtn, "Add New Product");
        waitForElementPresent(prodTxt, 300);
        type(prodTxt, "Call Recording Storage 1 year","Product");
        Thread.sleep(2000);
        waitForElementPresent(prodDropDown, 300);
        click(prodDropDown, "Product List");
        waitForElementPresent(macSaveBtn, 300);
        click(macSaveBtn, "Save button");
       // waitForElementPresent(approveAndEmailBtn, 300);
        //click(approveAndEmailBtn, "Approve And Email Button");
        //waitForElementPresent(sendToBillingBtn);
        //click(sendToBillingBtn, "Send to Billing Button");
     
        logOut();
    }
}
