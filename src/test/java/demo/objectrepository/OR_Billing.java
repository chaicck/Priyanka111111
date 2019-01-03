package demo.objectrepository;

public interface OR_Billing {

	 String billingMenu = "id=dd-Billing";
	 String billing_contracts= "xpath=//span[@id='notification-contracts']";
	 String billing_contracts_list="xpath=(//a[starts-with(@href,'/contract/listByCustomer/customer')])[2]";
	 String billing_Reconciliation="xpath=//a[starts-with(@href,'/recon/customerdetails/CustomerID')]";
	
	 
	 
	 //list-elements
	 String billing_contracts_list_TableNames="xpath=//*[@id='contract_table']/tbody/tr/td[3]";
	 String billing_contracts_list_TableStatusParametarised="xpath=//*[@id='contract_table']/tbody/tr[%s]/td[5]";
	 String billing_contracts_list_addContract="xpath=//a[starts-with(@href,'/quote/view/customer_id')]";
	 String addContract_name="id=quote[name]";
	 String addContract_ticket="id=quote[ticket_id]";
	 String addContract_RequestedInstallDate="id=quote_cstm[requested_install_date_c]";
	 String addContract_authorizedBy="id=quote[AuthorizedBy]";
	 String addContract_AssignedTo="name=quote_cstm[project_manager_c]";
	 String addContract_productsAddNew="xpath=//a[@onclick='addRow();']";
	 String addContract_productTextBox_parametarised="xpath=//*[@id='ptable']/tbody/tr[%s]/td[1]/span/input[2]";
	 String addContract_productTextBox_save="xpath=(//button[@type='submit'])[3]";
	 String addContract_approveEmail="xpath=(//button[@onclick='lockAndEmail();'])";
	 String addContract_sendToBilling="xpath=//a[starts-with(@href,'/quote/sendToBilling/customer_id')]";

	 //Reconciliation
	 String Reconciliation_refresh="xpath=//i[@class='fa  fa-refresh ']";
	 String Reconciliation_tableProducts="xpath=//*[@id='recon']/tbody/tr/td[2]";
	 String Reconciliation_tableContractedParametarised="xpath=//*[@id='recon']/tbody/tr[%s]/td[3]";
	 
	
}
