package demo.objectrepository;

public interface OR_SearchPage {
	
    String srchTxt = "css=input#search";
    String search_inventorySearchbox="xpath=(//input[@name='search'])[2]";
    String firstParentIdLnk = "xpath=(//table[@id='customer_table']/tbody/tr)[1]/td[8]/a";

    String noOfRows ="xpath=(//table[@id='customer_table']/tbody/tr)";
    //String invoic="xpath=//*[@id=\"customer_table\"]/tbody/tr[1]/td[1]/ul/li[2]/ul/li[5]/a";

    String $Symbol1stCustomer="xpath=(//table[@id='customer_table']/tbody/tr)[1]/td[1]/ul/li[2]/a";
    String reconsilation1stCustomer="xpath=(//table[@id='customer_table']/tbody/tr)[1]/td[1]/ul/li[2]/ul/li[7]/a";

    String customerNamefromTable="xpath=//table[@id='customer_table']/tbody/tr/td[4]";
    
    //Circuits
    String circuit_tableName="css=#circuit_table caption div div";
    
    //NumberSearch
    String numberSearch_active_code_info_table="xpath=//a[@href='#nnacl']";
	String pageHeader="className=clearfix";
	String search_number_portabilitySearch="xpath=//a[@href='/tn/portCheckMulti']";
	String search_number_inventorySearch="xpath=//a[@href='/tn/searchMulti']";
	String search_number_inventorySearch_searchTextBox="id=search";
	String search_number_inventorySearch_searchBtn="xpath=(//button[@type='submit'])[2]";
	String search_number_inventorySearch_tableNumbers="xpath=//*[@id='number_table']/tbody/tr/td[1]/a";
	String search_number_inventorySearch_customerParametarised="xpath=//*[@id='number_table']/tbody/tr[%s]/td[2]";
	
	String search_number_PortabilitySearch_table_NPA="xpath=//*[@id='number_table']/tbody/tr/td[1]";
	String search_number_PortabilitySearch_table_NPA_parametarised="xpath=//*[@id='number_table']/tbody/tr[%s]/td[1]";
	String search_number_PortabilitySearch_table_NXX_parametarised="xpath=//*[@id='number_table']/tbody/tr[%s]/td[2]";
	
    
    //ContractSearch
    String orderNumberValue="xpath=//div[@class='modal-body']/div/div/dl/dd";
    String createdByValue="xpath=//div[@class='modal-body']/div/div/dl/dd[7]";
    String typeValue="xpath=//div[@class='modal-body']/div/div/dl/dd[9]";
    
    //Device search
    String deviceTableName="css=#device_table caption";
    String deviceName="xpath=//*[@id=\'device_table\']/tbody/tr/td[3]";
    
    //dispatch
   String dispatchTableName="css=#dispatch_table caption";
    
    //ip infomation
    String idAddress="id=notification-ip";
 String verifyipadressheader = "xpath=//div[text()='IP Information']";
    
    //Inventory
    String inventoryTableName="css=#inventory_table caption";
    
    //project
    String projectTableName="css=#project_table caption";
    
   // ticket
    String ticketTableName="css=#ticket_table caption";
    
    String istparentLink="xpath=(//*[@id=\"customer_table\"]/tbody/tr/td[8]/a)[2]";
    
    
    String ParentCustomer_childCustomer="xpath=(//h1[@class='panel-title'])[2]/a";
    String ParentCustomer_childCustomer_city="xpath=//*[@id='child_table']/thead/tr/th[5]";
    String ParentCustomer_childCustomer_state="xpath=//*[@id='child_table']/thead/tr/th[6]";
    
    // Search -> Circuit     

    String search_circuit_ViewEditLinksTable="xpath=//a[starts-with(@href,'/circuit/view/circuit_id')]";
    String search_circuit_form_circuitId="id=carrier_circuit_id";
    String search_circuit_form_saveBtn="xpath=//button[@class='btn btn-primary btn-sm pull-right']";
    String search_circuit_form_successOkPopUp="xpath=//button[@class='btn btn-default center-block']";
    
    String search_circuit_form_addDesignEntryBtn="xpath=//a[@href='#design_add_modal']";
    String search_circuit_form_addDesignEntryBtn_circuitId="id=a_circuit_id";
    String search_circuit_form_addDesignEntryBtn_circuitId_Qa6="//a[@href='#design_add_modal']";
 
    String search_circuit_form_addDesignEntryBtn_addConnectedCircuitBtn="xpath=(//button[@class='btn btn-primary pull-right'])[2]";
    
    String search_circuit_form_CiircuitDesignEntries="xpath=//*[@id='circuit_design']/tbody/tr/td/div";
    //  String search_circuit_form_CiircuitDesignEntries_delete="xpath=//*[@id='circuit_design']/tbody/tr/td/div[1]/p/strong/a[1]";
    String search_circuit_form_CiircuitDesignEntries_delete="/p/strong/a[1]";
    
    //View In Verification
    String customerHome_viewInMenu="id=notification-view-in";
    String customerHome_viewInMenu_engage="id=notification-view-in-engage";
    String customerHome_viewInMenu_salesForce="id=notification-view-in-sales-force";
    String customerHome_viewInMenu_sugar="id=notification-view-in-sugar";
    
    String ViewInSugar_userName="id=user_name";
    String ViewInSugar_password="id=user_password";
    String ViewInSugar_loginBtn="id=login_button";
    
    String CustomersTableCustomerName="xpath=//*[@id='customer_table']/tbody/tr/td[4]"; 
    String CustomersTable_1stCustomer="xpath=//*[@id='customer_table']/tbody/tr[3]/td[4]/a";
    
