package demo.objectrepository;

public interface OR_CustInfo {
	String cusVipType = "id=vip_type";

	String billingStatus = "id=billing_status";
	String cusMrr = "css=input[title='Total MRR Billed to this site and all child sites']";
	String siteMrr = "css=input[title='Total MRR Billed to this site']";
	String cusRank = "css=input[title='Overall Rank of entire company billed MRR']";
	String siteRank = "css=input[title='Overall Rank of site billed MRR']";
	String csa = "css=input[name='csa']";
	String broadcastCluster = "id=broadsoft_cluster";
	String monitoringStatus = "css=a#monitoring_status";
	String downTime = "id=manage_downtime";
	String shipAddr = "xpath=(//div[@class='col-md-8'])[1]//input";
	String billingAddr = "xpath=(//div[@class='col-md-8'])[2]//input";
	String childCusTable = "css=a[href='#childCustomerTable']";
	String exportChildCus = "xpath=//a[contains(text(),'Export Child Customers')]";
	String eicTable = "css=a[href='#eicbTable']";
	String contactTable = "css=a[href='#contactTable']";
	String contractTimeLine = "css=a[href='#timeline_collapse_1']";
	String projectTimeLine = "css=a[href='#timeline_collapse_2']";
	String ticketTimeLine = "css=a[href='#timeline_collapse_3']";
	String notes = "xpath=//h1[text()='Notes']";
	String logEntries = "css=[class='table table-striped table-condensed']";
	String mrrTimeline = "xpath=//a[@href='#mrr_timeline_collapse']";
	String cusSince = "id=customer_since";
	String cusExpire = "id=customer_expire";
	String market = "id=market_name";
	String cusPin = "id=cpni_passcode";
	String customer_home_accountStatus = "id=account_status";
	String Thirdpartyproducts = "xpath=//a[@href='#thirdPartyToolsTable']";

	// Test case - customer Dash board
	String homeBtnDd = "xpath=//span[text()='Home']";
	String customerInfoLnk = "id=notification-customer-information";

	String customerTitleText = "xpath=//div[@class='panel-heading']";
	String marketDropDown = "xpath=//label[contains(text(),'Market')]/..//span";// Portland
	String marketTextBox = "xpath=//label[contains(text(),'Market')]/..//input[@type='text']";
	String globalNotesTextBox = "xpath=//label[contains(text(),'Global')]/../textarea";
	String createProjectButton = "xpath=//button[text()=' Create Project And On to Step 2']";
	String selectDateLink = "xpath=(//span[text()='Select Date'])[2]";
	String buildProjectButton = "xpath=//button[contains(text(),' Build Project Tasks')]";
	String fillBillingDate = "xpath=//input[@id='full_bill_date']";
	String saveButton = "xpath=//span[text()='Save']";
	String billingStatusDropDown = "xpath=//select[@id='project_state_name']";// Ready
																				// for
																				// FULL
																				// Billing
	// String
	// billingStatusDropDown="xapth=//option[@value='Ready for FULL Billing']";
	// option[@value='Ready for FULL Billing']
	String handoffCheckBox = "xpath=(//input[@type='checkbox'])[%d]";
	String checkBoxesList = "xpath=//input[@type='checkbox']";
	String productTypeDropDown = "xpath=//label[text()='Product Type']/..//select";// Hybrid
	String handoffRadioButtonsList = "xpath=//input[@type='radio'][@value='0']";
	String handoffRadioButtons = "xpath=(//input[@type='radio'][@value='0'])[%d]";
	String handoffDateTextBox = "xpath=//input[@type='date']";
	String handOffLink = "xpath=//span[text()='Handoff']";
	String handoffSaveandSignButton = "xpath=//button[text()='Save and Sign']";
	String successText = "xpath=//p[text()='Success!']";
	String okButton = "xpath=//button[text()='OK']";
	String handoffConfirmButton = "xpath=(//input[@value='Confirm'])[%d]";
	String handoffConfirmButtons = "xpath=//input[@value='Confirm']";

	String macNameTextBox = "xpath=//input[@name='quote[name]']";
	String macTitleTextBox = "xpath=//input[@name='quote[ticket_id]']";
	String addMacBtn = "css=#mac_table a";
	String disCustomer = "xpath=//a[@href='/customer/view/customer_id:%s']";
	/*
	 * String handoffConfirmButtons="xpath=//input[@value='Confirm']"; String
	 * handoffConfirmButtons="xpath=//input[@value='Confirm']"; String
	 * handoffConfirmButtons="xpath=//input[@value='Confirm']"; String
	 * handoffConfirmButtons="xpath=//input[@value='Confirm']";
	 */

