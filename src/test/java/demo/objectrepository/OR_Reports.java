package demo.objectrepository;

public interface OR_Reports {
	
	 String Reports_projectByPM = "id=notification-projects-by-pm";
	 String Reports_projectByVP = "id=notification-calendar-by-vp";
	 
	 String Reports_projectByPM_headline="xpath=//div[@class='container-fluid']";
	 String Reports_projectByVP_headline="xpath=//*[@id='header_crumbs']/li[3]";
	 
	 String Reports_projectByVP_dropDown="xpath=//div[@id='views_chosen']/a";
	 String Reports_projectByVP_dropDownMenuList="xpath=//ul[@class='chosen-results']/li";
	 String Reports_projectByVP_dropDownOption="xpath=//ul[@class='chosen-results']/li[3]";
	 

		String projects_table_magnifyingSymbol="xpath=//a[starts-with(@href,'/project/view/project_id')]";
	   
	    String reports_projectBtPM_projectViewEditPage_Tasks="xpath=//*[@id='project_tasks']/tbody/tr/td[2]";
	    String reports_projectBtPM_projectViewEditPage_TasksClickable="xpath=//*[@id='project_tasks']/tbody/tr[%s]/td[2]/a";
	    String reports_projectBtPM_projectViewEditPage_taskCheckBox="xpath=//*[@id='project_tasks']/tbody/tr[%s]/td[1]/input";
	    String reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg="xpath=//*[@id='alert_placeholder']/div/span";
	    String reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn="xpath=//button[@class='close']";
	   //project details -add task    
	   
	 
	    String projManagerDd = "css=.chosen-single";
	    String allOpenProjLnk = "xpath=//li[text()='- All Open Projects -']";
	    String srchBtn = "xpath=//button[text()=' Search']";
	    String firstProjLnk = "xpath=//table[@id='project_table']/tbody/tr[1]/td[@class='left danger']/a";

	    String reports_projectBtPM_ProjectManager_DD="id=project_manager_chosen";
	    String reports_projectBtPM_ProjectManager_DD_AbbyHastings="xpath=(//ul[@class='chosen-results']/li)[3]";       
	    String reports_projectBtPM_search="xpath=//button[@class='btn btn-primary btn-block']";
	    
	    String reports_projectBtPM_1stProjectInTableMagnifier="xpath=//*[@id='project_table']/tbody/tr[1]/td[1]/a[1]/i";
	    String reports_projectBtPM_projectViewEditPage_headLine="xpath=//h1[@class='panel-title']";
	    String reports_projectBtPM_projectViewEditPage_Projectname_DD ="id=project_type_name";
	    String reports_projectBtPM_projectViewEditPage_addTask="xpath=//a[starts-with(@href,'/project/addTaskModal/project_id')]";
	    String reports_projectBtPM_projectViewEditPage_taskNamesTable="xpath=//*[@id='project_tasks']/tbody/tr/td[2]/a";
	    
	  //project details -add task
	    
	    String reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD="id=system_task_select_chosen";
	    String reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox="xpath=(//input[@type='text'])[2]";
	   
	  
	    String reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result="xpath=//*[@id='system_task_select_chosen']/div/ul/li";
	    String reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn="xpath=//button[@class='btn btn-sm btn-primary']";
	    String taskAddSuccessMsg="xpath=//*[@id='basic_modal']/div/div/div[2]/div/span";
	    String reports_projectBtPM_projectViewEditPage_addTask_closeBtn="xpath=//button[@class='close']";
	   
