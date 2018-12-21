package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;
import demo.objectrepository.OR_Admin;

public class AdminDropDown extends MediatorClass{
	 
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/** TestCase Description:Verify all menu's and submenu's under the Admin dropdown */
	
	 @Test(alwaysRun=true,enabled=true)
	public void adminDropDownValidation(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);

		// * logger method for report starting from here
		logger = extent.startTest("Admin DropDown options verification").assignCategory("Admin", "Regression test");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify all menu's and submenu's under the Admin dropdown");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		
		isassert = verifySubMenuHeadLine(adminLInk, agent_portal,"Agent Portal Admin",agent_portal_faq,"Agent Portal - FAQs" ,agent_portal_headline, "Agent Portal Admin - FAQ");
		softassert.assertEquals(isassert, true, "Verify text on page Agent Portal Admin - FAQ");
		// wrong Heading - Verify once
		isassert = verifySubMenuHeadLine(adminLInk, agent_portal,"Agent Portal Admin",agent_portal_files,"Agent Portal - Files",agent_portal_headline, "AAANR Portal Admin - Demos");
		softassert.assertEquals(isassert, true, "Verify text on page Agent Portal Admin - Demos");
		
		isassert = verifySubMenuHeadLine(adminLInk,agent_portal,"Agent Portal Admin",agent_portal_messages,"Agent Portal - Messages" ,agent_portal_headline, "Agent Portal Admin - Messages");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,agent_portal,"Agent Portal Admin",agent_portal_news,"Agent Portal - News" ,agent_portal_headline, "Agent Portal Admin - News");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		//not present in qa6
		//Verify(agent_portal,agent_portal_products ,agent_portal_headline, "Agent Portal Admin - Products");
		isassert = verifySubMenuHeadLine(adminLInk,agent_portal,"Agent Portal Admin",agent_portal_promos,"Agent Portal - Files",agent_portal_headline, "Agent Portal Admin - Promos");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,agent_portal,"Agent Portal Admin",agent_portal_training_sessions,"Agent Portal - Training Sessions" ,agent_portal_headline, "Agent Portal Admin - Training Sessions");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,agent_portal,"Agent Portal Admin",agent_portal_users,"Agent Portal - Users" ,agent_portal_headline, "Agent Portal Admin - Users");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		//not present in qa6 only in QA5
	  
		isassert = verifySubMenuHeadLine(adminLInk,automation,"Automation",automation_automation_log,"Automation-Log",automation_headline, "Automation Log Runs");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,automation,"Automation",automation_automation_report,"Automation-Report",automation_headline, "Automation Report");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,automation,"Automation",automation_automation_viewAutomation,"Automation-ViewAutomation",automation_headline, "Automations");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_broadworks_service_packs,"BW Service Packs" ,c3_domain_headline, "Broadworks Service Packs");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_bulk_update_service_packs,"Bulk Service Packs" ,c3_domain_headline, "Bulk Update Service Packs");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_equipment,"C3 Equipment" ,c3_domain_headline, "C3 Equipment");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_phone_types," Phone Types" ,c3_domain_headline, "C3 Phone Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_service_packs ,"Service_Packs",c3_domain_headline, "Service Packs");        
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,c3_admin,"C3 Admin",c3_domain_services ,"Services",c3_domain_headline, "Services");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifyClicksInPage(adminLInk,"",dev,"Dev",dev_audit_log,"Audit Log" );
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifyClicksInPage(adminLInk,"", dev,"Dev",dev_reset_broadWorks," Reset Broadworks Password Rules");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifyClicksInPage(adminLInk,"",dev,"Dev",dev_sync_customer,"Sync Customer to Zeus");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifyClicksInPage(adminLInk,"",dev,"Dev",dev__icons," Icons");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifyClicksInPage(adminLInk,"",dev,"Dev",dev_salesForceBrowser,"Salesforce Browser" );
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifySubMenuHeadLine(adminLInk,devices,"Devices",device_bulk_change_notes,"Bulk Change Notes" ,device_subMenu_headline, "Change Device Notes");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,devices,"Devices",device_snmp,"SNMP",device_subMenu_headline, "Device SNMP Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,devices,"Devices",device_bulk_circuit_migration,"Bulk_Circuit_Migration",device_subMenu_headline, "Select a Device Name that is tied to a Circuit that you want to export:");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,devices,"Devices",device_templates ,"Templates",device_subMenu_headline, "Device Templates");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,devices,"Devices",device_types, "Types",device_subMenu_headline, "Device Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifySubMenuHeadLine(adminLInk,engineering,"Engineering",engineering_bulk_dns_update,"DNS" ,engineering_subMenu_headLine, "DNS");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,engineering,"Engineering",engineering_carriers,"Carriers" ,engineering_subMenu_headLine, "Carriers");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,engineering,"Engineering",engineering_manage_eicb_default_watchers,"Manage_EICB_Default_Watchers" ,engineering_subMenu_headLine, "Default EICB Watchers");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,engineering,"Engineering",engineering_manage_eicb_categories,"Manage_EICB_Categories" ,engineering_subMenu_headLine, "EICB Categories");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,engineering,"Engineering",engineering_pops,"POPS" ,engineering_subMenu_headLine, "POPs");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		Thread.sleep(1000);


		isassert = verifySubMenuHeadLine(adminLInk,email_notification_tool_logs,"Customer Email_Notification_Tool",email_notification_tool_logs_CustomerEmailNotificationTool,"Customer Notify" ,engineering_subMenu_headLine, "Customer Notification Tool");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,email_notification_tool_logs,"Email_Notification_Tool_logs",email_notification_tool_email_notificationLog ,"email_notification_tool_email_notificationLog",engineering_subMenu_headLine, "Search Notification Logs");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,customer_portal,"Customer Portal",customer_portal_msg_of_the_day,"Message of the day" ,customer_portal_headline, "Message of the day messages");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,hermes,"Hermes",hermes_admin_hmac_control,"Admin Hmac Control" ,engineering_subMenu_headLine, "User Parent");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,hermes,"Hermes",hermes_refreshMenthodsForPermissions,"Refresh Methods for Permissions",engineering_subMenu_headLine, " ");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,hermes,"Hermes",hermes_manageCustomerAgreements ,"Manage Customer Agreements",engineering_subMenu_headLine, "Agreements");
		softassert.assertEquals(isassert, true, "Verify text on page ");


		//Not working
		isassert = verifySubMenuHeadLine(adminLInk,OR_Admin.inventory,"Inventory",inventory_netcMapping ,"NetX Mapping",engineering_subMenu_headLine, "NetX Mapping");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifySubMenuHeadLine(adminLInk,OR_Admin.inventory,"Inventory",inventory_partsListMappings," Parts List Mapping" ,engineering_subMenu_headLine, "Parts List Mapping");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifySubMenuHeadLine(adminLInk,OR_Admin.inventory,"Inventory",inventory_uploadNextReport," Import Netx Report" ,engineering_subMenu_headLine, "Upload NetX Report");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		//not present in qa6
		//Verify(nexmo_gdm,"NEXAMO &GDM",nexmo_gdm_importPremierCentralNo ,"Manage Numbers",engineering_subMenu_headLine, "Premier Central Numbers Import");
		isassert = verifySubMenuHeadLine(adminLInk,nexmo_gdm,"NEXAMO &GDM",nexmo_gdm_managePremierCentralNo,"Manage Numbers" ,engineering_subMenu_headLine, "Premier Central Numbers");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,nexmo_gdm,"NEXAMO &GDM",nexmo_gdm_configuration,"Nexmo Feature Control" ,engineering_subMenu_headLine, "Nexmo & GDM Controls");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,noc,"NOC",noc_messageBoard,"Message Board Management" ,engineering_subMenu_headLine, "Message Board Messages");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,noc,"NOC",noc_rePushCdrFile," Re-push CDR file" ,engineering_subMenu_headLine, "CDR Repush Request Queue");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,notifications,"Notification",notifications_addNotification ,"Add Notification Type",engineering_subMenu_headLine, "Notification Type");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,notifications,"Notification",notifications_editNotification ," Edit Notification Type",engineering_subMenu_headLine, "Notification Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,ip_management,"IP Management",ip_management_ipNetworkTreeView,"IP Network Treeview" ,engineering_subMenu_headLine, "IP Network Tree View");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,ip_management,"IP Management",ip_management_typeManagementNetwork," Type Management - Network" ,engineering_subMenu_headLine, "List of Network Block Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,ip_management,"IP Management",ip_management_typeManagementCustomerType," Type Management -CustomerType" ,engineering_subMenu_headLine, "List of Customer IP Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,ip_management,"IP Management",ip_management_cidrBlockManagement," CIDR Block Management" ,engineering_subMenu_headLine, "List of IP CIDR Blocks");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,ip_management,"IP Management",ip_management_networkBlockManagement ,"NetWork Block Managment",engineering_subMenu_headLine, "List of IP Network Blocks");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,numbers,"Numbers",numbers_inventoryImport ,"Inventory Import",engineering_subMenu_headLine, "TN Import");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		// * Below method written to verify clicks in page
		isassert = verifyClicksInPage(adminLInk,"Admin link",numbers,"Numbers",numbers_nnacl,"NNACL" );
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,numbers,"Numbers",numbers_pseudo,"Pseudo NPA/NXXs" ,engineering_subMenu_headLine, "Pseudo Entries");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		// not present in qa6
		/* Verify(order_portal,order_portal_productFields ,engineering_subMenu_headLine, "Product Fields");
        Verify(order_portal,order_portal_priceBook ,engineering_subMenu_headLine, "Customer Pricebooks");*/

		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageGroups,"Manage Groups" ,admin_permissions_subMenu_headLine, "Manage Groups");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageUserGroups,"Manage User Groups",admin_permissions_subMenu_headLine, "User Group Assignment");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageUserByGroup,"Manage User By Group" ,admin_permissions_subMenu_headLine, "Users By Permissions Group");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageUserManageMethods ,"Manage Methods",admin_permissions_subMenu_headLine, "Manage Methods");        
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageMethodGroups,"Manage Method Groups" ,admin_permissions_subMenu_headLine, "Method Groups");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_refreshMethodsFromCode,"Refresh Methods From Code" ,admin_permissions_subMenu_headLine, "Refresh Methods for Permissions");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageCustomerProfiles,"Manage Customer Profiles" ,admin_permissions_subMenu_headLine, "Manage Customer Profile");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_permissions," Permissions",admin_permissions_manageCustomerAccess,"Manage Customer Access" ,admin_permissions_subMenu_headLine, "Customer Access");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_circuitQuoteByCustomers,"Circuit Quote By Customer" ,engineering_subMenu_headLine, "Circuit Quote");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		// * Below method written to verify clicks in page
		isassert = verifyClicksInPage(adminLInk,"Admin link", sales_tools,"Sales_Tools",sales_tools_circuitQuoteByAddress,"Circuit Quote By Address");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_CreateExternalEicb,"Create External EICB" ,engineering_subMenu_headLine, "External Engineering ICB");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_pcat,"PACT" ,engineering_subMenu_headLine, "Product Catalog (PCAT)");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_quota ,"Quota",engineering_subMenu_headLine, "Search Team Quota");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		//Hidden Menu        
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_quotaStage,"Quota Stage" ,engineering_subMenu_headLine, "Quote Stage");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,sales_tools,"Sales_Tools",sales_tools_salesOrderEdit,"Sales Order Edit" ,engineering_subMenu_headLine, "Search");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifySubMenuHeadLine(adminLInk,reconciliation,"Reconciliation",reconciliation_reconMacProductMapping," Reconciliation MAC Product Mapping" ,engineering_subMenu_headLine, "MAC Product Mapping");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		//Service Delivery
		// * Below method will resize the screen to 80% to view the drop-down selection
		setBrowserTo80Size();
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_dispatch ,"Dispatch",admin_permissions_subMenu_headLine, "Dispatch Admin");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_editProjectCancelReason,"Edit Project Cancel Reason" ,admin_permissions_subMenu_headLine, " Project Cancel Reasons");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_editProjectJeopReasons ,"Edit Project Jeop Reasons",admin_permissions_subMenu_headLine, "Edit Project Jeop Reasons");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_editProjectTemplates,"Edit Project Templates" ,admin_permissions_subMenu_headLine, "Project Templates");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_editSowTemplate,"Edit Sow Template" ,admin_permissions_subMenu_headLine, "Edit Scope of Work Template");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_editSystemTasks,"Edit System Tasks" ,admin_permissions_subMenu_headLine, "System Tasks");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_ManageProjectTypes,"Manage Project Types" ,admin_permissions_subMenu_headLine, "Project Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_manageC3Calanders,"Manage C3 Calanders" ,admin_permissions_subMenu_headLine, "C3 Calendar");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_manageC3CalandersTypes,"Manage C3 Calanders Types" ,admin_permissions_subMenu_headLine, "Manage Calendar Types");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		isassert = verifySubMenuHeadLine(adminLInk,admin_serviceDelivery,"Service Delivery Menu",admin_serviceDelivery_manageWorkQueues,"Manage Work Queues" ,admin_permissions_subMenu_headLine, "Manage Work Queues");


		isassert = verifySubMenuHeadLine(adminLInk,user,"Users",user_addNewUser ,"Add Users",engineering_subMenu_headLine, "Add User");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,user,"Users",user_manageUsers,"Manager Users" ,engineering_subMenu_headLine, "Zeus Users");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		//Hidden Menu        
		isassert = verifySubMenuHeadLine(adminLInk,user,"Users",user_manageUserLocations,"Manage User Lopcations" ,engineering_subMenu_headLine, "User Locations"); 
		softassert.assertEquals(isassert, true, "Verify text on page ");


		isassert = verifySubMenuHeadLine(adminLInk,zeus_admin,"zeus_admin",zeus_admin_CircuitQuoteProviders,"Circuit Quote Providers" ,engineering_subMenu_headLine, "Circuit Quote Providers");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		// Hidden Menu      
		
		isassert = verifySubMenuHeadLine(adminLInk,zeus_admin,"zeus_admin",zeus_admin_faxBack,"Fax Back" ,engineering_subMenu_headLine, "Faxback Configuration");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,zeus_admin,"zeus_admin",zeus_admin_hostedPayment,"Hosted Payment" ,engineering_subMenu_headLine, "HPP Page Configuration");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,zeus_admin,"zeus_admin",zeus_admin_platformConfiguration,"Platform Configuration" ,engineering_subMenu_headLine, "Platform Configuration");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		
		isassert = verifySubMenuHeadLine(adminLInk,zeus_admin,"zeus_admin",zeus_admin_menuManagement,"Menu Management " ,engineering_subMenu_headLine, "Menu Management");
		softassert.assertEquals(isassert, true, "Verify text on page ");
        Thread.sleep(5000);
        softassert.assertAll();
     // * Below method written to logout application
     	logOutt();

	
	}

}