	String projectManagerDropDown = "xpath=//label[contains(text(),'Project Manager')]/..//span";
	String projectManagerTextBox = "xpath=//label[contains(text(),'Project')]/..//input[@type='text']";

	// Customer Home - Configure Users
	String Home = "id=notification-home";
	String Home_attachments = "id=notification-attachments";
	String Home_portalUers = "id=notification-portal-users";
	String Home_C3 = "xpath=//a[starts-with(@href, '/c3/view/customer')]";
	String Home_C3_configureUsers = "id=notification-configure-users";
	String Home_C3_c3_DashBoard = "xpath=(//span[@id='notification-dashboard'])[2]";
	String Home_c3_buildEnterpriseGroup = "id=notification-build-enterprise/group";
	String Home_C3_buildUserDevices = "id=notification-build-users-&-devices";

	String configureUser_addEntryDropDown = "id=addDropdown";
	// String configureUser_addUser="css=.addRow";
	String configureUser_addUser = "xpath=//*[@id='data-buttons']/span/ul/li[1]/a";

	String configureUser_DeviceCheck = "xpath=//a[@href='#device']";
	String configureUser_DeviceCheckVerify = "xpath=//a[@href='#device']/..";

	// String
	// configureUser_addEntrySuccessMessage="xpath=//*[@id='alert_placeholder']/div/span";
	String configureUser_addEntry_ext = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[2]/input";
	String configureUser_addEntry_firstName = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[3]/input";
	String configureUser_addEntry_lastName = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[4]/input";
	String configureUser_addEntry_timeZone_DD = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[5]/select";
	String configureUser_addEntry_email = "xpath=//*[@id='lines[new][0][Email_Address]']";
	String configureUser_addEntry_serviceSelection = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[7]";
	String configureUser_addEntry_serviceSelection_DD = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[7]/select";
	String configureUser_addEntry_serviceSelection_1st = "xpath=//*[@id='userInfo']/tbody/tr[1]/td[7]/div/div/ul/li[2]";

	// *[@id="userInfo"]/tbody/tr[1]/td[7]/select/option[2]

	String configureUser_addEntry_type_DD = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[11]/select";
	String configureUser_addEntry_MAC = "xpath=((//*[@id='userInfo']/tbody/tr)[1]/td)[12]/div/div/input";
	String configureUser_addEntry_saveButton = "xpath=//*[@id='data-buttons']/button";

	String configureUser_successMessage = "xpath=//*[@id='alert_placeholder']/div/span";

	// C3 -> Build Enterprise & group

	String buildEnterprise_buildCompanyNetworksInBroadworks = "id=mBuildEnterpriseGroupTNs";
	String buildEnterprise_buildCompanyNetworksInBroadworks_selectAllBtn = "id=mSelectAll";
	String buildEnterprise_buildCompanyNetworksInBroadworks_buildCheckTnsBtn = "xpath=//button[@name='buildEnterpriseGroupTNs']";
	String buildEnterprise_buildStatus = "id=buildStatus"; // Build of TNs in
															// Enterprise/Group
															// '8JU8/8JU8-Holmdel'
															// successful

	String buildEnterprise_buildEnterpriseGroup = "id=buildEnterpriseGroup"; // after
																				// build
																				// message
																				// ->Build
																				// of
																				// Enterprise
																				// '8JU8'
																				// successful...

	String Home_portalUser_AddPortalUserbtn = "xpath=//a[starts-with(@href,'/customer/addPortalUser/customer_id')]";
	// Add portal User elements
	String AddPortalUser_userName = "id=username";
	String AddPortalUser_password = "id=password";
	String AddPortalUser_password_confirm = "id=password_confirm";
	String AddPortalUser_first_name = "id=first_name";
	String AddPortalUser_last_name = "id=last_name";
	String AddPortalUser_AccessButtons = "xpath=//td[@class='width-1px']/button";
	String AddPortalUser_addButton = "xpath=//button[@class='btn btn-primary btn-block']";

