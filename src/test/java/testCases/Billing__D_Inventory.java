package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Billing__D_Inventory extends MediatorClass{

	 String fs= File.separator;
	 String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void billing_Inventory(String zUserName, String zPassword) throws Throwable {
		 
		    String Billing = "xpath=//span[text()='Billing']";
			String Billing_contract =  "id=notification-contracts";
		    String Billing_inventory = "id=notification-inventory";
			String Billing_inventory_Bulkedit = "id=bulk_edit_button";
			String Billing_inventory_export = "xpath=//a[@class='btn btn-success btn-sm pull-right']";
			String Billing_inventory_search_export = "xpath=//a[@class='btn btn-success btn-sm pull-right']";
			String  Billing_inventory_history = "id=notification-inventory-history";
			String  Billing_inventory_history_export = "xpath=//a[@class='btn btn-success btn-sm pull-right']";
			
		
		 
			String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		 
		    logger = extent.startTest("Billing_Inventory").assignCategory("Billing");
		logInfo("Currently Running on -- "+getCurrentUrl());
		    logInfo("TestCase Description: Inventory use nextcare parent account, perfrom Bulk Edit, Export the data. ");
		    type(userNameTxt, zUserName, "User name");
			type(passTxt, zPassword, "Password");
		    click(submitBtn, "Submit button");
		    String url=null;
			if(getCurrentUrl().contains("qa5")) {
			url="https://zeus.qa5.vonagenetworks.net/inventory/listByCustomer/customer_id:"+customer_id;		
			}
			else if (getCurrentUrl().contains("qa6")) {
				url="https://zeus.qa6.vonagenetworks.net/inventory/listByCustomer/customer_id:"+customer_id;			
			}
			else {
				url="https://zeus.qa5.vonagenetworks.net/inventory/listByCustomer/customer_id:"+customer_id; //keep preDev URL			
			}
			System.out.println(url);
			navigateTo(url);
		   // navigateTo("https://zeus.qa5.vonagenetworks.net/inventory/listByCustomer/customer_id:26396");
		   JSClick(Billing_inventory_Bulkedit, "Billing_inventory_Bulkedit");
		   acceptAlert();
		   JSClick(Billing_inventory_export, "Billing_inventory_export button clicked");			
			   
			    click(srchDd,"Search");   
		        click(search_inventory,"Inventory"); 
		        waitForElementPresent(search_inventorySearchbox, 300);
		        type(search_inventorySearchbox, "0004F26A67C4","Search box");
		        type(search_inventorySearchbox,"Search 0004F26A67C4",Keys.ENTER); 
		        verifyText(inventoryTableName, "Inventory", "Inventory Table Name");
		        JSClick(Billing_inventory_search_export, "Billing_inventory_search_export button clicked");
		        url.replace("listByCustomer", "historyByCustomer");
		        System.out.println(url);
		        navigateTo(url);
		        JSClick(Billing_inventory_history_export, "Billing_inventory_history_export button cliked");
		        logOut();
			

}
}
