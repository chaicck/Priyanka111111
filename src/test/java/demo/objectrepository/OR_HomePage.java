package demo.objectrepository;


public interface OR_HomePage {

	String homeBtnDd = "css=span[id='notification-home'] span[class='hidden-md hidden-sm hidden-xs']";
    String customerInfoLnk = "css=span[id='notification-customer-information']";
    String dashboardLnk = "css=span[id='notification-dashboard']";
    String clientConfCallLnk = "css=span[id='notification-client-configuration-call']";
    String contactsLnk = "css=span[id='notification-contacts']";
    String dispatchLnk = "xpath=(//span[@id='notification-dispatches'])[2]";
    String portalUserhLnk = "css=span[id='notification-portal-users']";
    
    String projectMenu="id=notification-projects";
    String projectmenu="id=dd-Projects";

    String searchTextBox = "xpath=//input[@id='search']";
    String customerserachButton = "xpath=//button[@type='button']";
    String queuesLink = "xpath=//span[@id='notification-queues']";
    String dashBoardBillingLink = "id=dd-Billing";
    String ContractsLink = "xpath=//span[@id='notification-contracts']";
    String searchLinkButton = "xpath=//button[@type='submit'][@title='Search']";
    String projectLink = "xpath=//a[text()='Adelson, Testan, Brudno, Novell & Jimenez-West Palm Beach']";
    String newprojectLink = "xpath= //span[@id='notification-new-projects']";
    String addprojectplusButton = "xpath=(//i[@class='glyphicon  glyphicon-plus '])[6]";
    String market = "xpath= //span[text()= 'All']";
    String prjLnk = "id=dd-Projects";
    String prjByPMLnk = "id=notification-projects-by-pm";
    String adminLInk="xpath=//span[text()='Admin']";
    String reconcilationLink="xpath=(//span[@id='notification-reconciliation'])[1]";
    String reconcilationMacLink="xpath=//span[@id='notification-recon-mac-product-mapping']";

    String macEditLink="xpath=(//a[@title='Edit'])[1]";
    String macDeleteLink="xpath=(//a[@title='Delete'])[1]";
    String macEditnameTextBox="xpath=//input[@id='recon_name']";
    String macDetailsSaveButton="xpath=//button[contains(text(),'Save')]";
    String macOkButton="xpath=//button[text()='OK']";
    String deleteButton="xpath=//a[text()='Delete Mapping']";
    String addMacLink="xpath=//(//a[@class='btn btn-sm btn-info pull-right'])[4]";
    String addMacNameTextBox="xpath=//label[contains(text(),'PCAT')]/..//input[@type='text']";
    String addMacNameDropDown="xpath=//label[contains(text(),'PCAT')]/..//span";
    
    String inventoryLnk="xpath=//li[@class='dropdown  open']//span[@id='notification-inventory']";

    String reports="id=dd-Reports";   
    String reportsReconsilation="xpath=//a[@href='/recon/reports/']";

    //String reconExceptionAgingOption="xpath=(//a[@href='/recon/exceptionAgingGraph/'])[2]";

    String reconExceptionAgingOption="xpath=//a[@href='/recon/exceptionAgingGraph/']";
    
    String srchDd="id=dd-Search";
    String customerLnk="xpath=//a[@href='/customer/search/']";
    
    String search_customer="id=notification-customer";
    String search_circuit="id=notification-circuit";
    String search_contact="id=notification-contact";
    String search_contract="id=notification-contract";
    String search_device="id=notification-device";
    String search_dispatch="id=notification-dispatch";
    String search_ip="id=notification-ip";
    String search_inventory="id=notification-inventory";    
    String search_number="id=notification-number";
    String search_project="id=notification-project";

    
    String CustomerHome_emailHeading="xpath=//*[@id='contacts_table']/thead/tr/th[6]";
    String CustomerHome_mobileNumberHeading="xpath=//*[@id='contacts_table']/thead/tr/th[5]";
    

    
    String ParentCustomer_contractTimeLine="xpath=//a[@href='#timeline_collapse_1']";
  
   // String homeBtnDd = "css=span[id='notification-home'] span[class='hidden-md hidden-sm hidden-xs']";

    String search_ticket="id=notification-ticket";
    String dataLnk="id=dd-Data";
    String dnsLnk="id=notification-dns";
    //String voiceLnk="id=dd-Voice";
    String faxMailLnk="id=notification-faxmail";

    String childCustomerTableName="xpath=//a[@href='#childCustomerTable']";
    String contactsTableName="xpath=//a[@href='#contactTable']";
    String engineering_ICBs	="xpath= //a[@href='#eicbTable']";

    String CustomerHome_emailList="xpath=//*[@id='contacts_table']/tbody/tr[1]/td[6]";
    String CustomerHome_mobileNumberList="xpath=//*[@id='contacts_table']/tbody/tr/td[4]";

    String customerDashboard_customerLink="xpath=(//a[starts-with(@href,'/customer/view/customer_id')])[3]";
    String customerDashboard_customerLink_exportChildCustomers="xpath=//a[@class='btn btn-sm btn-success pull-right']";


    
		}

