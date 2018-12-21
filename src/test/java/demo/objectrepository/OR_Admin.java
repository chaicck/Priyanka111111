package demo.objectrepository;

public interface OR_Admin {
	
	//String agent_portal="id=notification-agent-portal";
	String agent_portal="id=notification-agent-portal";
	String automation="id=notification-automation";
	String c3_admin="id=notification-c3-admin";
	String customer_portal="id=notification-customer-portal";
	String dev="id=notification-dev";
	String devices="id=notification-devices";
	String engineering="id=notification-engineering";
	String email_notification_tool_logs="id=notification-email-notification-tool/logs";
	String hermes="id=notification-hermes";
	String inventory="xpath=(//span[@id='notification-inventory'])[2]";
	String nexmo_gdm="id=notification-nexmo-&-gdm";
	String noc="id=notification-noc";
	String notifications="id=notification-notifications";
	String ip_management="id=notification-ip-management";
	String numbers="id=notification-numbers";
	String order_portal="id=notification-order-portal";
	String permissions="id=notification-permissions";
	String sales_tools="id=notification-sales-tools";	
	String reconciliation="id=notification-reconciliation";
	String service_delivery="id=notification-service-delivery";
	String user="id=notification-user";
	String zeus_admin="id=notification-zeus-admin";
	
	
	String agent_portal_agent="id=notification-agents";
	String agent_portal_faq="id=notification-faq";
	String agent_portal_files="id=notification-files";
	String agent_portal_messages="id=notification-messages";
	String agent_portal_news="id=notification-news";
	String agent_portal_products="id=notification-products";
	String agent_portal_promos="id=notification-promos";
	String agent_portal_training_sessions="id=notification-training-sessions";
	String agent_portal_users="id=notification-users";
	String agent_portal_videos="id=notification-videos";
	
	String agent_portal_headline="xpath=//div[@class='container']/h1";
	
	String automation_automation_log="id=notification-automation-log";
	String automation_automation_report="id=notification-automation-report";
	String automation_automation_viewAutomation="id=notification-view-automations";
	
	String automation_headline="xpath=//div[starts-with(@class,'container')]";
	
	
	String c3_domain_broadworks_service_packs="id=notification-broadworks-service-packs";
	String c3_domain_bulk_update_service_packs="id=notification-bulk-update-service-packs";
	String c3_domain_equipment="id=notification-equipment";
	String c3_domain_phone_types="id=notification-phone-types";
	String c3_domain_service_packs="id=notification-service-packs";
	String c3_domain_services="id=notification-services";
	
	String c3_domain_headline="xpath=//div[@class='container-fluid']";
	
	//String customer_portal_msg_of_the_day="id:notification-message-of-the-day";
	String customer_portal_msg_of_the_day="xpath=//a[@href='/messageOfTheDay']";
	//String customer_portal_msg_of_the_day="xpath=//*[@id='header_list']/li[2]/ul/li[4]/ul";
	String customer_portal_headline="xpath=//div[@class='container-fluid']";
	
	String dev_audit_log="id=notification-audit-log";
	String dev_reset_broadWorks="id=notification-reset-broadworks-password-rules";
	String dev_sync_customer="id=notification-sync-customer-to-zeus";
	String dev__icons="id=notification-icons";
	String dev_salesForceBrowser="id=notification-salesforce-browser";
	
	String dev_subMenu_headLine="xpath=//*[@id='header_crumbs']/li[3]";
	
	String device_bulk_change_notes="id=notification-bulk-change-notes";
	String device_snmp="id=notification-snmp";
	String device_bulk_circuit_migration="xpath=//a[@href='/circuit/bulkMigrate/']";
	String device_templates="id=notification-templates";
	String device_types="id=notification-types";
	String device_subMenu_headline="xpath=//div[@class='container-fluid']";
	