	    String reports_projectBtPM_projectViewEditPage_editTasks="id=btn-bulk-edit";
	    String reports_projectBtPM_projectViewEditPage_editTasks_checkBoxs="xpath=//*[@id='project_tasks']/tbody/tr[%s]/td[1]/input";
	    String reports_projectBtPM_projectViewEditPage_editTasks_Queue_DD="xpath=(//select[@name='ques[]'])[%s]";
	    String reports_projectBtPM_projectViewEditPage_editTasks_owner_DD="xpath=(//select[@name='owners[]'])[%s]";
	    String reports_projectBtPM_projectViewEditPage_editTasks_percent="xpath=(//input[@name='percent[]'])[%s]";
	    String reports_projectBtPM_projectViewEditPage_editTasks_note="xpath=(//input[@name='note[]'])[%s]";
	    String reports_projectBtPM_projectViewEditPage_editTasks_status_DD="xpath=(//select[@name='status[]'])[%s]";
	    String reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask="id=btn-delete-edit";
	    String reports_projectBtPM_projectViewEditPage_successMsg="xpath=//*[@id='alert_placeholder']/div/span";
	    String reports_projectBtPM_projectViewEditPage_editTasks_cancelEdit="id=btn-cancel-edit";
	    String reports_projectBtPM_projectViewEditPage_editTasks_saveBtn="id=btn-save-edit";
	    
	    String Reports_tasks_Calander="id=notification-tasks-calendar";
	    String Reports_tasks_CalanderViews_DD="id=views";
	    String Reports_tasks_CalanderWeek="xpath=(//div[@class='fc-button-group'])[2]/button[1]";
	    String Reports_tasks_CalanderDay="xpath=(//div[@class='fc-button-group'])[2]/button[2]";
	    String Reports_tasks_CalanderMonth="xpath=(//div[@class='fc-button-group'])[2]/button[3]";
	    String reports_projectBtPM_ProjectManager_DD_allOpenProjects="xpath=(//ul[@class='chosen-results']/li)[2]";       
	    
	
	String reports_customers="id=notification-customers";    
	String reports_reconciliation="id=notification-reconciliation";
	
	
	
	String reports_customers_activeCustomerContacts="id=notification-active-customer-contacts";
	String reports_reconciliation_exception_report="id=notification-daily-recon-exception-report";
	String reports_reconciliation_subMenu_headline="xpath=//div[@class='container-fluid']";
	
	String reports_customers_vipCustomerList="id=notification-vip-customer-list";
	String customers_vipCustomerList_Platinum_vipType_list="xpath=//i[@class='glyphicon glyphicon-fire has-vip-type']";
    String customers_vipCustomerList_vipType_List="xpath=//i[@class='glyphicon glyphicon-fire has-vip-type']";
    String customers_vipCustomerList_customers_dropDown="id=vip_type";
    String customers_vipCustomerList_customers_recordsInTable="xpath=//*[@id='customer_vip']/tbody/tr/td[3]";
    
    String customers_vipCustomerList_recordsPerPage_dropDown="name=customer_vip_length";
    String customers_customer_search ="xpath=//input[@type='search']";
  
	
	String report_number="xpath=//a[@href='/tn/reports/']";
	String report_number_international_DID_Report="xpath=//a[@href='/tn/internationalDIDReport']";
	String International_DIDs_TableHeaders="xpath=//*[@id='DataTables_Table_0']/thead/tr/th";
	String International_DIDs_Table_stateValues="xpath=//*[@id='DataTables_Table_0']/tbody/tr/td[3]";
	
	 String reports_accounting="id=notification-accounting";
     String reports_accounting_cancelledBeforeBilling ="id=notification-cancelled-before-billing";
     String reports_accounting_cancelledBeforeBilling_cancelReasonDD="id=cancel_reason_ids_chosen";
     String reports_accounting_cancelledBeforeBilling_cancelReasonDD_List="xpath=//ul[@class='chosen-results']/li";
    
     String Reports_tasks_date="xpath=//*[@id='calendar']/div[1]/div[3]/h2";
     
     // 1.2 test case
     
     String Report_headLine="className=clearfix";
 	
 	String Report_Accounting="xpath=//a[@href='/accounting/reports/']";
 	
