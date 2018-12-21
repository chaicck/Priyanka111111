package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_2_ReportHighLevelFunctionality_ReportsDropDown extends MediatorClass{
	
String Report_headLine="className=clearfix";
	
	String Report_Accounting="xpath=//a[@href='/accounting/reports/']";
	String Positive_Negative = "xpath=//div[@class='container-fluid']";
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
	String Report_Circuits_circuitQuotes="id=notification-circuit-quote-tool-usage";
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
		String Report_Monitoring_BroadWorksAuditLogs_verify_jcarris="xpath=(//td[text()='jcarris'])[1]";
		
		//Audit log
		
		//Bod
		
		  String Report_montering_auditlog_startdate="id=start_date";
		  String Report_montering_auditlog_enddate="id=end_date";
		  String Report_montering_auditlog_brodworkscluster="id=cluster";
		  String Report_montering_auditlog_verify_date_column="id=cluster";
		  String Report_montering_auditlog_verify_date_verifytextjcarris="xpath=(//td[text()='jcarris'])[1]";
		  String Report_montering_auditlog_verify_date_verifytextjcarris2="xpath=(//td[text()='jcarris'])[2]";
		  String Report_montering_auditlog_verify_date_verifytextcolumndate="xpath=//th[text()='Date (EDT)']";
		  String Report_montering_auditlog_verify_date_verifytextcolumnuser="xpath=//th[text()='User']";
		  String Report_montering_auditlog_verify_date_verifytextcolumnuserlevel="xpath=//th[text()='User Level']";
		  String Report_montering_auditlog_verify_date_verifytextcolumnmethod="xpath=//th[text()='Method']";
		  
	
		
		
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
	    
	    //Tickets	    
	    String Report_Tickets="xpath=//a[@href='/sales/reports/']";
	    String Report_Tickets_ActionReport="xpath=//a[@href='/ticket/ticketActionReport/']";
	    String Report_Tickets_CustomerInfancy="xpath=//a[@href='/ticket/reportByCustomerInfancy/']";
	    String Report_Tickets_HelpDeskReport="xpath=//a[@href='/ticket/ticketReport/']";
	    String Report_Tickets_ticketByAgent="xpath=//a[@href='/ticket/reportByAgent/']";
	    String Report_Tickets_ticketsPastSLA="xpath=//a[@href='/ticket/reportByLastUpdate/']";
	    String Report_Tickets_ticketQueueGroups="xpath=//a[@href='/ticket/listQueueGroups/']";
	    
	    
	    String fs= File.separator;
		  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	    @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_2_ReportHighLevelFunctionality(String zUserName, String zPassword) throws Throwable {

        logger = extent.startTest("1.2 Test ID : 18724 - All Reports_High Level Functionality Tests").assignCategory("Reports");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description: Report All Menus and SumMenus");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");    
           
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_accountQuotesReport,"Account Quotes", Report_headLine, "Account Quotes Report");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_aging,"Aging", Report_headLine, "Contract Aging Report");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_allInstallsByRep,"All Installs By Rep", Report_headLine, "All Installs By Sales Rep");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_allSalesByProduct,"allSalesByProduct", Report_headLine, "All Sales By Product");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_allSalesByRep, "allSalesByRep",Report_headLine, "All Sales By Sales Rep");
        //loading very slowly, didn't verified
        //Verify(Report_Accounting, Report_Accounting_assetTaxReport, Report_headLine, "Tax Report");        
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_cancels,"Cancelled Before Billing", Report_headLine, "Cancel Before Billing Report");        
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_renewedContracts,"Contract Renewals", Report_headLine, "Renewals Before Expiration Date");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_contractStageByMonth,"Contract Stage By Month", Report_headLine, "Contract Stage Report");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_contractStageByMonthChart,"Contract Stage By Month Chart", Report_headLine, "Contract Stage Chart");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_faxmail,"Faxmail CDR", Report_headLine, "FaxMail Report");        
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_salesBackdateReport,"GM Approved to Sales Month Diff", Report_headLine, "Sales Backdate Report");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_priceOverrides,"MAC Price Overrides", Report_headLine, "Product Price Overrides");
        aclick(reports,"Reports Link");
        aJSClick(Report_Accounting,"Accounting Reports");		
	aJSClick(Report_Accounting_positiveAfterNegative,"Positive After Negative");
	verifyText(Positive_Negative, "", "Positive_Negative");
	//Verify(Report_Accounting, " Accounting Reports",Report_Accounting_positiveAfterNegative,"Positive After Negative", Report_headLine, "Positive After Negative Contracts Report");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_productDiscountOverview,"Product Discount Overview", Report_headLine, "Products Discounts Report");
        Verify(Report_Accounting, "Accounting Reports",Report_Accounting_productDiscounts,"Product Discount ", Report_headLine, "Product Discounts Report");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_RevenueDetail_BOD,"BOD", Report_headLine, "Revenue Detail Report"); 
        click(srchDd,"Search");
        
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_telesphereSignedMACs," Self Signed MACs", Report_headLine, "Telesphere Signed MACs");
        Verify(Report_Accounting," Accounting Reports", Report_Accounting_userDiscountLevels,"User Discounting Level", Report_headLine, "User Discount Level Report");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_salesCommission," Commissions", Report_headLine, " Commission Report");
        Verify(Report_Accounting, " Accounting Reports",Report_Accounting_zeusToEngage,"Zeus to Engage", Report_headLine, "Zeus to Engage");
        
        // circuits
        
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_CircuitCost," Circuit Cost", Report_headLine, "Circuit Cost Report");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_quoteLookup,"Circuits Quote Look up",Report_headLine, "Circuit Quote Lookup");  
       // Verify(Report_Circuits," Circuit Reports", Report_Circuits_circuitQuotes,"Circuits Quote ", Report_headLine, "Circuit Quote Report");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportInactive,"Circuits Repor In active ", Report_headLine, "Inactive Customers");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportHidden,"Circuits Repor Hidden ", Report_headLine, "Hidden");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportNoContract,"Circuits Report No Contract", Report_headLine, "Circuits with no contract");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportNoZloc,"Circuits Report  No ZLoc",  Report_headLine, "No ZLoc");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportOverdue, "Circuits Report  overdue",Report_headLine, "Overdue");  
        Verify(Report_Circuits, " Circuit Reports",Report_Circuits_reportPendingDISCO, "Circuits Report Pending DISCO",Report_headLine, "Pending DISCO");  
        Verify(Report_Circuits, " Circuit Reports",Report_Circuits_reportDS3,"Circuits Report  DS3 Report", Report_headLine, "DS3");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportByCarrier,"Circuits Report Report By Carrier", Report_headLine, "Report By Carrier");  
        Verify(Report_Circuits," Circuit Reports", Report_Circuits_reportByType, "Circuits Report Report By Type",Report_headLine, "Report By Type");  
      
        //Customers - menu
        VerifyClick(Report_Customers, Report_Customers_activeCustomrs);  
        VerifyClick(Report_Customers, Report_Customers_customersOpen24x7);  
        Verify(Report_Customers,"  Customer Reports", Report_Customers_agentTotalRevenue," Agent Customers and Revenue", Report_headLine, "Agent Total Revenue");  
        Verify(Report_Customers,"  Customer Reports", Report_Customers_customerAgentReport," All Customers with Agent", Report_headLine, "Customer Agent Report");  
        Verify(Report_Customers, "  Customer Reports",Report_Customers_agentCustomers," Customers By Agent", Report_headLine, "Agent Customers");  
        Verify(Report_Customers,"  Customer Reports", Report_Customers_customersByIndustry, " Industry",Report_headLine, "Customers By Industry");  
        VerifyClick(Report_Customers,  Report_Customers_reportPostalCodes);  
        Verify(Report_Customers,"  Customer Reports", Report_Customers_customerRankingReport," RankingReport", Report_headLine, "Customer Ranking Report");  
        Verify(Report_Customers, "  Customer Reports",Report_Customers_customerSeats,"  Seats Count Report", Report_headLine, "Customer Seat Report");  
        Verify(Report_Customers, "  Customer Reports",Report_Customers_reportVIP,"   VIP Customer List", Report_headLine, "VIP Customer List");  
        Verify(Report_Customers,"  Customer Reports", Report_Customers_customerProductContacts," Customer Product Contact Report", Report_headLine, "Customer Product Contact Report");  
       
       //Devices
        
    	Verify(Report_Device," Device Reports", Report_Device_AllDevices," All Devices", Report_headLine, "Devices All");  
        Verify(Report_Device," Device Reports", Report_Device_Installing,"Installing", Report_headLine, "Installing");  
    	
        //Enginnering
        Verify(Report_Engineering,"Engineering", Report_Engineering_masterPOPList, "Master POP List",Report_headLine, "Point of Presence (POP) - Report");  
        
        //Finance
        Verify(Report_Finance,"Finance", Report_Finance_NetXReport,"NetXReport", Report_headLine, "NetX Report");  
        
        //Inventory - menu
        VerifyClick(Report_Inventory, Report_Inventory_inactiveCustomers);
        Verify(Report_Inventory,"Inventory", Report_Inventory_inventoryHistory,"Inventory_inventoryHistory", Report_headLine, "Inventory History"); 
       
        //ips
        Verify(Report_ips,"IPS", Report_ips_inactiveCustomers,"Inactive Customers", Report_headLine, "Inactive Customers"); 


      //Monitoring
        Verify(Report_Monitoring,"Monitoring", Report_Monitoring_Alerts,"Alerts",Report_headLine,"Alerts");        
        Verify(Report_Monitoring,"Monitoring", Report_Monitoring_BroadWorksAuditLogs,"BroadWorksAuditLogs", Report_headLine, "BroadWorks Audit Log"); 
      //Numbers
    Verify(Report_Numbers,"Numbers Reports", Report_Numbers_AllTNReport,"All TN Report",Report_headLine,"TN Report");        
        Verify(Report_Numbers,"Numbers Reports", Report_Numbers_InterNationalDIDReport,"  International DID Report", Report_headLine, "International DID Report"); 
	    
        //Operations
        Verify(Report_Operations,"Operations", Report_Operations_backlogChart,"BacklogChart",Report_headLine,"Backlog Chart"); 
   
      
        
	   //Service Delivery
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_Dispatches,"Dispatches", Report_headLine, "Dispatches");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_HandOffs,"HandOffs", Report_headLine, "Handoffs");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_inFlightProducts,"In Flight Products", Report_headLine, "In Flight Products");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_pmProjectCountDashboard,"PM Project Count Dashboard", Report_headLine, "PM Project Count Dashboard");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_projectsInstallByProgress,"Projects Install By Progress", Report_headLine, "Projects Completed with status Install In Progress");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_installationCalander, "Installation Calander",Report_headLine, "Installation Calendar");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_jeops,"Jeops", Report_headLine, "JEOP Report");  
        Verify(Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_OReallyPendingDate,"OReally Pending Date", Report_headLine, "O'Reilly Pending Data");  
        
        //Reconciliation
        Verify(Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_DailyReconExceptionReport,  "DailyReconExceptionReport",Report_headLine, "Recon Exception Report");
        Verify(Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_OperationReconOverView, "OperationReconOverView", Report_headLine, "Operations Reconcilation Overview");
        Verify(Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconOverView, "ReconOverView,", Report_headLine, " Reconcilation Overview");
        Verify(Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconProducts, "ReconProducts", Report_headLine, "Product Reconciliation");
        Verify(Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconWorkDone, "_ReconWorkDone", Report_headLine, "Reconciliation Work Done");
        Verify(Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_reconExceptionAgingGraph, "reconExceptionAgingGraph", Report_headLine, "Recon Exception Report");
       
        //Sales
        Verify(Report_Sales,  "Sales Reports", Report_Sales_ETL_ContractSummary,"ETL Contract Summary",  Report_headLine, "ETL Report");
        Verify(Report_Sales,"Sales Reports", Report_Sales_ICB,"Sales ICB",  Report_headLine, "ICB");
        Verify(Report_Sales,"Sales Reports",  Report_Sales_soldProducts, "Sold Products", Report_headLine, "Monthly Sold Products Report");
        Verify(Report_Sales,"Sales Reports",  Report_Sales_salesByRep,"Sales By Rep",  Report_headLine, "Sales By Rep");
        
        
        		String Reports_Sales_Salesbtrep = "id=month";
        		//String Reports_Sales_Salesbtrep = "id=month";
        
        Verify(Report_Sales, "Sales Reports", Report_Sales_salesByState,"Sales By State", Report_headLine, "Sales By State");
        Verify(Report_Sales,"Sales Reports",  Report_Sales_salesByTeam,"Sales By Team" ,Report_headLine, "Sales By Team");
      //Hidden Menu
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_ETL_renewals, Report_headLine, "Renewals Report: Expired");        
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_renewalsByRep, Report_headLine, "Customers By Rep or CSA");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_salesEditAudit, Report_headLine, "Sales Order Edit Audit Report");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_contractsByMonthAndRevenueType, Report_headLine, "Contracts By Month And Revenue Stage");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_soldProductDetails, Report_headLine, "Sold Product Details Report");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_sales, Report_headLine, "Sales Report");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_trendsByMonth, Report_headLine, "Sales Trends");
        VerifyByReducingBrowseSize(Report_Sales, Report_Sales_wework, Report_headLine, "WeWork");
   
        //Tickets	    
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_ActionReport, Report_headLine, "Ticket Action Report");
	    
	    
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_CustomerInfancy, Report_headLine, "Customer Infancy");
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_HelpDeskReport, Report_headLine, "Help Desk Tickets");
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_ticketByAgent, Report_headLine, "Report");
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_ticketsPastSLA, Report_headLine, "Tickets Past SLA");
	    VerifyByReducingBrowseSize(Report_Tickets, Report_Tickets_ticketQueueGroups, Report_headLine, "Ticket Queue Admin");
	 
	}

	private void VerifyClick(String menu, String submenu) throws Throwable {
		// TODO Auto-generated method stub
		aclick(reports,"Reports Link");
		aactionsClick(menu,menu);		
		aJSClick(submenu,submenu);
	}

	private void Verify(String menu,String menuText,String submenu,String submenuText, String textElement, String text) throws Throwable {
		aclick(reports,"Reports Link");
		aactionsClick(menu,menuText);		
		aJSClick(submenu,submenuText);
        waitForElementPresent(textElement, 200);
        verifyText(textElement,  text, "Verifying HeadLine text");
	}
	
	
	private void VerifyByReducingBrowseSize(String menu,String submenu, String textElement, String text) throws Throwable {
		setBrowserTo80Size();
		aclick(reports,"Reports Link");
		aactionsClick(menu,menu);		
		aJSClick(submenu,submenu);
        waitForElementPresent(textElement, 200);
        verifyText(textElement,  text, "Verifying HeadLine text");
	}
}