	String Home_portalUser_emailsInTable = "xpath=//*[@id='users_table']/tbody/tr/td[2]";

	// Home->C3->notification-e911-address-assignment
	String c3_e911_address_assignment = "id=notification-e911-address-assignment";
	String e9_address_assignment_manage_e911_address = "xpath=//a[@class='btn btn-sm btn-default pull-right']";

	String manage_e911_address_streetNumber1 = "id=hno";
	String manage_e911_address_streetNumber2 = "id=stn";
	String manage_e911_address_city = "id=mcn";
	String manage_e911_address_state = "id=sta";
	String manage_e911_address_zip = "id=zip";

	String manage_e911_validateAddress = "id=validate";
	String manage_e911_addAddress = "id=addEdit";
	String manage_e911_goBackToAssignment = "xpath=(//a[starts-with(@href,'/tn/e911Assignment/customer_id')])[2]";
	String manage_e911_adressDropdown = "id=globalCurrentAddresses";

	String manage_e911_chooseFile = "id=csv_file";
	String manage_e911_importbtn = "id=import-link";
	String manage_e911_importbtn_importbtm = "id=import";
	String manage_e911_importAddressChangeMsg = "xpath=//*[@id='tableMessages']/tbody/tr[2]/td";
	String manage_e911_returnToE911 = "xpath=//input[@value='Return to E911']";

	String attachments_uploadAdditionalDocumentsBtn = "xpath=//a[starts-with(@href,'/customer/addAttachment/customer_id')]";
	String attachments_uploadAdditionalDocuments_chooseFile = "xpath=//input[@name='file']";
	String attachments_uploadAdditionalDocuments_upload = "xpath=//button[@class='btn btn-primary pull-right u-btn']";
	String attachments_documentName = "xpath=//table[@class='table table-condensed']//tbody/tr/td[4]";
	// String
	// attachments_documentName="xpath=//table[@class='table table-condensed']//tbody/tr";
	String attachment_delete = "/td[10]/a/i";
	String attachment_delete_full = "xpath=(//a[starts-with(@href,'/customer/removeAttachment/customer_id')])[%s]";
	String vonage_userName = "name=user";
	String vonage_password = "name=pass";
	String vonage_loginBtn = "xpath=(//button[@type='submit'])[2]";

	String vonage_table1 = "xpath=//*[@id='sites']/tbody/tr[1]/td[1]/a";
	String vonage_dashboardHeadline = "xpath=/html/body/div[2]/h2";

	String vonage_account = "xpath=//a[@class='btn btn-default navbar-btn dropdown-toggle']";
	String vonage_account_projectOverView = "xpath=//a[@href='/admin/projects']";
	String vonage__account_projectOverView_projectStatus_DD = "name=project_status";
	String vonage__account_projectOverView_projectStatusList = "xpath=//*[@id='project_table']/tbody/tr/td[7]";

	String vonage_selectASiteFromList = "xpath=//*[@id='sites']/tbody/tr[1]/td[1]/a";
	String vonage_selectASiteFromListHeadLine = "xpath=/html/body/div[2]/div/h1";

	String Home_portalUser_login = "xpath=//a[@title='Log In As']";

	// Customer Home Data - Device
	String Home_data = "id=notification-data";
	// String Home_data_devices="id=notification-devices";
	String Home_data_devices = "xpath=//a[starts-with(@href,'/device/listByCustomer/customer_id')]";
	String Home_data_devices_addDevice = "xpath=//a[starts-with(@href,'/device/add/customer_id')]";
	// Add Device
	String addDevice_deviceName = "id=device_name";
	String addDevice_ipAddress = "id=ip_address";
	String addDevice_device_type_DD = "id=device_type_id";
	String addDevice_add = "xpath=//button[@class='btn btn-primary btn-sm pull-right']";

	String devices_verifyDeviceNameInTable = "xpath=//*[@id='device_table']/tbody/tr/td[3]";
	String device_verifyDeviceName_magnifyingSymbol = "xpath=//*[@id='device_table']/tbody/tr[%s]/td[1]/a[1]";

	String device_details_SolarWindMaintenance = "xpath=//a[@href='#solarwindsMaintenance']";
	String device_details_SolarWindMaintenance_grouping_DD = "id=systems_grouping";
	String device_details_SolarWindMaintenance_moveToSW = "id=sw_device_add_rmv";
	// comes only after move to SW operation
	String device_details_SolarWindMaintenance_removeFromSW = "id=sw_device_add_rmv";

