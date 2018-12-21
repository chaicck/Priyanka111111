package com.sugarAccountCreation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_Admin;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_Projects;
import demo.objectrepository.OR_ReconsiliationPage;
import demo.objectrepository.OR_Reports;
import demo.objectrepository.OR_SearchPage;

public class SuagrAccount extends CommonReusables implements OR_Projects, OR_Reports,OR_Admin, OR_SearchPage, OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC,OR_Inventory, OR_ReconsiliationPage {

	 @Test
	    public void suagrChildAccountCreation() throws Throwable {
		 
		 
		 
		 	String userName="ppundru";
		 	String password="Ramareddy1@";
		 	String customer_id="919614";
		 	String contract_id;
		 	

	        String sugar_comapniesMenu="link=Companies";
	        String sugar_createCompany="xpath=//div[@id=\"div_shortcuts\"]/ul/li/a";
	        String createACpmany_form_name = "id=name";
	        String createACpmany_form_market_DD="id=market_c";
	        String createACpmany_form_industry_DD="id=industry";
	        
	        String createACpmany_form_childOff_select="name=btn_parent_name";
	        
	        String childOff_newTab_nameSearch="id=name_advanced";
	        String childOff_newTab_1stChild="xpath=//*[@id='ext-gen2']/p[6]/table[2]/tbody/tr[3]/td[1]/a";	
	                                               //*[@id="ext-gen2"]/p[3]/table[2]/tbody/tr[3]/td[1]/a
	        String createACpmany_form_billingAddress_street="id=billing_address_street";
	        
	        String createACpmany_form_billingAddress_city="id=billing_address_city";
	        String createACpmany_form_billingAddress_state_DD="id=billing_address_state";
	        String createACpmany_form_billingAddress_postalCode="id=billing_address_postalcode";
	        String createACpmany_form_billingAddress_county="id=billing_address_country";   
	        String createACpmany_form_shippingAddress_street="id=shipping_address_street";
	        String createACpmany_form_shippingAddress_city="id=shipping_address_city";
	        String createACpmany_form_shippingAddress_state_DD="id=shipping_address_state";
	        String createACpmany_form_shippingAddress_postalcode="id=shipping_address_postalcode";
	        
	        String createACpmany_form_shippingAddress_county="id=shipping_address_country";
	        //String createACpmany_form_shippingAddress_saveBtn1="xpath=(//input[@value='Save'])";
	        String createACpmany_form_shippingAddress_saveBtn1="name=button";
	        String createACpmany_form_shippingAddress_saveBtn2="xpath=(//input[@value='Save'])[2]";
	       
	        
	        String createACpmany_form_billingAddress_verify="xpath=//a[@class='smarty-tag smarty-addr-billing smarty-tag-green']";
	        String createACpmany_form_shippingAddress_verify = "xpath=//a[@class='smarty-tag smarty-addr-shipping smarty-tag-green']";
	        
	        String createACpmany_form_copyAddress_checkBox="id=shipping_checkbox";
	        String createACpmany_form_Address_verify = "xpath=//a[@class='smarty-choice smarty-choice-override']";
	        
	        //Company home page
	        
	        String createACpmany_duplicateCompany_headLine="css=.h3Row tbody tr td h3";
	        
	        String createACpmany_Child_created ="xpth=//a[text()='Priyanka Reddy Child']";
	      String createAcompany_opportunities= "name=accounts_opportunities_create_button";
	      String createAcompany_opportunitiy_name ="xpath=//input[@name='name']";
	      
	      String createAcompany_opportunitiy_Market ="xpath=//select[@name='bill_group_c']";
	      String createAcompany_opportunitiy_Recurring_Amount ="xpath=//input[@id='amount']";
	      String createAcompany_opportunitiy_Expected_Proposal ="id=date_closed";
	      String createAcompany_opportunitiy_icbRequest_DD="id=icb_req_c";
	      String createAcompany_opportunitiy_save_button ="id=Opportunities_subpanel_save_button";
	      String createAcompany_opportunitiy_creditCheck="id=check_credit_c";
	      
	      //Proposal Creation    
	       String createACpmany_proposal_createBtn ="name=Quotes_create_button";
	       String createACpmany_proposal_form_subject="id=name";
	       String createACpmany_proposal_form_typeOfBusiness_DD="id=type_of_business_c"; //1
	       String createACpmany_proposal_form_proposalStage_DD="id=quote_stage";   //1
	       String createACpmany_proposal_form_proposal_type_DD="id=quote_type"; //1
	       String createACpmany_proposal_form_requestedInstallDate="id=requested_install_date_c";
	       String createACpmany_proposal_subjectListTable="xpath=//*[@id='list_subpanel_quotes']/table/tbody/tr/td[2]";
	       
	       String createACpmany_proposal_editBtn="id=edit_button";
	       String createACpmany_proposal_form_oppourtunityName="name=btn_opportunity_name";
	       String createACpmany_proposal_oppourtunitySearch_1stOption="xpath=//*[@id='ext-gen2']/p[3]/table[2]/tbody/tr[3]/td[1]/a";	
	       
	       String createACpmany_proposal_form_addRow="xpath=//input[@name='Add Row']";
	       String createACpmany_proposal_form_addRow_search="id=name_1"; //advanced
	       
	    // Contacts creation

	        String createAcompany_contacts_createBtn="id=accounts_contacts_create_button"; 
	        String createAcompany_contacts_form_firstName="id=first_name";
	        String createAcompany_contacts_form_lastName="id=last_name";
	        String createAcompany_contacts_form_emailAddress="id=emailAddress0";
	        String createAcompany_contacts_form_saveBtn="id=Contacts_subpanel_save_button";
	        String createAcompany_contacts_table_emailList="xpath=//*[@id='list_subpanel_contacts']/table/tbody/tr/td[3]/span/a";
	        String createAcompany_contacts_table_editLink="xpath=(//*[@id='list_subpanel_contacts']/table/tbody/tr/td[14]/span/a)[%s]";
	       
	        String createAcompany_contacts_edit_contactType_checkBoxs1="xpath=(//div[@id='LBL_PANEL1']/table/tbody/tr/td[2])/input[2]";
	        String createAcompany_contacts_edit_contactType_checkBoxs2="xpath=(//div[@id='LBL_PANEL1']/table/tbody/tr/td[4])/input[2]";
	        
	        String createAcompany_admin = "xpath=//a[text()='Admin']";
		     
			 //user management
			      
			      String createAcompany_userhome_account = "xpath=(//a[@class='listViewTdLinkS1'])[1]";
			      String createAcompany_usermanagement_edit = "name=Edit";
			      
			      String createAcompany_usermanagement_discountlevel ="name=discounting_level";
			      String createAcompany_usermanagement = "xpath=//a[text() ='User Management']";
			      String createAcompany_usermanagement_save = "xpath=(//input[@name='button'])[1]";
			      
			      // edit proposal/discount level
			      
			      String createAcompany_Accounte_click = "xpath=(//a[@class='lastViewLink'])[3]";
			      String createAcompany_Account_edit = "id=edit_button";
			      
			      String createAcompany_Account_proposal_subject = "xpath=(//a[@class='listViewTdLinkS1'])[4]";
			      String createAcompany_Account_proposal_discountchange ="xpath=//input[@id='discount_price_1']";
			      //pdf print
			      
			      String createAcompany_Account_pdf_print =  "xpath=//input[@value='Print as PDF']";
			      String createAcompany_Account_deposit_required ="id=deposit_required_c";
			      String createAcompany_Account_deposit_received ="id=deposit_received_c";
			      String createAcompany_Account_deposit_dnb_score ="id=dnb_score_c";
			      String createAcompany_Account_deposit_deposit ="id=deposit_terms_c";
			      String form_headerLocators="xpath=//td[@class='subTabBar']/table/tbody/tr[2]/td/table/tbody/tr/td/span";
          
	     
	      
	        
	        logger = extent.startTest("Suagr Child Account Creation");
	        type(sugar_username, userName, "view In sugar Username");
	        type(sugar_password,password, "view In sugar Password");
	        click(sugar_loginBtn, "login Button");
	        waitForElementPresent(sugar_comapniesMenu, 20);
	        actionsClick(sugar_comapniesMenu);
	        actionsClick(sugar_createCompany);
	        
	        String name="Priyanka "+getRandomString(2)+" Parent";
	        type(createACpmany_form_name, name, "");
	        selectDropDownByIndex(createACpmany_form_market_DD, 2);
	        selectDropDownByIndex(createACpmany_form_industry_DD, 2);
	        
	        /*
	        actionsClick(createACpmany_form_childOff_select);
	       	navigateToChild();
	        maximise();
	        Thread.sleep(1000);
	        type(childOff_newTab_nameSearch, "priyanka", "");
	        type(childOff_newTab_nameSearch,"search box",Keys.ENTER);
	        
	        Thread.sleep(1000);
	        actionsClick(childOff_newTab_1stChild);
	        
	        
	        navigateBackToParentWindow();   */
	        type(createACpmany_form_billingAddress_street, "2605 Wildberry Ct", "");
	        type(createACpmany_form_billingAddress_city, "Edison", "");
	        //selectDropDownByIndex(createACpmany_form_billingAddress_state_DD, 3);
	        type(createACpmany_form_billingAddress_postalCode, "08817", "");
	        type(createACpmany_form_billingAddress_postalCode,"search box",Keys.ENTER);
	        
	       //scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
	        Thread.sleep(4000);
	       actionsClick(createACpmany_form_shippingAddress_saveBtn1);
	       Thread.sleep(2000);
	      
	       if(verifyElementText(createACpmany_duplicateCompany_headLine, "Possible Duplicate Company")) {	        	
	    	   actionsClick(createACpmany_form_shippingAddress_saveBtn1);	        	
		      } 
	              
	        waitForElementPresent(createAcompany_opportunities, 20);
	        scrollElementIntoView(createAcompany_opportunities);
	        click(createAcompany_opportunities, "Opportunity created");
	        type(createAcompany_opportunitiy_name, "Priyanka Test", "Opportunitiy_name type");
	        selectDropDownByIndex(createAcompany_opportunitiy_Market, 2);
	        type(createAcompany_opportunitiy_Recurring_Amount, "1000", "Recurring Amount Entered");
	        type(createAcompany_opportunitiy_Expected_Proposal, dateAftersomeDays(30,"MM/dd/yyy"), "Expected proposal date");
	        selectDropDownByIndex(createAcompany_opportunitiy_icbRequest_DD, 2);
	        
	        actionsClick(createAcompany_opportunitiy_creditCheck);
	        actionsClick(createAcompany_opportunitiy_save_button);
	        
// Contacts creation

	        Thread.sleep(5000);
	        waitForElementToBeClickable(createAcompany_contacts_createBtn);
	        scrollElementIntoView(createAcompany_contacts_createBtn);
	        actionsClick(createAcompany_contacts_createBtn);
	        type(createAcompany_contacts_form_firstName, "Priyanka", "");
	        type(createAcompany_contacts_form_lastName, "Reddy"+getRandomString(2), "");
	        String email="Priyanka"+getRandomString(2)+"@gmail.com";
	        type(createAcompany_contacts_form_emailAddress,email , "");
	        Thread.sleep(1000);
	        actionsClick(createAcompany_contacts_form_saveBtn);
	        Thread.sleep(4000);
	        
	         verifyTextInColumnClickOtherColumn(createAcompany_contacts_table_emailList, createAcompany_contacts_table_editLink, email);
	        checkAll(createAcompany_contacts_edit_contactType_checkBoxs1);
	        checkAll(createAcompany_contacts_edit_contactType_checkBoxs2);
	        actionsClick(createACpmany_form_shippingAddress_saveBtn1);
	        Thread.sleep(5000);
	        //Need to write to verify 1's updated in the table
	  
	        //Proposal Creation    
	      
	       scrollElementIntoView(createACpmany_proposal_createBtn);
	       actionsClick(createACpmany_proposal_createBtn);
	       String proposal_subject="Test Proposal"+getRandomString(2);
	       type(createACpmany_proposal_form_subject, proposal_subject, "");
	       selectDropDownByIndex(createACpmany_proposal_form_typeOfBusiness_DD, 1);
	       selectDropDownByIndex(createACpmany_proposal_form_proposalStage_DD, 1);
	       selectDropDownByIndex(createACpmany_proposal_form_proposal_type_DD, 1);
	       type(createACpmany_proposal_form_requestedInstallDate, dateAftersomeDays(5, "MM/dd/yyyy"), "");
	       scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
	       actionsClick(createACpmany_form_shippingAddress_saveBtn2);
	       Thread.sleep(5000);
	       
	       scrollElementIntoView(createACpmany_proposal_createBtn);	       
	       verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable,proposal_subject);
	       
