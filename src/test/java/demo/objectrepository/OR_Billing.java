package demo.objectrepository;

public interface OR_Billing {

	String billingMenu = "id=dd-Billing";
	String billing_contracts = "xpath=//span[@id='notification-contracts']";
	String billing_contracts_list = "xpath=(//a[starts-with(@href,'/contract/listByCustomer/customer')])[2]";
	String billing_Reconciliation = "xpath=//a[starts-with(@href,'/recon/customerdetails/CustomerID')]";

	// list-elements
	String billing_contracts_list_TableNames = "xpath=//*[@id='contract_table']/tbody/tr/td[3]";
	String billing_contracts_list_TableStatusParametarised = "xpath=//*[@id='contract_table']/tbody/tr[%s]/td[5]";
	String billing_contracts_list_addContract = "xpath=//a[starts-with(@href,'/quote/view/customer_id')]";
	String addContract_name = "id=quote[name]";
	String addContract_ticket = "id=quote[ticket_id]";
	String addContract_RequestedInstallDate = "id=quote_cstm[requested_install_date_c]";
	String addContract_authorizedBy = "id=quote[AuthorizedBy]";
	String addContract_AssignedTo = "name=quote_cstm[project_manager_c]";
	String addContract_productsAddNew = "xpath=//a[@onclick='addRow();']";
	String addContract_productTextBox_parametarised = "xpath=//*[@id='ptable']/tbody/tr[%s]/td[1]/span/input[2]";
	String addContract_productTextBox_save = "xpath=(//button[@type='submit'])[3]";
	String addContract_approveEmail = "xpath=(//button[@onclick='lockAndEmail();'])";
	String addContract_sendToBilling = "xpath=//a[starts-with(@href,'/quote/sendToBilling/customer_id')]";

	// Reconciliation
	String Reconciliation_refresh = "xpath=//i[@class='fa  fa-refresh ']";
	String Reconciliation_tableProducts = "xpath=//*[@id='recon']/tbody/tr/td[2]";
	String Reconciliation_tableContractedParametarised = "xpath=//*[@id='recon']/tbody/tr[%s]/td[3]";

	String Queues_Billing = "id=notification-billing";
	String billing_credit_request_creditIDFromTable_parametarised = "xpath=//*[@id='credit-request-table']/tbody/tr[%s]/td[1]/a";
	String Queues_Billing_BillingDayLegend = "xpath=//table[@class='table table-condensed table-nonfluid table-striped']/thead";
	String Queues_Billing_HasBillCycle_symbol = "xpath=(//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[1]/td";
	String Queues_Billing_HasBillCycle = "xpath=((//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[1]/td)[2]";
	String Queues_Billing_Parent_HasBillCycle_symbol = "xpath=(//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[2]/td";
	String Queues_Billing_Parent_HasBillCycle = "xpath=((//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[2]/td)[2]";
	String Queues_Billing_RecomendedBillCycle_symbol = "xpath=(//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[3]/td";
	String Queues_Billing_RecomendedBillCycle = "xpath=((//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[3]/td)[2]";
	String Queues_Billing_PQ2C_Customers_symbol = "xpath=(//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[4]/td";
	String Queues_Billing_PQ2C_Customers = "xpath=((//table[@class='table table-condensed table-nonfluid table-striped']/tbody/tr)[4]/td)[2]";
	String Queues_Billing_NonBilling = "xpath=//td[text()='Non Billing']";
	String queues_billing_showRecords_DD = "name=DataTables_Table_0_length";
	String queues_billing_tableRecords = "xpath=//*[@id='DataTables_Table_0']/tbody/tr";
	String queues_billing_searchBox = "xpath=//input[@type='search']";
	String queues_billing_billQueueTableHeaders = "xpath=//*[@id='DataTables_Table_0']/thead/tr/th";
	String queues_billing_billQueueTableCaption = "xpath=//*[@id='DataTables_Table_0']/caption";
	String queues_billing_billQueueTable_customerID_Header = "xpath=//*[@id='DataTables_Table_0']/thead/tr/th[2]";
	String queues_billing_billQueueTable_customerIDs = "xpath=//*[@id='DataTables_Table_0']/tbody/tr/td[2]";
	String queues_billing_billQueueTable_processLinks = "xpath=//*[@id='DataTables_Table_0']/tbody/tr/td[1]";
	String queues_billing_billQueueTable_customerIDs_parameter = "xpath=(//*[@id='DataTables_Table_0']/tbody/tr/td[2])[%s]";

	
}