	// Circuit modification
	String Home_data_circuit = "xpath=//a[starts-with(@href,'/circuit/listByCustomer/customer_id')]";

	String Home_data_circuit_addCircuit = "xpath=//a[starts-with(@href,'/circuit/addStep1/customer_id')]";
	String Dada_addCirctit_circuitType_DD = "id=circuit_type_id";
	String Dada_addCirctit_carrier_DD = "id=carrier_id";
	String Dada_addCirctit_pop_DD = "id=pop_id";
	String Dada_addCirctit_continue = addDevice_add;
	String Dada_addCirctit_addCircuit = addDevice_add;

	// verifyCustomer Created
	String customerIdList = "xpath=//*[@id='customer_table']/tbody/tr/td[2]";
	String customerNameList = "xpath=//*[@id='customer_table']/tbody/tr/td[4]/a";
	String customerName = "xpath=//*[@id='customer_table']/tbody/tr[%s]/td[4]/a";
	String customerTableHeadline = "xpath=//*[@id='customer_table']/caption"; // Customers

	String customer_dashboard_name = "css=.panel-heading";
	String customer_dashboard_contacts = "xpath=//a[@href='#contactTable']";
	String customer_dashBoard_contacts_nameList = "xpath=//*[@id='contacts_table']/tbody/tr/td[2]";
	String customer_dashBoard_contacts_nameEmail = "xpath=//*[@id='contacts_table']/tbody/tr/td[6]";
	String customerHome_email = "xpath=//table[@id='contacts_table']/thead/tr/th[6]";
	String customerHome_name = "xpath=//table[@id='contacts_table']/thead/tr/th[2]";
	String customerHome_mobile = "xpath=//table[@id='contacts_table']/thead/tr/th[5]";
	String customer_dashboard_contacts_ticketIds_parameterised="xpath=//*[@id='ticket_table']/tbody/tr[%s]/td[2]";

	// Test case - Billing-contract

	String Billing = "xpath=//span[text()='Billing']";
	String Billing_contract = "id=notification-contracts";
	String Billing_contract_list = "id=notification-list";
	String Billing_contract_summary = "id=notification-summary";
	String Billing_contract_timeline = "id=notification-timeline";
	String Billing_contract_inventory = "id=notification-inventory";
	String Billing_contract_bulkedit = "id=bulk_edit_button";
	String Billing_contract_export = "xpath=//a[@class='btn btn-success btn-sm pull-right']";

	String billing_contracts_magnifierList = "xpath=//*[@id='contract_table']/tbody/tr/td[1]/a";
	String billing_contracts_contractIdList = "xpath=//*[@id='contract_table']/tbody/tr/td[2]/a";
	String engageIp_username = "id=Username";
	String engageIp_password = "id=Password";
	String engageIp_loginBtn = "id=LoginButton";
	String engageIp_contactsTab = "id=Contacts_tab";
	String engageIp_contactsPageTitle = "css=.listtitle"; // CONTACTS
	String engageIp_overViewTab = "id=Overview_tab";
	String engageIp_overView_packagesTitle = "xpath=//*[@id='userpackage_ListBody']/div[1]"; // Packages

	String customerHome_Queues = "id=dd-Queues";
	String queues_newProjects = "id=notification-new-projects";
	String queues_search = "xpath=//input[@type='search']";
	String queues_success_greenBtn = "xpath=//a[@class='btn btn-xs btn-success']";

	String queues_newProject_createAProjectOntoStep2Btn = "xpath=//button[@class='btn btn-primary']";

	String queues_createAProjectOntoStep_DueDate = "xpath=(//div/span[contains(text(),'Select Date')])[3]"; // 2nd
																											// day
																											// from
																											// today
	String queues_createAProjectOntoStep_buildProjectTask = "xpath=(//button[@class='btn btn-success'])[2]";

	String queues_createAProjectOntoStep_projectStatus_DD = "id=project_state_name"; // Ready
																						// for
																						// FULL
																						// Billing
	String queues_createAProjectOntoStep_fullBillDate = "id=full_bill_date";
	String queues_newProject_saveRecalculateBtn = "xpath=//button[@class='btn btn-warning btn-sm pull-right']";

	String queues_projectBuildSuccessMsg = "xpath=//div[@class='alert alert-success']/button";

