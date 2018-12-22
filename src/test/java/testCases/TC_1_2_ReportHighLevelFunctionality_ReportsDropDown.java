package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_2_ReportHighLevelFunctionality_ReportsDropDown extends
		MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description: Report All Menus and SumMenus
	 */
	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
    public void tc_1_2_ReportHighLevelFunctionality(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];

		// * logger method for report starting from here
		logger = extent.startTest("1.2 Test ID : 18724 - All Reports_High Level Functionality Tests").assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Report All Menus and SumMenus");

		// * Below Code written to verify login
		login(zUserName, zPassword);
   
           
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_accountQuotesReport,"Account Quotes", Report_headLine, "Account Quotes Report");
     	softassert.assertEquals(isassert, true,"Verified Account Quotes Report menu");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_aging,"Aging", Report_headLine, "Contract Aging Report");
     	softassert.assertEquals(isassert, true,"Verified Contract Aging Report menu");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_allInstallsByRep,"All Installs By Rep", Report_headLine, "All Installs By Sales Rep");
     	softassert.assertEquals(isassert, true,"Verified All Installs By Sales Reports menu");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_allSalesByProduct,"allSalesByProduct", Report_headLine, "All Sales By Product");
     	softassert.assertEquals(isassert, true,"Verified All Sales By Product menu");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_allSalesByRep, "allSalesByRep",Report_headLine, "All Sales By Sales Rep");
     	softassert.assertEquals(isassert, true,"Verified All Sales By Sales Rep menu");
        
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_cancels,"Cancelled Before Billing", Report_headLine, "Cancel Before Billing Report");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_renewedContracts,"Contract Renewals", Report_headLine, "Renewals Before Expiration Date");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_contractStageByMonth,"Contract Stage By Month", Report_headLine, "Contract Stage Report");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_contractStageByMonthChart,"Contract Stage By Month Chart", Report_headLine, "Contract Stage Chart");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_faxmail,"Faxmail CDR", Report_headLine, "FaxMail Report"); 
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_salesBackdateReport,"GM Approved to Sales Month Diff", Report_headLine, "Sales Backdate Report");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
     	isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_priceOverrides,"MAC Price Overrides", Report_headLine, "Product Price Overrides");
     	softassert.assertEquals(isassert, true,"Verified expected text on page");
     	
        aclick(reports,"Reports Link");
        aJSClick(Report_Accounting,"Accounting Reports");		
        aJSClick(Report_Accounting_positiveAfterNegative,"Positive After Negative");
        isassert = verifyText(Positive_Negative, "", "Positive_Negative");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_productDiscountOverview,"Product Discount Overview", Report_headLine, "Products Discounts Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting, "Accounting Reports",Report_Accounting_productDiscounts,"Product Discount ", Report_headLine, "Product Discounts Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_RevenueDetail_BOD,"BOD", Report_headLine, "Revenue Detail Report"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        click(srchDd,"Search");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_telesphereSignedMACs," Self Signed MACs", Report_headLine, "Telesphere Signed MACs");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting," Accounting Reports", Report_Accounting_userDiscountLevels,"User Discounting Level", Report_headLine, "User Discount Level Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_salesCommission," Commissions", Report_headLine, " Commission Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Accounting, " Accounting Reports",Report_Accounting_zeusToEngage,"Zeus to Engage", Report_headLine, "Zeus to Engage");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        // circuits
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_CircuitCost," Circuit Cost", Report_headLine, "Circuit Cost Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_quoteLookup,"Circuits Quote Look up",Report_headLine, "Circuit Quote Lookup");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportInactive,"Circuits Repor In active ", Report_headLine, "Inactive Customers"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportHidden,"Circuits Repor Hidden ", Report_headLine, "Hidden"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportNoContract,"Circuits Report No Contract", Report_headLine, "Circuits with no contract"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportNoZloc,"Circuits Report  No ZLoc",  Report_headLine, "No ZLoc"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportOverdue, "Circuits Report  overdue",Report_headLine, "Overdue");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits, " Circuit Reports",Report_Circuits_reportPendingDISCO, "Circuits Report Pending DISCO",Report_headLine, "Pending DISCO");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits, " Circuit Reports",Report_Circuits_reportDS3,"Circuits Report  DS3 Report", Report_headLine, "DS3");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportByCarrier,"Circuits Report Report By Carrier", Report_headLine, "Report By Carrier");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Circuits," Circuit Reports", Report_Circuits_reportByType, "Circuits Report Report By Type",Report_headLine, "Report By Type");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
      
        //Customers - menu
        isassert = verifyClicksInPage(reports, "Report link",Report_Customers, "Customer Reports", Report_Customers_activeCustomrs, "Active Customers"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifyClicksInPage(reports, "Report link",Report_Customers,"", Report_Customers_customersOpen24x7, "Customers open 24x7"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers,"Customer Reports", Report_Customers_agentTotalRevenue," Agent Customers and Revenue", Report_headLine, "Agent Total Revenue");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers,"Customer Reports", Report_Customers_customerAgentReport," All Customers with Agent", Report_headLine, "Customer Agent Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers, "Customer Reports",Report_Customers_agentCustomers," Customers By Agent", Report_headLine, "Agent Customers");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers,"Customer Reports", Report_Customers_customersByIndustry, " Industry",Report_headLine, "Customers By Industry");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifyClicksInPage(reports, "Report link",Report_Customers, "Report customers link", Report_Customers_reportPostalCodes, "Report postal codes");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers,"Customer Reports", Report_Customers_customerRankingReport," RankingReport", Report_headLine, "Customer Ranking Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers, "Customer Reports",Report_Customers_customerSeats,"  Seats Count Report", Report_headLine, "Customer Seat Report"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers, "Customer Reports",Report_Customers_reportVIP,"   VIP Customer List", Report_headLine, "VIP Customer List");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Customers,"Customer Reports", Report_Customers_customerProductContacts," Customer Product Contact Report", Report_headLine, "Customer Product Contact Report"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
       
       //Devices
        
        isassert = verifySubMenuHeadLine(reports, Report_Device," Device Reports", Report_Device_AllDevices," All Devices", Report_headLine, "Devices All");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Device," Device Reports", Report_Device_Installing,"Installing", Report_headLine, "Installing");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
    	
        //Enginnering
        isassert = verifySubMenuHeadLine(reports, Report_Engineering,"Engineering", Report_Engineering_masterPOPList, "Master POP List",Report_headLine, "Point of Presence (POP) - Report"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        //Finance
        isassert = verifySubMenuHeadLine(reports, Report_Finance,"Finance", Report_Finance_NetXReport,"NetXReport", Report_headLine, "NetX Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        //Inventory - menu
        isassert = verifyClicksInPage(reports, "Report link",Report_Inventory,"Report inventory", Report_Inventory_inactiveCustomers, "Inactive Customers");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Inventory,"Inventory", Report_Inventory_inventoryHistory,"Inventory_inventoryHistory", Report_headLine, "Inventory History"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
       
        //ips
        isassert = verifySubMenuHeadLine(reports, Report_ips,"IPS", Report_ips_inactiveCustomers,"Inactive Customers", Report_headLine, "Inactive Customers"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");

      //Monitoring
        isassert = verifySubMenuHeadLine(reports, Report_Monitoring,"Monitoring", Report_Monitoring_Alerts,"Alerts",Report_headLine,"Alerts");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Monitoring,"Monitoring", Report_Monitoring_BroadWorksAuditLogs,"BroadWorksAuditLogs", Report_headLine, "BroadWorks Audit Log"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
      //Numbers
        isassert = verifySubMenuHeadLine(reports, Report_Numbers,"Numbers Reports", Report_Numbers_AllTNReport,"All TN Report",Report_headLine,"TN Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Numbers,"Numbers Reports", Report_Numbers_InterNationalDIDReport,"  International DID Report", Report_headLine, "International DID Report"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
	    
        //Operations
        isassert = verifySubMenuHeadLine(reports, Report_Operations,"Operations", Report_Operations_backlogChart,"BacklogChart",Report_headLine,"Backlog Chart"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");

	   //Service Delivery
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_Dispatches,"Dispatches", Report_headLine, "Dispatches");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_HandOffs,"HandOffs", Report_headLine, "Handoffs"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_inFlightProducts,"In Flight Products", Report_headLine, "In Flight Products");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert =  verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_pmProjectCountDashboard,"PM Project Count Dashboard", Report_headLine, "PM Project Count Dashboard"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_projectsInstallByProgress,"Projects Install By Progress", Report_headLine, "Projects Completed with status Install In Progress"); 
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_installationCalander, "Installation Calander",Report_headLine, "Installation Calendar");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_jeops,"Jeops", Report_headLine, "JEOP Report");  
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_ServiceDelivery,"Service Delivery", Report_ServiceDelivery_OReallyPendingDate,"OReally Pending Date", Report_headLine, "O'Reilly Pending Data");  
        
        //Reconciliation
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_DailyReconExceptionReport,  "DailyReconExceptionReport",Report_headLine, "Recon Exception Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_OperationReconOverView, "OperationReconOverView", Report_headLine, "Operations Reconcilation Overview");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconOverView, "ReconOverView,", Report_headLine, " Reconcilation Overview");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconProducts, "ReconProducts", Report_headLine, "Product Reconciliation");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation, "Reconciliation Reports", Report_Reconciliation_ReconWorkDone, "_ReconWorkDone", Report_headLine, "Reconciliation Work Done");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Reconciliation,  "Reconciliation Reports",Report_Reconciliation_reconExceptionAgingGraph, "reconExceptionAgingGraph", Report_headLine, "Recon Exception Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        //Sales
        isassert = verifySubMenuHeadLine(reports, Report_Sales, "Sales Reports", Report_Sales_ETL_ContractSummary,"ETL Contract Summary",  Report_headLine, "ETL Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Sales,"Sales Reports", Report_Sales_ICB,"Sales ICB",  Report_headLine, "ICB");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Sales,"Sales Reports",  Report_Sales_soldProducts, "Sold Products", Report_headLine, "Monthly Sold Products Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Sales,"Sales Reports",  Report_Sales_salesByRep,"Sales By Rep",  Report_headLine, "Sales By Rep");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifySubMenuHeadLine(reports, Report_Sales, "Sales Reports", Report_Sales_salesByState,"Sales By State", Report_headLine, "Sales By State");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifySubMenuHeadLine(reports, Report_Sales,"Sales Reports",  Report_Sales_salesByTeam,"Sales By Team" ,Report_headLine, "Sales By Team");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        //Hidden Menu
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_ETL_renewals, Report_headLine, "Renewals Report: Expired");        
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_renewalsByRep, Report_headLine, "Customers By Rep or CSA");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_salesEditAudit, Report_headLine, "Sales Order Edit Audit Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_contractsByMonthAndRevenueType, Report_headLine, "Contracts By Month And Revenue Stage");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_soldProductDetails, Report_headLine, "Sold Product Details Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_sales, Report_headLine, "Sales Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_trendsByMonth, Report_headLine, "Sales Trends");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports, Report_Sales, Report_Sales_wework, Report_headLine, "WeWork");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        //Tickets	    
        isassert = verifyByReducingBrowseSize(reports, Report_Tickets, Report_Tickets_ActionReport, Report_headLine, "Ticket Action Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
	    
        isassert = verifyByReducingBrowseSize(reports, Report_Tickets, Report_Tickets_CustomerInfancy, Report_headLine, "Customer Infancy");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        
        isassert = verifyByReducingBrowseSize(reports,Report_Tickets, Report_Tickets_HelpDeskReport, Report_headLine, "Help Desk Tickets");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports,Report_Tickets, Report_Tickets_ticketByAgent, Report_headLine, "Report");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports,Report_Tickets, Report_Tickets_ticketsPastSLA, Report_headLine, "Tickets Past SLA");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
        isassert = verifyByReducingBrowseSize(reports,Report_Tickets, Report_Tickets_ticketQueueGroups, Report_headLine, "Ticket Queue Admin");
        softassert.assertEquals(isassert, true,"Verified expected text on page");
      
        // * Below method written to logout application
     	logOut();
     	softassert.assertAll();
	}

}
