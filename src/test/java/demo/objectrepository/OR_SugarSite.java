package demo.objectrepository;

public interface OR_SugarSite {
	
	
//**************** Locators ****************
  String sugar_comapniesMenu="link=Companies";
  String sugar_createCompany="xpath=//div[@id='div_shortcuts']/ul/li/a";
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
 
  String createACpmany_companyId="xpath=//div[@id='DEFAULT']/table/tbody/tr[1]/td[2]";
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
	      String createACpmany_proposal_saveAsPdf ="xpath=//input[@value='Print as PDF']";


}
