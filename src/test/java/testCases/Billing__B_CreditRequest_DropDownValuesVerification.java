package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Billing__B_CreditRequest_DropDownValuesVerification extends MediatorClass{
	
	 String fs= File.separator;
	    String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void verifyBilling(String zUserName, String zPassword) throws Throwable {

		//test Data
		String id="35560";
		
		logger = extent.startTest("Billing_CreditRequest_DropDownValuesVerification").assignCategory("Billing");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("Description:Verify credit type and reason in add credit");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
                waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		waitForElementPresent(CustomersTableCustomerName, 300);
		actionsClick(CustomersTableCustomerName);
		waitForElementPresent(customerHome_billing, 300);
        actionsClick(customerHome_billing, "Billing Menu");
		JSClick(billing_creditRequest, "Credit request");
		waitForElementPresent(billing_crediRequest_addNew, 300);
		actionsClick(billing_crediRequest_addNew, "Add new");
		waitForElementPresent(billing_addCustomerCredit_form_requestedBy, 300);
		
		List<String> l1=AddElementsIntoList("Select Value; Backdated Customer Disconnect Credit; Backdated Location Disconnect Credit; Backdated Removal of Services Credit; Backdated Renewal Credit; Billing Adjustment; Bill Start Date Credit; Migration Credit; Pricing Adjustment; Promotion Credit; Reconcilation Credit; Services Never Installed Credit; Shipping Charges Credit; Surcharge/Fees Credit");
		List<String> l2=AddElementsIntoList("Select Value; Billing Adjustment; Goodwill Credit-Surcharges/Fees; Goodwill Credit-Backdated Customer Disconnect; Goodwill Credit-Backdated Location Disconnect; Goodwill Credit-Backdated Removal of Services; Goodwill Credit-Backdated Renewal; Goodwill Credit-Bill Start Date; Goodwill Credit-Client Services Quality; Goodwill Credit-General; Goodwill Credit-Incorrect Pricing; Goodwill Credit-Long Distance; Goodwill Credit-NRC/Equipment; Goodwill Credit-Sales Quality; Goodwill Credit-Service Delivery Quality; Goodwill Credit-Service Outage Apeasement; Goodwill Credit-Services Never Installed; Goodwill Credit-Shipping Charges; Service Outage Credit");
		List<String> l3=AddElementsIntoList("Select Value; Fraud Usage Credit");
		List<String> l4=AddElementsIntoList("Select Value; Late Fee Credit");
		List<String> l5=AddElementsIntoList("Select Value; Long Distance Credit");
		List<String> l6=AddElementsIntoList("Select Value; NRC/Equipment Credit");
		List<String> l7=AddElementsIntoList("Select Value; Tax Credit");
		List<String> l8=AddElementsIntoList("Select Value; Write Off Credit");
		List<String> l9=AddElementsIntoList("Select Value; Write Off Credit");
		List<String> l10=AddElementsIntoList("Select Value; Write Off Credit");
		List<String> l11=AddElementsIntoList("Select Value; Write Off Credit");		
		
		@SuppressWarnings("rawtypes")
		List<List> ll=new ArrayList<List>();
		ll.add(l1);ll.add(l2);ll.add(l3);ll.add(l4);ll.add(l5);ll.add(l6);ll.add(l7);ll.add(l8);ll.add(l9);ll.add(l10);ll.add(l11);
		waitForElementPresent(billing_addCustomerCredit_form_creditType_DD, 300);
		int dropdownSize=getDropDownValues(billing_addCustomerCredit_form_creditType_DD, "").size();
		for (int i = 1; i < dropdownSize; i++) {
			Thread.sleep(10000);
			selectDropDownByIndex(billing_addCustomerCredit_form_creditType_DD, i);
			Thread.sleep(10000);
			waitForElementPresent(billing_addCustomerCredit_form_CreditReason_DD, 300);
			List<String> creditReasonList=getDropDownValuesText(billing_addCustomerCredit_form_CreditReason_DD, "");
			System.out.println(i+"th details ********* "+creditReasonList);
			System.out.println("loop size- "+i);
			logPass("Verified credit reson and credit type");
			for (int j = 0; j < creditReasonList.size(); j++) {
				System.out.println(ll.get((i-1)).get(j).toString());
				System.out.println(creditReasonList.get(j));
				Assert.assertTrue(ll.get((i-1)).get(j).toString().contains(creditReasonList.get(j)));
			}
			
		}
	  logOut();
	} 

}