 	String Report_Accounting_accountQuotesReport="xpath=//a[@href='/reports/accountQuotesReport/']";
 	String Report_Accounting_aging="xpath=//a[@href='/reports/aging/']";
 	String Report_Accounting_allInstallsByRep="xpath=//a[@href='/reports/allInstallsByRep']";
 	String Report_Accounting_allSalesByProduct="xpath=//a[@href='/reports/allSalesByProduct/']";
 	String Report_Accounting_allSalesByRep="xpath=//a[@href='/reports/allSalesByRep/']";
 	String Report_Accounting_assetTaxReport="xpath=//a[@href='/reports/assetTaxReport/']";	
 	String Report_Accounting_cancels="xpath=//a[@href='/reports/cancels/']";
 	String Report_Accounting_renewedContracts="xpath=//a[@href='/reports/renewedContracts/']";
 	String Report_Accounting_contractStageByMonth="xpath=//a[@href='/reports/contractStageByMonth/']";
 	String Report_Accounting_contractStageByMonthChart="xpath=//a[@href='/reports/contractStageByMonthChart/']";
 	String Report_Accounting_faxmail="xpath=//a[@href='/reports/faxmail/']";	
 	String Report_Accounting_salesBackdateReport="xpath=//a[@href='/reports/salesBackdateReport/']";	
 	String Report_Accounting_priceOverrides="xpath=//a[@href='/reports/priceOverrides/']";
 	String Report_Accounting_positiveAfterNegative="xpath=//a[@href='/reports/positiveAfterNegative']";
 	String Report_Accounting_productDiscountOverview="xpath=//a[@href='/reports/productDiscountOverview/']";
 	String Report_Accounting_productDiscounts="xpath=//a[@href='/reports/productDiscounts/']";	
 	String Report_Accounting_RevenueDetail_BOD="xpath=//a[@href='/reports/bod/']";	
 	String Report_Accounting_telesphereSignedMACs="xpath=//a[@href='/reports/telesphereSignedMACs/']";
 	String Report_Accounting_userDiscountLevels="xpath=//a[@href='/reports/userDiscountLevels/']";
 	String Report_Accounting_salesCommission="xpath=//a[@href='/reports/salesCommission/']";
 	String Report_Accounting_zeusToEngage="xpath=//a[@href='/reports/zeusToEngage']";
 	String Report_Circuits="xpath=//a[@href='/circuit/reports/']";	
 	String Report_Circuits_CircuitCost="xpath=//a[@href='/circuit/reportCircuitCost/']";
 	String Report_Circuits_quoteLookup="xpath=//a[@href='/circuitQuote/quoteLookup/']";
 	String Report_Circuits_circuitQuotes="Report_Circuits_circuittool";
 	String Report_Circuits_reportInactive="xpath=//a[@href='/circuit/reportInactive/']";
 	String Report_Circuits_reportHidden="xpath=//a[@href='/circuit/reportHidden/']";
 	String Report_Circuits_reportNoContract="xpath=//a[@href='/circuit/reportNoContract/']";
 	String Report_Circuits_reportNoZloc="xpath=//a[@href='/circuit/reportNoZloc/']";
 	String Report_Circuits_reportOverdue="xpath=//a[@href='/circuit/reportOverdue/']";
 	String Report_Circuits_reportPendingDISCO="xpath=//a[@href='/circuit/reportPendingDISCO/']";
 	String Report_Circuits_reportDS3="xpath=//a[@href='/circuit/reportDS3/']";
 	String Report_Circuits_reportByCarrier="xpath=//a[@href='/circuit/reportByCarrier/']";
 	String Report_Circuits_reportByType="xpath=//a[@href='/circuit/reportByType/']";
 	
 	String Report_Customers="xpath=//a[@href='/customer/reports/']";
 	