    String customerHome_billing="id=dd-Billing";
    String customerHome_billing_contracts="id=notification-contracts";
    String customerHome_billing_contracts_list="xpath=(//a[starts-with(@href,'/contract/listByCustomer/customer_id')])[2]";
    String customerHome_billing_contracts_summary="xpath=//a[starts-with(@href,'/contract/summary/customer_id')]";
    String customerHome_billing_contracts_timeline="id=notification-timeline";
    
    String billing_contracts_contractsListPage="className=container-fluid"; //Contracts
    String billing_contracts_contractSummaryPage="className=container-fluid"; //Contract Summary
    String billing_contracts_contractTimeLineHeadLine="xpath=//*[@id='header_crumbs']/li[4]"; //Contract Timeline
    
    String billing_creditRequest="id=notification-credit-request";
    String billing_inventory="xpath=//a[starts-with(@href,'/inventory/listByCustomer/customer_id')]";
    String billing_crediRequest_addNew="xpath=//a[@class='btn btn-info btn-sm pull-right']";
  
      // Billing - Add Customer Credit - form
    String billing_addCustomerCredit_form_requestedBy="id=Requestor";
    String billing_addCustomerCredit_form_phoneNo="id=RequestorPhone";
    String billing_addCustomerCredit_form_email="id=RequestorEmail";
    String billing_addCustomerCredit_form_invoice_DD="id=InvoiceNumber";
    String billing_addCustomerCredit_form_creditType_DD="id=BillingCreditServiceType";
    String billing_addCustomerCredit_form_ticketNumber="id=TicketNumber";
    String billing_addCustomerCredit_form_CreditReason_DD="name=data[CreditReason]";
    String billing_addCustomerCredit_form_CreditTaxable_DD="id=CreditTaxable";
    String billing_addCustomerCredit_form_CreditNotes="id=CreditNotes";
    String billing_addCustomerCredit_form_CreditAmount="id=CreditAmount";
    String billing_addCustomerCredit_form_save_Btn="xpath=//button[@form='credit-request-save']";
    
    
    String billing_addCustomerCredit_successMsg="xpath=//div[@class='alert alert-success alert-dismissable']/div";
    
    String rightTopMenu="css=#notification-";
    String rightTopMenu_loginAs="xpath=//a[@href='/user/logInAs/']";
    String rightTopMenu_logout="xpath=//a[@href='/login/logout/']";
    String loginAs_User_DD="name=uid";  //Kevin Knoll
    
    String billing_credit_request_amountFromTable="xpath=//*[@id='credit-request-table']/tbody/tr/td[11]";
    String billing_credit_request_ticketFromTable="xpath=//*[@id='credit-request-table']/tbody/tr/td[4]";
    String billing_credit_request_creditIdFromTable="xpath=//*[@id='credit-request-table']/tbody/tr[%s]/td[1]/a";
    
    
    
    String billing_addCustomerCredit_form_approvedAmount="id=ApprovedAmount";
    String billing_addCustomerCredit_editForm_save_confirm="xpath=//button[@name='approval[save]']";

    // billing inventory
   
    String billing_inventory_uniqueId_checkBox_list="xpath=//input[@type='checkbox']";
    String billing_inventory_bulkEdit_btn="id=bulk_edit_button";
    
    String billing_inventory_bukEdit_OwnerId="id=owner_id";
    String billing_inventory_bukEdit_saveBtn="id=bulk_edit_save";
    String billing_inventory_ownerList="xpath=//*[@id='inventory_table']/tbody/tr/td[8]/a";
    String billing_inventory_export="xpath=//a[@class='btn btn-success btn-sm pull-right']";
    
    String billing_inventory_history="xpath=//a[starts-with(@href,'/inventory/historyByCustomer/customer_id')]";
    String billing_invoicePayments="id=notification-invoices-&-payments";
    String billing_invoicePayments_invoiceHyperLinksList="xpath=//*[@id='invoice_table']/tbody/tr/td[3]/a";
    String billing_invoicePayments_invoiceHyperLink_closeBtn="css=.close";
    
    String billing_reconciliation="xpath=//a[starts-with(@href,'/recon/customerdetails/CustomerID')]";  
    String billing_reconciliation_headLine="xpath=//*[@id='header_crumbs']/li[3]";
    String billing_reconciliation_reconcile_btn="xpath=//button[@class='btn btn-sm btn-primary']";
    		
    // ***********************************
    
   
    String Symbol1stCustomer="xpath=(//table[@id='customer_table']/tbody/tr)[1]/td[1]/ul/li[2]/a";
   
    //Customer Table
    String cusTableTotalRecords="xpath=//table[@id='customer_table']/tbody/tr";
    String cusTableTr="xpath=(//table[@id='customer_table']/tbody/tr)[%s]";
    String cusTableBillingStatus="/td[7]";
    String cusTableAccStatus="/td[6]";
    String cusTableDollorLnk="/td[1]//a[@id='dd-Billing']";
    String invoicesAndPayMentsLnk="/td[1]//span[@id='notification-invoices-&-payments']";
    String inventory="/td[1]//span[@id='notification-inventory']/..";
    //Project table
    String projTableTotalRecords="xpath=//table[@id='project_table']/tbody/tr";
    String projTableTr="xpath=(//table[@id='project_table']/tbody/tr)[%s]";
    String projTableStatus="/td[9]";
    String projTableCompletion="/td[8]//div[@class='progress-text']";
    String projTableCusLnk="/td[3]/a";
    String firstCustomerRecord="xpath=//table[@id='customer_table']/tbody/tr[1]/td[4]/a";




    String voiceLnk="xpath=(//a[@id='dd-Voice'])[1]";
    String numbersBtn="xpath=(//span[@id='notification-numbers'])[3]";


}