	String queue_billing = "id=notification-billing";
	String queue_billing_search = "xpath=//input[@type='search']";
	String queue_billing_run = "xpath=//a[@href='/admin/runAutomation/name:engageStatusSync']";
	String queue_billing_run_run = "xpath=//input[@class='btn btn-primary']";
	String queue_billing_run_successText = "xpath=//small[@class='text-success']";
	String queue_billing_processLnkList = "xpath=//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a";
	String queue_billing_pushToBilling1 = "xpath=(//input[@value='Push To Billing'])[1]";
	String queue_billing_pushToBilling2 = "xpath=(//input[@value='Push To Billing'])[2]";

	String queue_billing_pushToBilling_viewInEngage = "link=View in EngageIP";
	// String
	// queue_billing_pushToBilling_addToEngage="xpath=//div[@class='customerinfo']/form/div[2]/div[6]/input";
	String queue_billing_pushToBilling_addToEngage = "xpath=//input[@value='Add To EngageIP']";

	String queue_billing_pushToBilling_addView = "xpath=//input[@value='Add To EngageIP']";

	// customer disconnect
	String customerHome_viewInMenu_sugarr = "id=notification-view-in-sugar";
	String viewInSugar_editButton = "id=edit_button";
	String viewInSugar_edit_market_DD = "id=market_c";
	String viewInSugar_edit_industry_DD = "id=industry";
	String viewInSugar_edit_saveBtn = "xpath=//input[@value='Save']";

	String viewInEngage_status = "id=CurrentAccountStatus";

	String sugar_username = "id=user_name";
	String sugar_password = "id=user_password";
	String sugar_loginBtn = "id=login_button";

	String viewInEngage_status_magnifier = "id=UserStatusType_select";
	String viewInEngage_status_writeOff_Option = "xpath=//td[@id='User.UserStatusType_Disconnected - Write Off']";
	String viewInEngage_status_saveBtn = "id=SaveButton";
	String viewInEngage_status_immediatelyWithNoTransaction = "xpath=//input[@id='Immediately With No Transaction']";
	String viewInEngage_overView_status_logo = "xpath=//img[@class='statustypelogo']";
	String statusLogo = "class=statustypelogo";

	String automation_runBtn = "xpath=//a[@href='/admin/runAutomation/name:syncAccount']";
	String automation_syncAllBtn = "xpath=//a[@href='/admin/runAutomation/name:syncAccounts']";
	String Admin_automation_runSynchAccount_runBtn = "xpath=//input[@value='Run']";
	String Admin_automation_runSynchAccount_customerId = "name=args[customer_id]";

	String Admin_automation_runSynchAccount_interval = "name=args[interval]";
	String Admin_automation_name = "xpath=//*[@id='automations']/tbody/tr/td[1]";
	String Admin_automation_runButton = "xpath=//*[@id='automations']/tbody/tr[%s]/td[3]/a";

	String Admin_automation_runSynchAccount_successMsg = "xpath=//small[@class='text-success']";

	// Sugar Customer info

	String Sugar_Company = "xpth=a[@class='currentTabLink']";

	String customerDashBoard_customerVipType_DD = "id=vip_type";
	String customerDashBoard_customerVipIcon = "id=vip_icon";
	String customerDashBoard_editBtn = "xpath=//a[@title='Edit']";
	String customerDashBoard_edit_saveBtn = "id=btnSave";

	String c3_dashBoard_customerName = "xpath=//*[@id='header_hint']/li[2]";
	String c3_dashBoard_customerPortalLogin = "xpath=//a[starts-with(@href,'https://customer.qa5.vonagenetworks.net/install/view')]";
	String c3_dashBoard_customerPortalLogin_for = "xpath=//div[@class='col-xs-12']/h2";

	String dashBoard_data = "id=dd-Data";
	String dashBoard_data_cdr_config = "id=notification-cdr-config";
	// String
	// dashBoard_data_cdr_config_checkBoxEnable="xpath=//*[@id='cdrFields']/tbody/tr/td[1]/div";
	String dashBoard_data_cdr_config_checkBoxEnable1 = "xpath=(//div[@class='bootstrap-switch-container'])[2]";
	String dashBoard_data_cdr_config_checkBoxEnable2 = "xpath=(//div[@class='bootstrap-switch-container'])[3]";
	String dashBoard_data_cdr_config_summaryBtn = "link=Summary";

