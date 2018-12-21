package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_69_VerifyUserAbilityToSelectTypeOfCustomer extends MediatorClass{
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tC_1_69_VerifyUserAbilityToSelectTypeOfCustomer(String zUserName, String zPassword) throws Throwable {

		String customerDashboard_childCustomerLink="xpath=//*[@id='header_crumbs']/li[3]/a[2]";

		String customer_name="nextcare - AZ - greenway";

		logger = extent.startTest("1.69 Test ID : 16366 - Verify if user has the ability to select the type of customer Field Label").assignCategory("Customer_DashBoard");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Check that the user gets to select any of the three customer types as follows: platinum\r\n" + 
				"VIP ,standard ,VIP and save must save selection on the page using the save button for any customer ");
		 type(userNameTxt, zUserName, "User name");
			type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
		type(searchTextBox, customer_name, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		if(verifyElementText(customerTableHeadline, "Customers")) {			
			Thread.sleep(1000);
			actionsClick(customerNameList);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");				
		actionsClick(customerDashboard_customerLink);		
		actionsClick(customerDashBoard_editBtn);		
		logInfo("Working on parent customer "+getText(customer_dashboard_name));
		selectDropDownByVisibleText(customerDashBoard_customerVipType_DD, "Platinum VIP");
		Thread.sleep(1000);
		selectDropDownByVisibleText(customerDashBoard_customerVipType_DD, "Platinum VIP");
		//verifying icon displayed
		String icon=getAttributeValue(customerDashBoard_customerVipIcon, "style");
		System.out.println(icon);
		Assert.assertTrue(icon.contains("red"));	//&&icon.contains("inline-block")

		selectDropDownByVisibleText(customerDashBoard_customerVipType_DD, "Standard");		
		//verifying icon displayed
		icon=getAttributeValue(customerDashBoard_customerVipIcon, "style");
		System.out.println(icon);
		Assert.assertTrue(icon.contains("display: none;"));	

		selectDropDownByVisibleText(customerDashBoard_customerVipType_DD, "VIP");
		//verifying icon displayed
		icon=getAttributeValue(customerDashBoard_customerVipIcon, "style");
		System.out.println(icon);
		Assert.assertTrue(icon.contains("blue")); //&&icon.contains("inline-block")

		actionsClick(customerDashBoard_edit_saveBtn);
		Thread.sleep(3000);
		scrollUp();
		scrollElementIntoView(customerDashBoard_customerVipType_DD);
		System.out.println("selected value "+getDropdownSelectedValue(customerDashBoard_customerVipType_DD));
		
		Assert.assertTrue(getDropdownSelectedValue(customerDashBoard_customerVipType_DD).contains("VIP"));
		logInfo("selected value under customer Type DropDown in Parent is "+getDropdownSelectedValue(customerDashBoard_customerVipType_DD));


		//Navigating to child
		Thread.sleep(8000);
		
		String url=null;
		if(getCurrentUrl().contains("qa5")) {
		url="https://zeus.qa5.vonagenetworks.net";		
		}
		else if (getCurrentUrl().contains("qa6")) {
			url="https://zeus.qa6.vonagenetworks.net";			
		}
		else {
			url="https://master-hades.hydra.dev.vonagenetworks.net";			
		}
		navigateTo(url);
		waitForElementPresentE(srchTxt, 20);
		type(srchTxt, customer_name,"searchBox");
		type(srchTxt,"Search box",Keys.ENTER);   
		if(verifyElementText(customerTableHeadline, "Customers")) {			
			Thread.sleep(1000);
			actionsClick(customerNameList);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");

		actionsClick(customerDashboard_childCustomerLink);
		waitForElementPresent(customerDashBoard_customerVipType_DD, 200);
		Assert.assertTrue(getDropdownSelectedValue(customerDashBoard_customerVipType_DD).contains("VIP"));
		logPass("Default selected value under customerType DropDown in child is "+getDropdownSelectedValue(customerDashBoard_customerVipType_DD));
		logOut();		

	}


}
