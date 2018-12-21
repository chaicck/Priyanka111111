package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Viewin extends MediatorClass {
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
		 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
		public void viewin(String zUserName, String zPassword) throws Throwable {
			// test Data
			String id = "41450";
			String viewInMenu="xpath=//span[@id='notification-view-in']";
			String viewInEngage="id=notification-view-in-engage";
			String viewInSalesForce="id=notification-view-in-sales-force";
			String viewInSugar="id=notification-view-in-sugar";
			
			logger = extent.startTest("View In Menu Verification");
			logInfo("Currently Running on -- "+getCurrentUrl());
			logInfo("TestCase Description:Able to select View In Engage,View In Sugar,View In SalesForce");
			type(userNameTxt, zUserName, "User name");
			type(passTxt, zPassword, "Password");
			click(submitBtn, "Submit button");
			
			logInfo("Logged into Zeus successfully");
			String url=getCurrentUrl();
			type(searchTextBox, id, "Search Box");
			type(searchTextBox,"search box",Keys.ENTER);
			Thread.sleep(3000);
			if (verifyElementText(customerTableHeadline, "Customers")) {
				verifyTextInColumnClickOtherColumn(customerIdList, customerName, id);
			}
			waitForElementPresent(customer_dashboard_name, 300);
			verifyText(customer_dashboard_name, "Customer:", "Customer Name");  
			
			actionsClick(viewInMenu, "View In Menu");
			JSClick(viewInEngage,"View in Engage");
			
			actionsClick(viewInMenu, "View In Menu");
			JSClick(viewInSalesForce,"View in SalesForce");
			
			actionsClick(viewInMenu, "View In Menu");
			JSClick(viewInSugar,"View in Sugar");
			
		 }
}