	String dashBoard_data_cdr_config_summaryBtn_downLoadPreview = "id=downloadPreviewButton";
	String dashBoard_data_cdr_config_searchBox = "xpath=//input[@type='search']";
	String dashBoard_data_cdr_config_fieldsBtn = "xpath=//a[@href='#fields']";
	String dashBoard_data_cdr_config_table = "css=#cdrFields tbody";

	String customerDashboard_addMAC = "xpath=(//a[starts-with(@href,'/quote/view/customer')])[1]";
	String customerDashboard_addMAC_productAddNew = "xpath=//a[@onclick='addRow();']";
	String customerDashboard_addMAC_productAddNew_macName = "id=quote[name]";
	String customerDashboard_addMAC_productAddNew_ticket = "id=quote[ticket_id]";
	String customerDashboard_addMAC_productAddNew_productTextBoxList = "xpath=//*[@id='ptable']/tbody/tr/td[1]/span/input[2]";

	String Customer_DashBoard = "xpath=//*[@id='header_hint']/li[2]";
	String Customer_DashBoard_review = "xpath=//*[@id='OReillyForm']/h4";

	String customer_dashboard_contacts_ticketIdList = "xpath=//*[@id='ticket_table']/tbody/tr/td[2]";
	String customer_dashboard_contacts_magnifier = "xpath=//*[@id='ticket_table']/tbody/tr[%s]/td[1]/a";
	String contacts_addTicket_loginPageFrame = "id=helpspot";
	String vonageBusiness_options = "id=request-option-button-hover";
	String vonageBusiness_options_mergeRequest = "xpath=(//ul[@class='tooltip-menu'])[6]/li/a/span";
	String vonageBusiness_mergeRequest_requestIdToMerge = "id=merge_req_id";
	String vonageBusiness_mergeRequest_startMegeBtn = "xpath=//button[@class='btn theme thin rnd nofloat buttons-popup']";
	String vonageBusiness_mergeRequest_startMege_confirmMergeBtn = "xpath=//button[@class='btn theme thin rnd buttons-popup']";
	String vonageBusiness_ticketId = "xpath=//span[@class='box_title_big']";
	// String
	// customer_dashboard_contacts_addTicket="xpath=//a[starts-with(@href,'/ticket/add/customer_id')]";
	String customer_dashboard_openTicketsMergedTickMark = "//*[@id='ticket_table']/tbody/tr[%s]/td[9]/span";

	String openTickets_contactListParametarised = "xpath=//*[@id='ticket_table']/tbody/tr[%s]/td[7]";

	String customer_dashboard_contacts_addTicket = "xpath=//a[starts-with(@href,'/ticket/add/customer_id')]";

	String contacts_addTicket_loginPage_userName = "id=username";
	String contacts_addTicket_loginPage_password = "id=password";
	String contacts_addTicket_loginPage_signIn = "xpath=//button[text()='Sign In']";
	String vonageBusiness_firstname = "id=sFirstName";
	String vonageBusiness_lastname = "id=sLastName";
	String vonageBusiness_Category = "id=xCategory";
	String vonageBusiness_Email = "id=sEmail";
	String vonageBusiness_connectedVia = "id=fOpenedVia";
	String contacts_addTicket_noteFrameinternal = "className=ephox-hare-content-iframe";
	String contacts_addTicket_notes = "xpath=//body[@class='ephox-candy-mountain ephox-candy-mountain-active']";

	String vonageBusiness_CasePriority = "id=Custom1";
	String vonageBusiness_ticketSummary = "id=Custom27";
	String vonageBusiness_groupAssignment = "id=Custom26";
	String vonageBusiness_createRequest = "id=sub_create";

	String vonageBusiness_alertAccept = "xpath=//button[@id='alert-button-ok']";

	String vonage_dashboard_siteService = "linkText= Site Services ";
	String vonage_dashboard_siteService_routerConfiguration = "xpath=//a[@href='/RouterConfig/Shell']";
	String vonage_dashboard_siteService_routerConfiguration_commandInput = "id=inputfield";
	String vonage_dashboard_siteService_routerConfiguration_commandOutput = "xpath=//*[@id='output']/table/tbody/tr/td[1]";

