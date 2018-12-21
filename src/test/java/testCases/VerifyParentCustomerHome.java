package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class VerifyParentCustomerHome extends MediatorClass{
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void verifyParentCustomerHome(String zUserName, String zPassword) throws Throwable {
   
		//Customer dashboard
		String customer_dashboard_id = "id=customer_id";
		String customer_dashboard_account_status = "id=account_status";
		String Customer_dashboard_enterprise = "id=enterprise";
		String Customer_dashboard_thirdparty_tool = "xpath=//a[@href='#thirdPartyToolsTable']";
		String Customer_dashboard_ticket = "xpath=//*[@id=\"ticket_table\"]/caption";
		String Customer_dashboard_contract_timeline = "xpath=//a[@href='#timeline_collapse_1']";
		String Customer_dashboard_project_timeline = "xpath=//a[@href='#timeline_collapse_2']";
		String Customer_dashboard_notes = "xpath=//h1[text()='Notes']";
		String Customer_dashboard_ticket_timeline = "xpath=//a[@href='#timeline_collapse_3']";
		String Customer_dashboard_Enganeering_ICB = "xpath=//table[@id='eicb_table']";
		String Customer_dashboard_Open_mac = "id=mac_table";
		String Customer_dashboard_dispatch ="id=dispatch_table";
		String add_Contact = "xpath=//a[starts-with(@href,'/customer/editContact/customer_id')]"; 
		String add_Contact_emailadress = "id=email_address";
		String add_Contact_firtst_name ="id=first_name";
		String add_Contact_last_name ="id=last_name";
		String add_Contact_title ="id=title";
		String add_Contact_department ="id=department";
		String add_Contact_description ="id=description";
		String add_Contact_phone_work = "id=phone_work";
		String add_Contact_mobile_phone ="id=phone_mobile";
		String add_Contact_fax_number ="id=phone_fax";
		String add_Contact_other_phone ="id=phone_other";
		String add_Contact_save = "xpath=//button[@name='save']";
		String add_Contact_isprimary = "xpath=//label[@for='is_primary']";
		String add_Contact_isonsite = "xpath=//label[@for='is_onsite']";
		String add_Contact_isbilling = "xpath=//label[@for='is_billing']";
		String add_Contact_istech = "xpath=//label[@for='is_tech']";
		String add_Contact_isafter = "xpath=//label[@for='is_afterhours']";
		String add_contact_isauthorized = "xpath=//label[@for='is_authorized']";
		//String  contact_tabel = "xpath=//table[@id='contacts_table']";
		String  contact_tabel = "xpath=//*[@id='contacts_table']/tbody/tr/td[%s]";      
		String contact_saved_verifytext = "xpath=//span[text()='Contact Saved']";
		String coustomer_dashboard = "id=notification-dashboard";
		String Contact_collapsed = "xpath=//a[@href='#contactTable']";
		String Contact_magnifyingglass = "xpath=(//*[@id='contacts_table']/tbody/tr/td[1]/a)[%s]";
		String contact_delete = "xpath=//a[starts-with(@href,'/customer/deleteContactModal/contact_id')]";
		String contact_delete_from_all_locations = "xpath=//button[@id='btn-deleteAll']";
		String delete_contact_window = "xpath=//a[@class='close']";
		String contact_delete_verify_text = "xpath=//h4[text()='Delete Contact']";	
		String contact_deleted_verify_text = "xpath=//span[text()='Contact deleted from all locations.']";
		
	
		logger = extent.startTest("VerifyParentCustomerHome");
		logInfo("Currently Running on -- "+getCurrentUrl());
		 logInfo("TestCase Description:Verify Customer DashBoard-Add Contact and Save");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");

		String customer_id = "34596";
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  


		
		String emailadress = "priyanka"+randomString(2)+"@gmail.com";
		String firstname = "priyanka"+randomString(3);
		String lastname = "automation"+randomString(3);
		waitForElementPresent(add_Contact, 300);
		scrollElementIntoView(add_Contact);
		waitForElementPresent(add_Contact, 300);
		JSClick(add_Contact, "add contact");
		Thread.sleep(6000);
		navigateToChild();
		waitForElementPresent(add_Contact_save, 300);
		click(add_Contact_save, "Save");
		waitForElementPresent(add_Contact_emailadress, 300);
	    type(add_Contact_emailadress, "qwerthj", "Email adress enterd on wrong fprmat");
		waitForElementPresent(add_Contact_save, 300);
		click(add_Contact_save, "Save");
		waitForElementPresent(add_Contact_emailadress, 300);
		type(add_Contact_emailadress, emailadress, "email adress entered");
		type(add_Contact_firtst_name, firstname, "first_name");
		type(add_Contact_last_name, lastname, "last_name");
		type(add_Contact_title, "Automation test", "Title");
		type(add_Contact_department, "Test enganeer", "department");
		type(add_Contact_description, "Testing", "Description");
		type(add_Contact_phone_work, "1234567890", "phone_work");
		type(add_Contact_mobile_phone, "0987654321", "Mobile_phone");
		type(add_Contact_fax_number, "123", "Fax_number");
		type(add_Contact_other_phone, "78901234567", "Other Phone");
		scrollElementIntoView(add_Contact_isprimary);
		click(add_Contact_isprimary, "Is primary");
		click(add_Contact_isonsite, "Is onsite");
		click(add_Contact_isbilling, "Is billing");
		click(add_Contact_istech, "Is_tech");
		click(add_Contact_isafter, "Is ofter");
		click(add_contact_isauthorized, "Is Authorized");
		waitForElementPresent(add_Contact_save, 300);
		scrollUp();
		scrollElementIntoView(add_Contact_save);
		click(add_Contact_save, "Contact Save");  
		waitForElementPresent(contact_saved_verifytext, 300);
        verifyText(contact_saved_verifytext, "Contact Saved", "Contact saved sucessfully");
        waitForElementPresent(coustomer_dashboard, 300);
        JSClick(coustomer_dashboard);
        waitForElementPresent(Contact_collapsed, 300);
        scrollElementIntoView(Contact_collapsed);
        JSClick(Contact_collapsed, "contacts");
        waitForElementPresent(contact_tabel, 300);
        verifyTextInColumnClickOtherColumn(contact_tabel, Contact_magnifyingglass, firstname);
    	navigateToChild();
    	logOut();
      
		
}
	
}
