package demo.objectrepository;

public interface OR_Voice {

	String voice_menu ="id=notification-voice";
	String voice_menu_faxmail ="id=notification-faxmail";
	String voice_menu_faxmail_records ="id=user_table";
	String voice_number_penIcons_customer_shippingAddress_DD_edit="id=customer_edit";
	String voice_number_penIcons_customer_shippingAddress_DD="id=customer_id_chosen";
	
	//String voice_menu="id=dd-Voice";
	String voice_notification_faxmail="id=notification-faxmail";
	String voice_notification_faxmail_addUser="xpath=//a[starts-with(@href,'/fax/add/customer_id')]";
	String voice_notification_faxmail_addUser_number_DD="id=tn_id";
	String voice_notification_faxmail_addUser_inboundEmail="id=inbound_email";
	String voice_notification_faxmail_addUser_addBtn="id=addFaxMailUser";
	String voice_notification_faxmail_addUser_faxMailUserMenu="xpath=(//a[starts-with(@href,'/fax/listByCustomer/customer_id')])[3]";
	
	String voice_notification_faxmail_numberDelete_Table="xpath=(//*[@id='user_table']/tbody/tr[%s]/td[1]/a)[2]";
	String voice_notification_faxmail_recipients_Table="xpath=//*[@id='user_table']/tbody/tr/td[3]";
	String voice_notification_faxmail_successMsgAccept="xpath=//button[@class='btn btn-default center-block']";

	String voice_notificationBroadWorks="xpath=(//span[@id='notification-broadworks'])[2]";		
	String voice_notificationBroadWorks_platform_configuration="xpath=(//*[@id='notification-platform-configuration'])[2]";
	String voice_notificationBroadWorks_platform_configuration_nameLabel="xpath=(((//div[@class='row'])[2]/div/div/label)[1])[1]";
	String voice_notificationBroadWorks_platform_configuration_codeLabel="xpath=((//div[@class='row'])[2]/div/div/label)[2]";
	String voice_notificationBroadWorks_platform_configuration_ProvisioningLabel="xpath=((//div[@class='row'])[2]/div/div/label)[3]";
	String voice_notificationBroadWorks_platform_configuration_BillingLabel="xpath=((//div[@class='row'])[2]/div/div/label)[4]";
	String voice_notificationBroadWorks_platform_configuration_CRMLabel="xpath=((//div[@class='row'])[2]/div/div/label)[5]";
	String voice_notificationBroadWorks_platform_configuration_DeviceManagementLabel="xpath=((//div[@class='row'])[2]/div/div/label)[6]";
	String voice_notificationBroadWorks_platform_configuration_PopRegionsLabel="xpath=((//div[@class='row'])[2]/div/div/label)[7]";
	String voice_notificationBroadWorks_platform_configuration_DBMailLabel="xpath=((//div[@class='row'])[2]/div/div/label)[8]";
	String voice_notificationBroadWorks_platform_configuration_CircuitProfileLabel="xpath=((//div[@class='row'])[2]/div/div/label)[9]";
	
	String voice_notificationBroadWorks_platform_configuration_Provisioning_DD="id=broadworks";
	String voice_notificationBroadWorks_platform_configuration_saveBtn="xpath=(//button[@type='submit'])[2]";
	String voice_notificationBroadWorks_platform_configuration_saveBtn_successPopUp="xpath=//button[@class='btn btn-default center-block']";
	
	// Numbers

	String customer_notification_voice_number_importNumbers="xpath=(//a[starts-with(@href,'/tn/import/customer_id')])[2]";
	String number_importNumbers_tnImport_status_DD="id=status";
	String number_importNumbers_tnImport_carrierName_DD="id=carrier_name";
	String number_importNumbers_tnImport_numberList="xpath=//div[@id='import_accordion']/div/div/a";
	String number_importNumbers_tnImport_numberListTextbox="id=tn_blob";
	String number_importNumbers_tnImport_saveBtn="xpath=(//button[@type='submit'])[2]";
	String number_importNumbers_tableStartNumbers="xpath=//*[@id='number_table']/tbody/tr/td[8]";
	String number_importNumbers_tableDeleteOption="xpath=//*[@id='number_table']/tbody/tr[%s]/td[3]/a";
	
