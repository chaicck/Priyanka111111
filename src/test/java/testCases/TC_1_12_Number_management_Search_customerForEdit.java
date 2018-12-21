package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_12_Number_management_Search_customerForEdit extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_12_Number_management_Search_customerForEdit(String zUserName, String zPassword) throws Throwable {
    	
    	String customer_name="nextcare - AZ - greenway";

        logger = extent.startTest("1.12 Test ID : 20696 - Number management - Search customer for edit").assignCategory("Voice");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description: Go to voice then select numbersfor any numver edit the Customer and Shipping Address filed	");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");
        waitForElementPresent(searchTextBox, 300);
        type(searchTextBox, customer_name, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
	    waitForElementPresent(customerTableHeadline, 300);
		if(verifyElementText(customerTableHeadline, "Customers")) {
			//verifyTextInColumnClickOtherColumn(customerNameList, customerName, customer_name); 
			Thread.sleep(1000);
			actionsClick(customerNameList);
		}
		 waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");
	    waitForElementPresent(customerDashboard_customerLink, 300);
		actionsClick(customerDashboard_customerLink,"customerDashboard_customerLink");
		actionsClick(customer_dashboard_notification_voice, "Voice");
		actionsClick(customer_dashboard_notification_numbers,"Numbers");
		waitForElementPresent(customer_dashboard_notification_voice_number_penIcons, 300);
		actionsClick(customer_dashboard_notification_voice_number_penIcons);
	    logPass("Clicked on pen icon for any telephone number");	
		Thread.sleep(5000);
		
		if(verifyElementText(customer_dashboard_notification_voice_number_penIcons_subList, "")) {
			Thread.sleep(1000);
			actionsClick(customer_dashboard_notification_voice_number_penIcons_subList);
		}
		
		waitForElementPresent(voice_number_penIcons_customer_shippingAddress_DD_edit, 300);
		actionsClick(voice_number_penIcons_customer_shippingAddress_DD_edit);
		Thread.sleep(7000);
		actionsClick(voice_number_penIcons_customer_shippingAddress_DD);
		logPass("Edit Shipping Address filed section under customer");
		String voice_number_penIcons_customer_shippingAddress_searchBox="xpath=//div[@class='chosen-search']/input";
		type(voice_number_penIcons_customer_shippingAddress_searchBox, "ada", "ada");
        String voice_number_penIcons_customer_shippingAddress_searchResult="xpath=//ul[@class='chosen-results']/li";
		
		logPass("Search Criteria workingas expected");
		logOut();
		
    }

	

	
}