	String engineering_bulk_dns_update ="id=notification-bulk-dns-update";
	String engineering_carriers ="id=notification-carriers";
	String engineering_manage_eicb_default_watchers ="id=notification-manage-eicb-default-watchers";
	String engineering_manage_eicb_categories ="id=notification-manage-eicb-categories";
	String engineering_pops="id=notification-pops";
	String engineering_subMenu_headLine="xpath=//div[@class='container-fluid']";
	
	String email_notification_tool_logs_CustomerEmailNotificationTool ="id=notification-customer-email-notification-tool";
	String email_notification_tool_email_notificationLog ="id=notification-email-notification-logs";
	String email_notification_tool_VisualEmailQue ="id=notification-visual-email-queue";
	
	
	String hermes_admin_hmac_control ="id=notification-admin-hmac-control";
	String hermes_refreshMenthodsForPermissions ="id=notification-refresh-methods-for-permissions";
	String hermes_manageCustomerAgreements ="id=notification-manage-customer-agreements";
	// ---
	String inventory_netcMapping="id=notification-netx-mapping";
	String inventory_partsListMappings="id=notification-parts-list-mappings";
	String inventory_uploadNextReport="id=notification-upload-netx-report";
	
	/*String inventory_netcMapping="xpath=//*[@id='header_list']/li[2]/ul/li[10]/ul/li[1]";
	String inventory_partsListMappings="xpath=//*[@id='header_list']/li[2]/ul/li[10]/ul/li[2]";
	String inventory_uploadNextReport="xpath=//*[@id='header_list']/li[2]/ul/li[10]/ul/li[3]";
	*/
	
	String nexmo_gdm_importPremierCentralNo="id=notification-import-premier-central-numbers";
	String nexmo_gdm_managePremierCentralNo="id=notification-manage-premier-central-numbers";
	String nexmo_gdm_configuration="id=notification-nexmo-&-gdm-configuration";
	
	String noc_messageBoard="id=notification-message-board";
	String noc_rePushCdrFile="id=notification-re-push-cdr-file";
	
	String notifications_addNotification="id=notification-add-notification-type";
	String notifications_editNotification="id=notification-edit-notification-type";
	
	String ip_management_ipNetworkTreeView="id=notification-ip-network-tree-view";
	String ip_management_typeManagementNetwork="id=notification-type-management---network";
	String ip_management_typeManagementCustomerType="id=notification-type-management---customer-ip";
	String ip_management_cidrBlockManagement="id=notification-cidr-block-management";
	String ip_management_networkBlockManagement="id=notification-network-block-management";
	
	String numbers_inventoryImport="id=notification-inventory-import";
	String numbers_nnacl="id=notification-nnacl";
	String numbers_pseudo="id=notification-pseudo-npa/nxxs";
	
	String order_portal_productFields="id=notification-product-fields";
	String order_portal_priceBook="id=notification-pricebook";
	
	
	String sales_tools_circuitQuoteByCustomers="id=notification-circuit-quote-by-customer";
	String sales_tools_circuitQuoteByAddress="id=notification-circuit-quote-by-address";
	String sales_tools_CreateExternalEicb="id=notification-create-external-eicb-quote";
	String sales_tools_pcat="id=notification-pcat";
	String sales_tools_quota="id=notification-quota";
	String sales_tools_quotaStage="id=notification-quote-stage";
	String sales_tools_salesOrderEdit="id=notification-sales-order-edit";
	
	String reconciliation_reconMacProductMapping="id=notification-recon-mac-product-mapping";
	
	String user_addNewUser="id=notification-add-new-user";
	String user_manageUsers="id=notification-manage-users";
	String user_manageUserLocations="id=notification-manage-user-locations";	
	
	String zeus_admin_CircuitQuoteProviders="id=notification-circuit-quote-providers";
	String zeus_admin_faxBack="id=notification-faxback-platform-configuration";
	String zeus_admin_hostedPayment="id=notification-hosted-payment-page-config";
	String zeus_admin_platformConfiguration="id=notification-platform-configuration";
	String zeus_admin_menuManagement="id=notification-zeus-menu-management";
	

	
	String admin_serviceDelivery_manage_c3_calanders="id=notification-manage-c3-calendars";
	
	
	
	
	String admin_menu ="id=notification-admin";

