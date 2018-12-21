package demo.objectrepository;

public interface OR_Queues {
	String Queues_Menu="id=notification-queues";
	
	
    String Queues_Menu_Creditreq="id=notification-credit-requests";
    String Queues_Menu_Creditreq_cretdate="id=query[CreatedDate]";
    String Queues_Menu_Creditreq_Showprocedd="xpath=//a[@class='small']";
    
    String Queues_Menu_Creditreq_Showprocedd_search="xpath=//input[@type='search']";
    String Queues_Menu_Creditreq_Showprocedd_creditclick="xpath=//td[@class='small text-center sorting_1']/a";
    
    String Credit_Save="xpath=(//button[@form='credit-request-save'])[2]";
    String Credit_Invoice ="xpath=//*[@id=\"credit-request-table\"]/tbody/tr[1]/td[5]/a";
     
    String Credit_Invoice_Close ="xpath=//*[@id='basic_modal']//button[contains(@class, 'close')]";
    String Credit_Invoice_Requster="id=Requestor";
    String ViewInEngage_Transaction="id=Transactions_tab";
    
    String Queues ="xpath=//span[text()='Queues']";
	 String Queues_enganeering_ICB = "id=notification-engineering-icb";
	 String Queues_enganeering_ICB_search ="xpath=//input[@class='form-control input-sm']";
	 String Queues_enganeering_ICB_search_servicedeliver_aprproved ="xpath=//td[text()='service-delivery-approved'])[1]";
	 String Queues_enganeering_ICB_search_inactive ="xpath=//a[@href='/eicb/queue/active:0']";
	 String Queues_enganeering_ICB_search_inactive_rejected ="xpath=//td[text()='rejected'])[1]"; 
	 String Queues_enganeering_ICB_search_inactive_result ="id=queue_info";
	 

	
}