	String openTickets_contactList = "xpath=//*[@id='ticket_table']/tbody/tr/td[7]";
	String customer_dashboard_contacts_ticketId = "xpath=//*[@id='ticket_table']/tbody/tr[%s]/td[2]";

	String customer_dashboard_notification_voice = "id=notification-voice";
	String customer_dashboard_notification_numbers = "xpath=//a[starts-with(@href,'/tn/listByCustomer/customer_id')]";

	String customer_dashboard_notification_voice_number_penIcons = "xpath=(//*[@id='number_table']/tbody/tr/td[1])[1]";

	String customer_dashboard_notification_voice_number_penIcons_subList = "xpath=//*[@id='number_table']/tbody/tr[1]/td[1]/div/ul/li/a";

	String vonageBusiness_editSave_successMsg = "xpath=//*[@id='hdfeedbackbox']/tbody";
	String vonageBusiness_updateRequest = "id=sub_update";
	String vonageBusiness_updateClose = "id=sub_updatenclose";
	String ticketMagnifierList = "xpath=(//a[starts-with(@href,'/ticket/viewHS/ticket_id')])[%s]";

	String customerHome_dashBoard = "id=notification-dashboard";
	String customerHome_dashBoard_broadSoftCluster = "id=broadsoft_cluster";

	String customer_dashboard_notification_number_International_DIDs = "link=International DIDs";
	String customer_dashboard_notification_number_inputNumber = "xpath=//div[@class='bootstrap-tagsinput']/input";

	String customer_dashboard_notification_number_successMsg = "xpath=/html/body/div[2]/div[1]/div";

	String customer_dashboard_notification_number_number_saveBtn = "xpath=//button[@class='btn btn-sm btn-primary pull-right']";

	String customer_dashboard_notification_number_assign_number = "xpath=	//i[@class='glyphicon  glyphicon-plus']";
	String customer_dashboard_notification_number_assign_number_select_state = "id=state";
	String customer_dashboard_notification_number_assign_number_rate_center = "id=rate_center_name";
	String customer_dashboard_notification_number_assign_number_search = "xpath=(//button[@class='form-control btn btn-primary'])[1]";
	String customer_dashboard_notification_number_assign_select_number = "xpath=//a[@data-number-start='17192199405']";
	String customer_dashboard_notification_number_assign_number_search_assigne_number = "xpath=//button[text()='Assign Numbers']";

	String dashboard_data = "id=dd-Data";
	String data_devices = "xpath=//a[starts-with(@href,'/device/listByCustomer/customer_id')]";
	String data_devices_devicesNameTable = "xpath=//*[@id='device_table']/tbody/tr/td[2]";
	String data_devices_magnifierNameTable = "xpath=//*[@id='device_table']/tbody/tr[%s]/td[1]/a[1]";
	String data_devices_magnifierNameTable_deviceMonitorType_DD = "id=monitor_type";
	String data_devices_magnifierNameTable_solarWindStatus = "id=solar_winds_status";
	String data_devices_1StMagnifier = "xpath=//*[@id='device_table']/tbody/tr[1]/td[1]/a[1]";
	String data_devices_1StDeviceId = "xpath=//*[@id='device_table']/tbody/tr[1]/td[2]";

	String voice_broadWorks="id=notification-broadworks";
	String voice_broadWorks_numberActivation="id=notification-number-activation";
	String voice_broadWorks_numberActivation_Table_numbers="xpath=//*[@id='numbers_table']/tbody/tr/td[2]";
	
	String voine_numbers_AssignNumbersFrmInventoryBtn="xpath=//*[@id='number_table']/caption/a[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD="name=rate_center_name";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search="xpath=(//button[@type='submit'])[3]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn="xpath=//a[@class='select_numbers']";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_mobileNumber="xpath=//*[@id='number_table']/tbody/tr[1]/td[4]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn_assign="xpath=//button[text()='Assign Numbers']";
	String Voice_CDR="id=notification-cdrs";
	String Voice_CDR_usuageHistory="xpath=//a[starts-with(@href,'/cdr/usageHistory/customer')]";
	String Voice_CDR_usuageHistory_filter_DD="id=type";
	String Voice_CDR_usuageHistory_filerBtn="xpath=(//button[@type='submit'])[2]";
	String Voice_CDR_usuageHistory_tableColumnHeaders="xpath=//*[@id='usage']/thead/tr/th";
}