	String admin_menu_reconcilation ="xpath=//span[@id='notification-reconciliation']/..";   
			
	String admin_menu_reconcilation_reconmac_mapping ="xpath=//a[@href='/recon/reconMACProductMapping']";

	String admin_menu_reconcilation_reconmac_mapping_addmapping ="xpath=//a[@href='/recon/reconMACProductMappingModal/']";
	
	
	String admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield ="id=recon_name";
	String admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD ="id=pcat_id_chosen";
	String admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD_searchtextfield ="xpath=//*[@id=\"pcat_id_chosen\"]/div/div/input";
	String admin_menu_reconcilation_reconmac_mapping_addmapping_save ="xpath=//button[@form='recon_mapping']";
	
	String admin_menu_reconcilation_reconmac_mapping_addmapping_ok ="xpath=//button[text()='OK']";
	
	//String admin_menu_reconcilation_reconmac_mapping_addmapping_search_field ="xpath=//div[@class='dataTables_filter']";
	String admin_menu_reconcilation_reconmac_mapping_addmapping_search_field="xpath=//input[@placeholder='Search']";
	String admin_menu_reconcilation_recoeNameTable="xpath=//*[@id='recon_table']/tbody/tr/td[1]";
	String admin_menu_reconcilation_editIconTable="xpath=//*[@id='recon_table']/tbody/tr[%s]/td[5]/a";
	String admin_menu_reconcilation_deleteIconTable="xpath=//*[@id='recon_table']/tbody/tr[%s]/td[6]/a/i";
	String admin_menu_reconcilation_deleteMapping="id=confirmDelete";
	String admin_menu_reconcilation_successMsg="xpath=//div[@class='alert alert-success alert-dismissable']";
	


	String admin_menu_salestools ="id=notification-sales-tools";

	String admin_menu_salestools_create_ecib ="id=notification-create-external-eicb-quote";

	String Create_external_engineering_icb_subject ="id=subject";
	String Create_external_engineering_icb_description ="id=description";
	String Create_external_engineering_icb_product_DD ="id=product_id_chosen";
    String Create_external_engineering_icb_product_DD_type_insearch_product="xpath=//*[@id=\"product_id_chosen\"]/div/div/input";
  
    
    String Create_external_engineering_icb_externalid="id=external_customer_id";
    String Create_external_engineering_icb_external_quote_id="id=external_quote_id";
    String Create_external_engineering_icb_external_case_id="id=external_case_id";
    
    String Create_external_engineering_icb_category_DD="id=category_id_chosen"; 
    
    String Create_external_engineering_icb_category_DD_type_Search_category ="xpath=//*[@id=\"category_id_chosen\"]/div/div/input";
    
    String Create_external_engineering_icb_submit ="id=submit";