	String voice_Number_NumberRange_title="xpath=//*[@id='number_table']/caption";
    String voice_Number_NumberRange_penIcons="xpath=//*[@id='number_table']/tbody/tr/td[1]";
    String voice_Number_NumberRange_penIcons_paraMetarised="xpath=//*[@id='number_table']/tbody/tr[%s]/td[1]/a";
    
    String voice_Number_NumberRange_penIconsMany="xpath=//*[@id='number_table']/tbody/tr[1]/td[1]/div/ul/li[1]/a";
    String voice_Number_manage="xpath=//button[@data-target='#manageNumbers']";
    String voice_Number_manage_checkBox="xpath=//*[@id='manage_number_table']/tbody/tr[1]/td[1]"; 
    String voice_Number_manage_searchBox="xpath=//div[@id='manage_number_table_filter']/label/input";
    String voice_Number_manage_TN="xpath=//*[@id='manage_number_table']/tbody/tr[1]/td[2]";
    String voice_Number_manage_moveCheckedTnsBtn="name=move_checked_tns";
    String voice_Number_manage_moveCheckedTnsBtn_description="id=description";
    String voice_Number_manage_moveCheckedTnsBtn_customerIDChoosen="id=to_customer_id_chosen";
    String voice_Number_manage_moveCheckedTnsBtn_customerIDChoosen_search="xpath=(//input[@type='text'])[2]";
    String voice_Number_manage_moveCheckedTnsBtn_save="xpath=//button[text()='Save']";
    
    String voice_Number_manage_table_start="xpath=//*[@id='number_table']/tbody/tr/td[8]";
    
    String voice_number_penIcons_customer_shippingAddress_searchBox="xpath=//div[@class='chosen-search']/input";
    String voice_number_penIcons_customer_shippingAddress_searchResult="xpath=//ul[@class='chosen-results']/li";
    
    String voine_numbers_AssignNumbersFrmInventoryBtn="xpath=//*[@id='number_table']/caption/a[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD="name=rate_center_name";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search="xpath=(//button[@type='submit'])[3]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn="xpath=//a[@class='select_numbers']";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_mobileNumber="xpath=//*[@id='number_table']/tbody/tr[1]/td[4]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn_assign="xpath=//button[text()='Assign Numbers']";
	
	String voice_number_internationalDIDs="link=International DIDs";
	String voice_number_internationalDIDs_textBoxEntry="xpath=(//input[@type='text'])[2]";
	String voice_number_internationalDIDs_save="xpath=//button[@form='international_did']";
	String voice_number_internationalDIDs_helpIcon="xpath=//i[@class='fa  fa-question-circle ']";
	String voice_number_internationalDIDs_tooltipText="xpath=//div[@role='tooltip']";
	String voice_number_internationalDIDs_numbersCount="xpath=//*[@id='international_table']/caption/span";
	String voice_number_internationalDIDs_errorMsg="xpath=//div[@class='alert alert-danger alert-dismissable']";
	String voice_number_internationalDIDs_errorMsg_Xbtn="xpath=//div[@class='alert alert-danger alert-dismissable']/button";
	
	
	String voice_number_internationalDIDs_successMsg="xpath=//div[@class='alert alert-success alert-dismissable']";
	String voice_number_internationalDIDs_successMsg_Xbtn="xpath=//div[@class='alert alert-success alert-dismissable']/button";
	String voice_number_internationalDIDs_NumbersList="xpath=//div[@class='bootstrap-tagsinput']/span";
	String voice_number_internationalDIDs_NumbersList_X_parametarised="xpath=(//div[@class='bootstrap-tagsinput']/span/span)[%s]";
}