 	String Report_Customers_activeCustomrs="xpath=//a[@href='/reports/activeCustomers/']";
 	String Report_Customers_customersOpen24x7="xpath=//a[@href='/reports/customersOpen24x7/']";
 	String Report_Customers_agentTotalRevenue="xpath=//a[@href='/reports/agentTotalRevenue/']";
 	String Report_Customers_customerAgentReport="xpath=//a[@href='/reports/customerAgentReport/']";
 	String Report_Customers_agentCustomers="xpath=//a[@href='/reports/agentCustomers']";
 	String Report_Customers_customersByIndustry="xpath=//a[@href='/reports/customersByIndustry/']";
 	String Report_Customers_reportPostalCodes="xpath=//a[@href='/customer/reportPostalCodes/']";
 	String Report_Customers_customerRankingReport="xpath=//a[@href='/reports/customerRankingReport/']";
 	String Report_Customers_customerSeats="xpath=//a[@href='/reports/customerSeats/']";
 	String Report_Customers_reportVIP="xpath=//a[@href='/reports/reportVIP/']";
 	String Report_Customers_customerProductContacts="xpath=//a[@href='/reports/customerProductContacts/']";
 	
 	//Devices    
     String Report_Device="xpath=//a[@href='/device/reports/']";	
 	String Report_Device_AllDevices="xpath=//a[@href='/device/reportAll/']";
 	String Report_Device_Installing="xpath=//a[@href='/device/reportInstalling/']";
 	
 	//Engineering
 	String Report_Engineering="xpath=//a[@href='/engineering/reports/']";		
 	String Report_Engineering_masterPOPList="xpath=//a[@href='/reports/pop/']";
 	
 	//Finance
 	String Report_Finance="xpath=//a[@href='/finance/reports/']";		
 	String Report_Finance_NetXReport="xpath=//a[@href='/reports/netXReport/']";
 	
 	//Inventory
     String Report_Inventory="xpath=//a[@href='/inventory/reports/']";	
 	String Report_Inventory_inactiveCustomers="xpath=//a[@href='/inventory/reportInactive/csv:1']";
 	String Report_Inventory_inventoryHistory="xpath=//a[@href='/inventory/historyByCustomerWithFilter/']";
 	
 	//ips
 		String Report_ips="xpath=//a[@href='/ip/reports/']";		
 		String Report_ips_inactiveCustomers="xpath=//a[@href='/ip/reportInactive']";
 	
 		//Monitoring
 	    String Report_Monitoring="xpath=//a[@href='/monitoring/reports/']";	
 		String Report_Monitoring_Alerts="xpath=//a[@href='/monitoring/reportAlerts/']";
 		String Report_Monitoring_BroadWorksAuditLogs="xpath=//a[@href='/monitoring/reportBWAuditLogs/']";
 		
 		//Numbers
 	    String Report_Numbers="xpath=//a[@href='/tn/reports/']";	
 		String Report_Numbers_AllTNReport="xpath=//a[@href='/tn/reportAll/']";
 		String Report_Numbers_InterNationalDIDReport="xpath=//a[@href='/tn/internationalDIDReport']";	
 		
 		//Operations
 	    String Report_Operations="xpath=//a[@href='/operationsReports/menu/']";	
 		String Report_Operations_backlogChart="xpath=//a[@href='/operationsReports/backlogChart/']";
 		String Report_Operations_backlogReport="xpath=//a[@href='/operationsReports/backlog/']";	
 		
 		//Service Delivery
 	    String Report_ServiceDelivery="xpath=//a[@href='/project/reports/']";
 	    String Report_ServiceDelivery_Dispatches="xpath=//a[@href='/dispatch/report']";
 	    String Report_ServiceDelivery_HandOffs="xpath=//a[@href='/project/reportHandoffs/']";
 	    String Report_ServiceDelivery_inFlightProducts="xpath=//a[@href='/project/reportInFlightProducts/']";
 	    String Report_ServiceDelivery_pmProjectCountDashboard="xpath=//a[@href='/reports/pmProjectCountDashboard']";
 	    String Report_ServiceDelivery_projectsInstallByProgress="xpath=//a[@href='/project/listByInstallInProgress/']";
 	    String Report_ServiceDelivery_installationCalander="xpath=//a[@href='/serviceDelivery/viewInstallationCalendar/']";
 	    String Report_ServiceDelivery_jeops="xpath=//a[@href='/reports/dueDate']";
 	    String Report_ServiceDelivery_OReallyPendingDate="xpath=//a[@href='/project/reportORAPPendingData']";
 	   