    String Create_external_engineering_icb_verify ="xpath=/html/body/div[2]/div[2]";

   


String admin_permissions="id=notification-permissions";
String admin_permissions_subMenu_headLine="xpath=//div[@class='clearfix']";

String admin_permissions_manageGroups="id=notification-manage-groups";
String admin_permissions_manageUserGroups="id=notification-manage-user-groups";
String admin_permissions_manageUserByGroup="id=notification-users-by-group";
String admin_permissions_manageUserManageMethods="id=notification-manage-methods";
String admin_permissions_manageMethodGroups="id=notification-manage-method-groups";
String admin_permissions_refreshMethodsFromCode="id=notification-refresh-methods-from-code";
String admin_permissions_manageCustomerProfiles="id=notification-manage-customer-profiles";
String admin_permissions_manageCustomerAccess="id=notification-manage-customer-access";

//Service Delivery
String admin_serviceDelivery="id=notification-service-delivery";
String admin_serviceDelivery_dispatch="xpath=//a[@href='/dispatch/dispatchAdmin/']";
String admin_serviceDelivery_editProjectCancelReason="id=notification-edit-project-cancel-reasons";
String admin_serviceDelivery_editProjectJeopReasons="id=notification-edit-project-jeop-reasons";
String admin_serviceDelivery_editProjectTemplates="id=notification-edit-project-templates";
String admin_serviceDelivery_editSowTemplate="id=notification-edit-sow-template";
String admin_serviceDelivery_editSystemTasks="id=notification-edit-system-tasks";
String admin_serviceDelivery_ManageProjectTypes="id=notification-manage-project-types";
String admin_serviceDelivery_manageC3Calanders="id=notification-manage-c3-calendars";
String admin_serviceDelivery_manageC3CalandersTypes="id=notification-manage-c3-calendar-types";
String admin_serviceDelivery_manageWorkQueues="id=notification-manage-work-queues";

String salesTools_pcat_searchBox="xpath=//input[@type='search']";
String salesTools_pcat_Edit_Table="xpath=//a[starts-with(@href,'/sales/pcatManagement/product_id')]";
String salesTools_pcat_genaralInfo_agentPortalCategory="id=ap_category";
String salesTools_pcat_genaralInfo_saveAll="xpath=//button[@class='btn btn-primary btn-sm pull-right']";
String salesTools_pcat_buildServices_saveAll="xpath=(//button[@class='btn btn-primary btn-sm pull-right'])[3]";

String salesTools_pcat_genaralInfo_BuildService_AddService ="xpath=//a[@href='#bundleTable']";
String salesTools_pcat_genaralInfo_BuildService_AddService_handSetPurchase_DD="name=services[new-0][id]";
String salesTools_pcat_genaralInfo_BuildService_deleteOption="xpath=(//i[@class='fa fa-trash'])[2]";
String salesTools_pcat_genaralInfo_search_DD="id=product_id";
String salesTools_pcat_genaralInfo_search ="xpath=(//button[@type='submit'])[2]";
String successMessage="xpath=//button[@class='btn btn-default center-block']";
String salesTools_pcat_genaralInfo_BuildService="xpath=(//a[@href='#bundleTable'])[2]";

String admin_salesTools_cicuit_quote_customerId="id=CustomerID";
String admin_salesTools_cicuit_quote_customerId_status="id=cn"; //Vonage Corporate
String admin_salesTools_cicuit_quote_submit_status="xpath=//div[@class='alert alert-danger']"; //Error! Cannot not get a quote for this location. Verify there is a valid Install Address and Office Phone
String admin_salesTools_cicuit_quote_submit_success_status="xpath=//div[@class='alert alert-success']";

String admin_salesTools_cicuit_quote_submit="id=qsubmit";
String admin_salesTools_cicuit_quote_term="name=term";
String admin_salesTools_cicuit_quote_checkBoxes="xpath=//input[@type='checkbox']";
String admin_salesTools_cicuit_quote_addBtn="id=add";
String admin_salesTools_cicuit_quote_selectedQuoteId_DD="name=qid";
String sugar_salesOrder="xpath=//*[@id='DEFAULT']/table/tbody/tr[2]/td[2]";

String admin_salesTools_cicuit_quote_OutSideClick="id=money";
	
	


String admin_menu_salestool ="id=notification-sales-tools";
String admin_menu_salestool_salesorder_Edit ="id=notification-sales-order-edit";
String admin_menu_salestool_salesorder_Edit_customerID ="id=customerID";
String admin_menu_salestool_salesorder_Edit_orderno ="id=salesOrderNum";
String admin_menu_salestool_salesorder_Edit_customer_name ="id=customerNAME";
String admin_menu_salestool_salesorder_Edit_Search_button="xpath=(//button[@type='submit'])[2]";
String admin_menu_salestool_salesorder_Edit_Customer_name_text="xpath=//th[text()='Customer Name']";
String admin_menu_salestool_salesorder_Edit_Customer_ID_text="xpath=//th[text()='CustomerID']";
String admin_menu_salestool_salesorder_Edit_Salesorder_text="xpath=//th[text()='Sales Order#']";
String admin_menu_salestool_salesorder_Edit_Market_text="xpath=//th[text()='Market']";
String admin_menu_salestool_salesorder_Edit_Sales_Month_text="xpath=//th[text()='Sales Month']";
String admin_menu_salestool_salesorder_EditBilling_Status_text="xpath=//th[text()='Billing Status']";
String admin_menu_salestool_salesorder_Edit_Sales_Order_Name_text="xpath=//th[text()='Sales Order Name']";
String admin_menu_salestool_salesorder_Edit_MRC_text="xpath=//th[text()='MRC']";
String admin_menu_salestool_salesorder_Edit_GMApproved_text="xpath=//th[text()='GMApproved']";
String admin_menu_salestool_salesorder_Edit_Quote_Stage_text="xpath=//th[text()='Quote Stage']";
String admin_menu_salestool_salesorder_Edit_Type_OfBusiness_text="xpath=//th[text()='Type Of Business']";
String admin_menu_salestool_salesorder_Edit_click="xpath=(//a[text()='Edit'])[1]";
 
String admin_menu_salestool_salesorder_Edit_click_salesdropdown_DD="id=form[type_of_business_c]";

String admin_menu_salestool_salesorder_Edit_Save_click="xpath=//button[@onclick='doSubmit()']";

String admin_menu_salestool_salesorder_Edit_Save_click_0order="xpath=//h3[text()='0 order sorted by GMApproved date']";

String admin_menu_salestool_salesorder_Edit_Save_click_somenumberorder="xpath=//h3[contains(text(),' orders sorted by GMApproved date')]";


	
String admin_nexmo_managePremier_importQA5="xpath=(//a[@href='/premierCentral/importNumbers'])[2]";
String admin_nexmo_managePremier_import="xpath=//a[@href='/premierCentral/importNumbers']";
String admin_nexmo_managePremier_import_numberList="xpath=//h4[@class='panel-title']";
String admin_nexmo_managePremier_import_numberRange="xpath=(//h4[@class='panel-title'])[2]";

String admin_nexmo_managePremier_import_numberList_numberEntry="id=tns_entry";
String admin_nexmo_managePremier_import_numberList_saveBtn="xpath=(//button[@type='submit'])[2]";
String admin_nexmo_managePremier_search="xpath=//input[@type='search']";
String admin_nexmo_managePremier_table_numbers="xpath=//*[@id='numbers_table']/tbody/tr/td[2]";
String admin_nexmo_managePremier_table_delete_parametarised="xpath=//*[@id=\"numbers_table\"]/tbody/tr[%s]/td[1]/a";
String admin_nexmo_managePremier_successMsg="xpath=//*[@id='alert_placeholder']/div/span";

String admin_nexmo_managePremier_import_numberRange_startNo="id=tn_start";
String admin_nexmo_managePremier_import_numberRange_endNo="id=tn_end";
String admin_nexmo_managePremier_export="id=export-link";	
	//bulk circuit
	String username = System.getProperty("user.name");	
	String loc = "C:\\Users\\"+username+"\\Downloads";
	String upload = "id=csv_file";
	String dryRun = "id=dry_run";
	String dryRun_msg = "xpath=(//label[@for='csv_file'])[2]";
	String importt = "id=import";
	String dryRun_warningMsg = "xpath=//div[@class='alert-danger alert-error']";
	String dry_run = "xpath=//input[@name='Dry Run']";
	String import_process = "xpath=//input[@name='process']";
	String name = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[1]";
	String fromInterface = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[2]";
	String toDevice = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[3]";
	String toInterface = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[4]";
	String customerId = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[5]";
	String circuitId = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[6]";
	String BulkMigrate_header = "xpath=//a[@href='/circuit/bulkMigrate']";
	String importError = "className=has-error";
	String Bulkcircuitprocessheader = "xpath=//label[text()='THIS ONLY UPDATES MONITORING!']";
	String Bulkcircuite_process = "xpath=(//input[@name='process'])[2]";
	


}