	       waitForElementToBeClickable(createACpmany_proposal_editBtn);
	       actionsClick(createACpmany_proposal_editBtn);    
	       
	        actionsClick(createACpmany_proposal_form_oppourtunityName);
	       	navigateToChild();
	        maximise();
	        Thread.sleep(1000);
	        type(childOff_newTab_nameSearch, "test", "");
	        type(childOff_newTab_nameSearch,"search box",Keys.ENTER);
	        
	        Thread.sleep(1000);
	        actionsClick(createACpmany_proposal_oppourtunitySearch_1stOption);  
	        navigateBackToParentWindow(); 
	        
	        scrollElementIntoView(createACpmany_proposal_form_addRow);
	        actionsClick(createACpmany_proposal_form_addRow);
	        type(createACpmany_proposal_form_addRow_search, "advanced", "");
	        Thread.sleep(3000);
	        type(createACpmany_proposal_form_addRow_search,"search box",Keys.ENTER);
	        actionsClick(createACpmany_form_shippingAddress_saveBtn2);
	        
	        //Admin
	        
	        Thread.sleep(1000);
	        
	        actionsClick(createAcompany_admin);   
	        actionsClick(createAcompany_usermanagement);
	        actionsClick(createAcompany_userhome_account);
	        actionsClick(createAcompany_usermanagement_edit); 
            selectDropDownByValue(createAcompany_usermanagement_discountlevel, "gm");	
            actionsClick(createAcompany_usermanagement_save);

	    
           // proposal row discount check
           