 	    //Reconciliation
 	    String Report_Reconciliation="xpath=//a[@href='/recon/reports/']";
 	    String Report_Reconciliation_DailyReconExceptionReport="xpath=//a[@href='/recon/exceptionReport/']";
 	    String Report_Reconciliation_OperationReconOverView="xpath=//a[@href='/recon/operations/']";
 	    String Report_Reconciliation_ReconOverView="xpath=//a[@href='/recon/overall/']";
 	    String Report_Reconciliation_ReconProducts="xpath=//a[@href='/recon/byProduct/']";
 	    String Report_Reconciliation_ReconWorkDone="xpath=//a[@href='/recon/work/']";
 	    String Report_Reconciliation_reconExceptionAgingGraph="xpath=//a[@href='/recon/exceptionAgingGraph/']";
 	    
 	  //Sales
 	    String Report_Sales="xpath=//a[@href='/sales/reports/']";
 	    String Report_Sales_ETL_ContractSummary="xpath=//a[@href='/reports/etlReport/']";
 	    String Report_Sales_ICB="xpath=//a[@href='/circuit/reportICB/']";
 	    String Report_Sales_soldProducts="xpath=//a[@href='/reports/soldProducts/']";
 	    String Report_Sales_salesByRep="xpath=//a[@href='/reports/salesByRep/']";
 	    String Report_Sales_salesByState="xpath=//a[@href='/reports/salesByState/']";
 	    String Report_Sales_salesByTeam="xpath=//a[@href='/reports/salesByTeam/']";	    
 	    String Report_Sales_ETL_renewals="xpath=//a[@href='/reports/renewals/']";
 	    String Report_Sales_renewalsByRep="xpath=//a[@href='/reports/renewalsByRep']";
 	    String Report_Sales_salesEditAudit="xpath=//a[@href='/reports/salesEditAudit/']";
 	    String Report_Sales_contractsByMonthAndRevenueType="xpath=//a[@href='/salesReports/contractsByMonthAndRevenueType/']";
 	    String Report_Sales_soldProductDetails="xpath=//a[@href='/reports/soldProductDetails/']";
 	    String Report_Sales_sales="xpath=//a[@href='/reports/sales/']";
 	    String Report_Sales_trendsByMonth="xpath=//a[@href='/salesReports/trendsByMonth/']";
 	    String Report_Sales_wework="xpath=//a[@href='/salesReports/wework']";
 	    
 	    String report_Sales_By_rep_month = "id=month";
 	    
 	    //Tickets	    
 	    String Report_Tickets="xpath=//a[@href='/sales/reports/']";
 	    String Report_Tickets_ActionReport="xpath=//a[@href='/ticket/ticketActionReport/']";
 	    String Report_Tickets_CustomerInfancy="xpath=//a[@href='/ticket/reportByCustomerInfancy/']";
 	    String Report_Tickets_HelpDeskReport="xpath=//a[@href='/ticket/ticketReport/']";
 	    String Report_Tickets_ticketByAgent="xpath=//a[@href='/ticket/reportByAgent/']";
 	    String Report_Tickets_ticketsPastSLA="xpath=//a[@href='/ticket/reportByLastUpdate/']";
 	    String Report_Tickets_ticketQueueGroups="xpath=//a[@href='/ticket/listQueueGroups/']";
 	    
 	    

}