            verifyTextPresentInLinkAndClick(form_headerLocators, name);
            actionsClick(createAcompany_Accounte_click);
            //wrong
            //actionsClick(createAcompany_Account_edit);
           /* scrollElementIntoView(createAcompany_Account_proposal_subject);
 	        actionsClick(createAcompany_Account_proposal_subject);
 	       waitForElementToBeClickable(createACpmany_proposal_editBtn);
	       actionsClick(createACpmany_proposal_editBtn);  
 	        
	       scrollElementIntoView(createAcompany_Account_proposal_discountchange);
	       
	       clearText(createAcompany_Account_proposal_discountchange);
	        type(createAcompany_Account_proposal_discountchange, "50", " ");
	        Thread.sleep(2000);
	        type(createAcompany_Account_proposal_discountchange,"search box",Keys.ENTER);*/
	        
	        //pdf format
	        
	      //actionsClick(createAcompany_Account_pdf_print);
	        
	        //actionsClick(createAcompany_Accounte_click);
	        Thread.sleep(2000);
	        /*verifyTextPresentInLinkAndClick(form_headerLocators, name); */
	        actionsClick(createAcompany_Account_edit);	       
	        scrollElementIntoView(createAcompany_Account_deposit_required);
	        
	        type(createAcompany_Account_deposit_required, "0", "");
	        type(createAcompany_Account_deposit_received, "0", "");
	        type(createAcompany_Account_deposit_dnb_score, "0", "");
	        type(createAcompany_Account_deposit_deposit, "0", "");
	        actionsClick(createACpmany_form_shippingAddress_saveBtn2);
	        
	        
	        scrollElementIntoView(createACpmany_proposal_createBtn);	       
		    verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable,proposal_subject);
		     
		   //wrong 
	        /*scrollElementIntoView(createAcompany_Account_proposal_subject);
 	        actionsClick(createAcompany_Account_proposal_subject);*/
	      //actionsClick(createAcompany_Account_pdf_print);
	       
		    String createACpmany_proposal_saveAsPdf ="xpath=//input[@value='Print as PDF']";
	        actionsClick(createACpmany_proposal_saveAsPdf);
	        Thread.sleep(10000);
	        navigateBack();
	        Thread.sleep(1000);
	        actionsClick(createAcompany_Account_edit);
	       
	        //GM approved Pending
	       
 	        
 	       // Child Creation    
		 
 	        actionsClick(sugar_comapniesMenu);
	        actionsClick(sugar_createCompany);
	        
	        String name_child="Priyanka "+getRandomString(2)+" Child";
	        type(createACpmany_form_name, name_child, "");
	        selectDropDownByIndex(createACpmany_form_market_DD, 1);
	        selectDropDownByIndex(createACpmany_form_industry_DD, 1);
	        
	      
	        actionsClick(createACpmany_form_childOff_select);
	       	navigateToChild();
	        maximise();
	        Thread.sleep(1000);
	        type(childOff_newTab_nameSearch, name, "");
	        type(childOff_newTab_nameSearch,"search box",Keys.ENTER);
	        
	        Thread.sleep(1000);
	        actionsClick(childOff_newTab_1stChild);       
	        
	        navigateBackToParentWindow();   
	        
	        type(createACpmany_form_billingAddress_street, "2605 Wildberry Ct", "");
	        type(createACpmany_form_billingAddress_city, "Edison", "");
	        //selectDropDownByIndex(createACpmany_form_billingAddress_state_DD, 3);
	        type(createACpmany_form_billingAddress_postalCode, "08817", "");
	        type(createACpmany_form_billingAddress_postalCode,"search box",Keys.ENTER);
	        
	       //scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
	        Thread.sleep(4000);
	       actionsClick(createACpmany_form_shippingAddress_saveBtn1);
	       Thread.sleep(2000);
	      
	       if(verifyElementText(createACpmany_duplicateCompany_headLine, "Possible Duplicate Company")) {	        	
	    	   actionsClick(createACpmany_form_shippingAddress_saveBtn1);	        	
		      } 
	              
	        waitForElementPresent(createAcompany_opportunities, 20);
	        scrollElementIntoView(createAcompany_opportunities);
	        click(createAcompany_opportunities, "Opportunity created");
	        type(createAcompany_opportunitiy_name, "Priyanka Test", "Opportunitiy_name type");
	        selectDropDownByIndex(createAcompany_opportunitiy_Market, 2);
	        type(createAcompany_opportunitiy_Recurring_Amount, "1000", "Recurring Amount Entered");
	        type(createAcompany_opportunitiy_Expected_Proposal, dateAftersomeDays(30,"MM/dd/yyy"), "Expected proposal date");
	        selectDropDownByIndex(createAcompany_opportunitiy_icbRequest_DD, 2);
	        
	        actionsClick(createAcompany_opportunitiy_creditCheck);
	        actionsClick(createAcompany_opportunitiy_save_button);

	        // contacts creation - child
	        Thread.sleep(5000);
	        waitForElementToBeClickable(createAcompany_contacts_createBtn);
	        scrollElementIntoView(createAcompany_contacts_createBtn);
	        actionsClick(createAcompany_contacts_createBtn);
	        type(createAcompany_contacts_form_firstName, "Priyanka", "");
	        type(createAcompany_contacts_form_lastName, "Reddy"+getRandomString(2), "");
	        String email_child="Priyanka"+getRandomString(2)+"@gmail.com";
	        type(createAcompany_contacts_form_emailAddress,email_child , "");
	        Thread.sleep(1000);
	        actionsClick(createAcompany_contacts_form_saveBtn);
	        Thread.sleep(4000);
	        
	         verifyTextInColumnClickOtherColumn(createAcompany_contacts_table_emailList, createAcompany_contacts_table_editLink, email_child);
	        checkAll(createAcompany_contacts_edit_contactType_checkBoxs1);
	        checkAll(createAcompany_contacts_edit_contactType_checkBoxs2);
	        actionsClick(createACpmany_form_shippingAddress_saveBtn1);
	        Thread.sleep(5000);
	        //Need to write to verify 1's updated in the table
	        
 	    // child Proposal creation
	        
	        //Proposal Creation    
		      
		       scrollElementIntoView(createACpmany_proposal_createBtn);
		       actionsClick(createACpmany_proposal_createBtn);
		       String proposal_subject_child="Test Proposal"+getRandomString(2);
		       type(createACpmany_proposal_form_subject, proposal_subject_child, "");
		       selectDropDownByIndex(createACpmany_proposal_form_typeOfBusiness_DD, 2);
		       selectDropDownByIndex(createACpmany_proposal_form_proposalStage_DD, 1);
		       selectDropDownByIndex(createACpmany_proposal_form_proposal_type_DD, 1);
		       type(createACpmany_proposal_form_requestedInstallDate, dateAftersomeDays(5, "MM/dd/yyyy"), "");
		       scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
		       actionsClick(createACpmany_form_shippingAddress_saveBtn2);
		       Thread.sleep(5000);
		       
		       scrollElementIntoView(createACpmany_proposal_createBtn);	       
		       verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable,proposal_subject_child);
		       waitForElementToBeClickable(createACpmany_proposal_editBtn);
		       actionsClick(createACpmany_proposal_editBtn);    
		       
		        actionsClick(createACpmany_proposal_form_oppourtunityName);
		       	navigateToChild();
		        maximise();
		        Thread.sleep(1000);
		        type(childOff_newTab_nameSearch, "test", "");
		        type(childOff_newTab_nameSearch,"search box",Keys.ENTER);
		        
		        Thread.sleep(1000);
		        actionsClick(createACpmany_proposal_oppourtunitySearch_1stOption);  
		        navigateBackToParentWindow(); 
		        
		        scrollElementIntoView(createACpmany_proposal_form_addRow);
		        actionsClick(createACpmany_proposal_form_addRow);
		        type(createACpmany_proposal_form_addRow_search, "advanced", "");
		        Thread.sleep(1000);
		        type(createACpmany_proposal_form_addRow_search,"search box",Keys.ENTER);
		        actionsClick(createACpmany_form_shippingAddress_saveBtn2);
	       
	 }
	
	




	/*private String dateAftersomeDays(int i, String Dateformat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
SimpleDateFormat format = new SimpleDateFormat(Dateformat);
		return format.format(cal.getTime());
	}*/

	private void Verify(String menu,String submenu, String textElement, String text) throws Throwable {
			click(customerHome_billing,"customerHome billing");
			actionsClick(menu);	
			JSClick(submenu);	
	        waitForElementPresent(textElement, 200);
	        verifyText(textElement,  text, "Verifying HeadLine text");
		}
	 public boolean verifyElementText(String locator, String text){
		   try {
			if(getElement(locator).getText().contains(text))
				return true;		
		} catch (Exception e) {		  
			   return false;		   
		}
		   return false;
	   }
}
